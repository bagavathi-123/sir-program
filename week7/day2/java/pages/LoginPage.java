package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class LoginPage extends BaseClass {

	
	public LoginPage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	//step -1 create intput agrs in method
	public LoginPage enterUserName() {
		//step2- repalce hardcoded values to input agrs
		driver.findElement(By.id("username")).sendKeys(p.getProperty("username"));

		//m1
		//LoginPage lp=new LoginPage();
		//return lp;
		
		//m2
		return this;
	}
	
	public LoginPage enterPassword() {
		driver.findElement(By.id("password")).sendKeys(p.getProperty("password"));
		return this;
	}
	
	public HomePage clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
//m1 
		//HomePage hp=new HomePage();
		//return hp;
		
		//m2- return new Nextpage -ClassName()
		return new HomePage(driver);
		
	}
	
}
