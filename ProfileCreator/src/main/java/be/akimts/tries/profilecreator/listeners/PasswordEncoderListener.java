package be.akimts.tries.profilecreator.listeners;

import be.akimts.tries.profilecreator.models.entity.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class PasswordEncoderListener {

    private static PasswordEncoder encoder;

    @PreUpdate
    @PrePersist
    public void encrypt(Profile a) {
        a.setPassword( encoder.encode(a.getPassword()) );
    }

    // TODO feels dirty
    public static void setPasswordEncoder(PasswordEncoder encoder){
//        if(PasswordEncoderListener.encoder == null)
//            throw new IllegalStateException("encoder has already been set");

        PasswordEncoderListener.encoder = encoder;
    }

}
