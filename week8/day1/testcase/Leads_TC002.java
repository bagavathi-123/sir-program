package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class Leads_TC002 extends BaseClass{

	
	@BeforeTest
	public void setdata() {
	
		filedata="Login";
		testName="Login Page";
		testDesc="Login with valid data";
		testAuthor="Vinoth";
		testCategory="s";
	}
	
	
	
	@Test(dataProvider = "getName")
	
	public void leads(String uname,String pwd) throws IOException {
		
		
		LoginPage lp = new LoginPage(driver,node);
		System.out.println(driver +" :leads_tc002");
		lp.enterUserName()
		.enterPassword().clickLoginButton();
		
		
		
	}
	
}
