package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

public class LoginPage extends BaseClass {

	
	public LoginPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	
	public LoginPage enterUserName() throws IOException {
		
		try {
			driver.findElement(By.id("username")).sendKeys(p.getProperty("username"));
			//call reportStep method from @BeforeClass
			reportStep("UserName as Enter Successfully","Pass");
		} catch (Exception e) {
			reportStep("UserName as Not Enter Successfully","fail");
		}
		return this;
	}
	
	public LoginPage enterPassword() throws IOException {
		try {
			driver.findElement(By.id("password")).sendKeys(p.getProperty("password"));
			reportStep("Password as Enter Successfully","pass");

		} catch (Exception e) {
			reportStep("Password as  Not Enter Successfully","fail");

		}
		return this;
	}
	
	public HomePage clickLoginButton() throws IOException {
		try {
			driver.findElement(By.className("decorativeSubmi")).click();
			reportStep( "Login is Successfully","pass");

		} catch (Exception e) {
			reportStep("Login is Not Successfully","fail");

		}
		return new HomePage(driver);
		
	}
	
}
