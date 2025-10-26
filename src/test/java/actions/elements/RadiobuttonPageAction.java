package actions.elements;

import common.BasePage;
import org.openqa.selenium.WebDriver;

import static interfaces.elements.RadiobuttonPageInterface.*;

public class RadiobuttonPageAction extends BasePage {

    public RadiobuttonPageAction(WebDriver driver) {
        super(driver);
    }

    public void selectRadioButton(String option) {
        String locator = String.format(RADIO_BY_LABEL, option.toLowerCase());
        waitForElementIsVisible(driver, locator);
        scrollIntoView(driver, locator);
        clickToElementByJS(driver, locator);
    }

    public String getResultText() {
        waitForElementIsVisible(driver, resultTextRadio);
        return getTextElement(driver, resultTextRadio);
    }

      public boolean isNoOptionDisabled() {
          String locator = String.format(RADIO_BY_LABEL, "no");
          if ("true".equals(getElementAttributeValue(driver, locator, "disabled"))) {
              return true;
          }

          String classValue = getElementAttributeValue(driver, locator, "class");
          if (classValue != null && (classValue.contains("disabled") || classValue.contains("not-allowed"))) {
              return true;
          }
          return false;
    }

}
