package com.dowell.castle.registration;

import com.dowell.castle.CharacterType;

public interface RegistrationView {


    String getUserName();

    String getPassword();

    String getCharacterName();

    CharacterType getCharacterType();
}
