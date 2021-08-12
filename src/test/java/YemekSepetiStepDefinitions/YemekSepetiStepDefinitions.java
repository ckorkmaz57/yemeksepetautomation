package YemekSepetiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class YemekSepetiStepDefinitions {

    @Given("User navigate to {string} page")
    public void user_navigate_to_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Baris");
    }

    @When("User clicks ÜYE GİRİŞİ button")
    public void user_clicks_üye_gi̇ri̇şi̇_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Ustek");
    }

    @Then("User successfully logs in")
    public void user_successfully_logs_in() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Cansu");
    }

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Ustek");
    }

}
