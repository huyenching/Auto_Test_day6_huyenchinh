package testcases;

import actions.HomePageAction;
import actions.elements.CheckboxPageAction;
import actions.elements.MenuLeftAction;
import actions.elements.RadiobuttonPageAction;
import common.BaseTest;
import org.openqa.selenium.WebDriver;

public class FlowToElementTestcase_Radiobutton extends BaseTest {
    WebDriver driver;
    public void init(){
        driver = getBrowserDriver("chrome","https://demoqa.com/");

    }
    public void flowToElement() throws InterruptedException {
        HomePageAction homePageAction = new HomePageAction(driver);
        homePageAction.clickOnMenu("Elements");
        MenuLeftAction menuleftAction = new MenuLeftAction(driver);
        menuleftAction.clickOnMenu("Radio Button");
//      menuleftAction.SleepInSeconds(5);
        RadiobuttonPageAction radiobuttonPageAction = new RadiobuttonPageAction(driver);
        radiobuttonPageAction.selectRadioButton("yesRadio");
        radiobuttonPageAction.SleepInSeconds(5);


        driver.quit();

    }
    public static void main(String[] args) throws InterruptedException {

        FlowToElementTestcase_Radiobutton testCase = new FlowToElementTestcase_Radiobutton();
        testCase.init();
        testCase.flowToElement();
    }
}
