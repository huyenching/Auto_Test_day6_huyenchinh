package actions.forms;

import common.BasePage;
import interfaces.forms.FormsInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPageAction extends BasePage {
    public FormPageAction(WebDriver driver) {
        super(driver);
    }
    public void fillForm(String first, String last, String email, String gender, String mobile) {
        enterTextToElement(driver,FormsInterface.FIRST_NAME, first);
        enterTextToElement(driver, FormsInterface.LAST_NAME, last);
        enterTextToElement(driver, FormsInterface.EMAIL, email);
        clickToElementByJS(driver, FormsInterface.GENDER_MALE);
        enterTextToElement(driver, FormsInterface.MOBILE, mobile);
    }
    public void submitForm() {
        clickToElementByJS(driver, FormsInterface.SUBMIT_BUTTON);
    }
    public boolean isModalDisplayed() {
        return isDisplayElements(driver, FormsInterface.MODAL_CONTENT);
    }
}
