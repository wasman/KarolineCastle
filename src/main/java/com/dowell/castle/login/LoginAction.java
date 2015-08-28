package com.dowell.castle.login;

import com.dowell.castle.Action;
import com.dowell.castle.UserProfile;
import com.dowell.castle.UserSession;
import com.dowell.castle.profile.AuthenticationException;
import com.dowell.castle.profile.ProfileService;

public class LoginAction implements Action{

    private final LoginView loginView;
    private final ProfileService profileService;
    private final UserSession userSession;

    public LoginAction(LoginView loginView, ProfileService profileService, UserSession userSession) {

        this.loginView = loginView;
        this.profileService = profileService;
        this.userSession = userSession;
    }

    @Override
    public void doAction() {
        System.out.println("Login:");
        String userName = loginView.getUserName();
        String password = loginView.getPassword();
        UserProfile userProfile = null;
        try {
            userProfile = profileService.getUserProfile(userName, password);
            userSession.setUserProfile(userProfile);
        }
        catch (AuthenticationException e) {
            System.out.println(e.getMessage());
        }


    }
}
