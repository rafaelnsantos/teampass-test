package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends TeampassBasePage {

    @FindBy(xpath = "//*[@id=\"ui-id-10\"]")
    WebElement settings;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstTabName(){
        return settings.getText();
    }
}
