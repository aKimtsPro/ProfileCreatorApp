package be.akimts.tries.profilecreator.models.form;

import be.akimts.lib.jwt.models.RegisterFormSpec;
import be.akimts.tries.profilecreator.models.entity.Profile;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterForm implements RegisterFormSpec {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public Profile toEntity(){
        Profile profile = new Profile();

        profile.setUsername(username);
        profile.setPassword(password);

        return profile;
    }

}
