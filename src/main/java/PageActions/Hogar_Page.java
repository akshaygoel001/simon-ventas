package PageActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import TestBase.VentasBase;

public class Hogar_Page extends VentasBase{
	
	
	public Actions action;
	
	@FindBy(xpath="//a[@class='arrow']/span[text()=' Cotizadores Hogar Test']")
	public WebElement hogar_main;
	
	@FindBy(xpath="//a[text()=' Hogar Test']")
	public WebElement hogar_menu;
	
	@FindBy(xpath="//input[@id='codAgente']")
	public WebElement clave;
	
	@FindBy(xpath="//input[@id='step1C']")
	public WebElement siguiente1;
	
	@FindBy(xpath="//input[@id='step2C']")
	public WebElement siguiente2;
	
	@FindBy(xpath="//input[@id='step3C']")
	public WebElement siguiente3;
	
	@FindBy(xpath="//input[@id='step4C']")
	public WebElement siguiente4;
	
	@FindBy(xpath="//input[@id='step5C']")
	public WebElement riesgo_continuar;
	
	@FindBy(xpath="//input[@id='step6C']")
	public WebElement siguiente6;
	
	@FindBy(xpath="//input[@id='step8C']")
	public WebElement siguiente7;
	
	@FindBy(id="codProductoSelect")
	public WebElement producto;
	
	@FindBy(xpath="//input[@id='numeroDocumento']")
	public WebElement nrodocumento;
	
	@FindBy(xpath="//label[@for='autorizaDatosCheck1']")
	public WebElement autoriza_datos_chbx;
	
	@FindBy(xpath="//input[@id='continuarUSO']")
	public WebElement continuar;
	
	@FindBy(id="codCiudad")
	public WebElement ciudadRiesgo;
	
	
	@FindBy(id="direccionRiesgo")
	public WebElement direccionRiesgo;
	
	
	@FindBy(id="anosConstruccion")
	public WebElement anosConstruccion;
	
	@FindBy(id="valorAsegurado_formatted")
	public WebElement vr_edificio;
	
	@FindBy(id ="valorNoElectrico_formatted")
	public WebElement vr_contenido_no_eléctrico;
	
	@FindBy(id ="valorElectrico_formatted")
	public WebElement vr_contenido_eléctrico;

	@FindBy(id="submitbutton")
	public WebElement submit;
		
	@FindBy(xpath="//label[@id='quotNo']")
	public WebElement quoteNo;
	
	@FindBy(id="formalize")
	public WebElement emitir;
	
	@FindBy(id="continueAlerta")
	public WebElement alert;
	
	@FindBy(id="tab_risk_informaciónAdicional1")
	public WebElement datos_adicionales_1;
	
	@FindBy(id="numeroDePisos1")
	public WebElement numero_pisos;
	
	@FindBy(id="barrio1")
	public WebElement barrio;
	
	@FindBy(id="tipoEnvio")
	public WebElement tipo_envio;
	
	@FindBy(xpath="//label[@id='quotNo']")
	public WebElement numero_poliza;
	
		
	@FindBy(xpath="//a[@class='btn btn-primary closePopUpForAcceptar']")
	public WebElement acceptar;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	public WebElement continuar_poliza;
	
		
	public Hogar_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//navigate to hogar create cotizacion page
	public void gotoHogar() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		action=new Actions(driver);
		
		action.moveToElement(hogar_main).build().perform();
		
		action.moveToElement(hogar_menu).build().perform();
		
		hogar_menu.click();
		
		String pagetitle=driver.getTitle();
		
		Assert.assertEquals(pagetitle, "Cotizacion Hogar");
		System.out.println("User sucessfully Landed on Crear Cotizacion Page");
		
	}
	
	public void enterClave(String agente) {
		
		//WebDriverWait wait=new WebDriverWait(driver, 2000);
		//wait.until(ExpectedConditions.elementToBeClickable(clave));
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		clave.clear();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		clave.click();
		clave.sendKeys(agente);
		
		action=new Actions(driver);		
		action.sendKeys(Keys.TAB).build().perform();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
			
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click();", siguiente1);
		}
	
	public void selectProducto(String codProducto) {
		
		Select select=new Select(producto);
		
		select.selectByValue(codProducto);
		
		
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click();", siguiente2);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		jse2.executeScript("arguments[0].click();", siguiente3);
		
		
	}
	
	public void enterTomador(String nro_documento ) {
		
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click();", nrodocumento);
		
		//nrodocumento.click();
		
		nrodocumento.sendKeys(String.valueOf(nro_documento));
		
		action=new Actions(driver);
		
		action.sendKeys(Keys.TAB).build().perform();
		
		
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		action.moveToElement(autoriza_datos_chbx).build().perform();
		
		jse2.executeScript("arguments[0].click();", autoriza_datos_chbx);
		
		
		continuar.click();
		
		siguiente4.click();
		
	}
	
	
	public void enterRiesgoInmueble(String ciudad, String direccion, String ano_construction) {
		
		ciudadRiesgo.sendKeys(ciudad);
		
		action=new Actions(driver);
		
		action.sendKeys(Keys.TAB).build().perform();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		direccionRiesgo.sendKeys(direccion);
		action.sendKeys(Keys.TAB).build().perform();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		Select select=new Select(anosConstruccion);
		select.selectByValue(ano_construction);
		
		
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click();", riesgo_continuar);
		//riesgo_continuar.click();
		
		
		
	}

	public void enterValorAsegurado(String edificio, String contenido_no_eléctrico, String contenido_eléctrico) {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click();", vr_edificio);
		vr_edificio.sendKeys(edificio);
		
		jse2.executeScript("arguments[0].click();", vr_contenido_no_eléctrico);
		vr_contenido_no_eléctrico.sendKeys(contenido_no_eléctrico);
		
		
		jse2.executeScript("arguments[0].click();", vr_contenido_eléctrico);
		vr_contenido_eléctrico.sendKeys(contenido_eléctrico);
		
		siguiente6.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		submit.click();
		
		System.out.println("Cotizacion No is : "+quoteNo.getText());
		
		
		
		
	}
	
	public void doEmitir() {
		
		
		emitir.click();
		System.out.println("Emitir Clicked");
		
		alert.click();
		
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		siguiente1.click();
		
		
		action=new Actions(driver);	
		action.moveToElement(autoriza_datos_chbx).build().perform();
		
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click();", autoriza_datos_chbx);
		
		
		continuar.click();
		
		siguiente2.click();
		
		siguiente3.click();
		
		siguiente4.click();
		
		
		action.moveToElement(datos_adicionales_1).click().build().perform();
		
		numero_pisos.sendKeys("1");
		barrio.sendKeys("1");
		
		riesgo_continuar.click();
		
		
		siguiente6.click();
		
		
		siguiente7.click();
		
		
		Select select=new Select(tipo_envio);
		select.selectByValue("PA");
		
		submit.click();
		System.out.println("Final Emitir button clicked");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		jse2.executeScript("arguments[0].click();", acceptar);
		
		
		String poliza=numero_poliza.getText();
		System.out.println("Número de póliza: "+poliza);
		
		
		
		
		
		continuar_poliza.click();
		
	}
	
	
	
	
	
	
}
