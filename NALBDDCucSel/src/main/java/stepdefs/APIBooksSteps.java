package stepdefs;

import java.util.List;

import apis.BooksApis;
import apis.UserApis;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepshelper.StepInitialization;

public class APIBooksSteps {
	
	 
	BooksApis booksApis = StepInitialization.booksApis;

	
	@When("user hits the url it is successfull")
	public void user_hits_the_url_it_is_successfull() {
		booksApis.getBooks();
	}
	@Then("user is able to check the books details")
	public void user_is_able_to_check_the_books_details() {
	   System.out.println("aiwai");
	   booksApis.verifyStatusCode();
	}

	@Then("user is able to check the {string}")
	public void user_is_able_to_check_the(String string, DataTable dataTable) {
	   List<String> isbns = dataTable.asList();
	   System.out.println(isbns.get(0));
	   booksApis.checkTitleForISBN(isbns.get(0));
	}

}
