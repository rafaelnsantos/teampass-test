package po.role;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import po.BaseModal;
import po.TeampassBasePage;

public class AddRoleModal extends BaseModal {

    @FindBy(id = "new_function")
    WebElement name;

    @FindBy(id = "new_role_complexity")
    WebElement passwordStrength;

    @FindBy(xpath = "/html/body/div[11]/div[3]/div/button[1]")
    public WebElement submitButton;

    @FindBy(id = "new_role_error")
    WebElement error;


    public AddRoleModal(TeampassBasePage parent) {
        super(parent);
    }

    public AddRoleModal setName(String name) {
        parent.type(this.name, name);
        return this;
    }

    public AddRoleModal setPasswordStrength(String text) {
        parent.select(passwordStrength, text);
        return this;
    }

    public ManageRolesPage submit() {
        parent.click(submitButton);
//        parent.wait.until( ExpectedConditions.elementToBeClickable(((ManageRolesPage)parent).title));
        parent.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ui-widget-overlay ui-front")));
        return (ManageRolesPage)parent;
    }

    public AddRoleModal submitDuplicate() {
        parent.click(submitButton);
        parent.wait.until( ExpectedConditions.elementToBeClickable(error) );
        return this;
    }

    public String getErrorMessage(){
        return error.getText();
    }

}
