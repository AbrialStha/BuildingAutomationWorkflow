package browser;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

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
            ele.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
