package com.dowell.castle.game;

import com.dowell.castle.Action;
import com.dowell.castle.Character;
import com.dowell.castle.Position;
import com.dowell.castle.UserProfile;
import com.dowell.castle.UserSession;
import com.dowell.castle.WordMap;
import com.dowell.castle.WordMapImpl;

import static java.util.Arrays.asList;

public class MoveAction implements Action {

    private final UserSession userSession;
    private final GameView gameView;
    private final GameHelper gameHelper;

    public MoveAction(UserSession userSession, GameView gameView, GameHelper gameHelper) {

        this.userSession = userSession;
        this.gameView = gameView;
        this.gameHelper = gameHelper;
    }

    @Override
    public void doAction() {
        String moveAction = gameView.requestUserMoveAction();
        UserProfile profile = userSession.getProfile();
        Character character = profile.getCharacters().get(0);
        WordMap currentWordMap = character.getCurrentWord();
        Position characterLocation = currentWordMap.getCharacterLocation();
        Position newCharacterLocation;
        switch (moveAction) {
            case "1":
                newCharacterLocation = new Position(characterLocation.getXaix() - 1, characterLocation.getYaix());
                break;
            case "2":
                newCharacterLocation = new Position(characterLocation.getXaix(), characterLocation.getYaix() - 1);
                break;
            case "3":
                newCharacterLocation = new Position(characterLocation.getXaix(), characterLocation.getYaix() + 1);
                break;
            case "4":
                newCharacterLocation = new Position(characterLocation.getXaix() + 1, characterLocation.getYaix());
                break;
            default:
                newCharacterLocation = characterLocation;
                break;
        }

        Character updatedCharacter = new Character.Builder(character)
                .currentWord(new WordMapImpl.Builder(currentWordMap)
                        .characterLocation(newCharacterLocation)
                        .build())
                .build();

        Character newCharacter = gameHelper.processActionCell(updatedCharacter);

        UserProfile newProfile = new UserProfile.Builder(profile)
                .characters(asList(newCharacter))
                .build();
        userSession.setUserProfile(newProfile);
        gameView.displayGame(newProfile);

    }
}
