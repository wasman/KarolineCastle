package com.dowell.castle.game;

import com.dowell.castle.Action;
import com.dowell.castle.UserProfile;

public interface GameView {

    void displayGame(UserProfile updatedUserProfile);

    String requestUserMoveAction();

    void wireMoveAction(Action action);
}
