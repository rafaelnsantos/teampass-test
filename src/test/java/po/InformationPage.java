package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationPage extends TeampassBasePage {
    
    @FindBy(css = "html body div#main div.title.ui-widget-content.ui-corner-all.tooltipstered")
    WebElement welcome;
    
    public InformationPage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMessage() {
        return welcome.getText();
    }
    
}
