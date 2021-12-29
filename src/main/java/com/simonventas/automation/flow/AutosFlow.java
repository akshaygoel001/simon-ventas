package com.simonventas.automation.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.simonventas.automation.commons.helpers.DriverFactory;
import com.simonventas.automation.commons.utils.DataUtil;
import com.simonventas.automation.commons.utils.ExcelReader;
import com.simonventas.automation.commons.utils.FlowUtil;
import com.simonventas.automation.commons.utils.Log;
import com.simonventas.automation.ui.AutosUI;

public class AutosFlow extends AutosUI{
	
	public ExcelReader dataExcel=DataUtil.dataExcel;
	public static Log log=new Log(AutosFlow.class.getName());
	

	public  void gotoAutos(int rowNum) {
		if(FlowUtil.elementIsDisplayed(page_error)) {
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum, page_error.getText().substring(0, 53));
			Assert.fail(page_error.getText());
		}
		else {
			FlowUtil.waitTillClickable(autos_main);
			FlowUtil.movetoElement(autos_main);
			FlowUtil.waitTillVisibility(autos_menu);
			FlowUtil.movetoElementandClick(autos_menu);
			log.info("Navigated to Autos Menu");
			waitTillInvisibilityofCargando();
			
		}	
	}
	
	public void enterMarcaPlaca(int rowNum,String agente,String codsubProducto,String placa, String marcaDesc) {
		/*if(FlowUtil.isElementPresent(page_error)) {
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum, "Serivce Error");
			Assert.fail("Service Error"+page_error.getText());
		}*/
		FlowUtil.clearvalue(clave);
		FlowUtil.click(clave);
		FlowUtil.sendvalue(clave, agente);
		FlowUtil.pressTab();
		waitTillInvisibilityofCargando();
		log.info("clave nombre:"+clave_nombre.getText());
		if(FlowUtil.elementIsDisplayed(clave_nombre)){
			FlowUtil.movetoElement(subproducto);
			if(!codsubProducto.equalsIgnoreCase("251")) {
				FlowUtil.selectByValue(subproducto, codsubProducto);
				waitTillInvisibilityofCargando();
			}
			if(placa.isEmpty()) {
				FlowUtil.movetoElement(marcaCheckbox);
				FlowUtil.javascriptClick(marcaCheckbox);
				FlowUtil.sendvalue(marcaDescription, marcaDesc);
				FlowUtil.pressTab();
				waitTillInvisibilityofCargando();
				if(FlowUtil.elementIsDisplayed(errorMarcaPlaca)) {
					dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum, errorMarcaPlaca.getText().substring(0, 53));
					Assert.fail(errorMarcaPlaca.getText());
				}
				else {
					FlowUtil.movetoElement(marcaConsultationTable);
					FlowUtil.click(firstmarca);
					FlowUtil.waitTillVisibility(modelo);
					FlowUtil.click(modelo);
					FlowUtil.acceptAlert();
					waitTillInvisibilityofCargando();
				}
			}
			else {
				//placa part
				FlowUtil.sendvalue(placa_campo, placa);
				FlowUtil.pressTab();
				waitTillInvisibilityofCargando();
				FlowUtil.waitTillVisibility(closeNuevoCheckPopup);
				waitTillInvisibilityofCargando();
				FlowUtil.click(closeNuevoCheckPopup);
			}
		}
		else if(FlowUtil.elementIsDisplayed(clave_service_error)) {
			FlowUtil.click(inicio);
			Assert.fail("clave service error");
		}
		
		
	}
	public void enterTomador(int rowNum,String nro_documento,String placa) {
		if(placa.isEmpty()) {
			waitTillInvisibilityofCargando();
			FlowUtil.sendvalue(nrodocumento, nro_documento);
			FlowUtil.pressTab();
			waitTillInvisibilityofCargando();
			if(FlowUtil.elementIsDisplayed(tomador_error)){
				log.info(DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='errorSpan']")).getText());
				if(FlowUtil.getText(tomador_no_existe).contains("Persona no existe")){
					FlowUtil.sendvalue(nombre, DataUtil.newTomadorNombre);
					FlowUtil.sendvalue(apellidos, DataUtil.newTomadorApellido);
				}else {
					dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum, tomador_error.getText().substring(0, 53));
					dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
					dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Fail");
					FlowUtil.takeFailedScreenshot("CrearCotizacion");
					FlowUtil.movetoElementandClick(inicio);
					Assert.fail("Error on Tomador Screen");
				}
			}
			FlowUtil.scrollToElement(autoriza_datos_chbx);
			FlowUtil.movetoElement(autoriza_datos_chbx);
			FlowUtil.javascriptClick(autoriza_datos_chbx);
			FlowUtil.click(continuar);
			FlowUtil.javascriptClick(siguiente1);
		}
		else {
			FlowUtil.scrollToElement(autoriza_datos_chbx);
			FlowUtil.movetoElement(autoriza_datos_chbx);
			FlowUtil.javascriptClick(autoriza_datos_chbx);
			FlowUtil.click(continuar);
			FlowUtil.javascriptClick(siguiente1);
		}
	}
	
	public void datosVehiculo(String placa,String placaByMarca) {
		if(placa.isEmpty()) {
			FlowUtil.click(siguiente2);
		}
		else {
			/*FlowUtil.sendvalue(placa_campo,placaByMarca);
			FlowUtil.pressTab();
			FlowUtil.acceptAlert();
			waitTillInvisibilityofCargando();
			FlowUtil.click(closeNuevoCheckPopup);*/
			FlowUtil.click(siguiente2);
		}
		
	}
	public void datosDelConductorHabitual() {
		FlowUtil.click(siguiente4);
	}
	
	public void datosDelBeneficiario() {
		FlowUtil.click(siguiente5);
	}
	
	public void deducibles() {
		FlowUtil.click(siguiente6);
	}
	
	public void crearCotizacion(int rowNum,String cobName) {
		FlowUtil.click(submit);
		waitTillInvisibilityofCargando();
		if(FlowUtil.isElementPresent(error)){
			log.info("Error is displayed on Crear Cotizacion:"+error.getText());
			//dataExcel.setCellData("Hogar", "Num_Cotizacion",rowNum ," ");
			//dataExcel.setCellData("Hogar", "Error", rowNum, " ");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion", rowNum, "");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum, error.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Fail");
			FlowUtil.takeFailedScreenshot("CrearCotizacion");
			FlowUtil.click(cancelar);
			Assert.fail("Error on Crear Cotizacion");
		}
		WebElement coverage=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//label[@for='cob"+cobName+"']"));
		FlowUtil.javascriptClick(coverage);
		FlowUtil.click(crearCotizacion);
		waitTillInvisibilityofCargando();
		if(FlowUtil.isElementPresent(quoteNo)) {
			log.info("Cotizacion No is : "+quoteNo.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion",rowNum , quoteNo.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum , "No");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "CotizacionPDF",rowNum,"Not Executed");
			FlowUtil.takeSuccessScreenshot("CrearCotizacion");
		}
		else if(FlowUtil.isElementPresent(error)){
			log.info("Error is displayed on Crear Cotizacion:"+error.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion", rowNum, "");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum, error.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Fail");
			FlowUtil.takeFailedScreenshot("CrearCotizacion");
			FlowUtil.click(cancelar);
			Assert.fail("Error on Crear Cotizacion");
		}
	}
	public void doEmitir(int rowNum,String color,String placa2,String motorVehiculo,String chasisVin,String tipoEnvioPoliza) {
		FlowUtil.click(emitir);
		waitTillInvisibilityofCargando();
		FlowUtil.click(alert);
		log.info("Emision Started");
		waitTillInvisibilityofCargando();
		FlowUtil.click(siguiente1);
		FlowUtil.scrollToElement(autoriza_datos_chbx);
		FlowUtil.movetoElement(autoriza_datos_chbx);
		FlowUtil.javascriptClick(autoriza_datos_chbx);
		FlowUtil.click(continuar);
		FlowUtil.javascriptClick(siguiente2);
		FlowUtil.click(siguiente3);
		FlowUtil.click(datos_beneficiario_continuar);
		FlowUtil.sendvalue(color_campo, color);
		FlowUtil.sendvalue(emission_placa_campo, placa2);
		FlowUtil.pressTab();
		waitTillInvisibilityofCargando();
		FlowUtil.sendvalue(motor, motorVehiculo);
		FlowUtil.sendvalue(chasis_vin, chasisVin);
		FlowUtil.click(siguiente5);
		FlowUtil.click(siguiente7);
		FlowUtil.click(siguiente10);
		FlowUtil.click(siguiente12);
		FlowUtil.selectByValue(tipo_envio_poliza,tipoEnvioPoliza);
		FlowUtil.click(submit);
		waitTillInvisibilityofCargando();
		
	}
	
	public void waitTillInvisibilityofCargando() {
		WebElement cargando=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@class='blockUI blockMsg blockPage']//img"));
		FlowUtil.waitTillInivisibility(cargando);
	}


}
