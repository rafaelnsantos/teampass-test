import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import po.folder.AddFolderModal;
import po.folder.ManageFoldersPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private WebDriver driver;
    
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("headless");
        //chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     
    }
    
    @After
    public void after() {
        driver.close();
    }

    @Test
    public void createFolderTest() {
        ManageFoldersPage manageFoldersPage = LoginTest.login(driver).getMenu().goToManageFolders();

        manageFoldersPage.clickAddRole().setName("asd").setPasswordStrength("Weak").setParentFolder("Root").submit();

        assertEquals("asd", manageFoldersPage.getFirstFolder());
    }



    @Test
    public void createDuplicateRoleTest() {
        ManageFoldersPage manageFoldersPage = LoginTest.login(driver).getMenu().goToManageFolders();

        AddFolderModal modal = manageFoldersPage.clickAddRole().setName("asd").setPasswordStrength("Weak").setParentFolder("Root").submitDuplicate();

        assertEquals("This folder already exists!", modal.getErrorMessage());
    }

    @Test
    public void editFolderTest() {
        ManageFoldersPage manageFoldersPage = LoginTest.login(driver).getMenu().goToManageFolders();

        manageFoldersPage.clickEditFolder().setName("sss").setPasswordStrength("Strong").submit().clickRefresh();

        assertEquals("sss", manageFoldersPage.getFirstFolder());
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteFolderTest() {
        ManageFoldersPage manageFoldersPage = LoginTest.login(driver).getMenu().goToManageFolders();

        manageFoldersPage.clickDeleteFolder().getMenu().goToManageFolders();

        manageFoldersPage.getFirstFolder();
    }

}
