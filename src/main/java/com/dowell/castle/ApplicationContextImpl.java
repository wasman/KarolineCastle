package com.dowell.castle;

import com.dowell.castle.profile.ProfileService;
import com.dowell.castle.profile.ProfileServiceImpl;
import com.dowell.castle.profile.SecurityHelper;
import com.dowell.castle.profile.SecurityHelperImpl;
import com.dowell.castle.registration.RegisterController;
import com.dowell.castle.registration.RegisterControllerImpl;
import com.dowell.castle.registration.RegisterView;
import com.dowell.castle.registration.RegisterViewImpl;
import com.dowell.castle.repository.ProfileRepository;
import com.dowell.castle.repository.ProfileRepositoryImpl;

public class ApplicationContextImpl extends AbstractApplicationContext {

    @Override
    protected RegisterController createRegisterController(RegisterView view, UserSession userSession, GameWordService gameWordService, ProfileService profileService) {
        return new RegisterControllerImpl(view, profileService, gameWordService, userSession);
    }

    @Override
    protected ProfileService createProfileService(GameWordService gameWordService, ProfileRepository repository, SecurityHelper securityHelper) {
        return new ProfileServiceImpl(securityHelper, repository, gameWordService);
    }

    @Override
    protected SecurityHelper createSecurityHelper() {
        return new SecurityHelperImpl();
    }

    @Override
    protected ProfileRepository createProfileRepository() {
        return new ProfileRepositoryImpl();
    }

    @Override
    protected GameWordService createGameWordService() {
        return new GameWordServiceImpl();
    }

    @Override
    protected UserSession createUserSession() {
        return new UserSessionImpl();
    }

    @Override
    protected RegisterView creatRegisterView() {
        return new RegisterViewImpl();
    }
}
