package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class YourCartPage extends CommonElements {

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindAll(@FindBy(css = ".cart_item"))
    private List<WebElement> cartItems;

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    public void checkout(){
        clickElement(checkoutButton);
    }

    public void validateCartItemsAmount(int amount){
        Assert.assertEquals(cartItems.size(), amount);
    }




}
