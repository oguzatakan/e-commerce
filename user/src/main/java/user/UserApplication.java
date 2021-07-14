package user;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;


@SpringBootApplication
public class UserApplication {

    public static void main(String[] args){ SpringApplication.run(User.class,args); }
}
