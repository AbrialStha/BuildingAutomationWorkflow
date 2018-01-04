package browser;

import main.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by LT102 on 1/3/2018.
 */
public class BrowserFactory {
    /**
     * Factory method for getting the browser
     *
     * @param browserName String
     * @return browser WebDriver
     */
    public WebDriver getBrowser(String browserName) {
        WebDriver browser = null;
        switch (browserName.toLowerCase()) {
            case "firefox":
                browser = new FirefoxDriver();
                System.out.println("this is Firefox Browser");
                break;
            case "chrome":
                System.out.println("Initialize the chrome Browser");
                System.setProperty(ConfigUtils.getProperty("chromeDriver"), ConfigUtils.getProperty("driverPathChrome"));
                browser = new ChromeDriver();
                break;
            case "phantomjs":
                System.out.println("Initialize the phantom Browser");
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setJavascriptEnabled(true);
                caps.setCapability("takesScreenshot", true);
                caps.setCapability(
                        PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                        ConfigUtils.getProperty(("driverPathPhantom"))
                );
                browser = new PhantomJSDriver(caps);
                break;
            default:
                System.out.println("no web driver is initialized");
                break;
        }
        return browser;
    }
}
