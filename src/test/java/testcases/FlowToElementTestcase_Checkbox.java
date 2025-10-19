package testcases;

import actions.HomePageAction;
import actions.elements.CheckboxPageAction;
import actions.elements.MenuLeftAction;
import common.BaseTest;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class FlowToElementTestcase_Checkbox extends BaseTest {
    WebDriver driver;
    public void init(){
        driver = getBrowserDriver("chrome","https://demoqa.com/");

    }
    public void flowToElement() throws InterruptedException {
        HomePageAction homePageAction = new HomePageAction(driver);
        homePageAction.clickOnMenu("Elements");
        MenuLeftAction menuleftAction = new MenuLeftAction(driver);
        menuleftAction.clickOnMenu("Check Box");
        menuleftAction.SleepInSeconds(5);
        CheckboxPageAction checkboxPageAction = new CheckboxPageAction(driver);
        checkboxPageAction.clickExpandAll();
        checkboxPageAction.SleepInSeconds(2);
        checkboxPageAction.clickCheckbox("Desktop");
        checkboxPageAction.SleepInSeconds(5);
        driver.quit();

    }
    public static void main(String[] args) throws InterruptedException {

        FlowToElementTestcase_Checkbox testCase = new FlowToElementTestcase_Checkbox();
        testCase.init();
        testCase.flowToElement();
    }
}
