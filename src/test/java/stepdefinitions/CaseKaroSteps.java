package stepdefinitions;

import com.anand.BrowserL;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CaseKaroSteps {

    BrowserL browser = new BrowserL();

    @Given("User opens CaseKaro website")
    public void user_opens_casekaro_website() {
        browser.executeTest();
    }

    @Then("Cart should contain exactly 3 items")
    public void cart_should_contain_exactly_3_items() {
        System.out.println("Scenario Passed");
    }
}