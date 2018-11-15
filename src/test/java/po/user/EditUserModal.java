package po.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import po.BaseModal;
import po.TeampassBasePage;
import po.folder.ManageFoldersPage;

public class EditUserModal extends BaseModal {

    @FindBy(id = "edit_folder_title")
    WebElement name;

    @FindBy(id = "edit_parent_id")
    WebElement parentFolder;

    @FindBy(id = "edit_folder_complexite")
    WebElement passwordStrength;

    @FindBy(xpath = "/html/body/div[12]/div[3]/div/button[2]/span")
    public WebElement submitButton;

    @FindBy(id = "edit_folder_show_error")
    WebElement error;

    public EditUserModal(TeampassBasePage parent) {
        super(parent);
    }


    public EditUserModal setName(String name) {
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

    public EditUserModal setPasswordStrength(String text) {
        Select select = new Select(passwordStrength);
        select.selectByVisibleText(text);
        return this;
    }

    public ManageUsersPage submit() {
        parent.click(submitButton);
        parent.wait.until( ExpectedConditions.elementToBeClickable(((ManageUsersPage)parent).title) );
        return (ManageUsersPage)parent;
    }

    public EditUserModal submitWrong() {
        parent.click(submitButton);
        parent.wait.until( ExpectedConditions.elementToBeClickable(error) );
        return this;
    }

    public String getErrorMessage(){
        return error.getText();
    }

}
