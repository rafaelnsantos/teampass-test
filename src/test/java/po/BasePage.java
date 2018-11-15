package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void click(WebElement menuOption) {
        wait.until( ExpectedConditions.visibilityOfAllElements(menuOption) );
        menuOption.click();
    }

    public void type(WebElement input, String text){
        input.clear();
        input.sendKeys(text);
    }

    public void select(WebElement select, String text){
        new Select(select).selectByVisibleText(text);
    }
}
