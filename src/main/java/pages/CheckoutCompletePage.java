package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutCompletePage extends CommonElements{

    @FindBy(css = ".complete-header")
    private WebElement completeHeader;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public void validateCompleteHeader(String header){
        Assert.assertTrue(getElementText(completeHeader).equals(header));
    }

}
