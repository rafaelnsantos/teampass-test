package po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DeleteRoleModal extends BaseModal {

    @FindBy(xpath = "/html/body/div[12]/div[3]/div/button[1]")
    public WebElement submitButton;

    public DeleteRoleModal(TeampassBasePage parent) {
        super(parent);
    }

    public ManageRolesPage submit() {
        parent.click(submitButton);
        parent.wait.until(ExpectedConditions.elementToBeClickable(((ManageRolesPage)parent).title));
        return (ManageRolesPage)parent;
    }

}
