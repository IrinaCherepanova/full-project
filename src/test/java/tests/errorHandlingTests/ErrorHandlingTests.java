package tests.errorHandlingTests;

import helpers.ApplicationURL;
import helpers.Credentials;
import helpers.LoginErrorMessages;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.BaseTest;

public class ErrorHandlingTests extends BaseTest {

    @Test(dataProvider = "getData")
    public void errorHandlingLoginTests(String username, String password, String expectedErrorMessage){

        driver.get(ApplicationURL.BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getPageUrl(), ApplicationURL.BASE_URL+"/");
        Assert.assertEquals(loginPage.getLoginErrorMessage(),  expectedErrorMessage);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {Credentials.LOCKED_OUT_USER, Credentials.CORRECT_PASSWORD, "Epic sadface: Sorry, this user has been locked out."},
                {Credentials.EMPTY_USERNAME, Credentials.EMPTY_PASSWORD, LoginErrorMessages.EMPTY_USERNAME},
                {Credentials.EMPTY_USERNAME, Credentials.CORRECT_PASSWORD, LoginErrorMessages.EMPTY_USERNAME},
                {Credentials.STANDARD_USER, Credentials.EMPTY_PASSWORD, LoginErrorMessages.EMPTY_USERNAME},
                {Credentials.STANDARD_USER, "dfdfgdfg", LoginErrorMessages.INCORRECT_USERNAME_OR_PASSWORD},
                {"dfgdfg", Credentials.CORRECT_PASSWORD, LoginErrorMessages.INCORRECT_USERNAME_OR_PASSWORD},
        };
    }


}
