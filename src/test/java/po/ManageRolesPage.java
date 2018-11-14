package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageRolesPage extends TeampassBasePage {

    @FindBy(xpath = "/html/body/div[3]/div[3]")
    WebElement title;

    @FindBy(xpath = "/html/body/div[3]/div[3]/button[1]")
    WebElement newRole;

    @FindBy(xpath = "/html/body/div[3]/div[4]/div[1]/table/thead/tr/th[2]")
    WebElement firstRole;

    @FindBy(xpath = "/html/body/div[3]/div[4]/div[1]/table/thead/tr/th[2]/span[1]")
    WebElement editRoleButton;

    @FindBy(xpath = "/html/body/div[3]/div[4]/div[1]/table/thead/tr/th[2]/span[2]")
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

    public String getFistRole(){
        return firstRole.getText();
    }

}
