package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageFoldersPage extends TeampassBasePage {

    @FindBy(xpath = "/html/body/div[3]/div[3]")
    WebElement title;

    public ManageFoldersPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle () {
        return title.getText();
    }
}
