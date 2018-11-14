import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import po.InformationPage;
import po.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginTest {
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
    public void testWrongLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setLogin("asdas")
                .setPw("dddddd")
                .addInvalidData();

        assertEquals("Login credentials do not correspond!", loginPage.getErrorMessage());
    }

    @Test
    public void testLogin() {
        InformationPage informationPage = login(driver);

        assertEquals("Thank you for using TeamPass!\n 2.1.27.23", informationPage.getWelcomeMessage());
    }

    public static InformationPage login(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);

        return loginPage.setLogin("admin")
                .setPw("admin")
                .addValidData();
    }
}
