package com.dowell.castle.login;

import com.dowell.castle.Character;

import java.util.List;

public interface LoginView {

    String getUserName();

    String getPassword();

    String getCurrentCharacterName(List<Character> characters);
}
