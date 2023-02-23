package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CommonElements extends BasePage{

    @FindBy(css = ".title")
    private WebElement title;

    public CommonElements(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        return getElementText(title);
    }

    public void validatePageTitle(String pageTitle){
        Assert.assertEquals(getElementText(title), pageTitle);
    }

}
