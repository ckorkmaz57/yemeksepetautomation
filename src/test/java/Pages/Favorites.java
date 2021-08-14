package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Favorites extends PageObject{
    public Favorites(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[@class='favorites panel-body']")
    private WebElement FavoritesList;

    @FindBy(xpath = "//div[@class='actions']")
    private WebElement ActionButton;

    @FindBy(xpath = "//div[@id='favorites']/div/p")
    private WebElement EmptyFavoritesText;

    public void clickCheckBoxFavorites(){
        List<WebElement> favoritesList=FavoritesList.findElements(By.xpath("//input[@type='checkbox']"));
        favoritesList.get(0).click();
    }

    public void clickButtonInFavoritesMenu(String buttonname){
        ActionButton.findElement(By.xpath("//button[text()='"+buttonname+"']")).click();
    }

    public boolean checkEmptyFavoritesTest(String favoritestext){
       return EmptyFavoritesText.getText().equals(favoritestext);
    }
}
