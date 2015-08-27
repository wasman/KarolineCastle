package com.dowell.castle.registration;

import com.dowell.castle.repository.ProfileRepository;
import org.junit.Test;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RegisterControllerImplTest {

    @Test
    public void testShowUserRegistrationForm() throws Exception {
        // initialize variable inputs

        // initialize mocks
        RegisterView view = mock(RegisterViewImpl.class);
        ProfileRepository repository = mock(ProfileRepository.class);

        // initialize class to test
        RegisterController testClass = new RegisterControllerImpl(view, null, null);

        // invoke method on class to test
        testClass.showUserRegistrationForm();

        // assert return value

        // verify mock expectations
        verify(view).showUserRegistrationForm();
    }

    @Test
    public void testWireActions() throws Exception {
        // initialize variable inputs

        // initialize mocks
        RegisterView view = mock(RegisterViewImpl.class);

        // initialize class to test
        RegisterController testClass = new RegisterControllerImpl(view, null, null);

        // invoke method on class to test
        testClass.wireRegisterAction();
        // assert return value

        // verify mock expectations
        verify(view).wireRegisterAction(isA(RegisterAction.class));
    }
    @Test
    public void testDoRegister() throws Exception {
        // initialize variable inputs


        // initialize mocks
        RegisterView view = mock(RegisterViewImpl.class);
        ProfileRepository repository = mock(ProfileRepository.class);

        // initialize class to test
        RegisterController testClass = new RegisterControllerImpl(view, null, null);

        // invoke method on class to test
        testClass.doRegister();

        // assert return value

        // verify mock expectations

    }
}
