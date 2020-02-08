package basics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllIncidentsXml {
	
	@Test
	public void getIncidents() {
		
		// EndPoint -> Server / resources
		RestAssured.baseURI = "https://dev57390.service-now.com/api/now/v2/table/incident";
		
		// Authorization
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// Create Paramter Request Map
		Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put("sysparm_fields", "number,sys_id");
		parametersMap.put("priority", "1");
/*		parametersMap.put("priority", "2");
*/		
		// Send the request
		Response response = RestAssured
				.given()
				.accept(ContentType.XML)
				.params(parametersMap)
				.get();
		
		// print the response to see
		response.prettyPrint();
		
		// Confirm the response status code
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		
		// Convert to XML
		XmlPath responseXml = response.xmlPath();
		
		// Find the count
		List<String> allIncidents = responseXml.getList("response.result.number");
		System.out.println(allIncidents.size());
		
		// Print all incident number
		for (String eachIncident : allIncidents) {
			System.out.println(eachIncident);
		}
		
		
	}

}








