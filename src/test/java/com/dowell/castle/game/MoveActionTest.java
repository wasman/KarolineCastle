package com.dowell.castle.game;

import com.dowell.castle.ActionCell;
import com.dowell.castle.CellType;
import com.dowell.castle.Character;
import com.dowell.castle.Position;
import com.dowell.castle.UserProfile;
import com.dowell.castle.UserSession;
import com.dowell.castle.WordMap;
import com.dowell.castle.WordMapImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MoveActionTest {

    @Test
    public void testDoActionMoveLeft() throws Exception {
        // initialize variable inputs

        WordMap currentWordMap = new WordMapImpl.Builder()
                .characterLocation(new Position(5, 5))
                .build();

        Character character = new Character.Builder()
                .name("doom")
                .currentWord(currentWordMap)
                .experience(0)
                .build();
        UserProfile userProfile = new UserProfile.Builder()
                .characters(asList(character))
                .build();

        WordMap expectedCurrentWordMap = new WordMapImpl.Builder()
                .characterLocation(new Position(4, 5))
                .build();
        Character expectedCharacter = new Character.Builder()
                .name("doom")
                .experience(0)
                .currentWord(expectedCurrentWordMap)
                .build();
        UserProfile expectedUserProfile = new UserProfile.Builder()
                .characters(asList(expectedCharacter))
                .build();

        // initialize mocks
        GameView view = mock(GameView.class);
        when(view.requestUserMoveAction()).thenReturn("1");

        UserSession userSession = mock(UserSession.class);
        when(userSession.getProfile()).thenReturn(userProfile);

        GameHelper gameHelper = mock(GameHelper.class);

        // initialize class to test
        MoveAction testClass = new MoveAction(userSession, view, gameHelper);
        when(gameHelper.processActionCell(expectedCharacter)).thenReturn(expectedCharacter);

        // invoke method on class to test
        testClass.doAction();

        // assert return value

        // verify mock expectations
        verify(view).displayGame(expectedUserProfile);
        verify(userSession).setUserProfile(expectedUserProfile);

    }

    @Test
    public void testDoActionMoveRight() throws Exception {
        // initialize variable inputs

        WordMap currentWordMap = new WordMapImpl.Builder()
                .characterLocation(new Position(5, 5))
                .build();

        Character character = new Character.Builder()
                .name("doom")
                .currentWord(currentWordMap)
                .experience(0)
                .build();
        UserProfile userProfile = new UserProfile.Builder()
                .characters(asList(character))
                .build();

        WordMap expectedCurrentWordMap = new WordMapImpl.Builder()
                .characterLocation(new Position(6, 5))
                .build();
        Character expectedCharacter = new Character.Builder()
                .name("doom")
                .experience(0)
                .currentWord(expectedCurrentWordMap)
                .build();
        UserProfile expectedUserProfile = new UserProfile.Builder()
                .characters(asList(expectedCharacter))
                .build();

        // initialize mocks
        GameView view = mock(GameView.class);
        when(view.requestUserMoveAction()).thenReturn("4");

        UserSession userSession = mock(UserSession.class);
        when(userSession.getProfile()).thenReturn(userProfile);

        GameHelper gameHelper = mock(GameHelper.class);
        when(gameHelper.processActionCell(expectedCharacter)).thenReturn(expectedCharacter);

        // initialize class to test
        MoveAction testClass = new MoveAction(userSession, view, gameHelper);

        // invoke method on class to test
        testClass.doAction();

        // assert return value

        // verify mock expectations
        verify(view).displayGame(expectedUserProfile);
        verify(userSession).setUserProfile(expectedUserProfile);

    }

    @Test
    public void testDoActionMoveUp() throws Exception {
        // initialize variable inputs

        WordMap currentWordMap = new WordMapImpl.Builder()
                .characterLocation(new Position(5, 5))
                .build();

        Character character = new Character.Builder()
                .name("doom")
                .currentWord(currentWordMap)
                .experience(0)
                .build();
        UserProfile userProfile = new UserProfile.Builder()
                .characters(asList(character))
                .build();

        WordMap expectedCurrentWordMap = new WordMapImpl.Builder()
                .characterLocation(new Position(5, 4))
                .build();
        Character expectedCharacter = new Character.Builder()
                .name("doom")
                .experience(0)
                .currentWord(expectedCurrentWordMap)
                .build();
        UserProfile expectedUserProfile = new UserProfile.Builder()
                .characters(asList(expectedCharacter))
                .build();

        // initialize mocks
        GameView view = mock(GameView.class);
        when(view.requestUserMoveAction()).thenReturn("2");

        UserSession userSession = mock(UserSession.class);
        when(userSession.getProfile()).thenReturn(userProfile);

        GameHelper gameHelper = mock(GameHelper.class);
        when(gameHelper.processActionCell(expectedCharacter)).thenReturn(expectedCharacter);

        // initialize class to test
        MoveAction testClass = new MoveAction(userSession, view, gameHelper);

        // invoke method on class to test
        testClass.doAction();

        // assert return value

        // verify mock expectations
        verify(view).displayGame(expectedUserProfile);
        verify(userSession).setUserProfile(expectedUserProfile);

    }

    @Test
    public void testDoActionMoveDown() throws Exception {
        // initialize variable inputs

        WordMap currentWordMap = new WordMapImpl.Builder()
                .characterLocation(new Position(5, 5))
                .build();

        Character character = new Character.Builder()
                .name("doom")
                .currentWord(currentWordMap)
                .experience(0)
                .build();
        UserProfile userProfile = new UserProfile.Builder()
                .characters(asList(character))
                .build();

        WordMap expectedCurrentWordMap = new WordMapImpl.Builder()
                .characterLocation(new Position(5, 6))
                .build();
        Character expectedCharacter = new Character.Builder()
                .name("doom")
                .experience(0)
                .currentWord(expectedCurrentWordMap)
                .build();
        UserProfile expectedUserProfile = new UserProfile.Builder()
                .characters(asList(expectedCharacter))
                .build();

        // initialize mocks
        GameView view = mock(GameView.class);
        when(view.requestUserMoveAction()).thenReturn("3");

        GameHelper gameHelper = mock(GameHelper.class);
        when(gameHelper.processActionCell(expectedCharacter)).thenReturn(expectedCharacter);

        UserSession userSession = mock(UserSession.class);
        when(userSession.getProfile()).thenReturn(userProfile);

        // initialize class to test
        MoveAction testClass = new MoveAction(userSession, view, gameHelper);

        // invoke method on class to test
        testClass.doAction();

        // assert return value

        // verify mock expectations
        verify(view).displayGame(expectedUserProfile);
        verify(userSession).setUserProfile(expectedUserProfile);

    }

    @Test
    public void testDoActionMoveDownAndFightModeExecuted() throws Exception {
        // initialize variable inputs

        ActionCell ork = new ActionCell.Builder()
                .cellType(CellType.ENEMY)
                .title("Ork")
                .build();
        Map<Position, ActionCell> currentWordMap = new HashMap<>();

        currentWordMap.put(new Position(5, 6), ork);

        WordMap currentWord = new WordMapImpl.Builder()
                .characterLocation(new Position(5, 5))
                .wordMap(currentWordMap)
                .build();

        Character character = new Character.Builder()
                .name("doom")
                .currentWord(currentWord)
                .experience(0)
                .build();

        UserProfile userProfile = new UserProfile.Builder()
                .characters(asList(character))
                .build();

        WordMap updateCurrentWordMap = new WordMapImpl.Builder(currentWord)
                        .characterLocation(new Position(5, 6))
                        .build();

        WordMap expectedCurrentWordMap = new WordMapImpl.Builder()
                .characterLocation(new Position(5, 6))
                .build();

        Character updatedCharacter = new Character.Builder()
                        .name("doom")
                        .experience(0)
                        .currentWord(updateCurrentWordMap)
                        .build();

        Character expectedCharacter = new Character.Builder()
                .name("doom")
                .experience(1)
                .currentWord(expectedCurrentWordMap)
                .build();

        UserProfile expectedUserProfile = new UserProfile.Builder()
                .characters(asList(expectedCharacter))
                .build();

        // initialize mocks
        GameView view = mock(GameView.class);
        when(view.requestUserMoveAction()).thenReturn("3");

        UserSession userSession = mock(UserSession.class);
        when(userSession.getProfile()).thenReturn(userProfile);

        GameHelper gameHelper = mock(GameHelper.class);
        when(gameHelper.processActionCell(updatedCharacter)).thenReturn(expectedCharacter);

        // initialize class to test
        MoveAction testClass = new MoveAction(userSession, view, gameHelper);

        // invoke method on class to test
        testClass.doAction();

        // assert return value

        // verify mock expectations
        verify(view).displayGame(expectedUserProfile);
        verify(userSession).setUserProfile(expectedUserProfile);

    }
}