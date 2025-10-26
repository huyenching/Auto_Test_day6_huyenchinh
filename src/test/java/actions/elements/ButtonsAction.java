package actions.elements;

import common.BasePage;
import common.CommonUtils; // Cần import CommonUtils
import interfaces.elements.ButtonsInterface;
import org.openqa.selenium.WebDriver;

public class ButtonsAction extends BasePage {
    public ButtonsAction(WebDriver driver) {
        super(driver);
    }

    public void clickButton() {
        waitForElementIsVisible(driver, ButtonsInterface.DOUBLE_CLICK_BUTTON);
        doubleClickOnElement(driver, ButtonsInterface.DOUBLE_CLICK_BUTTON);

        // FIX NOSUCHELEMENT: Cấp 1 giây để DOM cập nhật sau thao tác Double Click
        CommonUtils.SleepInSeconds(1);
    }

    public String getMessage() {
        // Hàm getTextElement (31) đã có chờ, nhưng Sleep ở trên giúp ổn định hơn
        return getTextElement(driver, ButtonsInterface.DOUBLE_CLICK_MESSAGE);
    }
}