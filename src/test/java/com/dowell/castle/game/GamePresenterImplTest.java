package com.dowell.castle.game;

import com.dowell.castle.UserSession;
import org.junit.Test;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GamePresenterImplTest {

    @Test
    public void testInit() throws Exception {
        // initialize variable inputs


        // initialize mocks
        GameView gameView = mock(GameView.class);
        UserSession userSession = mock(UserSession.class);

        // initialize class to test
        GamePresenter testClass = new GamePresenterImpl(gameView, userSession);

        // invoke method on class to test

        // assert return value

        // verify mock expectations
        verify(gameView).wireMoveAction(isA(MoveAction.class));
    }

}