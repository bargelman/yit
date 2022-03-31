package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesNavbarPage {

    @FindBy(tagName = "nav")
    public WebElement elem_MainNavbar;

    @FindBy(xpath = "//nav[@class='menu responsive v-2020']//li[1]//ul[1]//li[2]//a[1]")
    public WebElement btn_Politi;
}
