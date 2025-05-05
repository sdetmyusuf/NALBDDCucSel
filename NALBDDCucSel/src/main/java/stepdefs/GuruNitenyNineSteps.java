package stepdefs;

import basepackage.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.GuruNitetyNinePageObjects;
import stepshelper.StepInitialization;

public class GuruNitenyNineSteps {
	
	GuruNitetyNinePageObjects guruNitetyNinePageObjects = StepInitialization.guruNitetyNinePageObjects;
	BaseTest base = StepInitialization.base;
	
	@Given("user enters the email and starts the quiz")
	public void user_enters_the_email_and_starts_the_quiz() {
		guruNitetyNinePageObjects.startQuiz("mohdmyyusuf@gmail.com");
	}

	@When("user attempts the questions and submits.")
	public void user_attempts_the_questions_and_submits() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("quiz is submitted successfully")
	public void quiz_is_submitted_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
