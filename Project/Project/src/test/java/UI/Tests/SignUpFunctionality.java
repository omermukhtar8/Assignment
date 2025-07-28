package UI.Tests;

import UI.Pages.SignUp;
import org.testng.annotations.Test;

public class SignUpFunctionality extends BaseClass {

    @Test
    public void SignUp() throws InterruptedException {
        SignUp signUp = new SignUp(driver);

        signUp.clickSignInHomePage();
        signUp.enterEmailAndCreate("unique_email_for_test@mail.com");
        signUp.selectGender();
        signUp.enterFirstName("Omer");
        signUp.enterLastName("Mukhtar");
        signUp.enterPassword("test123");
        signUp.enterAddress("test address");
        signUp.enterCity("mycity");
        signUp.enterState("Alaska");
        signUp.enterPostCode("54000");
        signUp.enterCountry("United States");
        signUp.enterMobileNumber("036222112454");
        signUp.submitAccount();
        signUp.verifySuccessfulSignUp();
        signUp.logOut();
        signUp.verifyLogOut();
    }
}
