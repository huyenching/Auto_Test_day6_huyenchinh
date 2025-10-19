package actions.elements;

import common.BasePage;
import org.openqa.selenium.WebDriver;

import static interfaces.elements.RadiobuttonPageInterface.RADIO_OPTION;
import static interfaces.elements.RadiobuttonPageInterface.resultTextRadio;

public class RadiobuttonPageAction extends BasePage {
    WebDriver driver;
    public RadiobuttonPageAction(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void selectRadioButton(String option) {
        waitForElementIsVisible(driver,RADIO_OPTION,option);
        scrollIntoView(driver,RADIO_OPTION,option);
        clickToElementByJS(driver,RADIO_OPTION,option);
    }
    public String getResultText() {
        return getTextElement(driver, String.valueOf(resultTextRadio));
    }
}
