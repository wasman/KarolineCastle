package com.dowell.castle.profile;

import com.dowell.castle.UserProfile;

public interface ProfileService {

    UserProfile getUserProfile(String userName, String password) throws AuthenticationException;

    UserProfile createUserProfile(UserProfile userProfile);
}
