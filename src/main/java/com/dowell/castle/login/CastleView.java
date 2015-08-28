package com.dowell.castle.login;

import com.dowell.castle.Action;

public interface CastleView {

    void promptUserAction();

    void wireDoLoginAction(Action loginAction);

    void wireDoRegisterAction(Action registerAction);
}
