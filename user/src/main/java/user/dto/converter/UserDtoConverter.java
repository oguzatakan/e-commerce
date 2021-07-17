package user.dto.converter;

import user.dto.UserDto;
import org.springframework.stereotype.Component;
import user.model.UserInformation;

@Component
public class UserDtoConverter {

    public UserDto convert(UserInformation from){
        return new UserDto(from.getMail(),from.getFirstName(),from.getLastName(),from.getMiddleName());
    }
}
