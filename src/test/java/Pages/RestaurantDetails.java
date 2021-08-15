package Pages;

import com.aventstack.extentreports.templating.FreemarkerTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestaurantDetails extends PageObject{
    public RestaurantDetails(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//b[text()='Favorilere Ekle']")
    private WebElement AddButtonFavorites;

    @FindBy(xpath ="//b[text()='Favorilerden Çıkar']")
    private WebElement RemoveButtonFavorites;

    @FindBy(xpath = "//div[@class='banabi-delivery-info available']/div[@class='banabi-delivery-info-buttons']")
    private WebElement banaBiNotificationButtons;

    public void clickAddFavoritesButton(){
        AddButtonFavorites.click();

    }

    public boolean checkRemoveButtonFavorites(String removebuttonfavorites)
    {
        return RemoveButtonFavorites.getText().equals(removebuttonfavorites);
    }

    public void closeBanabiNotification(String buttonName){
        banaBiNotificationButtons.findElement(By.xpath("//a[text()='"+buttonName+"']")).click();
    }
}
