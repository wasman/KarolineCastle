package com.dowell.castle.registration;

import com.dowell.castle.Action;
import com.dowell.castle.CharacterType;

public interface RegisterView {

    void showUserRegistrationForm();

    void wireRegisterAction(Action action);

    String getUserName();

    String getPassword();

    String getCharacterName();

    CharacterType getCharacterType();
}
