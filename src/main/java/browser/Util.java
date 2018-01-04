package browser;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by LT102 on 1/3/2018.
 */
public class Util {
    /**
     * A method to check if the web element is in the page or not
     * works well if the element is auto added from js while certain event is triggered
     * unlike for bootstrap modal where modal is always present but out of display
     *
     * @param ele element to be check
     * @return boolean
     */
    public boolean isPresent(WebElement ele) {
        try {
            if (ele != null)
                ele.isDisplayed();
            else{
                System.out.println("element null");
                return false;
            }

        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public WebElement myDyanamicWait(WebDriver driver, String cssLocate, String message) {
        WebElement myDynamicElement = null;
        try {
            myDynamicElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssLocate)));
            System.out.println(message);
        } catch (Exception e) {
            System.out.println(e);
        }
        return myDynamicElement;
    }
}
