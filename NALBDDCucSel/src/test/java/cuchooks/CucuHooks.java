package cuchooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucuHooks {

	@Before
	public void setUp(Scenario scenario) {

		System.out.println(">>>>>> Execution of the scenario - "+scenario.getName()+" has been started ");
		System.out.println(">>>>>> Set up before hook");

	}

	@After
	public void tearDown(Scenario scenario) {

		System.out.println(">>>>>> Execution of the scenario - "+scenario.getName()+" has been completed ");
		System.out.println(">>>>>> close all the resources after hook");

	}
}
