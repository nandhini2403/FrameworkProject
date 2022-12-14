package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseframe.baseclass;

public class pomcontactus extends baseclass{

	//we need to create object repository-we will write all elements with element locators of contactus page
	@FindBy(name ="text-77525447616")    //driver.findElement(By.
	WebElement FirstName;
	
	@FindBy(id="text-95374915097")
	WebElement LastName;
	
	@FindBy(id="text-27022866830")
	WebElement Email;
	
	@FindBy(id="field-tIgxvmTMez6ibt1")
	WebElement Phone;
	
	@FindBy(id="button-18782068913")
	WebElement Sendbtn;

	//initiate page elements located by @FindBy, for this we need to create constructor
	public pomcontactus() {
	PageFactory.initElements(Driver,this);  //"init Element" is a static method in Pagefactory ,'this' converts local into global variable	
  }
    public void typeFirstName(String fname)  { 

        FirstName.sendKeys(fname);
    }
    public void typeLastName(String lname) {
    	LastName.sendKeys (lname);
    }
    public void typeEmail(String nemail) {
        Email.sendKeys(nemail);
    }
    public void typePhone(String pnumber) {
       Phone.sendKeys(pnumber);
    }
    public void clickbtn() {
       Sendbtn.click();	
    }
    public String verify() {
    	return Driver.getTitle();   //to get page title
    }
}