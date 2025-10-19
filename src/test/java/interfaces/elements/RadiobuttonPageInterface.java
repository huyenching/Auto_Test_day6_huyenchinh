package interfaces.elements;

import org.openqa.selenium.By;

public interface RadiobuttonPageInterface {
    String RADIO_OPTION = "//label[@for='%s']";
    By resultTextRadio = By.xpath("//*[@class='text-success']");
}
