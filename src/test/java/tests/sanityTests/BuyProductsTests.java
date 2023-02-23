package tests.sanityTests;

import helpers.ApplicationURL;
import helpers.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tests.BaseTest;

public class BuyProductsTests extends BaseTest {

    @Test
    public void buyProductsTests(){
        driver.get(ApplicationURL.BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.login(Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD);
        productsPage.validatePageTitle("PRODUCTS");
        Assert.assertEquals(productsPage.getPageUrl(), ApplicationURL.BASE_URL + "/inventory.html");

        int productsAmount = productsPage.chooseProduct("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Onesie");
        productsPage.validateNumberOfAddedItems(3);
        productsPage.goToCart();

        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.validatePageTitle("YOUR CART");
        yourCartPage.validateCartItemsAmount(productsAmount);
        yourCartPage.checkout();

        CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        checkoutYourInformationPage.validatePageTitle("CHECKOUT: YOUR INFORMATION");
        checkoutYourInformationPage.fillCheckoutForm("Irina", "Cherepanova", "20100");
        checkoutYourInformationPage.continueToNextStep();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.validatePageTitle("CHECKOUT: OVERVIEW");
        checkoutOverviewPage.finishCheckout();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutCompletePage.validatePageTitle("CHECKOUT: COMPLETE!");
        checkoutCompletePage.validateCompleteHeader("THANK YOU FOR YOUR ORDER");

    }

}
