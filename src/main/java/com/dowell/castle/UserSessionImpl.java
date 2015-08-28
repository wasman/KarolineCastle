package com.dowell.castle;

public class UserSessionImpl implements UserSession {

    private UserProfile profile;

    @Override
    public void setUserProfile(UserProfile profile) {

        this.profile = profile;
    }
}
