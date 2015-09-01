package com.dowell.castle.game;

import com.dowell.castle.UserSession;

public class GamePresenterImpl implements GamePresenter {

    private final GameView gameView;
    private final UserSession userSession;

    public GamePresenterImpl(GameView gameView, UserSession userSession) {

        this.gameView = gameView;
        this.userSession = userSession;
        wireActions();
    }

    private void wireActions() {
        gameView.wireMoveAction(new MoveAction(userSession, gameView));

    }

}
