package actions.elements;

import common.BasePage;
import common.CommonUtils;
import interfaces.elements.TextboxPageInterface;
import org.openqa.selenium.WebDriver;

// Cần import List
import java.util.List;
import org.openqa.selenium.WebElement;

import static interfaces.elements.TextboxPageInterface.*;

public class TextboxPageAction extends BasePage {

    public TextboxPageAction(WebDriver driver) {
        super(driver);
    }

    public void enterFullName(String fullName) {
        waitForElementIsVisible(driver, FULLNAME_TEXTBOX);
        enterTextToElement(driver, FULLNAME_TEXTBOX, fullName);
    }

    public void enterEmail(String email) {
        waitForElementIsVisible(driver, EMAIL_TEXTBOX);
        enterTextToElement(driver, EMAIL_TEXTBOX, email);
    }

    public void enterCurrentAddress(String currentAddress) {
        waitForElementIsVisible(driver, CURRENT_ADDRESS);
        enterTextToElement(driver, CURRENT_ADDRESS, currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress) {
        waitForElementIsVisible(driver, PERMANENT_ADDRESS);
        enterTextToElement(driver, PERMANENT_ADDRESS, permanentAddress);
    }

    public void clickSubmitButton() {
        waitForElementIsVisible(driver, SUBMIT_BUTTON);
        scrollIntoView(driver, SUBMIT_BUTTON);
        clickToElementByJS(driver, SUBMIT_BUTTON);
        CommonUtils.SleepInSeconds(1);
    }

    public String getResult() {
        waitForElementIsVisible(driver, outputText);
        return getTextElement(driver, outputText);
    }

    public String getEmailClass() {
        return getElementAttributeValue(driver, EMAIL_TEXTBOX, "class");
    }

    public boolean isOutputNotDisplayed() {
        int size = getListElementSize(driver, outputText);
        return size == 0;
    }
}