package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInformationPage extends CommonElements{

    @FindBy(css = "[data-test='firstName']")
    private WebElement firstNameInput;

    @FindBy(css = "[data-test='lastName']")
    private WebElement lastNameInput;

    @FindBy(css = "[data-test='postalCode']")
    private WebElement postalCodeInput;

    @FindBy(css = "[data-test='continue']")
    private WebElement continueButton;

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    public void fillCheckoutForm(String firstName, String lastName, String postalCode){
        typeText(firstNameInput, firstName);
        typeText(lastNameInput, lastName);
        typeText(postalCodeInput, postalCode);
    }

    public void continueToNextStep(){
        clickElement(continueButton);
    }



}
