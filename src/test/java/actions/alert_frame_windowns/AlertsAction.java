package actions.alert_frame_windowns;

import common.BasePage;
import interfaces.Alerts_Frame_Windows.AlertsInterface;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertsAction extends BasePage {
    public AlertsAction(WebDriver driver) {
        super(driver);
    }

    public void clickAlert() {
        scrollIntoView(driver, AlertsInterface.SIMPLE_ALERT_BUTTON);
        clickToElementByJS(driver, AlertsInterface.SIMPLE_ALERT_BUTTON);
    }

    public void acceptAlert() {
         Alert alert = waitForAlertPresence(driver);
        alert.accept();
    }
}