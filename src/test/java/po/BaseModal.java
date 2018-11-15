package po;

import org.openqa.selenium.support.PageFactory;

public class BaseModal {
    public TeampassBasePage parent;
    public BaseModal(TeampassBasePage parent) {
        this.parent = parent;
        PageFactory.initElements(parent.driver, this);
    }
}
