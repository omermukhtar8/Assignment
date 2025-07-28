package UI.Pages;


import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ProductListing {

    WebDriver driver;

    public ProductListing(WebDriver driver){this.driver = driver;}

    String firstSuggestionSearchBarCss = "div[class='ac_results'] li";
    String addToCartFromPDPCss = "p[id='add_to_cart'] button[type='submit']";
    String continueShoppingCss = "span[title='Continue shopping']";
    String cartPageTitleCss = "h1[id='cart_title']";

    By searchBar = By.cssSelector("input[name='search_query']");
    By firstSuggestionSearchBar = By.cssSelector(firstSuggestionSearchBarCss);
    By addToCartFromPDP = By.cssSelector(addToCartFromPDPCss);
    By closeMiniCartWindow = By.cssSelector("span[title='Close window']");
    By continueShopping = By.cssSelector(continueShoppingCss);
    By proceedToCheckout = By.cssSelector("a[title='Proceed to checkout']");
    By cartButton = By.cssSelector("a[title='View my shopping cart']");
    By cartPageTitle = By.cssSelector(cartPageTitleCss);
    By summaryProceedToCheckout = By.cssSelector("a[title='Proceed to checkout']:nth-child(1)");
    By addressProceedToCheckout = By.cssSelector("button[name='processAddress']");
    By shippingProceedToCheckout = By.cssSelector(" button[name='processCarrier']");
    By shippingAgreeBox = By.cssSelector("input[type='checkbox']");
    By bankWire = By.cssSelector("a[class='bankwire']");
    By confirmOrder = By.cssSelector("p[id='cart_navigation'] button[type='submit']");
    By backToOrders = By.cssSelector("a[title='Back to orders']");
    By ordersTable = By.cssSelector("table[id='order-list']");

    public void navigateToPDPBySearchBar(String search) {
        driver.findElement(searchBar).sendKeys(search);
        Utilities.waitForPresence(driver,firstSuggestionSearchBarCss,25);
        driver.findElement(firstSuggestionSearchBar).click();
        Utilities.waitForPresence(driver,addToCartFromPDPCss,25);
    }

    public void addToCartFromPDP() throws InterruptedException {
        driver.findElement(addToCartFromPDP).click();
        Thread.sleep(15000);
        driver.findElement(closeMiniCartWindow).click();
    }

    public void openCart(){
        driver.findElement(cartButton).click();
        Utilities.waitForPresence(driver,cartPageTitleCss,25);
    }

    public void navigateToAddress(){
        driver.findElement(summaryProceedToCheckout).click();
        Utilities.waitForVisibility(driver,addressProceedToCheckout,25);
    }

    public void navigateToShipping(){
        driver.findElement(addressProceedToCheckout).click();
        Utilities.waitForVisibility(driver,shippingProceedToCheckout,25);

    }

    public void navigateToPayment(){
        driver.findElement(shippingAgreeBox).click();
        driver.findElement(shippingProceedToCheckout).click();
        Utilities.waitForVisibility(driver,bankWire,25);
    }

    public void placeOrder(){
        driver.findElement(bankWire).click();
        Utilities.waitForVisibility(driver,confirmOrder,25);
        driver.findElement(confirmOrder).click();
        Utilities.waitForVisibility(driver,backToOrders,25);
    }

    public void navigateToOrderHistory(){
        driver.findElement(backToOrders).click();
        Utilities.waitForVisibility(driver,ordersTable,20);
    }

    public void assertOrderTextByRowAndColumn(String row, String column, String expectedText){

        String mySelector = String.format("table[id='order-list'] tbody tr:nth-child(%s) td:nth-child(%s)", row, column);
        String actualText = driver.findElement(By.cssSelector(mySelector)).getText();
        Assert.assertEquals(actualText,expectedText);
    }



}
