package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    //no annotation needed here -> matches html id with var name
    WebElement login;

    WebElement pw;

    @FindBy(id = "div-login-button")
    WebElement submitButton;

    @FindBy(id = "connection_error")
    WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("http://localhost");
    }    

    public LoginPage setLogin(String name) {
        login.clear();
        login.sendKeys(name);
        return this;
    }
    
    public LoginPage setPw(String name) {
        pw.clear();
        pw.sendKeys(name);
        return this;
    }

    public InformationPage addValidData() {
        submitButton.click();
        return new InformationPage(driver);
    }
    
    public LoginPage addInvalidData() {
        submitButton.click();
        wait.until( ExpectedConditions.elementToBeClickable(error) );
        return this;
    }

    public String getErrorMessage() {
        return error.getText();
    }

    public String getLogin() {
        return login.getAttribute("value");
    }

    public String getPw() {
        return pw.getAttribute("value");
    }
}