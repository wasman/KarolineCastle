package com.dowell.castle.game;

import com.dowell.castle.Action;
import com.dowell.castle.ConsoleUtil;
import com.dowell.castle.UserProfile;
import com.dowell.castle.WordMap;

public class GameViewImpl implements GameView {

    private Action moveAction;

    @Override
    public void startGame(UserProfile userProfile) {
        System.out.println("Paling as : " + userProfile.getCharacters().get(0));
        WordMap currentWordMap = userProfile.getCharacters().get(0).getCurrentWordMap();
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
