package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by LT102 on 1/3/2018.
 */
public class LoginPage {
    //These will be repeated for now
    private String baseUrl = "https://academy.fusemachines.com";
    private WebDriver driver;

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "#home > form > button")
    private WebElement loginBtn;

    /**
     * To navigate to login page
     */
    public void goTo() {
        driver.navigate().to(baseUrl + "/login");
    }

    /**
     * To Login
     *
     * @param userName : username
     * @param passWord : password
     */
    public void userLogin(String userName, String passWord) {
        username.sendKeys(userName);
        password.sendKeys(passWord);
        loginBtn.click();

    }
}
