package basics;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithFile {

	@Test
	public void createNewIncident() {

		// Get the File
		File jsonFile  = new File("./data1.json");

		// EndPoint -> Server / resources
		RestAssured.baseURI = "https://dev57390.service-now.com/api/now/v2/table/incident";

		// Authorization
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");

		// No Mandatory Field
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(jsonFile)
				.post();

		System.out.println(response.getStatusCode());


		response.prettyPrint();






	}

}
