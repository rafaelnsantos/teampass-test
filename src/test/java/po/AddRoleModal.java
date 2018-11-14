package po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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
        this.name.clear();
        this.name.sendKeys(name);
        return this;
    }

    public AddRoleModal setPasswordStrength(String text) {
        Select select = new Select(passwordStrength);
        select.selectByVisibleText(text);
        return this;
    }

    public ManageRolesPage submit() {
        parent.click(submitButton);
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
