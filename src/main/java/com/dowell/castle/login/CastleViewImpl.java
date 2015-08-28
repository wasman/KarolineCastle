package com.dowell.castle.login;

import com.dowell.castle.Action;
import com.dowell.castle.ConsoleUtil;

public class CastleViewImpl implements CastleView {

    private Action doLoginAction;
    private Action doRegisterAction;

    @Override
    public void promptUserAction() {

        String answer = ConsoleUtil.promptUserInput("Do you want to login to existing account ? yes/no");

        if ("yes".equalsIgnoreCase(answer)) {
            doLoginAction.doAction();
        }
        else {
            doRegisterAction.doAction();
        }

    }

    @Override
    public void wireDoLoginAction(Action loginAction) {

        this.doLoginAction = loginAction;
    }

    @Override
    public void wireDoRegisterAction(Action registerAction) {

        this.doRegisterAction = registerAction;
    }
}
