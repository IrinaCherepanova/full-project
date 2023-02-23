package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "[data-test='username']")
    private WebElement usernameInput;
    @FindBy(css = "[data-test='password']")
    private WebElement passwordInput;
    @FindBy(css = "[data-test='login-button']")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement loginErrorElement;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String username, String password) {
        typeText(usernameInput, username);
        typeText(passwordInput, password);
        clickElement(loginButton);
    }

    public String getLoginErrorMessage(){
        return getElementText(loginErrorElement);
    }
}
