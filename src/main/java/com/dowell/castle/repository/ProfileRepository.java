package com.dowell.castle.repository;

import com.dowell.castle.UserProfile;

public interface ProfileRepository {

    void save(UserProfile inputValue);

    UserProfile getUserProfile(String userName, String securePassword);

    void createUserProfile(UserProfile newUserProfile, String securePassword);
}
