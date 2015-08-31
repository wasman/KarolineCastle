package com.dowell.castle.login;

import com.dowell.castle.Action;
import com.dowell.castle.Character;
import com.dowell.castle.UserProfile;
import com.dowell.castle.UserSession;
import com.dowell.castle.game.GameView;
import com.dowell.castle.profile.AuthenticationException;
import com.dowell.castle.profile.ProfileService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoginAction implements Action{

    private final LoginView loginView;
    private final ProfileService profileService;
    private final UserSession userSession;
    private final GameView gameView;

    public LoginAction(LoginView loginView, ProfileService profileService, UserSession userSession, GameView gameView) {

        this.loginView = loginView;
        this.profileService = profileService;
        this.userSession = userSession;
        this.gameView = gameView;
    }

    @Override
    public void doAction() {
        System.out.println("Login:");
        String userName = loginView.getUserName();
        String password = loginView.getPassword();
        try {
            UserProfile userProfile = profileService.getUserProfile(userName, password);
            List<Character> characters = userProfile.getCharacters();
            String currentCharacterName = loginView.getCurrentCharacterName(characters);


            List<Character> updatedListOfCharacters = updatedListOfCharacters(currentCharacterName, characters);
            UserProfile updatedUserProfile = new UserProfile.Builder(userProfile)
                    .characters(updatedListOfCharacters)
                    .build();

            userSession.setUserProfile(updatedUserProfile);
            gameView.startGame(updatedUserProfile);

        }
        catch (AuthenticationException e) {
            System.out.println(e.getMessage());
        }


    }

    private List<Character> updatedListOfCharacters(String currentCharacterName, List<Character> characters) {
        List<Character> updatedListOfCharacters = new ArrayList<>(characters);
        for(int i = 0; i <= updatedListOfCharacters.size(); i++ ){
            if(currentCharacterName.equals(updatedListOfCharacters.get(i).getName())){
                Collections.swap(updatedListOfCharacters, i, 0 );
                return updatedListOfCharacters;
            }
        }
        return characters;
    }
}
