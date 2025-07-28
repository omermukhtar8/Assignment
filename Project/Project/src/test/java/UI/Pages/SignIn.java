package UI.Pages;

import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn  {

    WebDriver driver;

    public SignIn(WebDriver driver){
        this.driver = driver;
    }

    By inputEmail = By.cssSelector("input[id='email']");
    By inputPassword = By.cssSelector("input[id='passwd']");
    By homePageLogin = By.cssSelector("a[class='login']");
    By submitLogin = By.cssSelector("button[name='SubmitLogin']");
    By logOutButton = By.cssSelector("a[title='Log me out']");







    public void signInUsingCredentials(String email, String password){
        driver.findElement(homePageLogin).click();
        Utilities.waitForVisibility(driver,inputEmail,10);
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(submitLogin).click();
    }
    public void verifySuccessfulSignIn(){
        Utilities.waitForVisibility(driver,logOutButton,25);
    }
}
