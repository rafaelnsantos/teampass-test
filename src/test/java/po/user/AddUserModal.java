package po.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import po.BaseModal;
import po.TeampassBasePage;
import po.folder.ManageFoldersPage;

public class AddUserModal extends BaseModal {

    @FindBy(id = "ajouter_groupe_titre")
    WebElement name;

    @FindBy(id = "parent_id")
    WebElement parentFolder;

    @FindBy(id = "new_rep_complexite")
    WebElement passwordStrength;

    @FindBy(xpath = "/html/body/div[11]/div[3]/div/button[1]")
    public WebElement submitButton;

    @FindBy(id = "addgroup_show_error")
    WebElement error;

    @FindBy(id = "new_rep_roles")
    WebElement access;

    public AddUserModal(TeampassBasePage parent) {
        super(parent);
    }

    public AddUserModal setName(String name) {
        this.name.clear();
        this.name.sendKeys(name);
        return this;
    }

    public AddUserModal setParentFolder(String text) {
        parent.select(parentFolder, text);
        return this;
    }

    public AddUserModal setPasswordStrength(String text) {
        parent.select(passwordStrength, text);
        return this;
    }

    public AddUserModal setAccess(String text) {
        parent.select(access, text);
        return this;
    }

    public ManageUsersPage submit() {
        parent.click(submitButton);
        parent.wait.until(ExpectedConditions.elementToBeClickable(((ManageUsersPage)parent).title));
        return (ManageUsersPage)parent;
    }

    public AddUserModal submitDuplicate() {
        parent.click(submitButton);
        parent.wait.until( ExpectedConditions.elementToBeClickable(error) );
        return this;
    }

    public String getErrorMessage(){
        return error.getText();
    }

}
