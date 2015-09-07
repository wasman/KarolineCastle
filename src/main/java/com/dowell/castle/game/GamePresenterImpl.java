package com.dowell.castle.game;

import com.dowell.castle.UserSession;

public class GamePresenterImpl implements GamePresenter {

    private final GameView gameView;
    private final UserSession userSession;
    private final GameHelper gameHelper;

    public GamePresenterImpl(GameView gameView, UserSession userSession, GameHelper gameHelper) {

        this.gameView = gameView;
        this.userSession = userSession;
        this.gameHelper = gameHelper;
        wireActions();
    }

    private void wireActions() {
        gameView.wireMoveAction(new MoveAction(userSession, gameView, gameHelper));

    }

}
