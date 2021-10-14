package tests;

import org.testng.annotations.Test;

import APIinfo.usersAPI;

public class testcases {
	usersAPI users = new usersAPI();
	
	@Test
	public void getUserid()
	{
		String username = "Samantha";
		String userid = users.getUserid(username);
		System.out.println("User id for "+username+" is "+userid);	
	}

}
