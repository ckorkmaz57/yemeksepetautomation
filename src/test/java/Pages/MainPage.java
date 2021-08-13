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

    @FindBy(xpath ="//span[@class='ys-xl inner']/strong")
    private WebElement ErrorMessage;

    @FindBy(xpath = "//div/small[@data-cv-field='UserName']")
    private WebElement UserNameWarnMessage;

    @FindBy(xpath = "//div/small[@data-cv-field='Password']")
    private WebElement PasswordWarnMessage;

    public void clickButton(){
        LoginButton.click();
    }
    public void setUserNameTextbox(String username){

        UserNameTextbox.sendKeys(username);
    }
    public void SetPasswordTexbox(String password){
        Password.sendKeys(password);
    }

    public boolean checkErrorMessage(String errormessage){
        return ErrorMessage.getText().equals(errormessage);

    }

    public boolean checkWarnMessage(String warnmessage) {
        if(warnmessage.contains("kullanıcı")){
            return UserNameWarnMessage.getText().equals(warnmessage);
        }
        return PasswordWarnMessage.getText().equals(warnmessage);
    }
}
