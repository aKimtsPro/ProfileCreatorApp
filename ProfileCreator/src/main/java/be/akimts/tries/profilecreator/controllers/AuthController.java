package be.akimts.tries.profilecreator.controllers;

import be.akimts.lib.jwt.controllers.AbstractAuthController;
import be.akimts.lib.jwt.service.AuthService;
import be.akimts.lib.jwt.utils.JwtProvider;
import be.akimts.tries.profilecreator.models.form.LoginForm;
import be.akimts.tries.profilecreator.models.form.RegisterForm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController extends AbstractAuthController<LoginForm, RegisterForm> {
    public AuthController(JwtProvider provider, AuthService userService, AuthenticationManager manager) {
        super(provider, userService, manager);
    }
}
