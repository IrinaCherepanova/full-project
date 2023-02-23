package pages;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProductsPage extends CommonElements {

    @FindBy(css = "[class=\"shopping_cart_badge\"]")
    private WebElement shoppingCartBadge;

    @FindAll(@FindBy(css = "[class=\"inventory_item_description\"]"))
    private List<WebElement> itemDescriptionElements;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public int chooseProduct(String... products) {

        System.out.println("products.length = " + products.length);
        for (String product : products) {
            for (WebElement element : itemDescriptionElements) {
                WebElement title = element.findElement(By.cssSelector("[class=\"inventory_item_name\"]"));
                WebElement addToCartButton = element.findElement(By.cssSelector("button"));
                if (title.getText().equals(product)) {
                    addToCartButton.click();
                }
            }
        }

        return products.length;
    }

    public void validateNumberOfAddedItems(int numberOfAddedItems) {

        Assert.assertEquals(Integer.parseInt(getElementText(shoppingCartBadge)), numberOfAddedItems);
       // if (Integer.parseInt(getElementText(shoppingCartBadge)) == numberOfAddedItems) {
       //     System.out.println("Correct! :)");
       // } else {
       //     System.out.println("Incorrect... :(");
       // }
    }

    public void goToCart(){
        clickElement(shoppingCartBadge);
    }


}
