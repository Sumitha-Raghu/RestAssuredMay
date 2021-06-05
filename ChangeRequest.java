package servicenow;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ChangeRequest {

@Test
public void changerequest() {
	RestAssured.baseURI= "https://dev105626.service-now.com/api/now/table/change_request";
	RestAssured.authentication = RestAssured.basic("admin", "lFcq6SVtBR9k");
	Response response = RestAssured.get();
	System.out.println(response.statusCode());
	JsonPath json = response.jsonPath();
	List<String> sysid = json.getList("result.sys_id");
	List<String> description = json.getList("result.description");
	System.out.println(sysid.size());
	for (String temp1 : description) {
		System.out.println(temp1);
	}
	for (String temp2 : sysid) {
		System.out.println(temp2);
	}

}


	}


