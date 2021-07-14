package user.service;

import user.dto.CreateUserRequest;
import user.dto.UpdateUserRequest;
import user.dto.UserDto;
import user.dto.converter.UserDtoConverter;
import user.exception.UserNotFoundException;
import user.model.User;
import user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    private User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User could not be found by following id: " + id));
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userDtoConverter::convert).collect(Collectors.toList());
    }

    public UserDto getUserById(Long id){
        User user = findUserById(id);
        return userDtoConverter.convert(user);
    }

    public UserDto createUser(CreateUserRequest userRequest) {
        User user = new User( null,
                userRequest.getMail(),
                userRequest.getFirstName(),
                userRequest.getLastName(),
                userRequest.getMiddleName());
        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto updateUser(Long id ,UpdateUserRequest updateUserRequest) {

        User user = findUserById(id);
        User updatedUser = new User(user.getId(),
                user.getMail(),
                updateUserRequest.getFirstName(),
                updateUserRequest.getLastName(),
                updateUserRequest.getMiddleName());
        return userDtoConverter.convert(userRepository.save(updatedUser));
    }
}
