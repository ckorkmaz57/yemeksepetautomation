package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="UserName")
    private WebElement UserNameTextbox;

    @FindBy(id="password")
    private WebElement Password;

    @FindBy(id="ys-fastlogin-button")
    private WebElement LoginButton;

    public void clickButton(){
        LoginButton.click();
    }
    public void setUserNameTextbox(String username){

        UserNameTextbox.sendKeys(username);
    }
    public void SetPasswordTexbox(String password){
        Password.sendKeys(password);
    }

}
