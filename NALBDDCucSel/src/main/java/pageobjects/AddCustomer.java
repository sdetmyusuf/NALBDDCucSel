package pageobjects;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomer {
	
	@Test(dataProvider = "getData")
	public void customerAdder(String fname, String lname, String postcode) {
		
	}
	
//	@DataProvider
//	public void [][] getData() {
//		
//	}
}
