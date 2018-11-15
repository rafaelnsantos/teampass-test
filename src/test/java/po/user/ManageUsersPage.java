package po.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import po.TeampassBasePage;

public class ManageUsersPage extends TeampassBasePage {

    @FindBy(css = "html body div#main div.title.ui-widget-content.ui-corner-all.tooltipstered")
    WebElement title;

    public ManageUsersPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle () {
        return title.getText();
    }
}
