package com.dowell.castle.registration;

import com.dowell.castle.Action;
import com.dowell.castle.Character;
import com.dowell.castle.CharacterType;
import com.dowell.castle.GameWordService;
import com.dowell.castle.UserProfile;
import com.dowell.castle.UserSession;
import com.dowell.castle.WordMap;
import com.dowell.castle.profile.ProfileService;

public class RegisterAction implements Action {

    private final RegisterView view;
    private final ProfileService profileService;
    private final GameWordService gameWordService;
    private final UserSession userSession;

    public RegisterAction(RegisterView view, ProfileService profileService, GameWordService gameWordService, UserSession userSession) {
        this.view = view;
        this.profileService = profileService;
        this.gameWordService = gameWordService;
        this.userSession = userSession;
    }

    @Override
    public void doAction() {

        String userName = view.getUserName();
        String password = view.getPassword();
        String characterName = view.getCharacterName();
        CharacterType characterType = view.getCharacterType();
        WordMap startGame = gameWordService.getStartGame();


        Character character = new Character.Builder()
                .name(characterName)
                .currentWordMap(startGame)
                .characterType(characterType)
                .build();

        UserProfile profile = new UserProfile.Builder()
                .userName(userName)
                .password(password)
                .character(character)
                .build();

        UserProfile newUserProfile = profileService.createUserProfile(profile);
        userSession.setUserProfile(newUserProfile);
    }
}
