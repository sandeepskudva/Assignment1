package commonFunctions;

import static io.restassured.RestAssured.*;
import java.util.Arrays;
import java.util.List;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.*;

public class Logic {

	
	public int getUserid(String username)
	{
		baseURI = "https://jsonplaceholder.typicode.com";
		
		
		int userid=0;
		
		Response response = given().contentType(ContentType.JSON).when().get("/users");
		
		List<usersPOJO> pojo=Arrays.asList(response.getBody().as(usersPOJO[].class));
		
				
		for(int i=0;i<pojo.size();i++)
		{
			if(pojo.get(i).getUsername().equals(username))
				userid=pojo.get(i).getId();	
		}		
		
		
		return userid;	
	}	
	
		
	
}
