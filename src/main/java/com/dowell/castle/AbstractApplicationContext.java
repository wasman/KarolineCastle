package com.dowell.castle;

import com.dowell.castle.profile.ProfileService;
import com.dowell.castle.profile.SecurityHelper;
import com.dowell.castle.registration.RegisterController;
import com.dowell.castle.registration.RegisterView;
import com.dowell.castle.repository.ProfileRepository;

public abstract class AbstractApplicationContext implements ApplicationContext {

    @Override
    public void init() {
        createRegistrationComponent();
        createLoginComponent();
    }

    public void createLoginComponent() {

    }

    public void createRegistrationComponent() {
        RegisterView view = creatRegisterView();
        UserSession userSession = createUserSession();
        GameWordService gameWordService = createGameWordService();
        ProfileRepository repository = createProfileRepository();
        SecurityHelper securityHelper = createSecurityHelper();

        ProfileService profileService = createProfileService(gameWordService, repository, securityHelper);
        RegisterController controller = createRegisterController(view, userSession, gameWordService, profileService);

//        controller.showUserRegistrationForm();

    }

    protected abstract RegisterController createRegisterController(RegisterView view, UserSession userSession, GameWordService gameWordService, ProfileService profileService);

    protected abstract ProfileService createProfileService(GameWordService gameWordService, ProfileRepository repository, SecurityHelper securityHelper);

    protected abstract SecurityHelper createSecurityHelper();

    protected abstract ProfileRepository createProfileRepository();

    protected abstract GameWordService createGameWordService();

    protected abstract UserSession createUserSession();

    protected abstract RegisterView creatRegisterView();
}
