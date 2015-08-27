package com.dowell.castle.auth;

import com.dowell.castle.Character;
import com.dowell.castle.GameWordService;
import com.dowell.castle.GameWordServiceImpl;
import com.dowell.castle.UserProfile;
import com.dowell.castle.WordMap;
import com.dowell.castle.WordMapImpl;
import com.dowell.castle.repository.ProfileRepository;
import com.dowell.castle.repository.ProfileRepositoryImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticationServiceImplTest {

    @Test
    public void testGetUserProfile() throws Exception {
        // initialize variable inputs
        String userName = "Jack";
        String password = "thePassword";
        String securePassword = "$thePassword$";
        UserProfile expectedValue = new UserProfile.Builder().build();

        // initialize mocks
        SecurityHelper helper = mock(SecurityHelperImpl.class);
        ProfileRepository repository = mock(ProfileRepositoryImpl.class);

        when(helper.getSecurePassword(password)).thenReturn(securePassword);
        when(repository.getUserProfile(userName, securePassword)).thenReturn(expectedValue);

        // initialize class to test
        AuthenticationService testClass = new AuthenticationServiceImpl(helper, repository, null);

        // invoke method on class to test
        UserProfile returnValue = testClass.getUserProfile(userName, password);

        // assert return value
        assertEquals(expectedValue, returnValue);

        // verify mock expectations
    }

    @Test
    public void testGetUserProfileForNotAuthorisedUser() throws Exception {
        // initialize variable inputs
        String userName = "JackNotAuthorised";
        String password = "thePassword";
        String securePassword = "$thePassword$";
        AuthenticationException expectedException = new AuthenticationException("No such user");

        // initialize mocks
        SecurityHelper helper = mock(SecurityHelperImpl.class);
        ProfileRepository repository = mock(ProfileRepositoryImpl.class);

        when(helper.getSecurePassword(password)).thenReturn(securePassword);
        when(repository.getUserProfile(userName, securePassword)).thenReturn(null);

        // initialize class to test
        AuthenticationService testClass = new AuthenticationServiceImpl(helper, repository, null);

        // invoke method on class to test
        try {
            testClass.getUserProfile(userName, password);
            fail("Exception Should be thrown");
        }
        catch (AuthenticationException exception) {
            // assert return value

            assertEquals(expectedException, exception);
        }

        // verify mock expectations
    }

    @Test
    public void testRegisterUserProfile() throws Exception {
        // initialize variable inputs
        String userName = "Jack";
        String password = "thePassword";
        String securePassword = "$thePassword$";

        WordMap currentWordMap = new WordMapImpl.Builder().build();
        Character character = new Character.Builder().currentWordMap(currentWordMap).build();
        UserProfile expectedValue = new UserProfile.Builder()
                .userName(userName)
                .character(character)
                .build();

        // initialize mocks
        SecurityHelper helper = mock(SecurityHelperImpl.class);
        ProfileRepository repository = mock(ProfileRepositoryImpl.class);
        GameWordService gameWordService = mock(GameWordServiceImpl.class);

        when(helper.getSecurePassword(password)).thenReturn(securePassword);
        when(gameWordService.getStartGame()).thenReturn(currentWordMap);

        // initialize class to test
        AuthenticationService testClass = new AuthenticationServiceImpl(helper, repository, gameWordService);

        // invoke method on class to test
        UserProfile returnValue = testClass.createUserProfile(userName, password);

        // assert return value
        assertEquals(expectedValue, returnValue);

        // verify mock expectations
    }
}
