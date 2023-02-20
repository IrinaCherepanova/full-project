package tests.successTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import tests.BaseTest;

public class SuccessTests extends BaseTest {


    protected WebDriver driver;
    @Test
    public void testStandardUser(){
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getPageTitle(), "PRODUCTS");
        Assert.assertEquals(productsPage.getPageUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void testProblemUser(){
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.login("problem_user", "secret_sauce");
        Assert.assertEquals(productsPage.getPageTitle(), "PRODUCTS");
        Assert.assertEquals(productsPage.getPageUrl(), "https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void testPerfomanceUser(){
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.login("performance_glitch_user", "secret_sauce");
        Assert.assertEquals(productsPage.getPageTitle(), "PRODUCTS");
        Assert.assertEquals(productsPage.getPageUrl(), "https://www.saucedemo.com/inventory.html");

    }


}
