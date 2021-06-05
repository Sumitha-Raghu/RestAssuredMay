package servicenow;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ChangeRequestwithXML {

	@Test
	public void changerequest() {
		RestAssured.baseURI= "https://dev105626.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "lFcq6SVtBR9k");
		Response response = RestAssured
				.given()
				.accept(ContentType.XML)
				.get();
		System.out.println(response.statusCode());
		
		XmlPath xml = response.xmlPath();
		List<String> cr = xml.getList("result.number");
		
		System.out.println(cr.size());
		for (String temp1 : cr) {
			System.out.println(temp1);
		}
	
		}

	}


	


	

