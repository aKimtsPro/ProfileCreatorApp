package be.akimts.lib.jwt.controllers;

import be.akimts.lib.jwt.utils.JwtProvider;
import be.akimts.lib.jwt.models.AuthDTO;
import be.akimts.lib.jwt.models.LoginFormSpec;
import be.akimts.lib.jwt.models.RegisterFormSpec;
import be.akimts.lib.jwt.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin("*")
@RequestMapping("/auth")
public abstract class AbstractAuthController<LFORM extends LoginFormSpec, RFORM extends RegisterFormSpec> {

    private final JwtProvider provider;
    private final AuthService userService;
    private final AuthenticationManager manager;

    public AbstractAuthController(JwtProvider provider, AuthService userService, AuthenticationManager manager) {
        this.provider = provider;
        this.userService = userService;
        this.manager = manager;
    }

    @PostMapping("/login")
    public AuthDTO login(@Valid @RequestBody LFORM form){
        Authentication auth = manager.authenticate( new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));
        return provider.generateDTO(
                auth.getName(),
                auth.getAuthorities().stream().map( GrantedAuthority::getAuthority ).toList()
        );
    }

    @PostMapping("/register")
    public AuthDTO register(@Valid @RequestBody RFORM form){
        return userService.register(form);
    }
}
