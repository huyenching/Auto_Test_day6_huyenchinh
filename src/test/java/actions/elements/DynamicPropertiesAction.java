package actions.elements;

import common.BasePage;
import interfaces.elements.DynamicPropertiesInterface;
import org.openqa.selenium.WebDriver;

public class DynamicPropertiesAction extends BasePage {
    public DynamicPropertiesAction(WebDriver driver) {
        super(driver);
    }

    public boolean isEnableButtonEnabled(){
        return getElement(driver,DynamicPropertiesInterface.ENABLE_AFTER_BUTTON).isEnabled();

    }
    public void waitForButtonEnabled(){
        waitForElementClickable(driver,DynamicPropertiesInterface.ENABLE_AFTER_BUTTON);
    }

}
