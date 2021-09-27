package de.keeyzar.checkimdb.imdbclone.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    @NotNull
    private String username;
    @NotNull
    private String password;
    private String matchingPassword;
}