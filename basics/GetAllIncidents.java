package basics;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidents {
	
	@Test
	public void getIncidents() {
		
		// EndPoint -> Server / resources
		RestAssured.baseURI = "https://dev57390.service-now.com/api/now/v2/table/incident";
		
		// Authorization
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// Send the request
		Response response = RestAssured.get();
		
		// print the response to see
		// response.prettyPrint();
		
		// Confirm the response status code
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		
		// Convert the response to Json
		JsonPath jsonResponse = response.jsonPath();
		
		// Get all numbers that you need
		List<String> allIncidentNumbers = jsonResponse.getList("result.number");
		
		
		// Print the count of how many incidents
		System.out.println(allIncidentNumbers.size());		
		
	}

}
