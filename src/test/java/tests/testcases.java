package tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import commonFunctions.Logic;


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
			System.out.println(L.validateEmailList(emailids));
			System.out.println("------------------------------------------------------------------------------------------------");
		}
	}

}
