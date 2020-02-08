package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBody {

	@Test
	public void createNewIncident() {


		// EndPoint -> Server / resources
		RestAssured.baseURI = "https://dev57390.service-now.com/api/now/v2/table/incident";

		// Authorization
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");

		// No Mandatory Field
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{ \"short_description\" : \"From RA\" }")
				.post();

		System.out.println(response.getStatusCode());


		response.prettyPrint();






	}

}
