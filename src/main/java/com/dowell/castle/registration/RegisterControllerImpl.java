package com.dowell.castle.registration;

import com.dowell.castle.GameWordService;
import com.dowell.castle.UserSession;
import com.dowell.castle.profile.ProfileService;

public class RegisterControllerImpl implements RegisterController {

    private final RegisterView view;
    private final ProfileService profileService;
    private final GameWordService gameWordService;
    private final UserSession userSession;

    public RegisterControllerImpl(RegisterView view, ProfileService profileService, GameWordService gameWordService, UserSession userSession) {
        this.view = view;
        this.profileService = profileService;
        this.gameWordService = gameWordService;
        this.userSession = userSession;
    }

    @Override
    public void wireActions(){
        wireRegisterAction();
    }

    @Override
    public void showUserRegistrationForm() {
        view.showUserRegistrationForm();
    }

    void wireRegisterAction() {
        view.wireRegisterAction(new RegisterAction(view, profileService, gameWordService, userSession));
    }

}
