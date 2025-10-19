package interfaces.elements;

import org.openqa.selenium.By;

public interface CheckboxPageInterface {
    String BUTTON_CHECKBOX = "//span[contains(text(),'%s')]";
    String EXPAND_ALL_BUTTON = "//button[@title='Expand all']";
    By resultTextCheckbox = By.id("result");
}
