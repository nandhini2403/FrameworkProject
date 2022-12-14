package baseframe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Timeutils;

public class baseclass {
	
	   /* Base class is the parent class, if base class fails the entire frame work fails.
	    *So we keep data that are subjected to change in "config.files" and we use it whenever needed. Common commands are also kept here.
	    *So changes made to this data will have least impact on the code in the base class.(Browser info,url info,username,pw */ 
	 
	      public static Properties prop=new Properties();         // we have to create object of properties file to read config.prop
          
	      public static WebDriver Driver;                         // Driver is the reference variable for webdriver which is globally declared

  //Step 1 creating constructor of base class - we are going to write code to read prop of configu.file
          public baseclass() {
        	  
          try {	  
    	  FileInputStream file1=new FileInputStream("C:\\Users\\14373\\Desktop\\Eclipse Workspace\\Frameworks1\\src\\test\\java\\environmentvariables1\\Configu.Properties");
    	  prop.load(file1); //to read properties of the file 
        }
          catch(FileNotFoundException e) {
        	  e.printStackTrace(); // tool used to handle exception belongs to throwable class.
          }
          catch(IOException a)  {
        	  a.printStackTrace();
          }}
          //step2
          public static void initiate() {
          String Browsername= prop.getProperty("browser");	 
          if (Browsername.equals("Firefox")) {
        	  System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        	   Driver =new FirefoxDriver();}
         
          else if(Browsername.equals("chrome")) {
        	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        	  Driver =new ChromeDriver();
          }
          Driver.manage().window().maximize();
          Driver.manage().timeouts().pageLoadTimeout(Timeutils.timepage,TimeUnit.SECONDS );
          Driver.get(prop.getProperty("url"));
          }
          public static void screenshots(String Filename) {
        	 File file=((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
        	 try {
        	 FileUtils.copyFile(file,new File ("C:\\Users\\14373\\Desktop\\Eclipse Workspace\\Frameworks1\\src\\test\\java\\screenshots\\"+Filename+".jpg"));
          }
        	 catch(IOException e) {
        		 e.printStackTrace();
        	 } }
          
}
