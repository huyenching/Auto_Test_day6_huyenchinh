package common;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    protected WebDriver driver;
    private WebElement element;
    private WebDriverWait wait ;
    private Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    //1. Command element
    //1 getXpath
    public By getXpath(String xpath) {
        return By.xpath(xpath);
    }
    //2 getDynamicXpath
    public By getDynamicXpath(String xpath, String... params) {
        return By.xpath(String.format(xpath, (Object[]) params));
    }

    //3 getElement
    public WebElement getElement(WebDriver driver, String xpath) {
        element = driver.findElement(getXpath(xpath));
        return element;
    }
    // 5 getElements
    public List<WebElement> getElements(WebDriver driver, String xpath, String... params) {
        return driver.findElements(getDynamicXpath(xpath,params));
    }
    //6 getDynamicLocator
    public String getDynamicLocator(String pattern, String... params) {
        return String.format(pattern, (Object[]) params);
    }

    //7 getDynamicElement
    public WebElement getDynamicElement(WebDriver driver, String xpath, String... params) {
        element = driver.findElement(getDynamicXpath(xpath, params));
        return element;
    }

    //8 clickToElement
    public void clickToElement(WebDriver driver, String xpath) {
        waitForElementClickable(driver, xpath);
        getElement(driver, xpath).click();
    }
    //9 clickToElement (params)
    public void clickToElement(WebDriver driver, String xpath, String... params) {
        waitForElementClickable(driver, xpath, params);
        getDynamicElement(driver, xpath, params).click();
    }

    // 10 enterTextToElement
    public void enterTextToElement(WebDriver driver, String xpath, String text) {

        waitForElementIsVisible(driver, xpath);
        getElement(driver, xpath).clear();
        getElement(driver, xpath).sendKeys(text);
    }
    // 11 enterTextToElement (params)
    public void enterTextToElement(WebDriver driver, String xpath, String text, String... params) {

        waitForElementIsVisible(driver, xpath,params);
        getDynamicElement(driver, xpath,params).clear();
        getDynamicElement(driver, xpath,params).sendKeys(text);
    }

    //12 enterTextToElementUsingActions

    public void enterTextToElementUsingActions(WebDriver driver, String xpath, String text) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath);
        getElement(driver, xpath).clear();
        actions.sendKeys(getElement(driver, xpath),text).click().perform();
    }

    // 13 enterTextToElementUsingActions (params)
    public void enterTextToElementUsingActions(WebDriver driver, String xpath, String text, String... params) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath,params);
        getDynamicElement(driver, xpath).clear();
        actions.sendKeys(getDynamicElement(driver, xpath,params),text).click().perform();
    }

    //14 clickToElementByJS

    public void clickToElementByJS(WebDriver driver, String xpath){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, xpath));
    }

    public void clickToElementByJS(WebDriver driver, String xpath, String... params) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getDynamicElement(driver, xpath,params));
    }


    //15 waitForElementIsVisible
    public void waitForElementIsVisible(WebDriver driver, String xpath) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.Short_time_out));
        wait.until(ExpectedConditions.visibilityOf(getElement(driver, xpath)));
    }

    //16 waitForElementIsVisible (params)
    public void waitForElementIsVisible(WebDriver driver, String xpath, String... params) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.Short_time_out));
        By dynamicBy = getDynamicXpath(xpath, params);
        wait.until(ExpectedConditions.visibilityOf(getDynamicElement(driver, xpath, params)));
    }

    // 17 waitForElementClickable
    public void waitForElementClickable(WebDriver driver, String xpath) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.Short_time_out));
        wait.until(ExpectedConditions.elementToBeClickable(getElement(driver, xpath)));
    }

    // 18 waitForElementClickable (params)
    public void waitForElementClickable(WebDriver driver, String xpath, String... params) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.Short_time_out));
        wait.until(ExpectedConditions.elementToBeClickable(getDynamicElement(driver, xpath, params)));
    }

    // 19 highLightElement
    public void highlightElement(WebDriver driver, String xpath){
        waitForElementIsVisible(driver, xpath);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", getElement(driver, xpath));
    }
    // 20 highLightElement (params)
    public void highlightElement(WebDriver driver, String xpath,String... params) {
        waitForElementIsVisible(driver, xpath);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", getDynamicElement(driver, xpath,params));
    }

    // 21 SleepInSecond
    public void SleepInSeconds(long seconds) {
        try {
            Thread.sleep(seconds*1000L);
        } catch (InterruptedException ignored) {

        }
    }

    // 22 hoverToElement
    public void hoverToElement(WebDriver driver, String xpath) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath);
        actions.moveToElement(getElement(driver, xpath)).click().perform();
    }
    //23 hoverToElement (params)
    public void hoverToElement(WebDriver driver, String xpath, String... params) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath,params);
        actions.moveToElement(getDynamicElement(driver, xpath,params)).click().perform();
    }

    // 24 rightClickOnElement
    public void rightClickToElement(WebDriver driver, String xpath) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath);
        actions.contextClick(getElement(driver, xpath)).click().perform();
    }
    // 25 rightClickOnElement (params)
    public void rightClickToElement(WebDriver driver, String xpath, String... params) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath,params);
        actions.contextClick(getDynamicElement(driver, xpath,params)).click().perform();
    }
    // 26 doubleClickOnElement
    public void doubleClickOnElement(WebDriver driver, String xpath) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath);
        actions.doubleClick(getElement(driver, xpath)).click().perform();
    }
    // 27 doubleClickOnElement (params)
    public void doubleClickOnElement(WebDriver driver, String xpath, String... params) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath,params);
        actions.doubleClick(getDynamicElement(driver, xpath,params)).click().perform();
    }
    // 28 dragAndDropElement
    public void dragAndDropElement(WebDriver driver, String sourcexpath, String targetxpath) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, sourcexpath);
        waitForElementIsVisible(driver, targetxpath);
        actions.dragAndDrop(getElement(driver, sourcexpath), getElement(driver, targetxpath)).perform();
    }
    // 29 pressKeyToElement
    public void pressKeyToElement(WebDriver driver, String xpath, Keys key) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath);
        actions.moveToElement(getElement(driver, xpath)).sendKeys(key).perform();
    }

    // 30 pressKeyToElement (params)
    public void pressKeyToElement(WebDriver driver, String xpath, Keys key, String... params) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath,params);
        actions.moveToElement(getDynamicElement(driver, xpath,params)).sendKeys(key).perform();
    }
    // 31 getTextElement
    public String getTextElement(WebDriver driver, String xpath) {
        waitForElementIsVisible(driver, xpath);
        return getElement(driver, xpath).getText().trim();
    }
    //32 getTextElement (params)
    public String getTextElement(WebDriver driver, String xpath, String params) {
        waitForElementIsVisible(driver, xpath);
        return getDynamicElement(driver, xpath,params).getText().trim();
    }
    // 33 getElementAttributeValue
    public String getElementAttributeValue(WebDriver driver, String xpath, String attr) {
        waitForElementIsVisible(driver, xpath);
        return getElement(driver, xpath).getAttribute(attr);
    }
    // 34 getElementAttributeValue (params)
    public String getElementAttributeValue(WebDriver driver, String xpath, String attr, String... params) {
        waitForElementIsVisible(driver, xpath,params);
        return getDynamicElement(driver, xpath,params).getAttribute(attr);
    }
    // 35 getListElementSize
    public int getListElementSize(WebDriver driver, String xpath) {
        waitForElementIsVisible(driver, xpath);
        return driver.findElements(By.xpath(xpath)).size();
    }
    // 36 getListElementSize (params)
    public int getListElementSize(WebDriver driver, String xpath, String... params) {
        waitForElementIsVisible(driver, xpath,params);
        String dynamicXpath = String.format(xpath, (Object[]) params);
        return driver.findElements(By.xpath(dynamicXpath)).size();
    }
    // 37 isDisplayElement
    public boolean isDisplayElement(WebDriver driver, String xpath) {
        try {
            return getElement(driver, xpath).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // 38 isDisplayElement (params)
    public boolean isDisplayElement(WebDriver driver, String xpath, String... params) {
        try {
            return getDynamicElement(driver, xpath, params).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // 39 isDisplayElements
    public boolean isDisplayElements(WebDriver driver, String xpath) {
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

    // 40 isDisplayElements (params)
    public boolean isDisplayElements(WebDriver driver, String xpath, String... params) {
        String dynamicXpath = String.format(xpath, (Object[]) params);
        return driver.findElements(By.xpath(dynamicXpath)).size() > 0;
    }


    // 41 getPageUrl
    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    // 42 getPageTitle
    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    // 43 getPageSourceCode
    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    // 44 getCurrentUrl
    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    // 45 backToPage
    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    //46 forwardToPage
    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    // 47 refreshPage
    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    // 48 waitForAlertPresence
    public Alert waitForAlertPresence(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    // 49  acceptAlert
    public void acceptAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    // 50 cancelAlert
    public void cancelAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    // 51 getTextAlert
    public String getTextAlert(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    // 52 enterTextToAlert
    public void enterTextToAlert(WebDriver driver, String text) {
        Alert alert = waitForAlertPresence(driver);
        alert.sendKeys(text);
        alert.accept();
    }

    // 53 switchWindowByID
    public void switchWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String id : allWindows) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    // 54 switchWindowByTitle
    public void switchWindowByTitle(WebDriver driver, String expectedTitle) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String id : allWindows) {
            driver.switchTo().window(id);
            if (driver.getTitle().equals(expectedTitle)) {
                break;
            }
        }
    }

    // 55 closeAllWindowsWithoutParent

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String id : allWindows) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    // 56 selectItemInDefaultDropdown
    public void selectItemInDefaultDropdown(WebDriver driver, String xpath, String itemText) {
        Select select = new Select(getElement(driver, xpath));
        select.selectByVisibleText(itemText);
    }

    // 57 selectItemInDefaultDropdown (params)
    public void selectItemInDefaultDropdown(WebDriver driver, String xpath, String itemText, String... params) {
        Select select = new Select(getDynamicElement(driver, xpath, params));
        select.selectByVisibleText(itemText);
    }

    // 58 getFirstSelectedTextItem
    public String getFirstSelectedTextItem(WebDriver driver, String xpath) {
        Select select = new Select(getElement(driver, xpath));
        return select.getFirstSelectedOption().getText();
    }

    // 59 getFirstSelectedTextItem (params)
    public String getFirstSelectedTextItem(WebDriver driver, String xpath, String... params) {
        Select select = new Select(getDynamicElement(driver, xpath, params));
        return select.getFirstSelectedOption().getText();
    }

    // 60 isDropdownMultiple
    public boolean isDropdownMultiple(WebDriver driver, String xpath) {
        Select select = new Select(getElement(driver, xpath));
        return select.isMultiple();
    }

    // 61 isDropdownMultiple (params)
    public boolean isDropdownMultiple(WebDriver driver, String xpath, String... params) {
        Select select = new Select(getDynamicElement(driver, xpath, params));
        return select.isMultiple();
    }

    // 62 checkToCheckboxOrRadio
    public void checkToCheckboxOrRadio(WebDriver driver, String xpath) {
        WebElement element = getElement(driver, xpath);
        if (!element.isSelected()) {
            element.click();
        }
    }

    //63 checkToCheckboxOrRadio (params)
    public void checkToCheckboxOrRadio(WebDriver driver, String xpath, String... params) {
        WebElement element = getDynamicElement(driver, xpath, params);
        if (!element.isSelected()) {
            element.click();
        }
    }

    // 64 unCheckToCheckbox
    public void unCheckToCheckbox(WebDriver driver, String xpath) {
        WebElement element = getElement(driver, xpath);
        if (element.isSelected()) {
            element.click();
        }
    }

    // 65 unCheckToCheckbox (params)
    public void setImplicitTime(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    // 66 setImplicitTime
    public void switchToFrame(WebDriver driver, String xpath) {
        driver.switchTo().frame(getElement(driver, xpath));
    }

    // 67 switchToFrame
    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // 68 switchToDefaultContent
    public void unCheckToCheckbox(WebDriver driver, String xpath, String... params) {
        WebElement element = getDynamicElement(driver, xpath, params);
        if (element.isSelected()) {
            element.click();
        }
    }

    // 69.ScrollInToView
    public void scrollIntoView(WebDriver driver, String xpath, String... params) {
        WebElement el = getDynamicElement(driver, xpath, params);
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center', inline:'center'});", el
            );
        } catch (JavascriptException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
        }
    }


}
