package apis;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MoreApis {
	
	String responceAsString;
	String baseUri = "https://api.restful-api.dev/";
	
	public void getObjectsFromServer (String endpoints) {
		
		//List<String> endpoints = table.asList();
		
		String finalUri = baseUri +  endpoints;
		
		try {
		RestAssured.baseURI = finalUri;
		RequestSpecification httpRequest = RestAssured.given();
		
		Response resp = httpRequest.request(Method.GET, "");
		
		System.out.println(resp.getStatusCode());
	//	System.out.println(resp.prettyPrint());
		
		responceAsString = resp.getBody().asString();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode rootNode = objectMapper.readTree(responceAsString);
		
		for (JsonNode node : rootNode) {
            System.out.println("ID: " + node.get("id").asText());
            System.out.println("Name: " + node.get("name").asText());
            
            JsonNode dataNode = node.get("data");
            if (dataNode != null && !dataNode.isNull()) {
             //   System.out.println("Color: " + dataNode.get("color").asText());
            //  System.out.println("Capacity: " + dataNode.get("capacity") != null ? dataNode.get("capacity").asText() : dataNode.get("capacity").asText());
            } else {
                System.out.println("Data: Not available");
            }
            System.out.println("-------------------");
        }
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public String getItemWithID (String ids) {
		
		RestAssured.baseURI =baseUri + "objects?id="+ids;
		
		RequestSpecification httpres = RestAssured.given();
		
		Response resp = httpres.request(Method.GET, ids);
		
		String respAsString = resp.getBody().asString();
		System.out.println("Retruned object with "+ids+" = "+respAsString);
		
		return respAsString;
	}

}
