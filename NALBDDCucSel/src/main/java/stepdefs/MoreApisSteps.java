package stepdefs;

import java.util.List;

import apis.MoreApis;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import stepshelper.StepInitialization;

public class MoreApisSteps {
	
	MoreApis moreApis = StepInitialization.moreApis;

	@Given("User hits the url")
	public void user_hits_the_url(DataTable table) {
		List<String> endPoints = table.asList();
		moreApis.getObjectsFromServer(endPoints.get(0));
	}
	
	@Then("user searched the object with objec id")
	public void userSearchesId (DataTable table) {
		
		List<String> ids = table.asList();
		
		moreApis.getItemWithID(ids.get(0));
	}

}

	