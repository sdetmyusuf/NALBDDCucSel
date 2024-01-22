package stepdefs;

import apis.UserApis;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepshelper.StepInitialization;

public class APITestStepDefs {
	
	UserApis userApis = StepInitialization.userApis;
	@Given("when user hits the api request")
	public void when_user_hits_the_api_request() {
		userApis.getUsers();
	}

	@When("user create a user and checks the id")
	public void user_create_user_checks_id() {
		userApis.createUsers();
	}
	
	@Then("user update the user and checks details")
	public void user_update_user_checks_id() {
		userApis.updateUser();
	}	
	
	@Then("user list the details of the updated user")
	public void print_updated_user_details() {
		userApis.getSingleUser();
	}
}
