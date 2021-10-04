package user.service;


import org.springframework.stereotype.Service;
import user.dto.*;
import user.exception.UserDetailsNotFoundException;
import user.model.UserDetails;
import user.model.Users;
import user.repository.UserDetailsRepository;

@Service
public class UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;
    private final UserService userService;
    private final UserDetailsDtoConverter converter;

    public UserDetailsService(UserDetailsRepository userDetailsRepository, UserService userService,UserDetailsDtoConverter converter) {
        this.userDetailsRepository = userDetailsRepository;
        this.userService = userService;
        this.converter = converter;
    }

    public UserDetailsDto createUserDetails(final CreateUserDetailsRequest request) {

        Users user = userService.findUserById(request.getUserId());


        UserDetails  userDetails = new UserDetails(request.getPhoneNumber(),
                request.getAddress(),
                request.getCity(),
                request.getCountry(),
                request.getPostCode(),
                user);

        return converter.convert(userDetailsRepository.save(userDetails));
    }

    public UserDetailsDto updateUserDetails(final Long userDetailsId, final UpdateUserDetailsRequest request) {
        UserDetails userDetails = findUserDetailsById(userDetailsId);

        UserDetails  updateUserDetails = new UserDetails(
                userDetails.getId(),
                request.getPhoneNumber(),
                request.getAddress(),
                request.getCity(),
                request.getCountry(),
                request.getPostCode(),
                userDetails.getUsers());

        return converter.convert(userDetailsRepository.save(updateUserDetails));
    }

    public void deleteUserDetails(final Long id){
        findUserDetailsById(id);

        userDetailsRepository.deleteById(id);
    }

    private UserDetails findUserDetailsById(final Long userDetailsId){

        return userDetailsRepository.findById(userDetailsId)
                .orElseThrow(() -> new UserDetailsNotFoundException("User details couldn't be found by following id: " +userDetailsId));
    }

}
