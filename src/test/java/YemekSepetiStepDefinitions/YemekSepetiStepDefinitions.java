package YemekSepetiStepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class YemekSepetiStepDefinitions {

    protected WebDriver driver;
    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized")
                .addArguments("--disable-notifications");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @After
    public void afterTest() {

        driver.close();
        driver.quit();
    }

    @Given("User navigate to {string} page")
    public void userNavigateToPage(String endpoint) {

        driver.get(endpoint);

    }

    @When("^User enters (.*) and (.*)$")
    public void userEntersUsernameAndPassword() {

    }

    @And("User clicks {string} button")
    public void userClicksButton(String label) {

    }

    @Then("User successfully logs in")
    public void userSuccessfullyLogsIn() {

    }

    @Then("Error message is displayed")
    public void errorMessageIsDisplayed() {

    }

    @Then("^(.*) message is displayed$")
    public void warnMessageIsDisplayed() {

    }
}
