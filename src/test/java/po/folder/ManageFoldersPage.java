package po.folder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import po.TeampassBasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManageFoldersPage extends TeampassBasePage {

    @FindBy(css = "html body div#main div.title.ui-widget-content.ui-corner-all.tooltipstered")
    WebElement title;

    @FindBy(css = "html body div#main div.title.ui-widget-content.ui-corner-all.tooltipstered button.button.ui-button.ui-widget.ui-state-default.ui-corner-all.ui-button-text-only.tooltipstered")
    WebElement newFolderButton;

    @FindBy(xpath = "//*[@id=\"t_folders\"]/tbody/tr/td[1]/i")
    WebElement editFolderButton;

    @FindBy(css = "html body div#main div.title.ui-widget-content.ui-corner-all.tooltipstered button#click_delete_multiple_folders.button.ui-button.ui-widget.ui-state-default.ui-corner-all.ui-button-text-only.tooltipstered")
    WebElement deleteFolderButton;

    @FindBy(id = "click_refresh_folders_list")
    WebElement refreshFolderButton;

    @FindBy(xpath = "//*[@id=\"t_folders\"]/tbody/tr/td[2]")
    WebElement idFolder;

    public ManageFoldersPage(WebDriver driver) {
        super(driver);
    }

    public AddFolderModal clickAddRole(){
        click(newFolderButton);
        return new AddFolderModal(this);
    }

    public EditFolderModal clickEditFolder(){
        click(editFolderButton);
        return new EditFolderModal(this);
    }

    public ManageFoldersPage clickDeleteFolder(){
        driver.findElement(By.id("cb_selected-" + idFolder())).click();
        click(deleteFolderButton);
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ui-widget-overlay ui-front")));
        return this;
    }

    public String idFolder(){
        return idFolder.getText();
    }
    public String getFirstFolder(){
        return driver.findElement(By.id("title_"+idFolder())).getText();
    }
    public ManageFoldersPage clickRefresh(){
        click(refreshFolderButton);
        return this;
    }

    public String getTitle () {
        return title.getText();
    }
}
