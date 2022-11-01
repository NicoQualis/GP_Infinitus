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

public class TC_04_GO_PASOS_ADQ_700 {
	WebDriver driver;

	public void pagina1(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo) {

		report.AddLine("Se hace click en el boton NUEVO");
		System.out.println("Se hace click en el boton NUEVO\r\n");
		repo.get_obj_btnNuevo2().click();

	}

	public void pagina2(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo, String sysDate, String descripcion) throws InterruptedException {
		
		// Datos de la primer planilla de carga
		report.AddLine("Se carga la Descripción");
		System.out.println("Se carga la Descripción \r\n");
		repo.get_obj_inputTextByName("inputPagoDescripcion").sendKeys(descripcion);
		
		Thread.sleep(300);
		
		
		report.AddLine("Días de Plazo Crédito");
		System.out.println("Se carga Días de Plazo Crédito \r\n");
		repo.get_obj_inputTextByName("inputPagoDiasPlazo").sendKeys("5");
		
		Thread.sleep(300);
		
		report.AddLine("Se carga Tipo de Plazo * ");
		System.out.println("Se carga Tipo de Plazo *  \r\n");
		repo.get_obj_inputTextByName("inputPagoTipoPlazo").click();
		
		Thread.sleep(300);
		
		report.AddLine("Se carga Forma de Pago * ");
		System.out.println("Se carga Forma de Pago *  \r\n");
		repo.get_obj_selectOptionByName("selectPagoForma", "Transferencia Bancaria").click();
		
		Thread.sleep(300);
		
		report.AddLine(" Días de Plazo Débito * ");
		System.out.println("Se carga  Días de Plazo Débito *  \r\n");
		repo.get_obj_inputTextByName("inputPagoDiasPlazoDebito").sendKeys("5");
		
		Thread.sleep(300);
		
		report.AddLine(" Días de Plazo Prepaga * ");
		System.out.println("Días de Plazo Prepaga *  \r\n");
		repo.get_obj_inputTextByName("inputPagoDiasPlazoPrepaga").sendKeys("5");
		
		Thread.sleep(300);
		
		// Boton Guardar		
		
		report.AddLine("Se presiona el boton Guardar");
		System.out.println("Se presiona el boton Guardar\r\n");
		repo.get_obj_btnGuardar().click();

	}
	
	public void validar(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo) throws InterruptedException {

		report.AddLine("Validamos que sea Exitosa la operacion");
		System.out.println("Validamos que sea Exitosa la operacion\r\n");
		Thread.sleep(3000);
		report.validateObjectIsDisplayable(repo.get_obj_h1ConfirmacionExitosa());
		Thread.sleep(3000);
		repo.get_obj_h1ConfirmacionExitosa().click();
		
		Thread.sleep(2000);

		report.AddLine("Validacion exitosa");
		System.out.println("Validacion exitosa\r\n");
		report.Screenshot(name);

	}

}