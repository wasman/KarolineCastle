package com.dowell.castle;

import com.dowell.castle.game.GameView;
import com.dowell.castle.game.GameViewImpl;
import com.dowell.castle.login.CastlePresenterImpl;
import com.dowell.castle.login.CastleView;
import com.dowell.castle.login.CastleViewImpl;
import com.dowell.castle.login.LoginView;
import com.dowell.castle.login.LoginViewImpl;
import com.dowell.castle.profile.ProfileService;
import com.dowell.castle.profile.SecurityHelper;
import com.dowell.castle.registration.RegisterPresenter;
import com.dowell.castle.registration.RegistrationView;
import com.dowell.castle.repository.ProfileRepository;

public abstract class AbstractApplicationContext implements ApplicationContext {

    @Override
    public void init() {

        RegistrationView registrationView = creatRegistrationView();
        UserSession userSession = createUserSession();
        GameWordService gameWordService = createGameWordService();
        ProfileRepository profileRepository = createProfileRepository();
        SecurityHelper securityHelper = createSecurityHelper();

        ProfileService profileService = createProfileService(gameWordService, profileRepository, securityHelper);
        RegisterPresenter registrationPresenter = createRegisterController(registrationView, userSession, gameWordService, profileService);

        
        LoginView loginView = new LoginViewImpl();
        CastleView castleView = new CastleViewImpl();
        GameView gameView = new GameViewImpl();
        CastlePresenterImpl castlePresenter = new CastlePresenterImpl(castleView, loginView, registrationView, profileService, gameWordService, userSession, gameView);

        castlePresenter.init();

    }


    protected abstract RegisterPresenter createRegisterController(RegistrationView view, UserSession userSession, GameWordService gameWordService, ProfileService profileService);

    protected abstract ProfileService createProfileService(GameWordService gameWordService, ProfileRepository repository, SecurityHelper securityHelper);

    protected abstract SecurityHelper createSecurityHelper();

    protected abstract ProfileRepository createProfileRepository();

    protected abstract GameWordService createGameWordService();

    protected abstract UserSession createUserSession();

    protected abstract RegistrationView creatRegistrationView();
}
