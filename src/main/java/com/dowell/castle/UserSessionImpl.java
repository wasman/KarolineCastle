package com.dowell.castle;

import com.dowell.castle.profile.ProfileService;

public class UserSessionImpl implements UserSession {

    private UserProfile profile;
    private final ProfileService profileService;

    public UserSessionImpl(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Override
    public UserProfile getProfile() {
        return profile;
    }

    @Override
    public void setUserProfile(UserProfile profile) {
        this.profile = profile;
        profileService.save(profile);
    }
}
