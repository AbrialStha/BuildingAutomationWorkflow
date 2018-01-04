package tests;

import browser.DriverSingleton;
import browser.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagefactory.LoginPage;

/**
 * Created by LT102 on 1/3/2018.
 */
public class AuthTest {
    //these will be repeated
    WebDriver driver;
    DriverSingleton ds;
    Util util;

    @BeforeMethod
    public void setUp() {
        ds = DriverSingleton.getInstance();
        driver = ds.driver;
        util = new Util();
    }

    @Test
    public void signInPositive() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.userLogin("sanit@fusemachines.com", "sanit123");

        //For Validation
        WebElement elementToBePresent = util.myDyanamicWait(driver, "#sidebar-trigger", "Logged In Successfully");
        Assert.assertTrue(util.isPresent(elementToBePresent));
    }

    @Test
    public void signInnegative() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.userLogin("sanit@fusemachines.com", "wrongpassword");

        //For Validation
        WebElement elementToBePresent = util.myDyanamicWait(
                driver,
                "#home > div.alert.alert-danger.alert-dismissible",
                "Logged In Failed"
        );
        Assert.assertTrue(util.isPresent(elementToBePresent));
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
        ds.deleteInstance();
    }
}
