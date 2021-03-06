package com.dowell.castle.login;

import com.dowell.castle.GameWordService;
import com.dowell.castle.UserSession;
import com.dowell.castle.game.GameView;
import com.dowell.castle.profile.ProfileService;
import com.dowell.castle.registration.RegisterAction;
import com.dowell.castle.registration.RegistrationView;

public class CastlePresenterImpl implements CastlePresenter {

    private final CastleView castleView;
    private final LoginView loginView;
    private final RegistrationView registrationView;
    private final ProfileService profileService;
    private final GameWordService gameWordService;
    private final UserSession userSession;
    private final GameView gameView;

    public CastlePresenterImpl(CastleView castleView, LoginView loginView, RegistrationView registrationView, ProfileService profileService, GameWordService gameWordService, UserSession userSession, GameView gameView) {

        this.castleView = castleView;
        this.loginView = loginView;
        this.registrationView = registrationView;
        this.profileService = profileService;
        this.gameWordService = gameWordService;
        this.userSession = userSession;
        this.gameView = gameView;
    }

    @Override
    public void init() {
        castleView.wireDoLoginAction(new LoginAction(loginView, profileService, userSession, gameView));
        castleView.wireDoRegisterAction(new RegisterAction(
                registrationView, profileService, gameWordService, userSession
        ));
        castleView.promptUserAction();
    }
}
