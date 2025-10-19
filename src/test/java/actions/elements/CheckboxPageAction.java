package actions.elements;

import common.BasePage;
import org.openqa.selenium.WebDriver;

import static interfaces.elements.CheckboxPageInterface.*;

public class CheckboxPageAction extends BasePage {
    WebDriver driver;
    public CheckboxPageAction(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void clickExpandAll() {
        waitForElementIsVisible(driver, EXPAND_ALL_BUTTON);
       // highlightElement(driver,EXPAND_ALL_BUTTON);
        clickToElement(driver,EXPAND_ALL_BUTTON);
    }
    public void clickCheckbox(String buttonName) {
        waitForElementIsVisible(driver,BUTTON_CHECKBOX, buttonName);
        scrollIntoView(driver,BUTTON_CHECKBOX,buttonName);
        clickToElementByJS(driver, BUTTON_CHECKBOX, buttonName);
    }

    public String getResultText() {
        return getTextElement(driver, String.valueOf(resultTextCheckbox));
    }
}
