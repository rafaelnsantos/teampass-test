import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import po.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class NavigationTest {
    private WebDriver driver;
    
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     
    }
    
    @After
    public void after() {
        driver.close();
    }

    @Test
    public void navigationTest() {
        InformationPage informationPage = LoginTest.login(driver);

        SettingsPage settingsPage = informationPage.getMenu().goToSettings();
        assertEquals("Settings", settingsPage.getFirstTabName());

        ManageFoldersPage manageFoldersPage = settingsPage.getMenu().goToManageFolders();
        assertEquals("Manage Folders  ", manageFoldersPage.getTitle());

        ManageRolesPage manageRolesPage = manageFoldersPage.getMenu().goToManageRoles();
        assertEquals("Manage Roles  \n   ", manageRolesPage.getTitle());

        ManageUsersPage manageUsersPage = manageRolesPage.getMenu().goToManageUsers();
        assertEquals("Manage Users   ", manageUsersPage.getTitle());

        UtilitiesPage utilitiesPage = manageUsersPage.getMenu().goToUtilities();
        assertEquals("Generate password log", utilitiesPage.getFirstTabName());

        informationPage = utilitiesPage.getMenu().goToInformation();
        assertEquals("Thank you for using TeamPass!\n 2.1.27.23", informationPage.getWelcomeMessage());
    }
}
