package com.dowell.castle.login;

import com.dowell.castle.Character;
import com.dowell.castle.ConsoleUtil;

import java.util.List;

public class LoginViewImpl implements LoginView {

    @Override
    public String getUserName() {
        return ConsoleUtil.promptUserInput("User Name: ");
    }

    @Override
    public String getPassword() {
        return ConsoleUtil.promptSecureUserInput("Please enter you password");
    }

    @Override
    public String getCurrentCharacterName(List<Character> characters) {
        return ConsoleUtil.promptUserInput("What Character you would like to use " + characters + ", enter name: ");
    }
}
