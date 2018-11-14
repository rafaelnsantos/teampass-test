package po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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
        this.name.clear();
        this.name.sendKeys(name);
        return this;
    }

    public String getName() {
        return name.getAttribute("value");
    }

    public String getPasswordStrength() {
        return passwordStrength.getAttribute("value");
    }

    public EditRoleModal setPasswordStrength(String text) {
        Select select = new Select(passwordStrength);
        select.selectByVisibleText(text);
        return this;
    }

    public ManageRolesPage submit() {
        parent.click(submitButton);
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
