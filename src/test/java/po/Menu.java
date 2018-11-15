package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import po.folder.ManageFoldersPage;
import po.role.ManageRolesPage;
import po.user.ManageUsersPage;

public class Menu extends BasePage {
    
    @FindBy(xpath = "//*[@id=\"main_menu\"]/a[1]")
    WebElement information;

    @FindBy(xpath = "//*[@id=\"main_menu\"]/a[2]")
    private WebElement settings;

    @FindBy(xpath = "//*[@id=\"main_menu\"]/a[3]")
    WebElement manageFolders;

    @FindBy(xpath = "//*[@id=\"main_menu\"]/a[4]")
    WebElement manageRoles;

    @FindBy(xpath = "//*[@id=\"main_menu\"]/a[5]")
    WebElement manageUsers;

    @FindBy(xpath = "//*[@id=\"main_menu\"]/a[6]")
    WebElement utilities;

    @FindBy(xpath = "//*[@id=\"main_menu\"]/div[1]")//*[@id="ui-id-5"]
    WebElement profileMenu;

    @FindBy(xpath = "//*[@id=\"ui-id-5\"]")
    WebElement logout;

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

    public LoginPage logout() {
        click(profileMenu);
        click(logout);
        return new LoginPage(driver);
    }

}
