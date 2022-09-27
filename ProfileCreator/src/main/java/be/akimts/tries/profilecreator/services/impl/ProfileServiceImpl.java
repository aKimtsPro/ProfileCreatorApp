package be.akimts.tries.profilecreator.services.impl;

import be.akimts.tries.profilecreator.models.form.RegisterForm;
import be.akimts.tries.profilecreator.repositories.ProfileRepository;
import be.akimts.tries.profilecreator.services.ProfileService;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;

    public ProfileServiceImpl(ProfileRepository repository) {
        this.repository = repository;
    }

}
