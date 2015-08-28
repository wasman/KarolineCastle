package com.dowell.castle.login;

import com.dowell.castle.Action;

public class DoLoginAction implements Action{

    public DoLoginAction(LoginView loginView) {


    }

    @Override
    public void doAction() {
        System.out.println("Login:");
    }
}
