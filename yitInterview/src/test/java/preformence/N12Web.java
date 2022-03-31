package preformence;

import extensions.UIActions;
import extensions.Verifications;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;

@Listeners(utilities.Listeners.class)
public class N12Web extends CommonOps {

    final String linkPoliticsText = "פוליטי";
    final String linkUrl = "https://www.mako.co.il/news-politics?partner=NewsNavBar";
    final String currentDate = "31.03.22";
    final String linkWeatherText = "מזג האוויר";

    // Validation Of Category Button (פוליטי)
    @Test(priority = 1)
    public void verifyCategoryName() {
        Verifications.verifyTextInElement(categoriesNavbarPage.btn_Politi, linkPoliticsText);
    }

    @Test(priority = 2)
    public void verifyPoliticsPageSuccess() {
        UIActions.click(categoriesNavbarPage.btn_Politi);
        Verifications.verifyTextInElement(mainPoliticsPage.txt_HeaderTitle, linkPoliticsText);
    }

    @Test(priority = 3)
    public void verifyPoliticsButtonIsClickable() {
        Verifications.verifyTextEquals(UIActions.getAttributeOfElement(categoriesNavbarPage.btn_Politi), linkUrl);
    }

    @Test(priority = 4)
    public void verifyStickyNavbar() {
        UIActions.pageScroll();
        Verifications.verifyElementIsDisplayed(categoriesNavbarPage.elem_MainNavbar);
    }

    // Verifying Current Date
    @Test(priority = 5)
    public void verifyCurrentDate() {
        UIActions.navigatePageBack();
        Verifications.verifyTextEquals(getCurrentDate(headerNavbar.txt_Date), currentDate());
    }

    // Validation Of Weather Page
    @Test(priority = 6)
    public void verifyWeatherPageSuccess() {
        UIActions.goToUrl();
        UIActions.click(headerNavbar.btn_Weather);
        Verifications.verifyTextInElement(mainWeatherPage.txt_HeaderTitle, linkWeatherText);
    }

    @Test(priority = 7)
    public void verifyExistenceOfCities() throws InterruptedException {
        String[] citiesList = {"אילת", "אשדוד", "באר שבע", "חיפה", "טבריה", "ירושלים", "צפת", "תל אביב - יפו"};
        for (int i = 0; i < citiesList.length; i++) {
            if (getListOfCities(mainWeatherPage.list_Cities).get(i).equals(citiesList[i])) {
                UIActions.click(driver.findElement(By.xpath("//strong[contains(text(),'" + citiesList[i] + "')]")));
                Thread.sleep(1000);
                Verifications.verifyTextInElementSoft(mainWeatherPage.txt_CityName, citiesList[i]);
            } else {
                System.out.println("The city: " + citiesList[i] + " is NOT exists on the list");
                softAssert.fail();
            }
        }
        softAssert.assertAll("Some Cities are NOT exists on the list!!");
    }
}
