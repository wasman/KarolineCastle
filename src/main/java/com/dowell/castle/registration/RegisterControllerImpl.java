package com.dowell.castle.registration;

import com.dowell.castle.GameWordService;
import com.dowell.castle.profile.ProfileService;

public class RegisterControllerImpl implements RegisterController {

    private final RegisterView view;
    private final ProfileService profileService;
    private final GameWordService gameWordService;

    public RegisterControllerImpl(RegisterView view, ProfileService profileService, GameWordService gameWordService) {
        this.view = view;
        this.profileService = profileService;
        this.gameWordService = gameWordService;
    }

    @Override
    public void showUserRegistrationForm() {
        view.showUserRegistrationForm();
    }

    @Override
    public void wireRegisterAction() {
        view.wireRegisterAction(new RegisterAction(view, profileService, gameWordService, null));
    }

    @Override
    public void doRegister() {

    }
}
