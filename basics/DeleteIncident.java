package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncident {

	@Test
	public void createNewIncident() {


		// EndPoint -> Server / resources
		RestAssured.baseURI = "https://dev57390.service-now.com/api/now/v2/table/incident";

		// Authorization
		RestAssured.authentication = RestAssured.preemptive().basic("admin", "Tuna@123");

		// No Mandatory Field
		Response response = RestAssured
				.given()
				.log()
				.all()
				.delete("287634d2dbb2001091a65385ca96196e");

		System.out.println(response.getStatusCode());


		response.prettyPrint();






	}

}
