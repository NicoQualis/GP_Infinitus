package Pasos.GlobalOnLine_ADQ_700;

import java.util.ArrayList;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_WebRepository;

public class TC_03_GO_PASOS_ADQ_700 {
	WebDriver driver;

	public void pagina1(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo) {

		report.AddLine("Se hace click en el boton NUEVO");
		System.out.println("Se hace click en el boton NUEVO\r\n");
		repo.get_obj_btnNuevo().click();

	}

	public void pagina2(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo, String sysDate, String DMC) throws InterruptedException {
		
		// Datos de la primer planilla de carga
		report.AddLine("Se carga la descripcio�n");
		System.out.println("Se carga la descripci�n \r\n");
		repo.get_obj_inputTextByName("inputCierreDescripcion").sendKeys(DMC);
		
		Thread.sleep(300);
		
		report.AddLine("Se carga el Tratamiento de Feriados * ");
		System.out.println("Se carga el Tratamiento de Feriados *  \r\n");
		repo.get_obj_inputById("idInputCierreFeriados1").click();
		
		Thread.sleep(300);
		
		report.AddLine("Se carga el Tipo de Cierre * ");
		System.out.println("Se carga Tipo de Cierre *  \r\n");
		repo.get_obj_selectOptionByName("selectCierreTipo", "Diario").click();
		
		Thread.sleep(300);
		
		// Boton Guardar		
		
		report.AddLine("Se presiona el boton Guardar");
		System.out.println("Se presiona el boton Guardar\r\n");
		repo.get_obj_btnGuardar().click();

	}
	
	public void validar(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo) throws InterruptedException {
		Thread.sleep(2000);
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