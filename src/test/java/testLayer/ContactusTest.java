package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseframe.baseclass;
import pompackage.pomcontactus;
import testdata.Excelsheet;

public class ContactusTest extends baseclass {

	pomcontactus contact;
	
	public ContactusTest() {
	
		super(); //reads all files from configu.Prop, to call constructor of parent class
		System.out.println("step1");
	}
	@BeforeMethod
	public void initsetup() {
		initiate();
		screenshots("Contactus");
	contact=new pomcontactus();
	System.out.println("step2");
	
	}

	@Test(priority=1)
	public void Title() {
		String actual = contact.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Contact Us - Roicians");
		System.out.println("step3");
	}
	@DataProvider
	public Object[][]Details(){
		Object result[][]=Excelsheet.readdata("Sheet1");
		return result;
	}
	@Test(priority=2,dataProvider="Details")
	public void contactus(String Firstname,String LastName,String Email, String Phone) {
		contact.typeFirstName(Firstname);
		contact.typeLastName(LastName);
		contact.typeEmail(Email);
		contact.typePhone(Phone);
//		contact.clickbtn();
		System.out.println("step4");
	}
	@AfterMethod
	public void close() {
	Driver.close();
	System.out.println("step5");
	}
	
}
