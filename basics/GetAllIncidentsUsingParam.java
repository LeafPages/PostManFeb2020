package basics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidentsUsingParam {
	
	@Test
	public void getIncidents() {
		
		// EndPoint -> Server / resources
		RestAssured.baseURI = "https://dev57390.service-now.com/api/now/v2/table/incident";
		
		// Authorization
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// Create Parameter Request Map
		Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put("sysparm_fields", "number");
		parametersMap.put("priority", "1");
		
		
		// Send the request
		Response response = RestAssured
				.given()
				.params(parametersMap)
				.get();
		
		// print the response to see
		response.prettyPrint();
		
		// Confirm the response status code
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		
		
		
		
		
	}

}
