package com.dowell.castle;

import com.dowell.castle.game.GameHelper;
import com.dowell.castle.game.GameHelperImpl;
import com.dowell.castle.game.GamePresenterImpl;
import com.dowell.castle.game.GameView;
import com.dowell.castle.game.GameViewImpl;
import com.dowell.castle.login.CastlePresenterImpl;
import com.dowell.castle.login.CastleView;
import com.dowell.castle.login.CastleViewImpl;
import com.dowell.castle.login.LoginView;
import com.dowell.castle.login.LoginViewImpl;
import com.dowell.castle.profile.ProfileService;
import com.dowell.castle.profile.ProfileServiceImpl;
import com.dowell.castle.profile.SecurityHelper;
import com.dowell.castle.profile.SecurityHelperImpl;
import com.dowell.castle.registration.RegisterPresenter;
import com.dowell.castle.registration.RegisterPresenterImpl;
import com.dowell.castle.registration.RegistrationView;
import com.dowell.castle.registration.RegistrationViewImpl;
import com.dowell.castle.repository.ProfileRepository;
import com.dowell.castle.repository.ProfileRepositoryImpl;

public class ApplicationContextImpl extends AbstractApplicationContext {

    @Override
    protected RegisterPresenter createRegisterController(RegistrationView view, UserSession userSession, GameWordService gameWordService, ProfileService profileService) {
        return new RegisterPresenterImpl(view, profileService, gameWordService, userSession);
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
    protected UserSession createUserSession(ProfileService profileService) {
        return new UserSessionImpl(profileService);
    }

    @Override
    protected RegistrationView creatRegistrationView() {
        return new RegistrationViewImpl();
    }

    @Override
    protected GamePresenterImpl createGamePresenter(UserSession userSession, GameView gameView, GameHelper gameHelper) {return new GamePresenterImpl(gameView, userSession, gameHelper);}

    @Override
    protected CastlePresenterImpl createCastlePresenter(RegistrationView registrationView, UserSession userSession, GameWordService gameWordService, ProfileService profileService, LoginView loginView, CastleView castleView, GameView gameView) {return new CastlePresenterImpl(castleView, loginView, registrationView, profileService, gameWordService, userSession, gameView);}

    @Override
    protected CastleViewImpl createCastleView() {return new CastleViewImpl();}

    @Override
    protected GameViewImpl createGameView() {return new GameViewImpl();}

    @Override
    protected LoginViewImpl createLoginView() {return new LoginViewImpl();}

    @Override
    protected GameHelperImpl createGameHelper() {return new GameHelperImpl();}
}
