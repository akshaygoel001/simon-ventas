package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VentasBase_Page extends VentasBase{
	
	public WebDriver driver;
	
	@FindBy(xpath="//button")
	public WebElement login;
	
	
	//POM model
	public VentasBase_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
