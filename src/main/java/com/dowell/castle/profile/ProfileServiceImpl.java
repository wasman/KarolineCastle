package com.dowell.castle.profile;

import com.dowell.castle.GameWordService;
import com.dowell.castle.UserProfile;
import com.dowell.castle.repository.ProfileRepository;

public class ProfileServiceImpl implements ProfileService {

    private final SecurityHelper securityHelper;
    private final ProfileRepository repository;
    private final GameWordService gameWordService;

    public ProfileServiceImpl(SecurityHelper securityHelper, ProfileRepository repository, GameWordService gameWordService) {
        this.securityHelper = securityHelper;
        this.repository = repository;
        this.gameWordService = gameWordService;
    }

    @Override
    public UserProfile getUserProfile(String userName, String password) throws AuthenticationException {
        String securePassword = securityHelper.getSecurePassword(password);
        UserProfile userProfile = repository.get(userName);
        if (userProfile == null || !securePassword.equals(userProfile.getPassword())) {
            throw new AuthenticationException("No such user");
        }
        return userProfile;
    }

    @Override
    public UserProfile createUserProfile(UserProfile userProfile) {
        String securePassword = securityHelper.getSecurePassword(userProfile.getPassword());

        UserProfile newUserProfile = new UserProfile.Builder(userProfile)
                .password(securePassword)
                .build();

        repository.create(newUserProfile);
        return newUserProfile;
    }

    @Override
    public void save(UserProfile profile) {

        repository.save(profile);
    }
}
