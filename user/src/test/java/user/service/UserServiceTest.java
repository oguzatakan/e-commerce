package user.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import user.dto.CreateUserRequest;
import user.dto.UpdateUserRequest;
import user.dto.UserDto;
import user.dto.converter.UserDtoConverter;
import user.exception.UserNotFoundException;
import user.model.UserInformation;
import user.repository.UserInformationRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest extends TestSupport{

    private UserDtoConverter converter;
    private UserInformationRepository repository;

    private UserService userService;

    @BeforeEach
    public void setUp(){
        converter = mock(UserDtoConverter.class);
        repository = mock(UserInformationRepository.class);

        userService = new UserService(repository,converter);
    }

    @Test
    public void testGetAllUsers_itShouldReturnUserDtoList(){
        List<UserInformation> userList = generateUsers();
        List<UserDto> userDtoList = generateUserDtoList(userList);

        when(repository.findAll()).thenReturn(userList);
        when(converter.convert(userList)).thenReturn(userDtoList);

        List<UserDto> result = userService.getAllUsers();

        assertEquals(userDtoList,result);
        verify(repository).findAll();
        verify(converter).convert(userList);

    }

    @Test
    public void testGetUserByMail_whenUserMailExist_itShouldReturnUserDto(){
        String mail = "mail@atakanoguzdev.net";
        UserInformation user = generateUser(mail);
        UserDto userDto = generateUserDto(mail);

        when(repository.findByMail(mail)).thenReturn(Optional.of(user));
        when(converter.convert(user)).thenReturn(userDto);

        UserDto result = userService.getUserByMail(mail);

        assertEquals(userDto,result);
        verify(repository).findByMail(mail);
        verify(converter).convert(user);

    }

    @Test
    public void testGetUserByMail_whenUserMailDoesNotExist_itShouldThrowUserNotFoundException(){
        String mail = "mail@atakanoguzdev.net";

        when(repository.findByMail(mail)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () ->
                userService.getUserByMail(mail)
    );

        verify(repository).findByMail(mail);
        verifyNoInteractions(converter);

    }

    @Test
    public void testCreateUser_itShouldReturnCreatedUserDto(){

        String mail = "mail@atakanoguzdev.net";
        CreateUserRequest request = new CreateUserRequest(mail, "firstName", "lastName", "");
        UserInformation user = new UserInformation(mail,"firstName", "lastName", "",false);
        UserInformation savedUser = new UserInformation(1L,mail,"firstName", "lastName", "",false);
        UserDto userDto = new UserDto(mail,"firstName", "lastName", "");


        when(repository.save(user)).thenReturn(savedUser);
        when(converter.convert(savedUser)).thenReturn(userDto);

        UserDto result = userService.createUser(request);

        assertEquals(userDto,result);
        verify(repository).save(user);
        verify(converter).convert(savedUser);

    }

    @Test
    public void testUpdateUser_whenUserMailExistAndUserIsActive_itShouldReturnUpdatedUserDto(){

        String mail = "mail@atakanoguzdev.net";
        UpdateUserRequest request = new UpdateUserRequest("firstName2", "lastName2", "middleName");
        UserInformation user = new UserInformation(1L,mail,"firstName", "lastName", "",true);
        UserInformation updateUser = new UserInformation(1L,mail,"firstName2", "lastName2", "middleName",true);
        UserInformation savedUser = new UserInformation(1L,mail,"firstName2", "lastName2", "middleName",true);
        UserDto userDto = new UserDto(mail,"firstName2", "lastName2", "middleName");

        when(repository.findByMail(mail)).thenReturn(Optional.of(user));
        when(repository.save(updateUser)).thenReturn(savedUser);
        when(converter.convert(savedUser)).thenReturn(userDto);

        UserDto result = userService.updateUser(mail,request);

        assertEquals(userDto,result);

        verify(repository).findByMail(mail);
        verify(repository).save(updateUser);
        verify(converter).convert(savedUser);

    }

}