package com.dowell.castle.login;

import com.dowell.castle.ConsoleUtil;

public class LoginViewImpl implements LoginView {

    @Override
    public String getUserName() {
        return ConsoleUtil.promptUserInput("User Name: ");
    }

    @Override
    public String getPassword() {
        return ConsoleUtil.promptSecureUserInput("Please enter you password");
    }
}
