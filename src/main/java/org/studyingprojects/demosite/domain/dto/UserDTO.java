package org.studyingprojects.demosite.domain.dto;

import org.studyingprojects.demosite.domain.model.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
public class UserDTO {

    @NotBlank
    @Size(min = 4, message = "Username should be at least 4 symbols.")
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String confirm;


    public User toUser(PasswordEncoder passwordEncoder) {
        if (!confirm.equals(password)) {
            throw new IllegalArgumentException("Passwords should match, boi");
        }
        return new User(username, passwordEncoder.encode(password));
    }

}
