package po.role;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import po.BaseModal;
import po.TeampassBasePage;

public class DeleteRoleModal extends BaseModal {

    @FindBy(xpath = "/html/body/div[12]/div[3]/div/button[1]")
    public WebElement submitButton;

    public DeleteRoleModal(TeampassBasePage parent) {
        super(parent);
    }

    public ManageRolesPage submit() {
        parent.click(submitButton);
//        parent.wait.until(ExpectedConditions.elementToBeClickable(((ManageRolesPage)parent).title));

        parent.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ui-widget-overlay ui-front")));
        return (ManageRolesPage)parent;
    }

}
