package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String hashPassword;
    private String salt;

}
