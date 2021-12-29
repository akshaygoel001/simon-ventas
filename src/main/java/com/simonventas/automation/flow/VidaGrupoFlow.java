package com.simonventas.automation.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.simonventas.automation.commons.helpers.DriverFactory;
import com.simonventas.automation.commons.utils.DataUtil;
import com.simonventas.automation.commons.utils.ExcelReader;
import com.simonventas.automation.commons.utils.FlowUtil;
import com.simonventas.automation.commons.utils.Log;
import com.simonventas.automation.ui.VidaGrupoUI;

public class VidaGrupoFlow extends VidaGrupoUI{
	
	public ExcelReader dataExcel=DataUtil.dataExcel;
	public static Log log=new Log(VidaGrupoFlow.class.getName());
	
	public void gotoVidaGrupo(int rowNum) {
		if(FlowUtil.elementIsDisplayed(page_error)) {
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum, page_error.getText().substring(0, 53));
			Assert.fail(page_error.getText());
		}
		else {
			FlowUtil.waitTillClickable(vidagrupo_main);
			FlowUtil.movetoElement(vidagrupo_main);
			FlowUtil.waitTillVisibility(cotiacionPolizaHija_menu);
			FlowUtil.movetoElementandClick(cotiacionPolizaHija_menu);
			log.info("Navigated to Cotiacion Poliza Hija Menu");
		}	
	}
	public void selectProducto(int rowNum,String agente,String codProd,String principalPol,String tipoDocumento,String numeroDocumento) {
		waitTillInvisibilityofCargando();
		if(FlowUtil.elementIsDisplayed(page_error)) {
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum, "Serivce Error");
			Assert.fail("Service Error"+page_error.getText());
		}
		FlowUtil.clearvalue(clave);
		FlowUtil.sendvalue(clave, agente);
		FlowUtil.pressTab();
		waitTillInvisibilityofCargando();
		FlowUtil.selectByValue(producto, codProd);
		FlowUtil.sendvalue(polizaPrinipal, principalPol);
		FlowUtil.selectByValue(tipoDoc, tipoDocumento);
		FlowUtil.sendvalue(numDoc, numeroDocumento);
		FlowUtil.movetoElement(buscar);
		FlowUtil.click(buscar);
		waitTillInvisibilityofCargando();
		FlowUtil.movetoElement(cotizacionTable);
		FlowUtil.javascriptClick(cotizacionTable);
		FlowUtil.acceptAlert();
		waitTillInvisibilityofCargando();
	}
	public void enterAsegurado(int rowNum,String numDoc) {
		FlowUtil.movetoElement(asegNumDoc);
		FlowUtil.sendvalue(asegNumDoc, numDoc);
		FlowUtil.pressTab();
		waitTillInvisibilityofCargando();
		if(FlowUtil.isElementPresent(tomador_error)){
			log.info(tomador_error.getText());
			if(tomador_error.getText().contains("Persona no existe")){
				FlowUtil.sendvalue(nombre, DataUtil.newTomadorNombre);
				FlowUtil.sendvalue(apellidos, DataUtil.newTomadorApellido);
			}else {
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum, tomador_error.getText());
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Fail");
				FlowUtil.takeFailedFullPageScreenshot("CrearCotizacion");
				FlowUtil.movetoElementandClick(inicio);
				Assert.fail("Error on Tomador Screen");
			}
		}
		FlowUtil.movetoElement(liquidarPrima);
		FlowUtil.javascriptClick(liquidarPrima);
		waitTillInvisibilityofCargando();
	}
	public void adicionarRiesgo() {
		FlowUtil.movetoElement(addRiesgo);
		FlowUtil.javascriptClick(addRiesgo);
		waitTillInvisibilityofCargando();
	}
	public void crearCotizacion() {
		FlowUtil.movetoElement(crearCotizacion);
		FlowUtil.click(crearCotizacion);
		waitTillInvisibilityofCargando();
	}
	
	public void waitTillInvisibilityofCargando() {
		WebElement cargando=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@class='blockUI blockMsg blockPage']//img"));
		FlowUtil.waitTillInivisibility(cargando);
	}

}
