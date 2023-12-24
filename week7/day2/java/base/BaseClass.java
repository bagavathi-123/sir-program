package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.ExcelwithTC;



public class BaseClass {
	
	
	//static -common reference to all -seq execution
		//public static ChromeDriver driver;
	
	//parallel execution
	public ChromeDriver driver;
	
	//step3-excel prgm
		 public String filedata;
		 
		 
		 //for properties file
		 public static Properties p;
		 
		@BeforeMethod
		public void preCondition() throws IOException {
			
			
			//properties file
			FileInputStream fis=new FileInputStream("./src/main/resources/English.properties");
			p=new Properties();
			p.load(fis);
			
			
			
			 driver  = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://leaftaps.com/opentaps/control/main");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			}
		
		
		
		@AfterMethod
		public void postCondition() {
			driver.close();
		}
		
	
		//step4-excel prgm
				@DataProvider(name="getName")
				public String[][] fetchdata() throws IOException{
					String[][] excelData = ExcelwithTC.excelData(filedata);
					return excelData;
					
				}


}
