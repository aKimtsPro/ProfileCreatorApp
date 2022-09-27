package be.akimts.tries.profilecreator.services.impl;

import be.akimts.lib.jwt.models.AuthDTO;
import be.akimts.lib.jwt.models.RegisterFormSpec;
import be.akimts.lib.jwt.service.AuthService;
import be.akimts.lib.jwt.utils.JwtProvider;
import be.akimts.tries.profilecreator.models.entity.Profile;
import be.akimts.tries.profilecreator.repositories.ProfileRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final ProfileRepository repository;
    private final JwtProvider jwtProvider;

    public AuthServiceImpl(ProfileRepository repository, JwtProvider jwtProvider) {
        this.repository = repository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public AuthDTO register(RegisterFormSpec form) {
        if( repository.findByUsername(form.getUsername()).isPresent() )
            throw new RuntimeException();

        UserDetails user = repository.save( (Profile) form.toEntity() );

        return jwtProvider.generateDTO(
                user.getUsername(),
                user.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .toList()
        );
    }
}
