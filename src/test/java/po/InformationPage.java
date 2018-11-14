package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InformationPage extends TeampassBasePage {
    
    @FindBy(xpath = "/html/body/div[3]/div[3]")
    WebElement welcome;
    
    public InformationPage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMessage() {
        return welcome.getText();
    }
    
}
