package UI.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

public class SignUp  {
        WebDriver driver;

        public SignUp(WebDriver driver){
            this.driver = driver;
        }

        By signInButton = By.cssSelector("a[class='login']");
        By createAccountButton = By.cssSelector("button[name='SubmitCreate']");
        By signUpEmail = By.cssSelector("input[id='email_create']");
        By firstName = By.cssSelector("input[name='customer_firstname']");
        By lastName = By.cssSelector("input[id='customer_lastname']");
        By password =By.cssSelector("input[type='password']");
        By genderMale = By.cssSelector("input[name='id_gender'][value='1']");
        By address = By.cssSelector("input[id='address1']");
        By city = By.cssSelector("input[id='city']");
        By state = By.cssSelector("select[name='id_state']");
        By postCode = By.cssSelector("input[name='postcode']");
        By country = By.cssSelector("select[name='id_country']");
        By mobilePhone = By.cssSelector("input[name='phone_mobile']");
        By submitAccount = By.cssSelector("button[id='submitAccount']");
        By myAccountText = By.cssSelector("p[class='info-account']");
        By logOutButton = By.cssSelector("a[title='Log me out']");




        public void clickSignInHomePage(){

            driver.findElement(signInButton).click();
            Utilities.waitForVisibility(driver,createAccountButton,5);
        }

    public void enterEmailAndCreate(String email){

        driver.findElement(signUpEmail).sendKeys(email);
        driver.findElement(createAccountButton).click();
    }

    public void selectGender() throws InterruptedException {
            Utilities.waitForSeconds(13);
        driver.findElement(genderMale).click();
    }

    public void enterFirstName(String name)  {
        driver.findElement(firstName).sendKeys(name);
    }
    public void enterLastName(String name)  {
        driver.findElement(lastName).sendKeys(name);
    }
    public void enterPassword(String passcode)  {
        driver.findElement(password).sendKeys(passcode);
    }
    public void enterAddress(String input)  {
        driver.findElement(address).sendKeys(input);
    }
    public void enterCity(String input)  {
        driver.findElement(city).sendKeys(input);
    }
    public void enterPostCode(String input)  {
        driver.findElement(postCode).sendKeys(input);
    }
    public void enterMobileNumber(String input)  {
        driver.findElement(mobilePhone).sendKeys(input);
    }
    public void submitAccount()  {
        driver.findElement(submitAccount).click();
    }
    public void logOut()  {
        driver.findElement(logOutButton).click();
    }
    public void verifyLogOut() {
            Utilities.waitForVisibility(driver,createAccountButton,10);
        }
    public void verifySuccessfulSignUp()  {
            Utilities.waitForVisibility(driver,myAccountText,15);
        String text = driver.findElement(myAccountText).getText();
        Assert.assertEquals(text,"Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    public void enterState(String input)  {
        WebElement myState = driver.findElement(state);
        Select state = new Select(myState);
        state.selectByVisibleText(input);
    }

    public void enterCountry(String input)  {
        WebElement myCountry = driver.findElement(country);
        Select country = new Select(myCountry);
        country.selectByVisibleText(input);
    }


}
