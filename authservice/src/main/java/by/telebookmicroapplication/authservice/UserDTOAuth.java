package by.telebookmicroapplication.authservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOAuth {


    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String role;
}
