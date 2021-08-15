package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    @FindBy(xpath = "//div[@class='modal-header']/button[@aria-label='Kapat']")
    private WebElement PopupCloseButton;

    @FindBy(xpath = "//div/input[contains(@class, 'search-box')]")
    private WebElement SearchBox;

    @FindBy(xpath = "//div[contains(@class, 'search-button')]/button[@aria-label='ARA']")
    private WebElement SearchButton;

    @FindBy(id="select2-ys-areaSelector-container")
    private WebElement DistrictCombobox;

    @FindBy(xpath = "//li[@aria-label='Kayıtlı Adreslerim']")
    private WebElement SelectDropdown;



    public void clickButton(){
        LoginButton.click();
    }
    public void setUserNameTextbox(String username){

        UserNameTextbox.sendKeys(username);
    }
    public void setPasswordTexbox(String password){
        Password.sendKeys(password);
    }

    public boolean checkErrorMessage(String errormessage){
        return ErrorMessage.getText().equals(errormessage);

    }

    public boolean checkWarnMessage(String warnmessage) {
        if(warnmessage.contains("e-posta")){
            return UserNameWarnMessage.getText().equals(warnmessage);
        }
        return PasswordWarnMessage.getText().equals(warnmessage);
    }

    public void clickPopupCloseButton(){
        PopupCloseButton.click();

    }
    public void setSearchBox(String searchtext) {
        SearchBox.sendKeys(searchtext);
    }

    public void clickSearchButton() {
        SearchButton.click();
    }

    public void selectDistrict() {

        DistrictCombobox.click();
        List<WebElement> options = SelectDropdown.findElements(By.xpath("//ul[@class='select2-results__options select2-results__options--nested']"));
        options.get(0).click();
    }


}
