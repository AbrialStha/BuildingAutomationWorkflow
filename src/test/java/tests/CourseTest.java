package tests;

import browser.DriverSingleton;
import browser.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        //For Validation
        WebElement elementToBePresent = util.myDyanamicWait(driver, "#sidebar-trigger", "Logged In Successfully");
        Assert.assertTrue(util.isPresent(elementToBePresent));
    }

    @Test
    public void searchCourse() {
        CoursePage coursePage = new CoursePage(driver);
        coursePage.goTo();
        coursePage.searchCourse("Intro to AI");
        //For Validation
        WebElement elementToBePresent = util.myDyanamicWait(driver, ".course-block", "Course Found");
        Assert.assertTrue(util.isPresent(elementToBePresent));
    }
}
