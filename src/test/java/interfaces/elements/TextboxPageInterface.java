package interfaces.elements;

import org.openqa.selenium.By;

public interface TextboxPageInterface {
    String FULLNAME_TEXTBOX = "//input[@id='userName']";
    String EMAIL_TEXTBOX = "//input[@id='userEmail']";
    String CURRENT_ADDRESS = "//textarea[@id='currentAddress']";
    String PERMANENT_ADDRESS= "//textarea[@id='permanentAddress']";
    String SUBMIT_BUTTON = "//button[@id='submit']";
    By outputText = By.id("output");
}
