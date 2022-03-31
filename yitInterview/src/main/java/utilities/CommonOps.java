package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {
    String browserType = "firefox";
    protected static String url = "https://www.n12.co.il/";

    @BeforeClass
    public void startSession() {
        initBrowser(browserType);
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void closeSession() {
        driver.quit();
    }

    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else if (browserType.equalsIgnoreCase("safari"))
            driver = initSafari();
        else
            throw new RuntimeException("Invalid Browser Type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        wait = new WebDriverWait(driver, 10);
        driver.get(url);
        ManagePages.initWebPage();
    }

    // Init Web driver
    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static WebDriver initSafari() {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();
        return driver;
    }

    // Methods
    public static String currentDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        Date date = new Date();
        return dateFormat.format(date) ;
    }
    public static String getCurrentDate(WebElement element) {
        String[] date = element.getText().split(" ");
        return date[1];
    }

    public static List<String> getListOfCities(WebElement element) {
        List<String> cities = new ArrayList<>();
        for (int i = 0; i <= 7; i++) {
            cities.add(element.findElement(By.xpath("a[" + (i + 1) + "]//li//div[@class='txt']//div//strong")).getText());
        }
        return cities;
    }


}
