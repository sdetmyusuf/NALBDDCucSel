package stepdefs;

import apis.ArrayApis;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepshelper.StepInitialization;

public class ArrayAPIResponseSteps {

	ArrayApis arrayApis = StepInitialization.arrayApis;
	@Given("user is able to hit the request")
	public void user_is_able_to_hit_the_request() {
		arrayApis.jsonIterateArr();   
	}

	@When("user checks the response array is returned")
	public void user_checks_the_response_array_is_returned() {
	  
	}

	@Then("user is able to check the array data")
	public void user_is_able_to_check_the_array_data() {
	  
	}
	
	
}
