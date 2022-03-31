package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.MainPoliticsPage;

public class ManagePages extends Base {

    public static void initWebPage(){
        categoriesNavbarPage = PageFactory.initElements(driver, pageObjects.CategoriesNavbarPage.class);
        mainPoliticsPage = PageFactory.initElements(driver, MainPoliticsPage.class);
        headerNavbar = PageFactory.initElements(driver, pageObjects.HeaderNavbar.class);
        mainWeatherPage = PageFactory.initElements(driver, pageObjects.MainWeatherPage.class);

    }
}
