package actions.elements;

import common.BasePage;
import interfaces.elements.UploadAndDownloadInterface;
import org.openqa.selenium.WebDriver;

public class UploadAndDownloadAction extends BasePage {
    public UploadAndDownloadAction(WebDriver driver) {
        super(driver);
    }
    public void uploadFile(String fileName) {

        enterTextToElement(driver, UploadAndDownloadInterface.CHOOSE_FILE_INPUT, fileName);

    }
    public String getUploadedFilePath() {
        return getTextElement(driver, UploadAndDownloadInterface.UPLOADED_FILE_PATH);
    }

}
