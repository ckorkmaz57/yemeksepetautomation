package Pages;

import com.aventstack.extentreports.templating.FreemarkerTemplate;
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

    public void clickAddFavoritesButton(){
        AddButtonFavorites.click();

    }

    public boolean checkRemoveButtonFavorites(String removebuttonfavorites)
    {
        return RemoveButtonFavorites.getText().equals(removebuttonfavorites);
    }
}
