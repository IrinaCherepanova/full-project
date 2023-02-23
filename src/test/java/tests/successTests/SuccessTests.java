package tests.successTests;

import helpers.ApplicationURL;
import helpers.Credentials;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import tests.BaseTest;

public class SuccessTests extends BaseTest {


    @Test(dataProvider = "getData", description = "Group of successful login tests")
    public void testSuccessLogin(String username, String password) {

        driver.get(ApplicationURL.BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.login(username, password);
        Assert.assertEquals(productsPage.getPageTitle(), "PRODUCTS");
        Assert.assertEquals(productsPage.getPageUrl(), ApplicationURL.BASE_URL + "/inventory.html");

    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD},
                {Credentials.PROBLEM_USER, Credentials.CORRECT_PASSWORD},
                {Credentials.PERFORMANCE_GLITCH_USER, Credentials.CORRECT_PASSWORD}
        };
    }
}