package com.dowell.castle.login;

import com.dowell.castle.registration.DoRegisterAction;
import com.dowell.castle.registration.RegistrationView;
import org.junit.Test;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CastlePresenterImplTest {

    @Test
    public void testStartWord() throws Exception {
        // initialize variable inputs


        // initialize mocks
        CastleView castleView = mock(CastleView.class);
        LoginView loginView = mock(LoginView.class);
        RegistrationView registrationView = mock(RegistrationView.class);

        // initialize class to test
        CastlePresenter testClass = new CastlePresenterImpl(castleView, loginView, registrationView, null, null, null);

        // invoke method on class to test
        testClass.init();
        // assert return value

        // verify mock expectations
        verify(castleView).wireDoLoginAction(isA(DoLoginAction.class));
        verify(castleView).wireDoRegisterAction(isA(DoRegisterAction.class));
        verify(castleView).promptUserAction();
    }
}
