package Pasos.GlobalOnLine_ADQ_700;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_WebRepository;

public class TC_02_GO_PASOS_ADQ_700 {
	WebDriver driver;

	public void pagina1(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo) {

		report.AddLine("Se hace click en el boton NUEVO");
		System.out.println("Se hace click en el boton NUEVO\r\n");
		repo.get_obj_btnNuevo().click();

	}

	public void pagina2(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo, String sysDate, String cuit) throws InterruptedException {
		
		// Datos de la primer planilla de carga
		report.AddLine("Se carga el codigo tributario");
		System.out.println("Se carga el codigo tributario \r\n");
		repo.get_obj_inputTextByName("IdEstablecimiento").sendKeys(cuit);
		
		Thread.sleep(300);
		
		report.AddLine("Se carga la Posición Impositiva * ");
		System.out.println("Se carga la Posición Impositiva *  \r\n");
		repo.get_obj_selectOptionByName("IdPosicionImpositiva", "RESPONSABLE INSCRIPTO").click();
		
		Thread.sleep(300);
		
		report.AddLine("Se carga la Razón Social");
		System.out.println("Se carga la Razón Social \r\n");
		repo.get_obj_inputTextByName("RazonSocial").sendKeys("Establecimiento Automation");
		
		Thread.sleep(300);
		
		report.AddLine("Se carga la fecha de creacion");
		System.out.println("Se carga la fecha de creacion \r\n");
			
		
		repo.get_obj_inputTextByName("FechaCreacion").click();
		repo.get_obj_inputTextByName("FechaCreacion").sendKeys("28/01/2022");
		repo.get_obj_inputTextByName("FechaCreacion").sendKeys(Keys.ENTER);
		
		Thread.sleep(300);
		
		report.AddLine("Se carga la direccion");
		System.out.println("Se carga la direccion \r\n");
		repo.get_obj_inputTextByName("Domicilio.Direccion").sendKeys("Varela");
		
		Thread.sleep(300);
		
		report.AddLine("Se carga el numero");	
		System.out.println("Se carga el numero \r\n");
		repo.get_obj_inputTextByName("Domicilio.Numero").sendKeys("207");
		
		Thread.sleep(300);
		
		report.AddLine("Se carga el piso");	
		System.out.println("Se carga el piso \r\n");
		repo.get_obj_inputTextByName("Domicilio.Piso").sendKeys("1");
		
		Thread.sleep(300);
		
		report.AddLine("Se carga el depto");	
		System.out.println("Se carga el depto \r\n");
		repo.get_obj_inputTextByName("Domicilio.Depto").sendKeys("3");
		
		Thread.sleep(300);
		
		report.AddLine("Se carga el cp");	
		System.out.println("Se carga el cp \r\n");
		repo.get_obj_inputTextByName("Domicilio.IdCodigoPostal").sendKeys("1406");

		Thread.sleep(300);
		
		report.AddLine("Se carga el localidad");	
		System.out.println("Se carga el localidad \r\n");
		repo.get_obj_inputTextByName("Domicilio.Localidad").sendKeys("Flores");
		
		Thread.sleep(300);
		
		report.AddLine("Se carga la Posición Impositiva * ");
		System.out.println("Se carga la Posición Impositiva *  \r\n");
		repo.get_obj_selectOptionByName("Domicilio.IdProvincia", "CAPITAL FEDERAL").click();
		
		Thread.sleep(300);
		
		report.AddLine("Se carga el telefono");	
		System.out.println("Se carga el telefono \r\n");
		repo.get_obj_inputTextByName("Domicilio.Telefono").sendKeys("1122500166");
		
		Thread.sleep(300);
		
		// Boton siguiente
		report.AddLine("Se toca el boton siguiente");	
		System.out.println("Se toca el boton siguiente \r\n");
		repo.get_obj_btnSiguiente().click();
		
		Thread.sleep(30000);

	}

	public void pagina3(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo) throws InterruptedException {

		
		// Datos de la Tercer planilla de carga
		
		report.AddLine("Se carga el CUIL/RUT");
		System.out.println("Se carga el CUIL/RUT \r\n");
		repo.get_obj_inputTextByName("Responsable.Cuil").sendKeys("20957197834");
		
		report.AddLine("Se carga la Actividad");
		System.out.println("Se carga la Actividad \r\n");
		repo.get_obj_inputTextByName("Responsable.Actividad").sendKeys("Texto");	
		
		report.AddLine("Se carga el Nombre");
		System.out.println("Se carga el Nombre \r\n");
		repo.get_obj_inputTextByName("Responsable.Descripcion").sendKeys("Texto");	
		
		report.AddLine("Se carga el Cargo");
		System.out.println("Se carga el Cargo \r\n");
		repo.get_obj_inputTextByName("Responsable.Cargo").sendKeys("Texto");	
		
		report.AddLine("Se carga el Telefono");
		System.out.println("Se carga el Telefono \r\n");
		repo.get_obj_inputTextByName("Responsable.Telefono").sendKeys("Numero");	
		
		report.AddLine("Se carga el Email");
		System.out.println("Se carga el Email \r\n");
		repo.get_obj_inputTextByName("Responsable.Mail").sendKeys("a@a.com");
		
		report.AddLine("Se carga el Tipo de Documento *");
		System.out.println("Se carga el Tipo de Documento *  \r\n");
		repo.get_obj_selectOptionByName("Responsable.IdTIpoDocumento", "DNI").click();
		
		report.AddLine("Se carga el Numero de Documento");
		System.out.println("Se carga el Numero de Documento \r\n");
		repo.get_obj_inputTextByName("Responsable.NroDocumento").sendKeys("95719783");	
		
		report.AddLine("Se carga la Verificación Listado Terrorista *");
		System.out.println("Se carga la Verificación Listado Terrorista *  \r\n");
		repo.get_obj_selectOptionByName("Responsable.selectResponsableVerifListadoTerrorista", "No Verificado").click();
		
		report.AddLine("Se carga la Declaración Jurada sobre Condición de Persona Politícamente Expuesta *");
		System.out.println("Se carga la Declaración Jurada sobre Condición de Persona Politícamente Expuesta *  \r\n");
		repo.get_obj_selectOptionByName("Responsable.DdJjPep", "Sin DDJJ").click();
		
		report.AddLine("DDJJ Sujeto Obligado *");
		System.out.println("DDJJ Sujeto Obligado *  \r\n");
		repo.get_obj_selectOptionByName("Responsable.DdJjSo", "No aplica").click();
		//---
		report.AddLine("Se carga la Calle");
		System.out.println("Se carga la Calle \r\n");
		repo.get_obj_inputTextByName("Responsable.Direccion").sendKeys("Varela");	
		
		report.AddLine("Se carga el Numero");
		System.out.println("Se carga el Numero \r\n");
		repo.get_obj_inputTextByName("Responsable.Numero").sendKeys("207");	
		
		report.AddLine("Se carga el Piso");
		System.out.println("Se carga el Piso \r\n");
		repo.get_obj_inputTextByName("Responsable.Piso").sendKeys("1");	
		
		report.AddLine("Se carga el Depto");
		System.out.println("Se carga el Depto \r\n");
		repo.get_obj_inputTextByName("Responsable.Depto").sendKeys("3");	
		
		report.AddLine("Se carga el CP");
		System.out.println("Se carga el CP \r\n");
		repo.get_obj_inputTextByName("Responsable.IdCodigoPostal").sendKeys("1406");
		
		report.AddLine("Se carga la Localidad");
		System.out.println("Se carga la Localidad \r\n");
		repo.get_obj_inputTextByName("Responsable.Localidad").sendKeys("Flores");
		
		report.AddLine("Se carga La Provincia *");
		System.out.println("Se carga La Provincia *  \r\n");
		repo.get_obj_selectOptionByName("Responsable.IdProvincia", "CAPITAL FEDERAL").click();
		
		report.AddLine("Se carga el Telefono");
		System.out.println("Se carga el Telefono \r\n");
		repo.get_obj_inputTextByName3("Responsable.Telefono").sendKeys("1122500166");
		
		
		// Boton Guardar		
		
		report.AddLine("Se presiona el boton Guardar");
		System.out.println("Se presiona el boton Guardar\r\n");
		repo.get_obj_btnGuardar().click();
	}
	
	public void validar(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo) throws InterruptedException {

		report.AddLine("Validamos que sea Exitosa la operacion");
		System.out.println("Validamos que sea Exitosa la operacion\r\n");
		report.validateObjectIsDisplayable(repo.get_obj_h1ConfirmacionExitosa());
//		repo.get_obj_h1ConfirmacionExitosa().click();
		
		Thread.sleep(2000);

		report.AddLine("Validacion exitosa");
		System.out.println("Validacion exitosa\r\n");
		report.Screenshot(name);

	}

}