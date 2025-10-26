package actions.elements;

import common.BasePage;
import org.openqa.selenium.WebDriver;

import static interfaces.elements.LinksInterface.DIV_LINK_RESPONSE;
import static interfaces.elements.LinksInterface.LINK_CREATED;

public class LinksAction extends BasePage {
    public LinksAction(WebDriver driver) {
        super(driver);
    }
    public void ClickCreatedLink(){
        waitForElementIsVisible(driver,LINK_CREATED);
        clickToElementByJS(driver,LINK_CREATED);
    }
    public String getLinkStatus(){
        waitForElementIsVisible(driver,DIV_LINK_RESPONSE);
        return getTextElement(driver,DIV_LINK_RESPONSE);
    }
}
