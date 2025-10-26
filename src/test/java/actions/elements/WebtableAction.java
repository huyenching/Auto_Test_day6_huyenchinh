package actions.elements;

import common.BasePage;
import interfaces.elements.WebtableInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebtableAction extends BasePage {
    public WebtableAction(WebDriver driver) {
        super(driver);
    }

    public String getEmailByFirstName(String firstName) {
        String emailXpath = String.format(WebtableInterface.EMAIL_BY_FIRSTNAME, firstName);

        scrollIntoView(driver, WebtableInterface.TABLE_CONTAINER);

        return getTextElement(driver, emailXpath);
    }

    public void clickEditByLastName(String lastName) {
        scrollIntoView(driver, WebtableInterface.TABLE_CONTAINER);

        String xpath = WebtableInterface.EDIT_BY_LASTNAME;

         clickToElement(driver, xpath, lastName);
    }

    public boolean isEditFormDisplayed() {
        return isDisplayElement(driver, WebtableInterface.EDIT_FORM);
    }

    public int getRowsAfterAge(String age) {
        scrollIntoView(driver, WebtableInterface.TABLE_CONTAINER);
        return getListElementSize(driver, WebtableInterface.ROWS_AFTER_AGE, age);
    }

    public boolean isEmailValid(String firstName) {
        String email = "";
        try {
            email = getEmailByFirstName(firstName);
        } catch (Exception e) {
            return false;
        }

        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.trim().contains("@");
    }
}