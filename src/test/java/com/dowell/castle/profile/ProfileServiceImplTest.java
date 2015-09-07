package com.dowell.castle.profile;

import com.dowell.castle.Character;
import com.dowell.castle.GameWordService;
import com.dowell.castle.GameWordServiceImpl;
import com.dowell.castle.UserProfile;
import com.dowell.castle.repository.ProfileRepository;
import com.dowell.castle.repository.ProfileRepositoryImpl;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProfileServiceImplTest {

    @Test
    public void testGetUserProfile() throws Exception {
        // initialize variable inputs
        String userName = "Jack";
        String password = "thePassword";
        String securePassword = "$thePassword$";
        UserProfile expectedValue = new UserProfile.Builder()
                .userName(userName)
                .password(securePassword)
                .build();

        // initialize mocks
        SecurityHelper helper = mock(SecurityHelperImpl.class);
        ProfileRepository repository = mock(ProfileRepositoryImpl.class);

        when(helper.getSecurePassword(password)).thenReturn(securePassword);
        when(repository.get(userName)).thenReturn(expectedValue);

        // initialize class to test
        ProfileService testClass = new ProfileServiceImpl(helper, repository, null);

        // invoke method on class to test
        UserProfile returnValue = testClass.getUserProfile(userName, password);

        // assert return value
        assertEquals(expectedValue, returnValue);

        // verify mock expectations
    }

    @Test
    public void testGetUserProfileIfNotExist() throws Exception {
        // initialize variable inputs
        String userName = "Jack";
        String password = "thePassword";
        String securePassword = "$thePassword$";

        // initialize mocks
        SecurityHelper helper = mock(SecurityHelperImpl.class);
        ProfileRepository repository = mock(ProfileRepositoryImpl.class);

        when(helper.getSecurePassword(password)).thenReturn(securePassword);
        when(repository.get(userName)).thenReturn(null);

        // initialize class to test
        ProfileService testClass = new ProfileServiceImpl(helper, repository, null);

        // invoke method on class to test
        try {
            testClass.getUserProfile(userName, password);
            fail("should fail");
        }
        catch (AuthenticationException ex) {
            // assert return value
            assertEquals("No such user", ex.getMessage());
        }

        // verify mock expectations
    }

    @Test
    public void testGetUserProfileIfWrongPassword() throws Exception {
        // initialize variable inputs
        String userName = "Jack";
        String password = "thePassword";
        String securePassword = "$thePassword$";
        String wrongSecurePassword = "Wrong$thePassword$";
        UserProfile expectedValue = new UserProfile.Builder()
                .userName(userName)
                .password(securePassword)
                .build();

        // initialize mocks
        SecurityHelper helper = mock(SecurityHelperImpl.class);
        ProfileRepository repository = mock(ProfileRepositoryImpl.class);

        when(helper.getSecurePassword(password)).thenReturn(wrongSecurePassword);
        when(repository.get(userName)).thenReturn(expectedValue);

        // initialize class to test
        ProfileService testClass = new ProfileServiceImpl(helper, repository, null);

        // invoke method on class to test
        try {
            testClass.getUserProfile(userName, password);
            fail("should fail");
        }
        catch (AuthenticationException ex) {
            // assert return value
            assertEquals("No such user", ex.getMessage());
        }

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
        when(repository.get(userName)).thenReturn(null);

        // initialize class to test
        ProfileService testClass = new ProfileServiceImpl(helper, repository, null);

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

        Character character = new Character.Builder()
                .name("doom")
                .build();
        UserProfile inputValue = new UserProfile.Builder()
                .userName(userName)
                .password(password)
                .characters(asList(character))
                .build();

        UserProfile expectedValue = new UserProfile.Builder()
                .userName(userName)
                .characters(asList(character))
                .password(securePassword)
                .build();

        // initialize mocks
        SecurityHelper helper = mock(SecurityHelperImpl.class);
        ProfileRepository repository = mock(ProfileRepositoryImpl.class);
        GameWordService gameWordService = mock(GameWordServiceImpl.class);

        when(helper.getSecurePassword(password)).thenReturn(securePassword);

        // initialize class to test
        ProfileService testClass = new ProfileServiceImpl(helper, repository, gameWordService);

        // invoke method on class to test
        UserProfile returnValue = testClass.createUserProfile(inputValue);

        // assert return value
        assertEquals(expectedValue, returnValue);

        // verify mock expectations
        verify(repository).create(expectedValue);
    }

    @Test
    public void testSaveUserProfile() throws Exception {
        // initialize variable inputs
        String userName = "Jack";
        String password = "thePassword";
        String securePassword = "$thePassword$";

        Character character = new Character.Builder()
                .name("doom")
                .build();
        UserProfile inputValue = new UserProfile.Builder()
                .userName(userName)
                .password(password)
                .characters(asList(character))
                .build();

        // initialize mocks
        SecurityHelper helper = mock(SecurityHelperImpl.class);
        ProfileRepository repository = mock(ProfileRepositoryImpl.class);
        GameWordService gameWordService = mock(GameWordServiceImpl.class);

        when(helper.getSecurePassword(password)).thenReturn(securePassword);

        // initialize class to test
        ProfileService testClass = new ProfileServiceImpl(helper, repository, gameWordService);

        // invoke method on class to test
        testClass.save(inputValue);

        // assert return value

        // verify mock expectations
        verify(repository).save(inputValue);
    }
}
