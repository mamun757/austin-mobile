package page_objects;

import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class Login {
    private static final Logger LOGGER = LogManager.getLogger(Login.class);
    private static final String userNameLocator = "test-Username";
    private static final String passwordLocator = "test-Password";
    private static final String LoginLocator = "test-LOGIN";
    private static final String errorText = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView";
    private static final String productHeader ="//android.view.ViewGroup[@content-desc='test-Cart drop zone']/android.view.ViewGroup/android.widget.TextView";

    private AppiumDriver driver;

    public Login(AppiumDriver driver) {

        this.driver = driver;
    }

    public Login enterUserName(String value){
     driver.findElementByAccessibilityId(userNameLocator).clear();
     driver.findElementByAccessibilityId(userNameLocator).sendKeys(value);
     LOGGER.debug("Entered user name is: " + value);
     return this;
    }

    public Login enterPassword(String value){
        driver.findElementByAccessibilityId(passwordLocator).clear();
        driver.findElementByAccessibilityId(passwordLocator).sendKeys(value);
        LOGGER.debug("Entered password is: " + value);
        return this;
    }

    public Login ClickedOnLogInButton(){
        driver.findElementByAccessibilityId(LoginLocator).click();
        LOGGER.debug("Clicked on login button");
        return this;
    }

    public Login unsuccessfulLogInErrorText(String expectedErrorText) {
        String actualErrorText = driver.findElementByXPath(errorText).getText();
        LOGGER.debug("validating unsuccessful Login error");
        Assert.assertEquals(expectedErrorText, actualErrorText);
        return this;
    }

    public Login logInIsSuccessful(String expectedText) {
        String actualText = driver.findElementByXPath(productHeader).getText();
        LOGGER.debug("validating successful Text");
        Assert.assertEquals(expectedText, actualText);
        return this;
    }

}
