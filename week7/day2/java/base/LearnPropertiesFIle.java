package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LearnPropertiesFIle {

	public static void main(String[] args) throws IOException {
		
		//step 1 set path
		FileInputStream fis=new FileInputStream("./src/main/resources/English.properties");

		//step 2 create object for properties class
		Properties p=new Properties();
		
		//step 3 -load()
		p.load(fis);
		
		//step 4-print values using getproperty()
		
		System.out.println(p.getProperty("username"));
		System.out.println(p.getProperty("password"));

		
		
	}

}
