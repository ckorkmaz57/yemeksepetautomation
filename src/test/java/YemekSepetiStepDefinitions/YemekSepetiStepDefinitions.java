package YemekSepetiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class YemekSepetiStepDefinitions {

    @Given("User navigate to {string} page")
    public void userNavigateToPage(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
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
