package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pageObjects.MainPoliticsPage;

public class Base {
    // General
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor js;
    protected static SoftAssert softAssert;

    // Page Objects
    protected static pageObjects.CategoriesNavbarPage categoriesNavbarPage;
    protected static MainPoliticsPage mainPoliticsPage;
    protected static pageObjects.HeaderNavbar headerNavbar;
    protected static pageObjects.MainWeatherPage mainWeatherPage;
}
