package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Menu extends BasePage {
    
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/a[1]")
    WebElement information;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/a[2]")
    private WebElement settings;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/a[3]")
    WebElement manageFolders;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/a[4]")
    WebElement manageRoles;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/a[5]")
    WebElement manageUsers;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/a[6]")
    WebElement utilities;
    
    @FindBy(xpath = "/html/body/div[3]/div[2]")
    WebElement errors;

    public Menu(WebDriver driver) {
        super(driver);
    }

    public InformationPage goToInformation() {
        click(information);
        return new InformationPage(driver);
    }


    public SettingsPage goToSettings() {
        click(settings);
        return new SettingsPage(driver);
    }

    public ManageFoldersPage goToManageFolders() {
        click(manageFolders);
        return new ManageFoldersPage(driver);
    }

    public ManageUsersPage goToManageUsers() {
        click(manageUsers);
        return new ManageUsersPage(driver);
    }

    public ManageRolesPage goToManageRoles() {
        click(manageRoles);
        return new ManageRolesPage(driver);
    }

    public UtilitiesPage goToUtilities() {
        click(utilities);
        return new UtilitiesPage(driver);
    }

    public String getErrorMessage() {
        return errors.getText();
    }

}
