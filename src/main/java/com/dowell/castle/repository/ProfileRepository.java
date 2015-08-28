package com.dowell.castle.repository;

import com.dowell.castle.UserProfile;

public interface ProfileRepository {

    void save(UserProfile inputValue);

    UserProfile get(String userName);

    void create(UserProfile newUserProfile);
}
