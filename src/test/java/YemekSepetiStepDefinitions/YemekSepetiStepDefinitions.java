package YemekSepetiStepDefinitions;

import Pages.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class YemekSepetiStepDefinitions {

    protected WebDriver driver;
    String browserName ;
    MainPage mainPage;
    UserBox userBox;
    SearchResults searchResults;
    RestaurantDetails restaurantDetails;
    Favorites favorites;

    @Before
    public void beforeTest() {

        if (System.getProperty("browsername") == null){
            browserName = "chrome";
        }else
        browserName=System.getProperty("browsername").toLowerCase(Locale.ROOT);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized")
                .addArguments("--disable-notifications");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
            driver = new ChromeDriver(chromeOptions);
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "webdriver/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else {
            System.exit(0);
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        mainPage = new MainPage(driver);
        restaurantDetails = new RestaurantDetails(driver);
        userBox = new UserBox(driver);
        searchResults = new SearchResults(driver);
        favorites = new Favorites(driver);

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
    public void userEntersUsernameAndPassword(String username, String password) {

        mainPage.setUserNameTextbox(username.equals("spacecharacter") ? " " : username);
        mainPage.setPasswordTexbox(password);

    }

    @And("User clicks {string} button")
    public void userClicksButton(String label) {
        mainPage.clickButton();

    }

    @Then("{string} successfully logs in")
    public void userSuccessfullyLogsIn(String username) {

        Assert.assertTrue(userBox.checkUserName(username));
        mainPage.clickPopupCloseButton();

    }

    @Then("^Popup (.*) message is displayed$")
    public void popupMessageIsDisplayed(String errormessage) {
        Assert.assertTrue(mainPage.checkErrorMessage(errormessage));
    }

    @Then("^TextBox (.*) message is displayed$")
    public void textboxMessageIsDisplayed(String warnmessage) {
        Assert.assertTrue(mainPage.checkWarnMessage(warnmessage));
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {

        //validate if scenario has failed
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }

    }

    @When("User searches {string} in search textbox")
    public void userSearchesInSearchTextbox(String searchtext) {
        mainPage.setSearchBox(searchtext);
        mainPage.clickSearchButton();

    }

    @When("User select district")
    public void userSelectDistrict() {
        mainPage.selectDistrict();
    }

    @And("User clicks on listed restaurant")
    public void userClicksOnListedRestaurant() {

        searchResults.selectRestaurant();
    }

    @And("User clicks Favorilere Ekle")
    public void userClicksFavorilereEkle() {

        restaurantDetails.clickAddFavoritesButton();
    }

    @Then("{string} displayed")
    public void favorilerdenCikarDisplayed(String isfavoritecheck) throws InterruptedException{
        restaurantDetails.checkRemoveButtonFavorites(isfavoritecheck);
        Thread.sleep(5000);
    }


    @When("User clicks on {string} menu")
    public void userClicksOnMenu(String menuname) {
        userBox.clickUserBoxMenu();
        userBox.selectMenu(menuname);
    }

    @And("User checks on favorite restaurant")
    public void userChecksOnFavoriteRestaurant() {


        favorites.clickCheckBoxFavorites();
    }


    @And("User clicks {string} button in favorites menu")
    public void userClicksButtonInFavoritesMenu(String buttonname) {
        favorites.clickButtonInFavoritesMenu(buttonname);
    }

    @Then("{string} text should be displayed")
    public void textShouldBeDisplayed(String emptyfavoritestext) {
        Assert.assertTrue(favorites.checkEmptyFavoritesTest(emptyfavoritestext));
    }

    @And("User clicks {string} in banabi notification")
    public void userClicksInBanabiNotification(String buttonName) {
        restaurantDetails.closeBanabiNotification(buttonName);
    }
}
