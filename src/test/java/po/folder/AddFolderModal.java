package po.folder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import po.BaseModal;
import po.TeampassBasePage;
import po.role.AddRoleModal;

public class AddFolderModal extends BaseModal {

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

    public AddFolderModal(TeampassBasePage parent) {
        super(parent);
    }

    public AddFolderModal setName(String name) {
        this.name.clear();
        this.name.sendKeys(name);
        return this;
    }

    public AddFolderModal setParentFolder(String text) {
        parent.select(parentFolder, text);
        return this;
    }

    public AddFolderModal setPasswordStrength(String text) {
        parent.select(passwordStrength, text);
        return this;
    }

    public AddFolderModal setAccess(String text) {
        parent.select(access, text);
        return this;
    }

    public ManageFoldersPage submit() {
        parent.click(submitButton);
        parent.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ui-widget-overlay ui-front")));

//        parent.wait.until(ExpectedConditions.elementToBeClickable(((ManageFoldersPage)parent).title));
        return (ManageFoldersPage)parent;
    }

    public AddFolderModal submitDuplicate() {
        parent.click(submitButton);
        parent.wait.until( ExpectedConditions.elementToBeClickable(error) );
        return this;
    }

    public String getErrorMessage(){
        return error.getText();
    }

}
