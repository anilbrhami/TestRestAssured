import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SimplePostTest {
	
//	@Test
//	public void RegisterCustomerDetails(){
//		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
//		RequestSpecification request = RestAssured.given();
//		
//		JSONObject requestParameters = new JSONObject();
//		requestParameters.put("FirstName", "Tashaa");
//		requestParameters.put("LastName", "Singhia");
//		requestParameters.put("UserName", "Sample004");
//		requestParameters.put("Password", "password1");
//		requestParameters.put("Email", "aa2@t.com");
//		
//		request.header("Content-Type", "application/json");
//		request.body(requestParameters.toJSONString());
//		Response response = request.post("/register");
//		
//		int statusCode = response.getStatusCode();
//		ResponseBody body = response.getBody();
//		
//		System.out.println("Response body: "+body.asString() +"\n" +statusCode);
//		/*Assert.assertEquals(statusCode, "201");
//		
//		String successCode = response.jsonPath().get("SuccessCode");
//		Assert.assertEquals(successCode, "OPERATION_SUCCESS", "Correct Success code was returned");*/
//	}
	
//	@Test
//	public void JsonPathUsage() throws MalformedURLException {
//		RestAssured.baseURI="http://restapi.demoqa.com/utilities/books/getallbooks";
//		RequestSpecification request = RestAssured.given();
//		Response response = request.get("");
//		
//		JsonPath jsonPathEvaluator = response.jsonPath();
//		//List<String> allBooks = jsonPathEvaluator.getList("books.title");
//		List<Book> allBooks = jsonPathEvaluator.getList("books", Book.class);
//		
//		for(Book book: allBooks){
//			System.out.println("Book : " +book.title);
//		}
//		
//		
//	}
	
	@Test
	public void JsonToArrayList() throws MalformedURLException {
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/books/getallbooks";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("");
		
		System.out.println("Response body : "+response.body().asString());
		
		
		List<Book> books = response.jsonPath().getList("books", Book.class);
				

			System.out.println("Books as String " + books.toString());
		
		
		
	}
	
	

}
