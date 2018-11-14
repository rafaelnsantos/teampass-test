package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UtilitiesPage extends TeampassBasePage {

    @FindBy(xpath = "//*[@id=\"ui-id-10\"]")
    WebElement utilities;

    public UtilitiesPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstTabName(){
        return utilities.getText();
    }

}
