package apis;

import java.util.List;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BooksApis {
	

	public int statsCode;
	public String responceAsString;

	public void getBooks () {
		//Set the base uri using RA
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		//Now set the request specifications
		RequestSpecification httpRequest = RestAssured.given(); 
		
		Response response = httpRequest.request(Method.GET, "");
		
		System.out.println("Status received => " + response.getStatusLine()); 
		System.out.println("Response=>" + response.prettyPrint());
		
		statsCode = response.getStatusCode();
		responceAsString = response.getBody().asString();
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		List<String> titles = jsonPathEvaluator.get("books");
		System.out.println("===========>>> "+titles);

	}
	
	public void verifyStatusCode () {
		
		Assert.assertEquals(statsCode, 200, "The status code is not matching");
	}
	
	public void checkTitleForISBN (String isbn) {
		
		Assert.assertEquals(responceAsString.toLowerCase().contains(isbn), true);
		
		
	}
	
}
