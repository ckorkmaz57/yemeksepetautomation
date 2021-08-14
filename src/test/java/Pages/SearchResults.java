package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResults extends PageObject{
    public SearchResults(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='ys-result']")
    private WebElement RestaurantList;

    public void selectRestaurant() {
        List<WebElement> list=RestaurantList.findElements(By.xpath("//div[@class='restaurant-display-name']"));
        list.get(0).click();
    }
}
