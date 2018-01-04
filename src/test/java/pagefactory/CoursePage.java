package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by LT102 on 1/4/2018.
 */
public class CoursePage {
    //These will be repeated for now
    private String baseUrl = "https://academy.fusemachines.com";
    private WebDriver driver;

    //Constructor
    public CoursePage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".search-course>div.input-group>input")
    private WebElement searchBox;

    /**
     * To navigate to login page
     */
    public void goTo() {
        driver.navigate().to(baseUrl + "/courses");
    }

    public void searchCourse(String course){
        searchBox.sendKeys(course);
    }

}
