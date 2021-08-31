package org.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
