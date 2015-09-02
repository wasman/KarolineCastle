package com.dowell.castle.game;

import com.dowell.castle.Character;
import com.dowell.castle.Position;
import com.dowell.castle.UserProfile;
import com.dowell.castle.UserSession;
import com.dowell.castle.WordMap;
import com.dowell.castle.WordMapImpl;
import org.junit.Test;

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
                .currentWordMap(currentWordMap)
                .build();
        UserProfile userProfile = new UserProfile.Builder()
                .characters(asList(character))
                .build();

        WordMap expectedCurrentWordMap = new WordMapImpl.Builder()
                .characterLocation(new Position(4, 5))
                .build();
        Character expectedCharacter = new Character.Builder()
                .name("doom")
                .currentWordMap(expectedCurrentWordMap)
                .build();
        UserProfile expectedUserProfile = new UserProfile.Builder()
                .characters(asList(expectedCharacter))
                .build();

        // initialize mocks
        GameView view = mock(GameView.class);
        when(view.requestUserMoveAction()).thenReturn("1");

        UserSession userSession = mock(UserSession.class);
        when(userSession.getProfile()).thenReturn(userProfile);

        // initialize class to test
        MoveAction testClass = new MoveAction(userSession, view);

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
                   .currentWordMap(currentWordMap)
                   .build();
           UserProfile userProfile = new UserProfile.Builder()
                   .characters(asList(character))
                   .build();

           WordMap expectedCurrentWordMap = new WordMapImpl.Builder()
                   .characterLocation(new Position(6, 5))
                   .build();
           Character expectedCharacter = new Character.Builder()
                   .name("doom")
                   .currentWordMap(expectedCurrentWordMap)
                   .build();
           UserProfile expectedUserProfile = new UserProfile.Builder()
                   .characters(asList(expectedCharacter))
                   .build();

           // initialize mocks
           GameView view = mock(GameView.class);
           when(view.requestUserMoveAction()).thenReturn("4");

           UserSession userSession = mock(UserSession.class);
           when(userSession.getProfile()).thenReturn(userProfile);

           // initialize class to test
           MoveAction testClass = new MoveAction(userSession, view);

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
                   .currentWordMap(currentWordMap)
                   .build();
           UserProfile userProfile = new UserProfile.Builder()
                   .characters(asList(character))
                   .build();

           WordMap expectedCurrentWordMap = new WordMapImpl.Builder()
                   .characterLocation(new Position(5, 4))
                   .build();
           Character expectedCharacter = new Character.Builder()
                   .name("doom")
                   .currentWordMap(expectedCurrentWordMap)
                   .build();
           UserProfile expectedUserProfile = new UserProfile.Builder()
                   .characters(asList(expectedCharacter))
                   .build();

           // initialize mocks
           GameView view = mock(GameView.class);
           when(view.requestUserMoveAction()).thenReturn("2");

           UserSession userSession = mock(UserSession.class);
           when(userSession.getProfile()).thenReturn(userProfile);

           // initialize class to test
           MoveAction testClass = new MoveAction(userSession, view);

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
                   .currentWordMap(currentWordMap)
                   .build();
           UserProfile userProfile = new UserProfile.Builder()
                   .characters(asList(character))
                   .build();

           WordMap expectedCurrentWordMap = new WordMapImpl.Builder()
                   .characterLocation(new Position(5, 6))
                   .build();
           Character expectedCharacter = new Character.Builder()
                   .name("doom")
                   .currentWordMap(expectedCurrentWordMap)
                   .build();
           UserProfile expectedUserProfile = new UserProfile.Builder()
                   .characters(asList(expectedCharacter))
                   .build();

           // initialize mocks
           GameView view = mock(GameView.class);
           when(view.requestUserMoveAction()).thenReturn("3");

           UserSession userSession = mock(UserSession.class);
           when(userSession.getProfile()).thenReturn(userProfile);

           // initialize class to test
           MoveAction testClass = new MoveAction(userSession, view);

           // invoke method on class to test
           testClass.doAction();

           // assert return value

           // verify mock expectations
           verify(view).displayGame(expectedUserProfile);
           verify(userSession).setUserProfile(expectedUserProfile);

       }
}