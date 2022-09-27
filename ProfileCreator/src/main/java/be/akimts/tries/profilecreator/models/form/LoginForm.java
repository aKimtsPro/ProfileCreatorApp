package be.akimts.tries.profilecreator.models.form;

import be.akimts.lib.jwt.models.LoginFormSpec;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginForm implements LoginFormSpec {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
