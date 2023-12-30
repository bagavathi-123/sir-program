package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.ExcelwithTC;



public class BaseClass {
	
	public ChromeDriver driver;
		 public String filedata;
		 public static Properties p;
		 public static ExtentReports extent;
		 public String testName,testDesc,testAuthor,testCategory;
		 public  ExtentTest test ,node;
		 public ExtentHtmlReporter wb;
		 
		@BeforeMethod
		public void preCondition() throws IOException {
			
			FileInputStream fis=new FileInputStream("./src/main/resources/English.properties");
			p=new Properties();
			p.load(fis);
			
			
			 node = test.createNode(testName);
			 driver  = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://leaftaps.com/opentaps/control/main");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			}
		
		
		
		@AfterMethod
		public void postCondition() {
			driver.close();
		}
		
				@DataProvider(name="getName",indices = {1})
				public String[][] fetchdata() throws IOException{
					String[][] excelData = ExcelwithTC.excelData(filedata);
					return excelData;
					
				}
				
		@BeforeSuite
		public void startReport() {
		
			wb=new ExtentHtmlReporter("./snaps/lead1.html");
			wb.setAppendExisting(true);
			extent=new ExtentReports();
			extent.attachReporter(wb);
			
		}
		
		@AfterSuite
		public void stopReport() {
			extent.flush();
			System.out.println("Done");
		}
		
		
		
		@BeforeClass
		public void testDetails() {
			test=extent.createTest(testName,testDesc );
			test.assignAuthor(testAuthor);
			test.assignCategory(testCategory);
		}
			
			public void reportStep(String message,String status) throws IOException {
				
				if(status.equalsIgnoreCase("pass")) {
					node.pass(message,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
				}else if(status.equalsIgnoreCase("fail")) {
					node.fail(message,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
			}
		
			}
			
			
			public int takeSnap() throws IOException {
				int random = (int)(Math.random()*99999);
				File scr = driver.getScreenshotAs(OutputType.FILE);
				File dest=new File("./snaps/img"+random+".png");
				FileUtils.copyFile(scr, dest);
				return random;
			}

}
