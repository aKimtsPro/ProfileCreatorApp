package be.akimts.lib.jwt.models;

import org.springframework.security.core.userdetails.UserDetails;

public interface RegisterFormSpec {


    String getUsername();
    String getPassword();
    UserDetails toEntity();

}
