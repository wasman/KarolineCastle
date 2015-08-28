package com.dowell.castle.registration;

import com.dowell.castle.GameWordService;
import com.dowell.castle.UserSession;
import com.dowell.castle.profile.ProfileService;

public class RegisterPresenterImpl implements RegisterPresenter {

    private final RegistrationView view;
    private final ProfileService profileService;
    private final GameWordService gameWordService;
    private final UserSession userSession;

    public RegisterPresenterImpl(RegistrationView view, ProfileService profileService, GameWordService gameWordService, UserSession userSession) {
        this.view = view;
        this.profileService = profileService;
        this.gameWordService = gameWordService;
        this.userSession = userSession;
    }



}
