package com.dowell.castle;

import com.dowell.castle.game.GameHelper;
import com.dowell.castle.game.GameHelperImpl;
import com.dowell.castle.game.GamePresenter;
import com.dowell.castle.game.GamePresenterImpl;
import com.dowell.castle.game.GameView;
import com.dowell.castle.game.GameViewImpl;
import com.dowell.castle.login.CastlePresenter;
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
        GameWordService gameWordService = createGameWordService();
        ProfileRepository profileRepository = createProfileRepository();
        SecurityHelper securityHelper = createSecurityHelper();

        ProfileService profileService = createProfileService(gameWordService, profileRepository, securityHelper);
        UserSession userSession = createUserSession(profileService);

        RegisterPresenter registrationPresenter = createRegisterController(registrationView, userSession, gameWordService, profileService);

        LoginView loginView = createLoginView();
        CastleView castleView = createCastleView();
        GameView gameView = createGameView();
        CastlePresenter castlePresenter = createCastlePresenter(registrationView, userSession, gameWordService, profileService, loginView, castleView, gameView);
        GameHelper gameHelper = createGameHelper();
        GamePresenter gamePresenter = createGamePresenter(userSession, gameView, gameHelper);

        castlePresenter.init();

    }

    protected GamePresenterImpl createGamePresenter(UserSession userSession, GameView gameView, GameHelper gameHelper) {return new GamePresenterImpl(gameView, userSession, gameHelper);}

    protected abstract CastlePresenterImpl createCastlePresenter(RegistrationView registrationView, UserSession userSession, GameWordService gameWordService, ProfileService profileService, LoginView loginView, CastleView castleView, GameView gameView);

    protected abstract CastleViewImpl createCastleView();

    protected abstract GameViewImpl createGameView();

    protected abstract LoginViewImpl createLoginView();

    protected abstract GameHelperImpl createGameHelper();

    protected abstract RegisterPresenter createRegisterController(RegistrationView view, UserSession userSession, GameWordService gameWordService, ProfileService profileService);

    protected abstract ProfileService createProfileService(GameWordService gameWordService, ProfileRepository repository, SecurityHelper securityHelper);

    protected abstract SecurityHelper createSecurityHelper();

    protected abstract ProfileRepository createProfileRepository();

    protected abstract GameWordService createGameWordService();

    protected abstract UserSession createUserSession(ProfileService profileService);

    protected abstract RegistrationView creatRegistrationView();
}
