package browser;

import org.openqa.selenium.WebDriver;

/**
 * Created by LT102 on 1/3/2018.
 */
public class DriverSingleton {
    public WebDriver driver;
    public static DriverSingleton instance = null;

    public DriverSingleton(){
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getBrowser("chrome");
    }

    public static DriverSingleton getInstance() {
        if (instance == null) {
            instance = new DriverSingleton();
        }
        return instance;
    }

    public void deleteInstance() {
        if(instance != null)
            instance = null;
    }
}
