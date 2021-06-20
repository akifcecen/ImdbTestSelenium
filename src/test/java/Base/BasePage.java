package Base;

import Util.ElementInfo;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver = BaseTest.driver;
    private WebDriverWait wait = new WebDriverWait(driver, 15, 1000);
    protected Actions action = new Actions(driver);
    private Logger LOGGER = Logger.getLogger(BasePage.class);

    protected WebElement getElement(ElementInfo elementInfo) {
        return driver.findElement(elementInfo.getBy());
    }

    protected WebElement waitForElement(ElementInfo info) {
        isElementVisible(info,10);
        isElementClickable(info,10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(info.getBy()));
    }

    protected void waitForElementAndClick(ElementInfo elementInfo) {
        waitForElement(elementInfo).click();
    }
    protected void waitForElementAndClickWithAction(ElementInfo elementInfo) {
        Actions action = new Actions(driver);
        action.moveToElement(waitForElement(elementInfo)).click().build().perform();

    }

    protected void waitForElementAndSendKeys(ElementInfo elementInfo, String text) {
        waitForElement(elementInfo).sendKeys(text);
    }
    public boolean isElementClickable(ElementInfo elementInfo, int timeout){

        try{
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            waitClickableOfElementLocatedBy(elementInfo.getBy());
            return true;
        }catch (Exception e){
            // LOGGER.info(key +" görünmüyor.");
            return false;
        }
    }
    public boolean isElementVisible(ElementInfo elementInfo, int timeout){

        try{
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            waitVisibilityOfElementLocatedBy(elementInfo.getBy());
            return true;
        }catch (Exception e){
            // LOGGER.info(key +" görünmüyor.");
            return false;
        }
    }
    protected void waitSeconds(int seconds) {
        try {
            LOGGER.info(seconds + " saniye boyunca bekleniyor.");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            //  LOGGER.info(e);
        }
    }
    protected void waitVisibilityOfElementLocatedBy(By by) {
        try {
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(by));
        }catch (Exception e ){
            //this.LOGGER.error( by + "---> Element görünüm hatası. " + e.getStackTrace().toString());
        }
    }
    protected void waitClickableOfElementLocatedBy(By by) {
        try {
            wait.until(ExpectedConditions
                    .elementToBeClickable(by));
        }catch (Exception e ){
            //this.LOGGER.error( by + "---> Element tıklanamıyor hatası. " + e.getStackTrace().toString());
        }
    }
    protected boolean isElementExist(By by){
        return !driver.findElements(by).isEmpty();
    }
}
