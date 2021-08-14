package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserBox extends PageObject {

    public UserBox(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "ysUserName")
    private WebElement UserName;

    @FindBy(xpath = "//div[@class='ys-userComp']")
    private WebElement UserBoxMenu;

    @FindBy (xpath = "//div[@class='ys-userSettings']")
    private WebElement SelectUserBoxMenu;

    public boolean checkUserName(String username) {
        return UserName.getText().equals(username);
    }

    public void clickUserBoxMenu(){
        UserBoxMenu.click();
    }

    //Adı Favorilerim olana tıkla

     public void selectMenu(String menuname) {
         SelectUserBoxMenu.findElement(By.xpath("//a[text()='"+menuname+"']")).click();

     }

}
