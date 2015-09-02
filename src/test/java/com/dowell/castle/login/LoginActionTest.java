package com.dowell.castle.login;

import com.dowell.castle.Character;
import com.dowell.castle.UserProfile;
import com.dowell.castle.UserSession;
import com.dowell.castle.game.GameView;
import com.dowell.castle.profile.AuthenticationException;
import com.dowell.castle.profile.ProfileService;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class LoginActionTest {

    @Test
    public void testDoAction() throws Exception {
        // initialize variable inputs
        String username = "username";
        String password = "password";
        String characterName = "doom";
        Character currentCharacter = new Character.Builder()
                .name("doom")
                .build();
        Character anotherCharacter = new Character.Builder()
                .name("quake")
                .build();

        UserProfile userProfile = new UserProfile.Builder()
                .userName(username)
                .characters(asList(anotherCharacter, currentCharacter))
                .build();

        UserProfile updatedUserProfile = new UserProfile.Builder()
                .userName(username)
                .characters(asList(currentCharacter, anotherCharacter))
                .build();

        // initialize mocks
        LoginView loginView = mock(LoginView.class);
        GameView gameView = mock(GameView.class);

        ProfileService profileService = mock(ProfileService.class);
        UserSession userSession = mock(UserSession.class);

        when(loginView.getUserName()).thenReturn(username);
        when(loginView.getPassword()).thenReturn(password);
        when(loginView.getCurrentCharacterName(asList(anotherCharacter, currentCharacter))).thenReturn(characterName);


        when(profileService.getUserProfile(username, password)).thenReturn(userProfile);

        // initialize class to test
        LoginAction testClass = new LoginAction(loginView, profileService, userSession, gameView);

        // invoke method on class to test
        testClass.doAction();

        // assert return value

        // verify mock expectations
        verify(userSession).setUserProfile(updatedUserProfile);
        verify(gameView).displayGame(updatedUserProfile);

    }

    @Test
    public void testDoActionOnWrongOrNtExistingUser() throws Exception {
        // initialize variable inputs
        String username = "username";
        String password = "password";

        UserProfile userProfile = new UserProfile.Builder()
                .userName(username)
                .build();
        String expectedMessage = "Error";

        // initialize mocks
        LoginView loginView = mock(LoginView.class);
        ProfileService profileService = mock(ProfileService.class);
        UserSession userSession = mock(UserSession.class);

        when(loginView.getUserName()).thenReturn(username);
        when(loginView.getPassword()).thenReturn(password);

        doThrow(new AuthenticationException(expectedMessage)).when(profileService).getUserProfile(username, password);

        // initialize class to test
        LoginAction testClass = new LoginAction(loginView, profileService, userSession, null);

        // invoke method on class to test
        testClass.doAction();


        // assert return value

        // verify mock expectations
        verifyNoMoreInteractions(userSession);

    }
}