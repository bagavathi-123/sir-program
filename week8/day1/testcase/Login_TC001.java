package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class Login_TC001 extends BaseClass{

	@BeforeTest
	public void setData() {
		
		testName="Login Page";
		testDesc="Login with valid data";
		testAuthor="Dilip";
		testCategory="Sanity";
	}
	
	
	
	@Test
public void logindata() throws IOException {
	

		System.out.println(driver+" :login_tc001");

	new LoginPage(driver,node).enterUserName()
	.enterPassword().clickLoginButton();
}


}
