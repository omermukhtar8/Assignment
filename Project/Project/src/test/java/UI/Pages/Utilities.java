package UI.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilities {

    public static void waitForVisibility(WebDriver driver, By elementLocator, int seconds){
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementLocator)));
    }

    public static void waitForPresence(WebDriver driver, String cssSelector, int seconds){
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }

    public static void waitForSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
    }

}
