package tests;

import browser.DriverSingleton;
import browser.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        WebElement myDynamicElement;
        try {
            myDynamicElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("sidebar-trigger")));
            System.out.println("Logged In successfully");
            Assert.assertTrue(util.isPresent(myDynamicElement), "sidebar is visible only after successful login into the platform");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void signInnegative() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.userLogin("sanit@fusemachines.com", "wrongpassword");
        WebElement myDynamicElement;
        try {
            myDynamicElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#home > div.alert.alert-danger.alert-dismissible")));
            System.out.println("Logged In Failed");
            Assert.assertTrue(util.isPresent(myDynamicElement), myDynamicElement.getText());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @AfterMethod
    public void TearDown() {
//        driver.quit();
//        ds.deleteInstance();
    }
}
