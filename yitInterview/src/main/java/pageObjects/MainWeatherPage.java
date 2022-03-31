package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainWeatherPage {

    @FindBy(tagName = "h1")
    public WebElement txt_HeaderTitle;

    @FindBy(xpath = "//div[@class='forcastMapWrap weatherSearch']//ul")
    public WebElement list_Cities;

    @FindBy(xpath = "//button[@style='width: 225px;']//span[2]")
    public WebElement txt_CityName;
}
