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
import static org.junit.Assert.assertNull;

public class RoleTest {
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
    public void createRoleTest() {
        ManageRolesPage manageRolesPage = LoginTest.login(driver).getMenu().goToManageRoles();

        manageRolesPage.clickAddRole().setName("asd").setPasswordStrength("Weak").submit();

        assertEquals("asd\n  [ Weak ]", manageRolesPage.getFistRole());
    }



    @Test
    public void createDuplicateRoleTest() {
        ManageRolesPage manageRolesPage = LoginTest.login(driver).getMenu().goToManageRoles();

        AddRoleModal modal = manageRolesPage.clickAddRole().setName("asd").setPasswordStrength("Weak").submitDuplicate();

        assertEquals("This role already exists!", modal.getErrorMessage());
    }

    @Test
    public void editRoleTest() {
        ManageRolesPage manageRolesPage = LoginTest.login(driver).getMenu().goToManageRoles();

        manageRolesPage.clickEditRole().setName("asddw").setPasswordStrength("Strong").submit().getMenu().goToManageRoles();

        assertEquals("asddw\n  [ Strong ]", manageRolesPage.getFistRole());
    }

    @Test
    public void deleteRoleTest() {
        ManageRolesPage manageRolesPage = LoginTest.login(driver).getMenu().goToManageRoles();

        manageRolesPage.clickDeleteRole().submit().getMenu().goToManageRoles();

        assertNull(manageRolesPage.getFistRole());
    }

}
