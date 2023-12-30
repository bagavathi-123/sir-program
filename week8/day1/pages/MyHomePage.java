package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class MyHomePage extends BaseClass{
	
	public MyLeadsPage clickMyLeads() {
		driver.findElement(By.linkText(p.getProperty("MyHomePage.linktext.Leads"))).click();

		return new MyLeadsPage();
	}
	
	public MyLeadsPage clickAccounts() {

		driver.findElement(By.linkText("Accounts")).click();
		return new MyLeadsPage();

	}
	
	

}
