package Hogar;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DataProvider.Data;
import DataProvider.DataProviders;
import PageActions.Hogar_Page;
import TestBase.VentasBase;


@Listeners(CustomListener.TestListener.class)	

public class Hogar_Test extends VentasBase{

	//public WebDriver driver;
	public  VentasBase ventas;
	public Hogar_Page h;

	/*public static void main(String[] args) {

		Hogar_Test h=new Hogar_Test();

		h.launchVentas();
		h.CrearCotizacion();
		h.emisionPoliza();

	}*/

	@BeforeTest
	@Parameters({"browser","version","platform"})
	public void launchVentas(String browser,String version, String platform) {

		ventas=new VentasBase();
		try {

			//initiate browser and navigate to URL.  
			ventas.initBrowser(browser,version,platform,Data.url);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		//login into the simon ventas application
		ventas.login();
		

	}


	@Test(priority=1,dataProviderClass=DataProviders.class,dataProvider="getData")
	public void CrearCotizacion(Hashtable<String,String> data) {
		
		
		ventas=new VentasBase();
		//setWebDriver(driver);
		h=new Hogar_Page(driver);
		
		System.out.println(data.get("S.no") + "  Test Case starts");

		//after login, navigate to crear cotizacion hogar menu.
		h.gotoHogar(data.get("S.no"));

		String pagetitle=driver.getTitle();
		Assert.assertEquals(pagetitle, "Cotizacion Hogar");
		System.out.println("User sucessfully Landed on Crear Cotizacion Page");


		//enter clave
		h.enterClave(data.get("S.no"),data.get("Clave"));

		//select producto
		h.selectProducto(data.get("Producto"));

		//enter tomador
		h.enterTomador(data.get("Num_Doc"),data.get("S.no"));

		//enter riesgo data
		h.enterRiesgoInmueble(data.get("Ciudad"), data.get("Direccion"), data.get("Ano_Construccion"));

		//enter valor asegurado
		h.enterValorAsegurado(data.get("S.no"),data.get("Edifico"), data.get("No_Electrico"), data.get("Electrico"));




	}



	@Test(priority=2,enabled=false,dataProviderClass=DataProviders.class,dataProvider="getData")
	public void emisionPoliza(Hashtable<String,String> data) {
		
		h.doEmitir(data.get("S.no"),data.get("Numero_Pisos"),data.get("Barrio"));


	}
	
	@AfterTest
	public void quit() {
		
		//VentasBase.setWebDriver(ventas.driver);
		//driver.close();


	}	


}
