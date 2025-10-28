package actions.elements;

import common.BasePage;
import common.CommonUtils; // Cần import CommonUtils
import interfaces.elements.ButtonsInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsAction extends BasePage {
    public ButtonsAction(WebDriver driver) {
        super(driver);
    }

    public void clickButton() {
       waitForElementIsVisible(driver, ButtonsInterface.DOUBLE_CLICK_BUTTON);
        scrollIntoView(driver, ButtonsInterface.DOUBLE_CLICK_BUTTON);
        WebElement button = getElement(driver, ButtonsInterface.DOUBLE_CLICK_BUTTON);
        highlightElement(driver, ButtonsInterface.DOUBLE_CLICK_BUTTON);
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();
        CommonUtils.SleepInSeconds(2);
    }

    public String getMessage() {
        String messageXpath = ButtonsInterface.DOUBLE_CLICK_MESSAGE;
        int maxWaitTime = 10; // Chờ tối đa 10 lần (10 giây)
        int attempts = 0;

        // Vòng lặp Polling: Sử dụng isDisplayElement (37) để kiểm tra cho đến khi True
        while (attempts < maxWaitTime) {
            // isDisplayElement sẽ cố gắng tìm phần tử ngay lập tức
            if (isDisplayElement(driver, messageXpath)) {
                break;
            }
            // Tạm dừng ngắn để đợi DOM cập nhật
            CommonUtils.SleepInSeconds(1);
            attempts++;
        }

        // Sau khi đã chờ đủ lâu, gọi getTextElement (31) của BasePage
        // (getTextElement sẽ gọi lại Explicit Wait 20s, nhưng Polling đã khắc phục lỗi timing)
        return getTextElement(driver, messageXpath);
    }
}