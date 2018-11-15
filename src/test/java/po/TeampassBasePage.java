package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeampassBasePage extends BasePage {

    Menu menu;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]")
    WebElement errors;
    
    public TeampassBasePage(WebDriver driver) {
        super(driver);
        menu = new Menu(driver);
    }
    
    public Menu getMenu() {
        return menu;
    }

    public String getErrorMessage() {
        return errors.getText();
    }
    
}
