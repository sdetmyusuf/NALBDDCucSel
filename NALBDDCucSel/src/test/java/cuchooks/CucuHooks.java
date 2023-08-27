package cuchooks;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucuHooks {
	TestContext context;
	
	public CucuHooks(TestContext context) {
		this.context = context;
	}

	@Before
	public void setUp(Scenario scenario) {
		context.scenarioName = scenario.getName();
		System.out.println(">>>>>> Execution of the scenario - " + scenario.getName() + " has been started ");
		System.out.println(">>>>>> Set up before hook");
		System.out.println(scenario.getName() + " is executed and it is - " + scenario.getStatus());
	}

	@After
	public void tearDown(Scenario scenario) {

		System.out.println(">>>>>> Execution of the scenario - " + scenario.getName() + " has been completed ");
		System.out.println(">>>>>> close all the resources after hook");

	}
}
