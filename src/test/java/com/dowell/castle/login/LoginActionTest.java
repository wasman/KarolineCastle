package com.dowell.castle.login;

import com.dowell.castle.UserProfile;
import com.dowell.castle.UserSession;
import com.dowell.castle.profile.AuthenticationException;
import com.dowell.castle.profile.ProfileService;
import org.junit.Test;

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

        UserProfile userProfile = new UserProfile.Builder()
                .userName(username)
                .build();

        // initialize mocks
        LoginView loginView = mock(LoginView.class);
        ProfileService profileService = mock(ProfileService.class);
        UserSession userSession = mock(UserSession.class);

        when(loginView.getUserName()).thenReturn(username);
        when(loginView.getPassword()).thenReturn(password);

        when(profileService.getUserProfile(username, password)).thenReturn(userProfile);

        // initialize class to test
        LoginAction testClass = new LoginAction(loginView, profileService, userSession);

        // invoke method on class to test
        testClass.doAction();

        // assert return value

        // verify mock expectations
        verify(userSession).setUserProfile(userProfile);

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
        LoginAction testClass = new LoginAction(loginView, profileService, userSession);

        // invoke method on class to test
        testClass.doAction();


        // assert return value

        // verify mock expectations
        verifyNoMoreInteractions(userSession);

    }
}