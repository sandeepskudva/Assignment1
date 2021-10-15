package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import commonFunctions.Logic;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.usersPOJO;

public class testcases {
	Logic L = new Logic();
	
	@Test
	public void getUserid()
	{
		baseURI = "https://jsonplaceholder.typicode.com";
		
		String username = "Samantha";	
		int userid=0;
		
		Response response = given().contentType(ContentType.JSON).when().get("/users");
		
		List<usersPOJO> pojo=Arrays.asList(response.getBody().as(usersPOJO[].class));
		
				
		for(int i=0;i<pojo.size();i++)
		{
			if(pojo.get(i).getUsername().equals(username))
				userid=pojo.get(i).getId();	
		}
			
		assertEquals(response.getStatusCode(),200);
		
		System.out.println("Userid for "+username+" is "+userid);
		
	}	

}
