package extensions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.CommonOps;

public class Verifications extends CommonOps {

    public static void verifyTextEquals(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    public static void verifyTextInElement(WebElement element, String expected) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(element.getText(), expected);
    }

    public static void verifyElementIsDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed());
    }

    public static void verifyTextInElementSoft(WebElement element, String expected) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(element.getText(), expected);
    }
}
