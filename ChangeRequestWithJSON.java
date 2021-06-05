package servicenow;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ChangeRequestWithJSON {

	@Test
	public void changerequestwithjson() {
		

	
	RestAssured.baseURI= "https://dev105626.service-now.com/api/now/table/change_request";
	RestAssured.authentication = RestAssured.basic("admin", "lFcq6SVtBR9k");
	Response response = RestAssured
			.given()
			.accept(ContentType.JSON)
			.get();
	System.out.println(response.statusCode());
	
	JsonPath jsonpath=  response.jsonPath();
	List<String> sysid= jsonpath.getList("result.sys_id");
	System.out.println(sysid.size());
	for (String sys : sysid) {
		System.out.println(sys);
		
	}
	
}
}
