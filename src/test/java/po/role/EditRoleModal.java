package po.role;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import po.BaseModal;
import po.TeampassBasePage;

public class EditRoleModal extends BaseModal {

    @FindBy(id = "edit_role_title")
    WebElement name;

    @FindBy(id = "edit_role_complexity")
    WebElement passwordStrength;

    @FindBy(xpath = "/html/body/div[13]/div[3]/div/button[1]")
    public WebElement submitButton;

    @FindBy(id = "edit_role_error")
    WebElement error;

    public EditRoleModal(TeampassBasePage parent) {
        super(parent);
    }


    public EditRoleModal setName(String name) {
        parent.type(this.name, name);
        return this;
    }

    public String getName() {
        return name.getAttribute("value");
    }

    public String getPasswordStrength() {
        return passwordStrength.getAttribute("value");
    }

    public EditRoleModal setPasswordStrength(String text) {
        parent.select(passwordStrength, text);
        return this;
    }

    public ManageRolesPage submit() {
        parent.click(submitButton);
        parent.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ui-widget-overlay ui-front")));
        return (ManageRolesPage)parent;
    }

    public EditRoleModal submitDuplicate() {
        parent.click(submitButton);
        parent.wait.until( ExpectedConditions.elementToBeClickable(error) );
        return this;
    }

    public String getErrorMessage(){
        return error.getText();
    }

}
