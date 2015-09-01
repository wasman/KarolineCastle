package com.dowell.castle;

public interface UserSession {

    UserProfile getProfile();

    void setUserProfile(UserProfile newProfile);
}
