package servicenow;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsFileUsingDP {
	@DataProvider(name = "FetchData")
	public String[][] getData() {
		//[no of files][each file path]
		String[][] data = new String[2][1];
		data[0][0]= "./data/CreateIncident.json";
		data[1][0]= "./data/CreateIncident2.json";
		return data;
				
				
		
		
	}

	@Test(dataProvider ="FetchData" )
	public void getIncident(String path) {//> ./data/CreateIncident1.json

	
		RestAssured.baseURI = "https://dev105626.service-now.com/api/now/table/incident";
		// step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "lFcq6SVtBR9k");
		// step3: Reqtuest Type - post (ctrl+2 , l)
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				//				 .body(file)
				.body(new File(path))
				.post();
		// step4: validate status code - 201
		System.out.println(response.statusCode());
		// step5: print response
		response.prettyPrint();


	}

	}


