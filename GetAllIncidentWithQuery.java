package servicenow;


	import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.response.Response;

	public class GetAllIncidentWithQuery {
		
		@Test

		public void getIncident() {
			
			Map<String, String> allParam= new HashMap<String, String>();
			//adding value in map
			//allParam is an object
			allParam.put("category", "software");
			allParam.put("sysparm_fields","number,sys_id,category");
			// step1: Get End point/url (F3)
			// className.methodName();//Calling a static method
			//baseURI-> variable
			RestAssured.baseURI = "https://dev105626.service-now.com/api/now/table/incident";
			// step2: Authentication (basic)
			RestAssured.authentication = RestAssured.basic("admin", "lFcq6SVtBR9k");
			// step3: Request Type - get (ctrl+2 , l)(storing a local variable)+ Query Param
			Response response= RestAssured
						.given()
						.queryParams(allParam)
						 .get();
							
								
			
			// step4: validate status code - 200
			System.out.println(response.statusCode());
			// step5: print response
			response.prettyPrint();
			

		}


	}


