package testcases;

import actions.HomePageAction;
import actions.elements.MenuLeftAction;
import actions.elements.TextboxPageAction;
import common.AssertUtils;
import common.BaseTest;
import common.CommonUtils;
import common.Log;
import interfaces.elements.TextboxPageInterface;
import org.openqa.selenium.WebDriver;

public class FlowToElementTestcases extends BaseTest {
    WebDriver driver;
    public void init(){
        driver = getBrowserDriver("chrome","https://demoqa.com/");

    }
    public void flowToElementTextbox() throws InterruptedException {
        Log.info("Step1: Click vào menu Elements màn hình homepage");

        HomePageAction homePageAction = new HomePageAction(driver);
        homePageAction.clickOnMenu("Elements");

        Log.info("Step 2: Click vào menu Textbox màn hình Elements");
        MenuLeftAction menuleftAction = new MenuLeftAction(driver);
        menuleftAction.clickOnMenu("Text Box");

        CommonUtils.SleepInSeconds(5);

        TextboxPageAction actions = new TextboxPageAction(driver);
        Log.info("Step 3: Nhập fulname vào Textbox Fullname");
        actions.enterFullName("Đỗ Huyền Chinh");

        Log.info("Step 4: Nhập Email vào Textbox Email");
        actions.enterEmail("huyenchinh@gmail.com");

        Log.info("Step 5: Nhập CurrentAddress vào Textbox CurrentAddress");
        actions.enterCurrentAddress("Hà Nội");

        Log.info("Step 6: Nhập PermanentAddress vào Textbox PermanentAddress");
        actions.enterPermanentAddress("Thái Bình");

        Log.info("Step 7: Click Button Submit");
        // đổi lại clickbutton
        actions.enterSubmitButton(TextboxPageInterface.SUBMIT_BUTTON);
        CommonUtils.SleepInSeconds(5);
        Log.info("Step 8: Verify kết quả ra màn hình");
        AssertUtils.assertEquals(actions.getResult(),"Result");
        driver.quit();

    }

//    @Test
//    public void flowToElementCheckbox() throws InterruptedException {
//
//        HomePageAction homePageAction = new HomePageAction(driver);
//        homePageAction.clickOnMenu("Elements");
//
//        MenuLeftAction menuleftAction = new MenuLeftAction(driver);
//        menuleftAction.clickOnMenu("Check Box");
//
//
//        CommonUtils.SleepInSeconds(5);
//        CheckboxPageAction checkboxPageAction = new CheckboxPageAction(driver);
//        checkboxPageAction.clickExpandAll();
//        CommonUtils.SleepInSeconds(2);
//        checkboxPageAction.clickCheckbox("Desktop");
//        CommonUtils.SleepInSeconds(5);
//        driver.quit();
//
//    }
//
//    public void flowToElement() throws InterruptedException {
//        HomePageAction homePageAction = new HomePageAction(driver);
//        homePageAction.clickOnMenu("Elements");
//        MenuLeftAction menuleftAction = new MenuLeftAction(driver);
//        menuleftAction.clickOnMenu("Radio Button");
////      menuleftAction.SleepInSeconds(5);
//        RadiobuttonPageAction radiobuttonPageAction = new RadiobuttonPageAction(driver);
//        radiobuttonPageAction.selectRadioButton("yesRadio");
//        CommonUtils.SleepInSeconds(5);
//
//
//        driver.quit();
//
//    }
}
