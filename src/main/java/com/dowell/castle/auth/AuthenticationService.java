package com.dowell.castle.auth;

import com.dowell.castle.UserProfile;

public interface AuthenticationService {

    UserProfile getUserProfile(String userName, String password) throws AuthenticationException;

    UserProfile createUserProfile(String userName, String password);
}
