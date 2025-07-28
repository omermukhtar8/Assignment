package UI.Tests;

import UI.Pages.SignIn;
import org.testng.annotations.Test;

public class SignInFunctionality extends BaseClass{

    @Test
    public void successfulSignIn() throws InterruptedException {
        SignIn signIn = new SignIn(driver);
        signIn.signInUsingCredentials("mytestingemail@mail.com","test123");
        signIn.verifySuccessfulSignIn();
    }
}
