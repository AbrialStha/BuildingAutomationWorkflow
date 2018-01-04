package tests;

import browser.DriverSingleton;
import browser.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagefactory.CoursePage;
import pagefactory.LoginPage;

/**
 * Created by LT102 on 1/4/2018.
 */
public class CourseTest {
    //these will be repeated for now
    private WebDriver driver;
    private DriverSingleton ds = DriverSingleton.getInstance();
    private Util util;

    @BeforeTest
    public void setUp() {
        driver = ds.driver;
        util = new Util();
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
        }2
    }

    @Test
    public void searchCourse() {
        CoursePage coursePage = new CoursePage(driver);
        coursePage.goTo();
        coursePage.searchCourse("Intro to AI");

        WebElement myDynamicElement;
        try {
            myDynamicElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".course-block")));
            System.out.println("Course Found");
            Assert.assertTrue(util.isPresent(myDynamicElement), myDynamicElement.getText());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
