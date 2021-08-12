package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserBox extends PageObject {

    public UserBox(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "ysUserName")
    private WebElement UserName;

    public boolean checkUserName(String username) {
        return UserName.getText().equals(username);
    }
}
