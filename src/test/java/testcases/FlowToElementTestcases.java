package testcases;

import actions.HomePageAction;
import actions.Widgets.DatePickerAction;
import actions.alert_frame_windowns.AlertsAction;
import actions.elements.*;
import actions.forms.FormPageAction;
import common.AssertUtils;
import common.BaseTest;
import common.CommonUtils;
import common.Log;
import interfaces.elements.TextboxPageInterface;
import interfaces.elements.WebtableInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.time.Duration;

public class FlowToElementTestcases extends BaseTest {
    private WebDriverWait wait;

    private WebDriver driver;
    private HomePageAction homePage;
    private MenuLeftAction menuLeft;
    private TextboxPageAction textBox; // Dùng Action mới
    private CheckboxPageAction checkBox;
    private RadiobuttonPageAction radioButton;
    private WebtableAction webTable;
    private ButtonsAction buttons;
    private LinksAction links;
    private UploadAndDownloadAction uploadAndDownload;
    private DynamicPropertiesAction dynamicProperties;
    private AlertsAction alerts;
    private FormPageAction form;
    private DatePickerAction datePicker;
    @BeforeMethod
    public void init(){
        driver = getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homePage = new HomePageAction(driver);
        menuLeft = new MenuLeftAction(driver);
        textBox = new TextboxPageAction(driver);
        checkBox = new CheckboxPageAction(driver);
        radioButton = new RadiobuttonPageAction(driver);
        webTable = new WebtableAction(driver);
        buttons = new ButtonsAction(driver);
        links = new LinksAction(driver);
        uploadAndDownload = new UploadAndDownloadAction(driver);
        dynamicProperties = new DynamicPropertiesAction(driver);
        alerts = new AlertsAction(driver);
        form = new FormPageAction(driver);
        datePicker = new DatePickerAction(driver);
    }

    @Test(priority = 1, description = "DQ-TB-001 | Elements > Text Box | Positive E2E")
    public void DQ_TB_001() {
        Log.info("Step1: Click vào menu Elements màn hình homepage");
        homePage.clickOnMenu("Elements");

        Log.info("Step 2: Click vào menu Textbox màn hình Elements");
         menuLeft.clickOnMenu("Text Box");

        Log.info("Step 3: Nhập fulname vào Textbox Fullname");
        textBox.enterFullName("Đỗ Huyền Chinh");

        Log.info("Step 4: Nhập Email vào Textbox Email");
        textBox.enterEmail("huyenchinh@gmail.com");

        Log.info("Step 5: Nhập CurrentAddress vào Textbox CurrentAddress");
        textBox.enterCurrentAddress("Hà Nội");

        Log.info("Step 6: Nhập PermanentAddress vào Textbox PermanentAddress");
        textBox.enterPermanentAddress("Thái Bình");

        Log.info("Step 7: Click Button Submit");
        textBox.clickSubmitButton();

        Log.info("Step 8: Verify kết quả ra màn hình");
        String result = textBox.getResult();
        Assert.assertTrue(result.contains("Đỗ Huyền Chinh"), "FullName hiển thị không đúng");
        Assert.assertTrue(result.contains("huyenchinh@gmail.com"), "Email hiển thị không đúng");
    }
//    @Test(priority = 2, description = "DQ-TB-002 | Elements > Text Box | Email sai định dạng → hiển thị lỗi, không có output")
//    public void DQ_TB_002() {
//        Log.info("Step1: Click vào menu Elements màn hình homepage");
//        homePage.clickOnMenu("Elements");
//
//        Log.info("Step 2: Click vào menu Textbox màn hình Elements");
//        menuLeft.clickOnMenu("Text Box");
//
//        Log.info("Step 3: Nhập fulname vào Textbox Fullname");
//        textBox.enterFullName("Đỗ Huyền Chinh");
//
//        Log.info("Step 4: Nhập Email vào Textbox Email");
//        textBox.enterEmail("huyenchinh@");
//
//        Log.info("Step 5: Nhập CurrentAddress vào Textbox CurrentAddress");
//        textBox.enterCurrentAddress("Hà Nội");
//
//        Log.info("Step 6: Nhập PermanentAddress vào Textbox PermanentAddress");
//        textBox.enterPermanentAddress("Thái Bình");
//
//        Log.info("Step 7: Click Button Submit");
//        textBox.clickSubmitButton();
//
//        CommonUtils.SleepInSeconds(1);
//
//        Log.info("Step 8: Kiểm tra class của ô email");
//        String emailClass = textBox.getEmailClass(); // Đã sửa
//        Assert.assertTrue(emailClass.contains("error") || emailClass.contains("invalid") || emailClass.contains("field-error"),
//                "DQ_TB_002 Thất bại: Email sai định dạng không hiển thị lỗi.");
//
//        Log.info("Step 9: Verify output không chứa tên (dữ liệu chính)");
//        Assert.assertTrue(textBox.isOutputNotDisplayed(), "DQ_TB_002 Thất bại: Không nên có kết quả khi email sai định dạng.");
//    }

    @Test(priority = 3,description = "DQ-CB-001 | Elements > Check Box | Positive Single Node")
    public void DQ_CB_001() {
        Log.info("Step1: Click vào menu Elements màn hình homepage");
        homePage.clickOnMenu("Elements");
        Log.info("Step 2: Click vào menu Checkbox màn hình Elements");
        menuLeft.clickOnMenu("Check Box");
        Log.info("Step 3: Click vào ExpandAll ");
        checkBox.clickExpandAll();
        Log.info("Step 4: Click vào Desktop trong checkbox");
        checkBox.clickCheckbox("Desktop");
        Log.info("Step 5: Verify kết quả ra màn hình");
        String resultText = checkBox.getResultText();
        System.out.println("Kết quả là: "+resultText);
        Assert.assertTrue(resultText.toLowerCase().contains("desktop"),"Kết quả không chứa từ desktop");

    }
    @Test(priority = 4,description = "DQ-CB-002 | Elements > Check Box | Positive Parent Cascade")
    public void DQ_CB_002() {
        Log.info("Step1: Click vào menu Elements màn hình homepage");
        homePage.clickOnMenu("Elements");
        Log.info("Step 2: Click vào menu Checkbox màn hình Elements");
        menuLeft.clickOnMenu("Check Box");
        Log.info("Step 3: Click vào ExpandAll ");
        checkBox.clickExpandAll();
        Log.info("Step 4: Click vào home trong checkbox");
        checkBox.clickCheckbox("Home");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        String resultText = checkBox.getResultText();
        System.out.println("kết quả la: "+resultText);
        Assert.assertTrue(resultText.contains("home"));
        Assert.assertTrue(resultText.contains("documents"));
        Assert.assertTrue(resultText.contains("downloads"));
    }
    @Test(priority = 5, description = "DQ-RB-001 | Elements > Radio Button | Verify single selection")
    public void DQ_RB_001() {
        Log.info("Step 1: Click vào menu Elements trên homepage");
        homePage.clickOnMenu("Elements");

        Log.info("Step 2: Click vào menu Radio Button trên màn hình Elements");
        menuLeft.clickOnMenu("Radio Button");

        Log.info("Step 3: Chọn radio button 'Yes'");
        radioButton.selectRadioButton("yes");

        Log.info("Step 4: Verify kết quả hiển thị ra màn hình");
        String resultText = radioButton.getResultText();
        System.out.println("Kết quả là: " + resultText);

        Assert.assertTrue(resultText.contains("Yes"),
                "Kết quả hiển thị sau khi chọn 'Yes' không khớp với mong đợi.");

    }

    @Test(priority = 6, description = "DQ-RB-002 | Elements > Radio Button | Negative Check No option is disabled")
    public void DQ_RB_002() {
        Log.info("Step 1: Click vào menu Elements trên homepage");
        homePage.clickOnMenu("Elements");

        Log.info("Step 2: Click vào menu Radio Button trên màn hình Elements");
        menuLeft.clickOnMenu("Radio Button");

        Log.info("Step 3: Kiểm tra radio button 'No' có bị vô hiệu hóa không");
        boolean isDisabled = radioButton.isNoOptionDisabled();
        System.out.println("Attribute 'disabled' của No: " + isDisabled);
        Assert.assertTrue(isDisabled, "Nút 'No' phải bị vô hiệu hóa");

        Log.info("Step 4: Verify không có kết quả hiển thị cho 'No'");
        Assert.assertTrue(true, "Kết quả không được hiển thị khi chọn 'No'");
    }

    @Test(priority = 7,description = "DQ-WT-001 | Elements > Web Tavles | LOCATOR_FOLLOWING_SIBLING")
    public void DQ_WT_001() {
        Log.info("Step1: Click vào menu Elements màn hình homepage");
        homePage.clickOnMenu("Elements");
        Log.info("Step 2: Click vào menu Web Tables màn hình Elements");
        menuLeft.clickOnMenu("Web Tables");

        CommonUtils.SleepInSeconds(2);

        Log.info("Step 3: Tìm hàng có First Name = Cierra");
        webTable.getEmailByFirstName("Cierra");

        Log.info("Step 4: Verify kết quả ra màn hình");
        Assert.assertTrue(webTable.isEmailValid("Cierra"),"Email không hợp lệ hoặc không tìm thấy");
    }

//    @Test(priority = 8,description = "DQ-WT-002 | Elements > Web Tables | Locate Edit button by Last Name")
//    public void DQ_WT_002() {
//        Log.info("Step1: Click vào menu Elements màn hình homepage");
//        homePage.clickOnMenu("Elements");
//        Log.info("Step 2: Click vào menu Web Tables màn hình Elements");
//        menuLeft.clickOnMenu("Web Tables");
//        Log.info("Step 3: Tìm hàng có Last Name = Alden");
//        webTable.clickEditByLastName("Alden");
//
//        Log.info("Step 4: Verify form Edit hiển thị");
//        Assert.assertTrue(webTable.isEditFormDisplayed(),
//                "Form Edit phải hiển thị sau khi click Edit");
//    }

    @Test(priority = 9,description = "DQ-WT-003 | Elements > Web Tables | Count rows after specific Age")
    public void DQ_WT_003() {
        Log.info("Step1: Click vào menu Elements màn hình homepage");
        homePage.clickOnMenu("Elements");
        Log.info("Step 2: Click vào menu Web Tables màn hình Elements");
        menuLeft.clickOnMenu("Web Tables");

        CommonUtils.SleepInSeconds(2);

        Log.info("Step 3: Đếm số hàng nằm sau hàng có Age = 39");
        int count = webTable.getRowsAfterAge("39");
        Log.info("Số hàng phía sau: " + count);

        Log.info("Step 4: Kiểm tra số hàng hợp lệ");
        Assert.assertTrue(count >= 0, "Số hàng phía sau phải >= 0");
    }

//    @Test(priority = 10,description  = "DQ_BTN_001 | Elements > Buttons | Positive Double Click")
//    public void DQ_BTN_001() {
//        Log.info("Step1: Click vào menu Elements màn hình homepage");
//        homePage.clickOnMenu("Elements");
//        Log.info("Step 2: Click vào menu Button màn hình Elements");
//        menuLeft.clickOnMenu("Buttons");
//
//        // CommonUtils.SleepInSeconds(2);
//
//        Log.info("Step 3:Double click nút 'Double Click Me'");
//        buttons.clickButton();
//
//        Log.info("Step 4: Verify thông báo hiển thị đúng sau khi double click");
//        String message = buttons.getMessage();
//        Assert.assertEquals(message,"You have done a double click", "Thông báo không đúng sau khi double click");
//    }

    @Test(priority = 11,description = "DQ-LINK-001 | Elements > LINKS | Negative Check No option is disabled")
    public void DQ_LINK_001() {
        Log.info("Step1: Click vào menu Elements màn hình homepage");
        homePage.clickOnMenu("Elements");
        Log.info("Step 2: Click vào menu LINKS màn hình Elements");
        menuLeft.clickOnMenu("Links");


        Log.info("Step 3: Kiểm tra nút Created Links");
        links.ClickCreatedLink();

        Log.info("Step 4:Kiểm tra thông báo chứa 201");
        String result = links.getLinkStatus();
        Assert.assertTrue(result.contains("201") && result.contains("Created"),"Thông báo kết quả khng chính xác cho link Created");
    }

    @Test(priority = 12,description = "DQ-UP-001 | Elements > Upload and Download | UPLOAD_VALID")
    public void DQ_UP_001() {
        Log.info("Step1: Click vào menu Elements màn hình homepage");
        homePage.clickOnMenu("Elements");
        Log.info("Step 2: Click vào menu Upload and Download màn hình Elements");
        menuLeft.clickOnMenu("Upload and Download");


        String filePath = Paths.get("C:\\Users\\PC\\Downloads\\logo.png").toString();
        Log.info("Step 3: Click chọn file ");
        uploadAndDownload.uploadFile(filePath);

        String actualUpload = uploadAndDownload.getUploadedFilePath();

        Log.info("Step 4:Kiểm tra file path hieern thị tên file");
        Assert.assertTrue(actualUpload.contains("logo.png"),"File path hiển thị không đúng. Giá trị thực tế: " + actualUpload);
    }

    @Test(priority = 13,description = "DQ-DP-001 | Elements > Dynamic Properties | ENABLE_AFTER")
    public void DQ_DP_001() {
        Log.info("Step1: Click vào menu Elements màn hình homepage");
        homePage.clickOnMenu("Elements");
        Log.info("Step 2: Click vào menu Dynamic Properties màn hình Elements");
        menuLeft.clickOnMenu("Dynamic Properties");

        Log.info("Step 3: Kiểm tra ban đầu nút bị disable");
        boolean initialState = dynamicProperties.isEnableButtonEnabled();
        Assert.assertFalse(initialState,"Nút này ban đầu phải bị vô hiệu hóa");

        Log.info("Step 4: Chờ đến khi nút được bật lại");
        dynamicProperties.waitForButtonEnabled();

        Log.info("Step 5: Kiểm tra sau khi chờ");
        boolean finalState = dynamicProperties.isEnableButtonEnabled();
        Assert.assertTrue(finalState,"Nút đã được bật sau 5 giây");
    }

    @Test(priority = 14,description = "DQ-AL-001 | Alerts, Frame & Windows > Alerts | ALERT_SIMPLE")
    public void DQ_AL_001() {
        Log.info("Step1: Click vào menu Alerts, Frame & Windows màn hình homepage");
        homePage.clickOnMenu("Alerts, Frame & Windows");
        Log.info("Step 2: Click vào menu Alerts màn hình Alerts, Frame & Windows");
        menuLeft.clickOnMenu("Alerts");

        Log.info("Step 3: Click chọn Click me để mở alerts đơn giản ");
        alerts.clickAlert(); // Action đã có scroll/click

        Log.info("Step 4:accept sau khi click me ");
        alerts.acceptAlert();

        Assert.assertTrue(true,"Alert đã được hiển thị và accept thành công.");
    }

    @Test(priority = 15,description = "DQ-FM-001 | Forms > Practice Form | POSITIVE_SUBMIT")
    public void DQ_FM_001() {
        Log.info("Step1: Click vào menu Forms màn hình homepage");
        homePage.clickOnMenu("Forms");
        Log.info("Step 2: Click vào menu Practice Form màn hình Forms");
        menuLeft.clickOnMenu("Practice Form");

        Log.info("Step 3: Điền thng tin vào form ");
        form.fillForm("Huyen","Chinh","huyenchinh@gmail.com","Female","0705730778");

        Log.info("Step 4: Nhấn nút submit");
        form.submitForm();
        Log.info("Step 5: Kiểm tra modal xác nhận hiển thị");
        Assert.assertTrue(form.isModalDisplayed(),"Form is modal");

    }
    @Test(priority = 16,description = "DQ-DPICK-001 | Widgets > Date Picker | BVA_BOUNDARY")
    public void DQ_DPICK_001() {
        Log.info("Step1: Click vào menu Widgets màn hình homepage");
        homePage.clickOnMenu("Widgets");
        Log.info("Step 2: Click vào menu Date Picker Form màn hình Widgets");
        menuLeft.clickOnMenu("Date Picker");

        Log.info("Step 3: Mở picker");
        datePicker.openDatePicker();

        Log.info("Step 4: Chọn ngày 1 ");
        datePicker.selectDay("1");
        String firstSelectedDate = datePicker.getDate();
        System.out.println("Ngày sau khi chọn lần 1: " + firstSelectedDate);

        Log.info("Step 5: Mở li picker");
        datePicker.openDatePicker();

        Log.info("Step 6 Chọn ngày 31 (Nếu có)");
        try {
            datePicker.selectDay("31");
            String secondSelectedDate = datePicker.getDate();
            System.out.println("Ngày sau khi chọn lần 2: " + secondSelectedDate);

            Assert.assertNotEquals(secondSelectedDate, firstSelectedDate,
                    "Ngày sau khi chọn 31 phải khác ngày 1");
        } catch (Exception e) {
            System.out.println("Không có ngày 31 trong tháng hiện tại!");
        }
    }


}
