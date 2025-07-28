package UI.Tests;


import UI.Pages.ProductListing;
import UI.Pages.SignIn;
import org.testng.annotations.Test;

public class CreateOrderFunctionality extends BaseClass{


    @Test
    public void placeOrder() throws InterruptedException {
        SignIn signIn = new SignIn(driver);
        signIn.signInUsingCredentials("mytestingemail@mail.com","test123");
        signIn.verifySuccessfulSignIn();

        ProductListing productListing = new ProductListing(driver);
        productListing.navigateToPDPBySearchBar("Faded Short Sleeve T-shirts");
        productListing.addToCartFromPDP();

        productListing.navigateToPDPBySearchBar("blouse");
        productListing.addToCartFromPDP();

        productListing.openCart();

        productListing.navigateToAddress();
        productListing.navigateToShipping();
        productListing.navigateToPayment();
        productListing.placeOrder();

        productListing.navigateToOrderHistory();
        productListing.assertOrderTextByRowAndColumn("1","4","Bank wire");
        productListing.assertOrderTextByRowAndColumn("1","3","$45.51");
        productListing.assertOrderTextByRowAndColumn("1","5","On backorder");
    }

}
