package com.simonventas.automation.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.simonventas.automation.commons.BaseTest;
import com.simonventas.automation.commons.helpers.DriverFacade;

public class VidaGrupoUI extends BaseTest {

	protected DriverFacade driverFacade;

	@FindBy(xpath = "//div[@id='pageError']")
	public static WebElement page_error;

	@FindBy(xpath = "//a[contains(text(),'Inicio')]")
	public static WebElement inicio;

	@FindBy(xpath = "//span[text()=' Vida Grupo']")
	public static WebElement vidagrupo_main;

	@FindBy(xpath = "//a[contains(text(),'Cotización Póliza Hija')]")
	public static WebElement cotiacionPolizaHija_menu;

	// clave page elements
	@FindBy(xpath = "//input[@id='codAgente']")
	public static WebElement clave;

	@FindBy(xpath = "//span[@id='codAgenteError']")
	public static WebElement clave_service_error;

	@FindBy(xpath = "//div[@id='errorDiv']")
	public static WebElement clave_empty;

	@FindBy(xpath = "//span[contains(text(),' Agente Inexistente')]")
	public static WebElement clave_inexistente;

	@FindBy(xpath = "//span[@id='nombreAgente']")
	public static WebElement clave_nombre;

	// producto page elements
	@FindBy(xpath = "//select[@name='codProducto']")
	public static WebElement producto;
	
	@FindBy(xpath="//input[@id='polizaPrincipal']")
	public static WebElement polizaPrinipal;
	
	@FindBy(xpath="//select[@id='tipoDocumento']")
	public static WebElement tipoDoc;
	
	@FindBy(xpath="//input[@id='numeroDocumento']")
	public static WebElement numDoc;
	
	@FindBy(xpath="//input[@id='buscarPoliza']")
	public static WebElement buscar;
	
	@FindBy(xpath="//table[@id='table_cotizacion']//tbody//tr//td[1]")
	public static WebElement cotizacionTable;
	
	@FindBy(xpath="//input[@id='liquidarPrimaButton']")
	public static WebElement liquidarPrima;
	
	@FindBy(xpath="//select[@id='tipoDocumentoR']")
	public static WebElement asegTipoDoc;
	
	@FindBy(xpath="//input[@id='identificationR']")
	public static WebElement asegNumDoc;
	
	@FindBy(xpath="//span[@id='errorSpan']")
	public static WebElement tomador_error;
	
	public static String tomador_no_existe="//div[@id='errorSpan']";
	
	@FindBy(id="nombres")
	public static WebElement nombre;
	
	@FindBy(id="apellidos")
	public static WebElement apellidos;
	
	@FindBy(xpath="//input[@id='addriskbutton']")
	public static WebElement addRiesgo;
	
	@FindBy(xpath="//input[@id='submitbutton']")
	public static WebElement crearCotizacion;
	
	
	
}
