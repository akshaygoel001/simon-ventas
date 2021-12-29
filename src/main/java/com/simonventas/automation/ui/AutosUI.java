package com.simonventas.automation.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.simonventas.automation.commons.BaseTest;
import com.simonventas.automation.commons.helpers.DriverFacade;

public class AutosUI extends BaseTest{
	protected DriverFacade driverFacade;
	
	@FindBy(xpath="//div[@id='pageError']")
	public static WebElement page_error;
	
	@FindBy(xpath="//a[contains(text(),'Inicio')]")
	public static WebElement inicio;
	
	@FindBy(xpath="//span[normalize-space()='Autos Test autosIcon.png']")
	public static WebElement autos_main;
	
	@FindBy(xpath="//a[text()=' Cotización Autos']")
	public static WebElement autos_menu;
	
	//clave page elements
	@FindBy(xpath="//input[@id='codAgente']")
	public static WebElement clave;
	
	@FindBy(xpath="//span[@id='nombreAgente']")
	public static WebElement clave_nombre;
	
	@FindBy(xpath="//span[@id='codAgenteError']")
	public static WebElement clave_service_error;
	
	@FindBy(xpath="//select[@name='subProducto']")
	public static WebElement subproducto;
	
	@FindBy(xpath="//input[@id='placa']")
	public static WebElement placa_campo;
	
	@FindBy(xpath="//div[@id='errorPlaca']")
	public static WebElement errorPlaca;
	
	@FindBy(xpath="//input[@name='placa']")
	public static WebElement datos_vehiculo_placa;
	
	@FindBy(xpath="//input[@id='closeNuevoCheckPopup']")
	public static WebElement closeNuevoCheckPopup;
	
	@FindBy(xpath="//label[@for='marcaLikeCheckbox']")
	public static WebElement marcaCheckbox;

	@FindBy(xpath="//input[@id='marcaLike']")
	public static WebElement marcaDescription;
	
	@FindBy(xpath="//input[@id='buscar']")
	public static WebElement placa_marcaContinuar; 
	
	@FindBy(xpath="//tbody[@role='alert']")
	public static WebElement marcaConsultationTable;
	
	@FindBy(xpath="//div[@id='errorMarcaPlaca']")
	public static WebElement errorMarcaPlaca;
	
	@FindBy(xpath="//tbody[@role='alert']//tr[1]")
	public static WebElement firstmarca;
	
	@FindBy(xpath="//table[@id='modelYears']//tr[@class='odd']")
	public static WebElement modelo;
	
	//tomador details
	@FindBy(xpath="//input[@id='numeroDocumento']")
	public static WebElement nrodocumento;
	
	@FindBy(xpath="//div[@id='errorSpan']")
	public static WebElement tomador_error;
	
	public static String tomador_no_existe="//div[@id='errorSpan']";
	
	@FindBy(id="nombres")
	public static WebElement nombre;
	
	@FindBy(id="apellidos")
	public static WebElement apellidos;
	
	@FindBy(xpath="//label[@for='autorizaDatosCheck1']")
	public static WebElement autoriza_datos_chbx;
	
	@FindBy(xpath="//label[@for='ceroKm']")
	public static WebElement nuevo_chbx;

	@FindBy(xpath="//input[@id='continuarUSO']")
	public static WebElement continuar;
	
	@FindBy(xpath="//input[@id='step1C']")
	public static WebElement siguiente1;
	
	
	//datos vehiculo elements
	@FindBy(xpath="//input[@id='step2C']")
	public static WebElement siguiente2;
	
	@FindBy(xpath="//div[@id='prev-next-button4']//input[@id='step2C']")
	public static WebElement datos_beneficiario_continuar;
	
	//datos conductor habitual elements
	@FindBy(xpath="//input[@id='step4C']")
	public static WebElement siguiente4;
	
	//coberturas elements
	@FindBy(xpath="//select[@id='opcionCobertura']")
	public static WebElement opcionCob;
	
	@FindBy(xpath="//input[@id='step6C']")
	public static WebElement siguienteCoberturas;
	
	//	Datos de Resp. Civil Suplementaria elements
	@FindBy(xpath="//input[@id='step9C']")
	public static WebElement siguienteCivilSuplementaria;
	
	
	
	//datos del beneficiario elements
	@FindBy(xpath="//input[@id='step5C']")
	public static WebElement siguiente5;
	
	//deducibles elements
	@FindBy(xpath="//input[@id='step10C']")
	public static WebElement siguienteDeducibles;
	
	@FindBy(id="submitbutton")
	public static WebElement submit;
	
	@FindBy(xpath="//div[@id='errorSubmit']")
	public static WebElement error;
	
	@FindBy(xpath="//div[@id='overlayAlerta']")
	public static WebElement alertaPopup; 
	
	@FindBy(xpath="//span[@id='alertMsgSpan']")
	public static WebElement alertMsg;
	
	@FindBy(xpath="//input[@id='CanclearAlertaAdvance']")
	public static WebElement alertMsgCancelar;
	
	@FindBy(xpath="//a[text()='Cancelar']")
	public static WebElement cancelar;
	
	@FindBy(id="crearCotizacion")
	public static WebElement crearCotizacion;
	
	@FindBy(xpath="//label[@id='quotNo']")
	public static WebElement quoteNo;
	
	//emission elements	
	@FindBy(id="formalize")
	public static WebElement emitir;
	
	@FindBy(id="continueAlerta")
	public static WebElement alert;
	
	@FindBy(xpath="//a[@id='editTomador']")
	public static WebElement editTomador;
	
	@FindBy(xpath="//input[@id='step3C']")
	public static WebElement siguiente3;
	
	@FindBy(xpath="//input[@id='step7C']")
	public static WebElement siguiente7;
	
	@FindBy(xpath="//input[@id='colorDisplay2']")
	public static WebElement color_campo;
	
	@FindBy(xpath="//input[@id='placa2']")
	public static WebElement emission_placa_campo;
	
	@FindBy(xpath="//span[@id='placa2Error']")
	public static WebElement emission_placa_error;
	
	@FindBy(xpath="//input[@id='motor2']")
	public static WebElement motor;
	
	@FindBy(xpath="//input[@id='chasis2']")
	public static WebElement chasis_vin;
	
	@FindBy(xpath="//input[@id='step10C']")
	public static WebElement siguiente10;
	
	@FindBy(xpath="//input[@id='step12C']")
	public static WebElement siguiente12;
	
	@FindBy(xpath="//select[@id='tipoEnvio']")
	public static WebElement tipo_envio_poliza;
	
	@FindBy(xpath="//div[@id='closeNewAutosPopup']")
	public static WebElement emission_view_ad_popup;
	
	@FindBy(xpath="//label[normalize-space()='Número de póliza:']/../div/label/b")
	public static WebElement numero_poliza;

	@FindBy(xpath="//a[@class='btn btn-primary closePopUpForAcceptar']")
	public static WebElement acceptar;

	@FindBy(xpath="//a[@class='btn btn-primary']")
	public static WebElement continuar_poliza;
	
	
	
}
