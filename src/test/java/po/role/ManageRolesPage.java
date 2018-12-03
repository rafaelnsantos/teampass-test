package po.role;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import po.TeampassBasePage;

public class ManageRolesPage extends TeampassBasePage {

    @FindBy(css = "html body div#main div.title.ui-widget-content.ui-corner-all.tooltipstered")
    WebElement title;

    @FindBy(css = "html body div#main div.title.ui-widget-content.ui-corner-all.tooltipstered button.button.ui-button.ui-widget.ui-state-default.ui-corner-all.ui-button-text-only.tooltipstered")
    WebElement newRole;

    @FindBy(xpath = "//*[@id=\"matrice_droits\"]/table/thead/tr/th[2]")
    WebElement firstRole;

    @FindBy(xpath = "//*[@id=\"matrice_droits\"]/table/thead/tr/th[2]/span[1]")
    WebElement editRoleButton;

    @FindBy(xpath = "//*[@id=\"matrice_droits\"]/table/thead/tr/th[2]/span[2]")
    WebElement deleteRoleButton;

    public ManageRolesPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle () {
        return title.getText();
    }

    public AddRoleModal clickAddRole(){
        click(newRole);
        return new AddRoleModal(this);
    }

    public EditRoleModal clickEditRole(){
        click(editRoleButton);
        return new EditRoleModal(this);
    }

    public DeleteRoleModal clickDeleteRole(){
        click(deleteRoleButton);
        return new DeleteRoleModal(this);
    }

    public String getFirstRole(){
        return firstRole.getText();
    }

}
