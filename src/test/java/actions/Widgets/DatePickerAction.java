package actions.Widgets;

import common.BasePage;
import interfaces.Widgets.DatePickerInterface;
import org.openqa.selenium.WebDriver;

public class DatePickerAction extends BasePage {
    public DatePickerAction(WebDriver driver) {
        super(driver);
    }
    public void openDatePicker() {
        waitForElementIsVisible(driver, DatePickerInterface.DATE_INPUT);
        clickToElementByJS(driver,DatePickerInterface.DATE_INPUT);
    }
    public void selectDay(String day) {
        String dynamicDay = String.format(DatePickerInterface.CALENDAR_DAY,day);
        waitForElementIsVisible(driver, dynamicDay);
        clickToElementByJS(driver,dynamicDay);
    }
    public String getDate() {
        return getElementAttributeValue(driver,DatePickerInterface.DATE_INPUT,"value");
    }
}
