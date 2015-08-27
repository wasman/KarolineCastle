package com.dowell.castle.registration;

import com.dowell.castle.Action;
import com.dowell.castle.Character;
import com.dowell.castle.CharacterType;
import com.dowell.castle.GameWordService;
import com.dowell.castle.UserProfile;
import com.dowell.castle.UserSession;
import com.dowell.castle.WordMap;
import com.dowell.castle.WordMapImpl;
import com.dowell.castle.profile.ProfileService;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RegisterActionTest {

    @Test
    public void testDoAction() throws Exception {
        // initialize variable inputs
        String username = "username";
        String password = "password";
        String securePassword = "$password$";
        String characterName = "characterName";
        CharacterType characterType = CharacterType.ELF;
        WordMap wordMap = new WordMapImpl.Builder().build();

        Character character = new Character.Builder()
                .name(characterName)
                .characterType(characterType)
                .currentWordMap(wordMap)
                .build();

        UserProfile profile = new UserProfile.Builder()
                .userName(username)
                .password(password)
                .character(character)
                .build();

        UserProfile newProfile = new UserProfile.Builder()
                .userName(username)
                .password(securePassword)
                .character(character)
                .build();

        // initialize mocks
        RegisterView view = mock(RegisterViewImpl.class);
        when(view.getUserName()).thenReturn(username);
        when(view.getPassword()).thenReturn(password);
        when(view.getCharacterName()).thenReturn(characterName);
        when(view.getCharacterType()).thenReturn(characterType);

        ProfileService service = mock(ProfileService.class);
        when(service.createUserProfile(profile)).thenReturn(newProfile);

        GameWordService gameWordService = mock(GameWordService.class);
        when(gameWordService.getStartGame()).thenReturn(wordMap);

        UserSession userSession = mock(UserSession.class);

        // initialize class to test
        Action testClass = new RegisterAction(view, service, gameWordService, userSession);

        // invoke method on class to test
        testClass.doAction();
        // assert return value

        // verify mock expectations
        verify(service).createUserProfile(profile);
        verify(userSession).setUserProfile(newProfile);

    }
}