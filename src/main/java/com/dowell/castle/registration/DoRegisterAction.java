package com.dowell.castle.registration;

import com.dowell.castle.Action;

public class DoRegisterAction implements Action {

    public DoRegisterAction(RegistrationView registrationView) {

    }

    @Override
    public void doAction() {
        System.out.println("Register:");
    }
}
