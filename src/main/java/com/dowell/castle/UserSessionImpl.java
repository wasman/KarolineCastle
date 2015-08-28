package com.dowell.castle;

public class UserSessionImpl implements UserSession {

    private UserProfile profile;

    public UserProfile getProfile() {
        return profile;
    }

    @Override
    public void setUserProfile(UserProfile profile) {
        this.profile = profile;

        System.out.println(profile);
    }
}
