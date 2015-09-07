package com.dowell.castle.game;

import com.dowell.castle.Action;
import com.dowell.castle.Character;
import com.dowell.castle.ConsoleUtil;
import com.dowell.castle.UserProfile;
import com.dowell.castle.WordMap;

public class GameViewImpl implements GameView {

    private Action moveAction;

    @Override
    public void displayGame(UserProfile userProfile) {
        System.out.println("Profile status : " + userProfile.getCharacters().get(0));
        Character character = userProfile.getCharacters().get(0);
        System.out.println("Playing as : " + character.getName() + " experience : " +character.getExperience());
        WordMap currentWordMap = userProfile.getCharacters().get(0).getCurrentWord();
        ConsoleUtil.displayWord(currentWordMap);
        moveAction.doAction();

    }

    @Override
    public String requestUserMoveAction() {return ConsoleUtil.promptUserInput("Your Next Step (1-Left, 2-Up, 3-Down, 4-Right)");}

    @Override
    public void wireMoveAction(Action action) {
        this.moveAction = action;
    }
}
