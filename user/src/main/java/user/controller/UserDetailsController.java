package user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.dto.CreateUserDetailsRequest;
import user.dto.UpdateUserDetailsRequest;
import user.dto.UpdateUserRequest;
import user.dto.UserDetailsDto;
import user.service.UserDetailsService;

@RestController
@RequestMapping("/v1/userdetails")
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping
    public ResponseEntity<UserDetailsDto> createUserDetails(@RequestBody CreateUserDetailsRequest request){
        return  ResponseEntity.ok(userDetailsService.createUserDetails(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetailsDto> updateUserDetails(@PathVariable Long id, @RequestBody UpdateUserDetailsRequest request){
        return ResponseEntity.ok(userDetailsService.updateUserDetails(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserDetails(@PathVariable Long id){
        userDetailsService.deleteUserDetails(id);
        return ResponseEntity.ok().build();
    }

}
