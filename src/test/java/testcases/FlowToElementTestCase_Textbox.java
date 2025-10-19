package testcases;

import actions.HomePageAction;
import actions.elements.MenuLeftAction;
import actions.elements.TextboxPageAction;
import common.BaseTest;
import org.openqa.selenium.WebDriver;

public class FlowToElementTestCase_Textbox extends BaseTest {
    WebDriver driver;
    public void init(){
        driver = getBrowserDriver("chrome","https://demoqa.com/");

    }
    public void flowToElement() throws InterruptedException {
        HomePageAction homePageAction = new HomePageAction(driver);
        homePageAction.clickOnMenu("Elements");
        MenuLeftAction menuleftAction = new MenuLeftAction(driver);
        menuleftAction.clickOnMenu("Text Box");
        menuleftAction.SleepInSeconds(5);
        TextboxPageAction actions = new TextboxPageAction(driver);
        actions.enterFullName("Đỗ Huyền Chinh");
        actions.enterEmail("huyenchinh@gmail.com");
        actions.enterCurrentAddress("Hà Nội");
        actions.enterPermanentAddress("Thái Bình");
        actions.enterSubmitButton();
        actions.SleepInSeconds(5);
        String result=actions.getResult();
        System.out.println("Kết quả là: "+ result);
        driver.quit();

    }
    public static void main(String[] args) throws InterruptedException {

        FlowToElementTestCase_Textbox testCase = new FlowToElementTestCase_Textbox();
        testCase.init();
        testCase.flowToElement();
    }
}
