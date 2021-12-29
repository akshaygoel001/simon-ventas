package TestBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VentasBase {
	
	public static WebDriver driver;
	public Actions action;
	public WebDriverWait wait;
	
	public VentasBase_Page ventaspage;
	
	public static Logger log = Logger.getLogger(VentasBase.class.getName());

	//intialise browser
	public void initBrowser(String browser,String url) throws InterruptedException {

		//System.setProperty("webdriver.chrome.driver", "src/test/resources/ExecutableJARS/chromedriver.exe");
		System.out.println(System.getProperty("user.dir"));
		//logging
		PropertyConfigurator.configure("E:\\Automation\\SimonVentas\\src\\test\\resources\\Logs\\log4j.properties");

		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.debug("Driver Initialised");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

			
			driver.get(url);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.debug("Driver Initialised");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

			
			driver.get(url);
		}
		else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			log.debug("Driver Initialised");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

			
			driver.get(url);
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.debug("Driver Initialised");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

			
			driver.get(url);	

			
		}
		
	}
	
	
	//perform login
	public void login() {
		
		ventaspage=new VentasBase_Page(driver);
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		
		action=new Actions(driver);
		action.moveToElement(ventaspage.login).build().perform();
		
		
		ventaspage.login.click();
		
		System.out.println("login clicked");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		String pageTitle=driver.getTitle();
		
		Assert.assertEquals(pageTitle, "Bienvenido a Seguros Bolívar");
		
		System.out.println("User successfuly Landed on Home page with page title : "+pageTitle);
		
		
	}

}
