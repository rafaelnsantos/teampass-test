package po.folder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import po.BaseModal;
import po.TeampassBasePage;
import po.role.ManageRolesPage;

public class EditFolderModal extends BaseModal {

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

    public EditFolderModal(TeampassBasePage parent) {
        super(parent);
    }


    public EditFolderModal setName(String name) {
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

    public EditFolderModal setPasswordStrength(String text) {
        Select select = new Select(passwordStrength);
        select.selectByVisibleText(text);
        return this;
    }

    public ManageFoldersPage submit() {
        parent.click(submitButton);
//        parent.wait.until( ExpectedConditions.elementToBeClickable(((ManageFoldersPage)parent).title) );
        parent.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ui-widget-overlay ui-front")));

        return (ManageFoldersPage)parent;
    }

    public EditFolderModal submitWrong() {
        parent.click(submitButton);
        parent.wait.until( ExpectedConditions.elementToBeClickable(error) );
        return this;
    }

    public String getErrorMessage(){
        return error.getText();
    }

}
