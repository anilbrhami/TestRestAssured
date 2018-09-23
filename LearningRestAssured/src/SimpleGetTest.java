import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class SimpleGetTest {
	
	@Test
	public void GetWeatherDetails(){
//		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
//		RequestSpecification httpRequest = RestAssured.given();
//		Response response = httpRequest.request(Method.GET, "/Hyderabad");
//		String responseBody = response.getBody().asString();
//		String responseCode = response.getStatusLine().toString();
//		System.out.println("Response Body is =>  " + responseBody);
//		System.out.println("Response Code is =>  " + responseCode);
	
	//Condensed method
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		//System.out.println("Response Body is =>  " + response.asString());
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode,200, "Correct Status Code received");
		
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "application/json","It matches the expected content Type");
		System.out.println("Content type:  "+contentType);
	
	    String headers1 = response.getContentType();
	    System.out.println("Content type:  "+headers1);
	    
	    Map<String, String> allCookies = response.getCookies();
	    System.out.println("Cookies are: " +allCookies);
	    
	    ResponseBody body = response.getBody();
    	System.out.println("response body is: "+body.asString());
	    
	    Headers allHeaders = response.headers();
	    for (Header header: allHeaders){
	    	System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
	    	   }
	    
	}
	

}
