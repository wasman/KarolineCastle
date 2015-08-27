package com.dowell.castle.auth;

import com.dowell.castle.Character;
import com.dowell.castle.GameWordService;
import com.dowell.castle.UserProfile;
import com.dowell.castle.WordMap;
import com.dowell.castle.repository.ProfileRepository;

public class AuthenticationServiceImpl implements AuthenticationService {

    private final SecurityHelper securityHelper;
    private final ProfileRepository repository;
    private final GameWordService gameWordService;

    public AuthenticationServiceImpl(SecurityHelper securityHelper, ProfileRepository repository, GameWordService gameWordService) {
        this.securityHelper = securityHelper;
        this.repository = repository;
        this.gameWordService = gameWordService;
    }

    @Override
    public UserProfile getUserProfile(String userName, String password) throws AuthenticationException {
        String securePassword = securityHelper.getSecurePassword(password);
        UserProfile userProfile = repository.getUserProfile(userName, securePassword);
        if (userProfile == null) {
            throw new AuthenticationException("No such user");
        }
        return userProfile;
    }

    @Override
    public UserProfile createUserProfile(String userName, String password) {
        String securePassword = securityHelper.getSecurePassword(password);
        WordMap startGame = gameWordService.getStartGame();
        Character character = new Character.Builder()
                .currentWordMap(startGame)
                .build();

        UserProfile userProfile = new UserProfile.Builder()
                .userName(userName)
                .character(character)
                .build();
        repository.createUserProfile(userProfile,securePassword);
        return userProfile;
    }
}
