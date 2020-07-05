package by.learn.mainmicro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOMain {


    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String role;
}
