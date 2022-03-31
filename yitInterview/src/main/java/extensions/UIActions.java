package extensions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

public class UIActions extends CommonOps {

    public static void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static String getAttributeOfElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        String attribute = element.getAttribute("href");
        return attribute;
    }

    public static void pageScroll() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 2000)");
    }

    public static void navigatePageBack() {
        driver.navigate().back();
    }

    public static void goToUrl() {
        driver.navigate().to(url);
    }
}
