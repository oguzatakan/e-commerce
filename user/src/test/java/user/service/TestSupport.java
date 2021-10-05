package user.service;

import org.assertj.core.util.Lists;
import user.dto.UserDto;
import user.model.Users;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestSupport {

    public static Long userId = 100L;

    public static List<Users> generateUsers(){
        return IntStream.range(0,5).mapToObj(i->
             new Users((long) i,
                     i + "@atakanoguzdev.net",
                     "firstName" + i,
                     "lastName" + i,
                     "",
                     new Random(2).nextBoolean())).collect(Collectors.toList());
    }

    public static List<UserDto> generateUserDtoList(List<Users> userList){
       return userList.stream()
               .map(from -> new UserDto(from.getMail(), from.getFirstName(), from.getLastName(), from.getMiddleName(), Lists.emptyList()))
               .collect(Collectors.toList());
    }

    public static Users generateUser(String mail){
        return new Users(userId,
                mail,
                "firstName" + userId,
                "lastName" + userId,
                "",
                true);

    }

    public static UserDto generateUserDto(String mail){

        return new UserDto(mail, "firstName" + userId, "lastName" + userId, "", Lists.emptyList());

    }


}
