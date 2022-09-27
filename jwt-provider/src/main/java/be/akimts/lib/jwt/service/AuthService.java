package be.akimts.lib.jwt.service;

import be.akimts.lib.jwt.models.AuthDTO;
import be.akimts.lib.jwt.models.RegisterFormSpec;

public interface AuthService {

    AuthDTO register(RegisterFormSpec form);

}
