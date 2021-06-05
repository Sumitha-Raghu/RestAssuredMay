package servicenow;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsFile {
	@Test
	public void getIncident() {
		
		File file= new File("./data/CreateIncident.json");
		// step1: Get End point/url (F3)
		// className.methodName();//Calling a static method
		//baseURI-> variable
		RestAssured.baseURI = "https://dev105626.service-now.com/api/now/table/incident";
		// step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "lFcq6SVtBR9k");
		// step3: Request Type - post (ctrl+2 , l)(storing a local variable)
		Response response= RestAssured
				.given()
				//json body
				.contentType(ContentType.JSON)
				.body(file)
				
				.post();
		// step4: validate status code - 201
		System.out.println(response.statusCode());
		// step5: print response
		response.prettyPrint();
		

	}

	
	}



	


