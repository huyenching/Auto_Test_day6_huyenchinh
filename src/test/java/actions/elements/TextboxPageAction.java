package actions.elements;

import common.BasePage;
import interfaces.elements.TextboxPageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static interfaces.elements.TextboxPageInterface.*;

public class TextboxPageAction extends BasePage {
    WebDriver driver;
    public TextboxPageAction(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void enterFullName(String fullName) {
        waitForElementIsVisible(driver,FULLNAME_TEXTBOX);
        enterTextToElement(driver, FULLNAME_TEXTBOX, fullName);
    }
    public void enterEmail(String email) {
        waitForElementIsVisible(driver,EMAIL_TEXTBOX);
        enterTextToElement(driver, EMAIL_TEXTBOX, email);
    }
    public void enterCurrentAddress(String currentAddress) {
        waitForElementIsVisible(driver,CURRENT_ADDRESS);
        enterTextToElement(driver, CURRENT_ADDRESS, currentAddress);
    }
    public void enterPermanentAddress(String permanentAddress) {
        waitForElementIsVisible(driver,PERMANENT_ADDRESS);
        enterTextToElement(driver, PERMANENT_ADDRESS, permanentAddress);
    }
    public void enterSubmitButton(String value) {
        waitForElementIsVisible(driver,TextboxPageInterface.SUBMIT_BUTTON);
        scrollIntoView(driver,TextboxPageInterface.SUBMIT_BUTTON);
        clickToElement(driver, TextboxPageInterface.SUBMIT_BUTTON);
    }
    public String getResult() {
        waitForElementIsVisible(driver, String.valueOf(outputText));
        return   getTextElement(driver, String.valueOf(outputText));

    }
}
