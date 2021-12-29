package com.simonventas.automation.flow;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.simonventas.automation.commons.helpers.DriverFactory;
import com.simonventas.automation.commons.utils.DataUtil;
import com.simonventas.automation.commons.utils.ExcelReader;
import com.simonventas.automation.commons.utils.FlowUtil;
import com.simonventas.automation.commons.utils.Log;
import com.simonventas.automation.ui.AccidenteEscolaresUI;

import io.qameta.allure.Step;

public class AccidenteEscolaresFlow extends AccidenteEscolaresUI {

	public ExcelReader dataExcel = DataUtil.dataExcel;
	public static Log log = new Log(AccidenteEscolaresFlow.class.getName());

	public void gotoAutos(int rowNum) {
		if (FlowUtil.elementIsDisplayed(page_error)) {
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum,
					page_error.getText().substring(0, 53));
			Assert.fail(page_error.getText());
		} else {
			FlowUtil.waitTillClickable(saludTestmenu);
			FlowUtil.movetoElement(saludTestmenu);
			FlowUtil.waitTillVisibility(accidenteEscolaresMenu);
			FlowUtil.movetoElementandClick(accidenteEscolaresMenu);
			log.info("Navigated to Accidente Escolares Menu");
			waitTillInvisibilityofCargando();

		}
	}

	@Step("Enter Clave {1}")
	public void enterClave(int rowNum, String agente) {
		if (FlowUtil.isElementPresent(page_error)) {
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum, "Serivce Error");
			Assert.fail("Service Error" + page_error.getText());
		}
		FlowUtil.clearvalue(clave);
		FlowUtil.click(clave);
		FlowUtil.sendvalue(clave, agente);
		FlowUtil.pressTab();
		waitTillInvisibilityofCargando();
		FlowUtil.sleep(3000);
		log.info("clave nombre:" + clave_nombre.getText());
		if (FlowUtil.elementIsDisplayed(clave_nombre)) {
			// FlowUtil.movetoElementandClick(siguiente1);
			FlowUtil.javascriptClick(siguiente1);
		} else if (FlowUtil.elementIsDisplayed(clave_service_error)) {
			FlowUtil.click(inicio);
			Assert.fail("clave service error");
		}
	}
	@Step("Select Producto {0}")
	public void selectProducto(String codProducto) {
		FlowUtil.movetoElement(producto);
		FlowUtil.selectByValue(producto, codProducto);
		waitTillInvisibilityofCargando();
		FlowUtil.javascriptClick(siguiente2);
	}
	@Step("Enter Tomador Numero Documento:{1}, FirstName:{2}, LastName:{3}, Email:{4}, Celular:{5}, Ciudad:{6}, Direccion:{7}")
	public void enterTomador(int rowNum, String nro_documento,String tomadorName,String tomadorAppellido, String tomadorEmail,String tomadorCelular,String tomadorCiudad,String tomadorDireccion) {
		FlowUtil.javascriptClick(nrodocumento);
		FlowUtil.clearvalue(nrodocumento);
		FlowUtil.sendvalue(nrodocumento, nro_documento);
		FlowUtil.pressTab();
		waitTillInvisibilityofCargando();
		FlowUtil.sleep(3000);
		if (FlowUtil.isElementPresent(tomador_no_existe)) {
			if (tomador_no_existe.getText().contains("Persona no existe")) {
				log.info(tomador_no_existe.getText());
				FlowUtil.click(tomador);
				FlowUtil.sendvalue(tomador, tomadorName);
				FlowUtil.sendvalue(apellidos,tomadorAppellido);
				FlowUtil.sendvalue(AccidenteEscolaresUI.tomadorEmail, tomadorEmail);
				FlowUtil.sendvalue(AccidenteEscolaresUI.tomadorTelefono, tomadorCelular);
				FlowUtil.sendvalue(AccidenteEscolaresUI.tomadorCiudad, tomadorCiudad);
				FlowUtil.sendvalue(AccidenteEscolaresUI.tomadorDireccion, tomadorDireccion);
			} else {
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum,tomador_error.getText().substring(0, 53));
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Fail");
				FlowUtil.takeFailedFullPageScreenshot("CrearCotizacion");
				FlowUtil.movetoElementandClick(inicio);
				Assert.fail("Error on Tomador Screen");
			}
		}
		FlowUtil.scrollToElement(autoriza_datos_chbx);
		FlowUtil.movetoElement(autoriza_datos_chbx);
		FlowUtil.javascriptClick(autoriza_datos_chbx);
		FlowUtil.click(continuar);
		FlowUtil.javascriptClick(siguiente3);
		waitTillInvisibilityofCargando();
		if(FlowUtil.isElementPresent(accidentesTipoNegociacionError)) {
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum,accidentesTipoNegociacionError.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Fail");
			String msg=accidentesTipoNegociacionError.getText();
			FlowUtil.takeFailedFullPageScreenshot("CrearCotizacion");
			FlowUtil.movetoElementandClick(inicio);
			Assert.fail(msg);
		}
	}
	@Step("Enter Datos del Plantel {0},{1},{2},{3} & {4} ")
	public void filldatosdelplantel(String nombreplantel,String emailplantel,String telefonoplantel,String ciudaplantel,String direccion) {
		FlowUtil.sendvalue(nombrePlantel, nombreplantel);
		FlowUtil.sendvalue(emailPlantel, emailplantel);
		FlowUtil.sendvalue(telefonoPlantel, telefonoplantel);
		FlowUtil.sendvalue(ciudadPlantel, ciudaplantel);
		FlowUtil.pressTab();
		FlowUtil.sendvalue(direccionPlantel, direccion);
		FlowUtil.click(siguiente4);
	}
	@Step("Create Cotizacion with Numero Alumnos:{1}, Cobertura:{2}")
	public void crearCotizacion(int rowNum,String numeroAlumnos,String cobertura) {
		FlowUtil.clearvalue(numeroDeAlumnos);
		FlowUtil.acceptAlert();
		FlowUtil.click(numeroDeAlumnos);
		FlowUtil.sendvalue(numeroDeAlumnos, numeroAlumnos);
		WebElement coverage=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//label[@for='"+cobertura+"TotalCbxNo']"));
		FlowUtil.movetoElement(liquidar);
		FlowUtil.javascriptClick(coverage);
		FlowUtil.javascriptClick(liquidar);
		waitTillInvisibilityofCargando();
		FlowUtil.movetoElement(crearCotizacion);
		FlowUtil.javascriptClick(crearCotizacion);
		waitTillInvisibilityofCargando();
		if(FlowUtil.isElementPresent(quoteNo)) {
			log.info("Cotizacion No is : "+quoteNo.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion",rowNum , quoteNo.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum , "No");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "CotizacionPDF",rowNum,"Not Executed");
			FlowUtil.takeSuccessFullPageScreenshot("CrearCotizacion");
		}
		else if(FlowUtil.isElementPresent(error)){
			log.info("Error is displayed on Crear Cotizacion:"+error.getText());
			String msg=error.getText();
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion", rowNum, "");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum, error.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Fail");
			FlowUtil.takeFailedFullPageScreenshot("CrearCotizacion");
			FlowUtil.click(inicio);
			Assert.fail(msg);
		}	
		else if(FlowUtil.isElementPresent(accidentesQuotError)) {
			log.info("Error is displayed on Crear Cotizacion:"+accidentesQuotError.getText());
			String msg=accidentesQuotError.getText();
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion", rowNum, "");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum, accidentesQuotError.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Fail");
			FlowUtil.takeFailedFullPageScreenshot("CrearCotizacion");
			FlowUtil.click(inicio);
			Assert.fail(msg);
		}
	}
	@Step("Emission Poliza with Nombre Contacto:{1}, Num Doc Contacto:{2} & Telefono Contacto:{3}")
	public void doEmitir(int rowNum,String nombreContacto,String numdocContacto,String telefonoContacto) {
		FlowUtil.click(emitir);
		log.info("Emission Started");
		waitTillInvisibilityofCargando();
		String parentWindow=FlowUtil.getWindowHandle();
		FlowUtil.click(siguiente1);
		if(FlowUtil.isElementPresent(editTomador)) {
			FlowUtil.waitTillClickable(editTomador);
			FlowUtil.click(editTomador);
			FlowUtil.sleep(3000);
			Set<String> windows=FlowUtil.getWindowHandles();
			String subWindow = null;
			Iterator<String> iterate_window = windows.iterator();
			while (iterate_window.hasNext()) {
				subWindow = iterate_window.next();
				FlowUtil.swichToWindow(subWindow);
				String title=DriverFactory.getDriverFacade().getWebDriver().getTitle();
				if(title.contains("CONOCIMIENTO")) {
					FlowUtil.swichToWindow(subWindow);
					log.info(DriverFactory.getDriverFacade().getWebDriver().getTitle());
				}
			}
			waitTillInvisibilityofCargando();
			FlowUtil.selectByValue(rol, DataUtil.general_rol);
			FlowUtil.sendvalue(general_primer_nombre, DataUtil.general_primer_nombre);
			FlowUtil.sendvalue(general_primer_appelido, DataUtil.general_primer_appelido);
			FlowUtil.sendvalue(fecha_nacimiento, DataUtil.general_fecha_nacimiento);
			FlowUtil.sendvalue(lugar_nacimiento, DataUtil.general_lugar_nacimiento);
			FlowUtil.pressTab();
			FlowUtil.selectByValue(estado_civil, DataUtil.general_estado_civil);
			FlowUtil.selectByValue(sexo, DataUtil.general_sexo);
			FlowUtil.sendvalue(direccion, DataUtil.general_direccion);
			FlowUtil.sendvalue(ciudad, DataUtil.general_ciudad);
			FlowUtil.pressTab();
			FlowUtil.sendvalue(telephono, DataUtil.general_telephono);
			FlowUtil.sendvalue(celular, DataUtil.general_celular);
			FlowUtil.sendvalue(correo, DataUtil.general_correo);
			FlowUtil.click(informacion_general_siguiente);
			waitTillInvisibilityofCargando();
			FlowUtil.selectByValue(occupacion, DataUtil.actividad_economica_occupacion);
			WebElement expuesta=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-personaPublicamente"+DataUtil.actividad_economica_expuesta+"']"));
			FlowUtil.click(expuesta);
			WebElement expuesta_familiares=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-tieneVinculosSocio"+DataUtil.actividad_economica_familiares_expuesta+"']"));
			FlowUtil.click(expuesta_familiares);
			FlowUtil.click(actividad_econimica_siguiente);
			FlowUtil.sendvalue(total_activos, DataUtil.financiera_activos);
			FlowUtil.sendvalue(total_pasivos, DataUtil.financiera_pasivos);
			FlowUtil.sendvalue(total_patrimonio, DataUtil.financiera_patrimonio);
			FlowUtil.sendvalue(ingresos_mensuales, DataUtil.financiera_ingresos_menusales);
			FlowUtil.sendvalue(egresos_mensuales, DataUtil.financiera_egresos_mensuales);
			WebElement ingresos_adicionales=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-recibeOtrosIngresos"+DataUtil.financiera_ingresos_adicionales+"']"));
			FlowUtil.click(ingresos_adicionales);
			WebElement moneda_extranjera=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-realizaTransacciones"+DataUtil.financiera_moneda_extranjera+"']"));
			FlowUtil.click(moneda_extranjera);
			WebElement operaciones_internaciones=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-relizaOperaciones"+DataUtil.financiera_operaciones_internacionales+"']"));
			FlowUtil.click(operaciones_internaciones);
			WebElement financiero_exterior=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-posesProductos"+DataUtil.financiera_en_el_exterior+"']"));
			FlowUtil.click(financiero_exterior);
			FlowUtil.click(financiera_informacion_siguiente);
			WebElement autorizar_compartir=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//input[@id='autorizaCOmpartirInformacion"+DataUtil.declaracion_autoriza_compartir+"']"));
			FlowUtil.click(autorizar_compartir);
			WebElement autorizar_recibir=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//input[@id='autorizaRecibirInformacion"+DataUtil.declaracion_autoriza_recibir+"']"));
			FlowUtil.click(autorizar_recibir);
			FlowUtil.click(declaracion_siguiente);
			waitTillInvisibilityofCargando();
			if(FlowUtil.isElementPresent(conocimiento_ok)) {
				FlowUtil.click(conocimiento_ok);
				FlowUtil.swichToWindow(parentWindow);
				FlowUtil.click(refresh_tomador);
				waitTillInvisibilityofCargando();
			}
			else if(FlowUtil.isElementPresent(add_tomador_error)){
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, add_tomador_error.getText());
				FlowUtil.takeFailedFullPageScreenshot("emisionPoliza");
				Assert.fail("Error on Emision Poliza");
			}
		}
		FlowUtil.scrollToElement(autoriza_datos_chbx);
		FlowUtil.movetoElement(autoriza_datos_chbx);
		FlowUtil.javascriptClick(autoriza_datos_chbx);
		FlowUtil.click(continuar);
		FlowUtil.click(siguiente2);
		FlowUtil.click(siguiente4);
		FlowUtil.waitTillVisibility(datosCarnetAlumnosHeader);
		FlowUtil.movetoElement(alumnosSiguiente);
		FlowUtil.javascriptClick(alumnosSiguiente);
		FlowUtil.sendvalue(nombreDatosContacto, nombreContacto);
		FlowUtil.sendvalue(numdocDatosContacto, numdocContacto);
		FlowUtil.sendvalue(telefonoDatosContacto, telefonoContacto);
		FlowUtil.click(siguiente5);
		FlowUtil.click(siguiente6);
		FlowUtil.click(siguiente7);
		FlowUtil.waitTillClickable(submit);
		FlowUtil.click(submit);
		log.info("Final Emitir button clicked");
		//waitTillInvisibilityofCargando();
		if(FlowUtil.isElementPresent(error)) {
			log.info("Error is displayed on Emision Poliza:"+error.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, error.getText());
			FlowUtil.takeFailedFullPageScreenshot("emisionPoliza");
			FlowUtil.click(cancelar);
			Assert.fail("Error on Emision Poliza");
		}
		else {
			FlowUtil.javascriptClick(acceptar);
			String poliza=numero_poliza.getText();
			log.info("Numero de poliza: "+poliza);
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, poliza);
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Pass");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, "No");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Copiar_Cotizacion",rowNum , "Not Executed");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "PolicyPDF",rowNum , "Not Executed");
			FlowUtil.takeSuccessFullPageScreenshot("emisionPoliza");
			FlowUtil.waitTillClickable(salir);
			FlowUtil.click(salir);
		}
		
	}

	public void waitTillInvisibilityofCargando() {
		WebElement cargando = DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@class='blockUI blockMsg blockPage']//img"));
		FlowUtil.waitTillInivisibility(cargando);
	}

}
