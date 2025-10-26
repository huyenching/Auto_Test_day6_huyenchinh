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
        String editXpath = String.format(WebtableInterface.EDIT_BY_LASTNAME, lastName);

        String rowLocator = String.format("//div[text()='%s']", lastName);
        try {
            waitForElementIsVisible(driver, rowLocator); // Sử dụng BasePage.waitForElementIsVisible (16)
        } catch (Exception e) {
            System.err.println("Lỗi chờ dữ liệu cho " + lastName + ": " + e.getMessage());
        }
        scrollIntoView(driver, editXpath);

        clickToElementByJS(driver, editXpath);
    }

    public boolean isEditFormDisplayed() {
        try {

            waitForElementIsVisible(driver, WebtableInterface.EDIT_FORM);
             return isDisplayElement(driver, WebtableInterface.EDIT_FORM); // Sử dụng BasePage.isDisplayElement (37)
        } catch (Exception e) {

             return false;
        }
    }

    public int getRowsAfterAge(String age) {
        String rowsXpath = String.format(WebtableInterface.ROWS_AFTER_AGE, age);
        return getListElementSize(driver, rowsXpath);
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