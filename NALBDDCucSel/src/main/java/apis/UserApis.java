package apis;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class UserApis {

	int id;

	public void getUsers() {

		given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("page", equalTo(2)).log()
				.all();

	}

	public void createUsers() {

		HashMap data = new HashMap();
		data.put("name", "yusuf");
		data.put("job", "engg");

		 id = given().contentType("application/json").body(data).when().post("https://reqres.in/api/users")
				.jsonPath().getInt("id");
		
		System.out.println("Created user id===>"+id);

	}

	public void updateUser() {

		HashMap data = new HashMap();
		data.put("name", "khan");
		data.put("job", "engineer");

		given().contentType("application/json").body(data).when().put("https://reqres.in/api/users/" + id).then()
				.statusCode(200).log().all();
		
		System.out.println("Updated user id===>"+id);
	}
	
	
	public void getSingleUser() {
		
		System.out.println("id id ======>"+id);

		given().when().get("https://reqres.in/api/users/2").then().statusCode(200).body("id", equalTo(2)).log()
		.all();
	}
}
