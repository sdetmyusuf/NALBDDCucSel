
package apis;

import io.restassured.authentication.PreemptiveBasicAuthScheme;

public class ApiObject {
	

	PreemptiveBasicAuthScheme authScheme;
	
	public ApiObject () {
		
		authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("yusuf");
		authScheme.setPassword("Test@123");
		
	}
	
	

}


