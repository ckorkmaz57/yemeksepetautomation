package YemekSepetiStepDefinitions;

import Pages.MainPage;
import Pages.UserBox;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class YemekSepetiStepDefinitions {

    protected WebDriver driver;
    MainPage mainPage ;
    UserBox userBox;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized")
                .addArguments("--disable-notifications");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        mainPage = new MainPage(driver);

    }

    @After
    public void afterTest() {

        //driver.close();
        //driver.quit();
    }

    @Given("User navigate to {string} page")
    public void userNavigateToPage(String endpoint) {

        driver.get(endpoint);

    }

    @When("^User enters (.*) and (.*)$")
    public void userEntersUsernameAndPassword(String username,String password) {

        mainPage.setUserNameTextbox(username);
        mainPage.SetPasswordTexbox(password);


    }

    @And("User clicks {string} button")
    public void userClicksButton(String label) {
        mainPage.clickButton();

    }

    @Then("{string} successfully logs in")
    public void userSuccessfullyLogsIn(String username) {
        userBox = new UserBox(driver);
        Assert.assertTrue(userBox.checkUserName(username));

    }

    @Then("Error message is displayed")
    public void errorMessageIsDisplayed() {

    }

    @Then("^(.*) message is displayed$")
    public void warnMessageIsDisplayed() {

    }
}
