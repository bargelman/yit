package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderNavbar {

    @FindBy(className = "date")
    public WebElement txt_Date;

    @FindBy(xpath = "//li[@style='left: 0%;']")
    public WebElement btn_Weather;
}
