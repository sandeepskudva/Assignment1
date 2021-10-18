package tests;


import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import commonFunctions.Logic;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.postsPOJO;




public class testcases {
	Logic L = new Logic();

	// Test to verify email address entered in the comments section by user Samantha is in Proper format or not
	@Test
	public void validAllUseremails() {
		String username = "Samantha";
		int userid = L.getUserid(username);
		System.out.println("User id for " + username + " is " + userid);
		List<Integer> posts = L.getPostfromUser(userid);
		System.out.println("Posts writen by user " + username + "(" + userid + ")" + " are " + posts);
		List<String> emailids = new ArrayList<String>();
		for (int i = 0; i < posts.size(); i++) {
			emailids = L.getEmailids(posts.get(i));
			System.out.println("Email validation for Comments in Postid " + posts.get(i));
			System.out.println(L.validateEmailList(emailids,posts.get(i)));
			System.out.println("------------------------------------------------------------------------------------------------");
		}
	}
	
	@Test
	public void addPosttoUser() {
		baseURI = "https://jsonplaceholder.typicode.com";		
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("Content-Type","application/json");
		
		
		postsPOJO p = new postsPOJO();
		p.setUserId(1);
		p.setTitle("Title for new Post");
		p.setBody("New Post");			

		Response response = given().queryParams(reqMap).contentType(ContentType.JSON).when().body(p).post("/posts");		
				
		postsPOJO Responsepojo = response.getBody().as(postsPOJO.class);
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
		System.out.println(response.asString());
		System.out.println("New Postid created is "+Responsepojo.getId());
		System.out.println("------------------------------------------------------------------------------------------------");
	}
	
}
	



