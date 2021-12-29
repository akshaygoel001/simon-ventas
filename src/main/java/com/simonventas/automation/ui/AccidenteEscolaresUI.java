package com.simonventas.automation.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.simonventas.automation.commons.BaseTest;
import com.simonventas.automation.commons.helpers.DriverFacade;

public class AccidenteEscolaresUI extends BaseTest {

	protected DriverFacade driverFacade;

	@FindBy(xpath = "//div[@id='pageError']")
	public static WebElement page_error;

	@FindBy(xpath = "//a[contains(text(),'Inicio')]")
	public static WebElement inicio;

	@FindBy(xpath = "//span[contains(text(),'Cotizadores Salud Test')]")
	public static WebElement saludTestmenu;

	@FindBy(xpath = "//a[contains(text(),'Accidentes Escolares')]")
	public static WebElement accidenteEscolaresMenu;

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

	@FindBy(xpath = "//input[@id='step1C']")
	public static WebElement siguiente1;
	// clave page elements end

	// producto page elements
	@FindBy(xpath = "//select[@name='codProductoSelect']")
	public static WebElement producto;

	@FindBy(xpath = "//input[@id='step2C']")
	public static WebElement siguiente2;

	@FindBy(xpath = "//input[@id='step3C']")
	public static WebElement siguiente3;
	// producto page elements end

	// tomador page elements
	@FindBy(xpath = "//input[@id='numDocinstitucionNuevoNegocio']")
	public static WebElement nrodocumento;

	@FindBy(xpath = "//div[@id='errorSpan']")
	public static WebElement tomador_error;

	//public static String tomador_no_existe = "//span[@id='numDocinstitucionNuevoNegocioError']";
	
	@FindBy(xpath = "//span[@id='numDocinstitucionNuevoNegocioError']")
	public static WebElement tomadorError;
	
	@FindBy(xpath="//input[@id='tomador']")
	public static WebElement tomador;

	@FindBy(id = "nombres")
	public static WebElement nombre;

	@FindBy(id = "apellidos")
	public static WebElement apellidos;
	
	@FindBy(xpath="//input[@id='tomadorEmail']")
	public static WebElement tomadorEmail;
	
	@FindBy(xpath="//input[@id='telefono']")
	public static WebElement tomadorTelefono;
	
	@FindBy(xpath="//input[@id='codCiudad']")
	public static WebElement tomadorCiudad;
	
	@FindBy(xpath="//textarea[@id='direccion']")
	public static WebElement tomadorDireccion;
	
	@FindBy(xpath = "//input[@id='step4C']")
	public static WebElement siguiente4;
	
	@FindBy(xpath="//label[@for='autorizaDatosCheck1']")
	public static WebElement autoriza_datos_chbx;
	
	@FindBy(xpath="//input[@id='continuarUSO']")
	public static WebElement continuar;
	
	@FindBy(xpath="//div[@id='accidentesTipoNegociacionError']")
	public static WebElement accidentesTipoNegociacionError;
	// tomador page elements end
	
	//datos del plantel elements
	@FindBy(xpath="//input[@id='nombredelPlantel']")
	public static WebElement nombrePlantel;
	
	@FindBy(xpath="//input[@id='emailPlantelNuevoNegocio']")
	public static WebElement emailPlantel;
	
	@FindBy(xpath="//input[@id='telefonoplantel']")
	public static WebElement telefonoPlantel;
	
	@FindBy(xpath="//input[@id='cuidadplantel']")
	public static WebElement ciudadPlantel;
	
	@FindBy(xpath="//input[@id='direccionPlantel']")
	public static WebElement direccionPlantel;
	//datos del plantel elements end
	
	//crear cotizacion elements
	@FindBy(xpath="//input[@id='numeroDeAlumnos']")
	public static WebElement numeroDeAlumnos;
	
	@FindBy(xpath="//input[@id='liquidarbutton']")
	public static WebElement liquidar;
	
	@FindBy(xpath="//input[@id='crearCotizacion']")
	public static WebElement crearCotizacion;
	
	@FindBy(xpath="//label[@id='quotNo']")
	public static WebElement quoteNo;
	
	@FindBy(xpath="//div[@id='errorSubmit']")
	public static WebElement error;
	
	@FindBy(xpath="//div[@id='accidentesQuotError']")
	public static WebElement accidentesQuotError;
	
	@FindBy(xpath="//input[@id='continueFormalize']")
	public static WebElement emitir;
	
	//emission elements
	@FindBy(xpath="//a[@id='editTomador']")
	public static WebElement editTomador;
	
	@FindBy(id="rol")
	public static WebElement rol;
	
	@FindBy(xpath="//input[@id='nombresC']")
	public static WebElement general_primer_nombre;
	
	@FindBy(xpath="//input[@id='primerApellido']")
	public static WebElement general_primer_appelido;
	
	@FindBy(xpath="//input[@id='fechaNacimientoC']")
	public static WebElement fecha_nacimiento;
	
	@FindBy(xpath="//input[@id='lugarNacimiento']")
	public static WebElement lugar_nacimiento;
	
	@FindBy(xpath="//select[@id='estadoCivils']")
	public static WebElement estado_civil;
	
	@FindBy(xpath="//select[@id='sexo']")
	public static WebElement sexo;
	
	@FindBy(xpath="//input[@id='dirResidencia']")
	public static WebElement direccion;
	
	@FindBy(xpath="//input[@id='ciudadResi']")
	public static WebElement ciudad;
	
	@FindBy(xpath="//input[@id='telefonoResidencia']")
	public static WebElement telephono;
	
	@FindBy(xpath="//input[@id='noCelular']")
	public static WebElement celular;
	
	@FindBy(xpath="//input[@id='email']")
	public static WebElement correo;
	
	@FindBy(xpath="//input[@id='goNext']")
	public static WebElement informacion_general_siguiente;
	
	@FindBy(xpath="//select[@id='ocupacion']")
	public static WebElement occupacion;
	
	@FindBy(xpath="//input[@id='goNext1']")
	public static WebElement actividad_econimica_siguiente;
	
	@FindBy(xpath="//input[@id='totalActivos']")
	public static WebElement total_activos;
	
	@FindBy(xpath="//input[@id='totalPasivos']")
	public static WebElement total_pasivos;
	
	@FindBy(xpath="//input[@id='totalPatrrimonio']")
	public static WebElement total_patrimonio;
	
	@FindBy(xpath="//input[@id='totalIngresoMensuals']")
	public static WebElement ingresos_mensuales;
	
	@FindBy(xpath="//input[@id='totalEgresosMensuales']")
	public static WebElement egresos_mensuales;
	
	@FindBy(xpath="//input[@id='goNextInformacionFinanCiera']")
	public static WebElement financiera_informacion_siguiente;
		
	@FindBy(xpath="//input[@id='submitbutton114']")
	public static WebElement declaracion_siguiente;
	
	@FindBy(xpath="//button[text()='Ok']")
	public static WebElement conocimiento_ok;
	
	@FindBy(xpath="//a[@id='refreshTomador']")
	public static WebElement refresh_tomador;
	
	@FindBy(xpath="//div[@id='saveDataErrorOnSubmit']")
	public static WebElement add_tomador_error;
	
	@FindBy(xpath="//h2[contains(text(),'Datos Carnet Alumnos')]")
	public static WebElement datosCarnetAlumnosHeader;
	
	@FindBy(xpath="//h2[contains(text(),'Datos Carnet Alumnos')]/../../../..//input[@value='Siguiente']")
	public static WebElement alumnosSiguiente;
	
	@FindBy(xpath="//input[@id='nombreDatosContacto']")
	public static WebElement nombreDatosContacto;
	
	@FindBy(xpath="//input[@id='numdocDatosContacto']")
	public static WebElement numdocDatosContacto;
	
	@FindBy(xpath="//input[@id='telefonoDatosContacto']")
	public static WebElement telefonoDatosContacto;
	
	@FindBy(xpath = "//input[@id='step5C']")
	public static WebElement siguiente5;
	
	@FindBy(xpath = "//input[@id='step6C']")
	public static WebElement siguiente6;
	
	@FindBy(xpath = "//input[@id='step7C']")
	public static WebElement siguiente7;
	
	@FindBy(xpath="//input[@value='Generar póliza']")
	public static WebElement submit;
	
	@FindBy(xpath="//a[@class='btn btn-primary closePopUpForAcceptar']")
	public static WebElement acceptar;
	
	@FindBy(xpath="//a[text()='Cancelar']")
	public static WebElement cancelar;
	
	@FindBy(xpath="//label[@id='quotNo']")
	public static WebElement numero_poliza;
	
	@FindBy(xpath="//a[@class='btn btn-success']")
	public static WebElement salir;
	
	//common consultation elements
	@FindBy(xpath="//a[@class='arrow']/span[text()=' Consulta Cotizaciones Test']")
	public static WebElement consulta_cotizaciones_main;

	@FindBy(xpath="//a[text()=' Consulta Cotización por Rango de Fechas Test']")
	public static WebElement consulta_cotizaciones_menu;

	@FindBy(xpath="//select[@id='company']")
	public static WebElement compania;

	@FindBy(xpath="//input[@id='fechaInicio']")
	public static WebElement fecha_desde;

	@FindBy(xpath="//select[@id='seccion']")
	public static WebElement seccion;

	@FindBy(xpath="//select[@id='product']")
	public static WebElement codProducto;

	@FindBy(xpath="//input[@id='numDeCotizacion']")
	public static WebElement numero_cotizacion;
	
	@FindBy(xpath="//input[@id='fechaFin']")
	public static WebElement fecha_hasta;

	@FindBy(xpath="//input[@id='consultar']")
	public static WebElement consultar;

	@FindBy(xpath="//table[@id='searchResult']//a[@class='btn btn-success']")
	public static WebElement resultEmitir;
	
	//PDF elements
	@FindBy(xpath="//span[@id='popUpPDF']")
	public static WebElement pdf;
	
	

}
