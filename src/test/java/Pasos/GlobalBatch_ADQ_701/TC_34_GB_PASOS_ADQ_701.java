package Pasos.GlobalBatch_ADQ_701;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_WebRepository;

public class TC_34_GB_PASOS_ADQ_701 {
	private WebDriverWait waitFor;

	public void pagina3(Reports report, Repo_WebRepository repo, DriverManager DM, String name) {

		report.AddLine("se ingresa identificador de comercio");
		System.out.println("se ingresa identificador de comercio");
		repo.get_obj_inputById("parametro_01").clear();
		repo.get_obj_inputById("parametro_01").sendKeys("8238");

		report.AddLine("Se ingresa Fecha de presentación");
		System.out.println("Se ingresa Fecha de presentación");
		repo.get_obj_inputById("parametro_02").clear();
		repo.get_obj_inputById("parametro_02").sendKeys("20220726");

		report.AddLine("Se ingresa el identificador de terminal");
		System.out.println("Se ingresa el identificador de terminal");
		repo.get_obj_inputById("parametro_03").clear();
		repo.get_obj_inputById("parametro_03").sendKeys("null");
		
		report.AddLine("Se hace click en el boton Lanzar");
		System.out.println("Se hace click en el boton Lanzar");
		repo.get_obj_btnConfirmacionLanzamiento().click();

		waitFor = new WebDriverWait(DM.getActualDriver(), 30);
		waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo.get_def_tituloConfirmacionLanzamiento())));
		//report.validateObjectIsDisplayable(repo.get_obj_tituloConfirmacionLanzamiento());

		report.Screenshot(name);
	}

	public void pagina4 (Reports report, Repo_WebRepository repo, DriverManager DM, String name) {

		// Boton Confirmar
		report.AddLine("Se hace click en el boton Confirmar");
		System.out.println("Se hace click en el boton Confirmar");
		repo.get_obj_btnLanzamiento().click();

		waitFor = new WebDriverWait(DM.getActualDriver(), 15);
		waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo.get_def_tituloProcesosEnEjecucion())));
		//report.validateObjectIsDisplayable(repo.get_obj_tituloProcesosEnEjecucion());

		report.Screenshot(name);		

	}

	public String pagina5 (Reports report, Repo_WebRepository repo, DriverManager DM, String name) {

		// Variables
		String runId;

		// Boton Confirmar
		report.AddLine("Se toma el RunID del Proceso en Ejecucion");
		System.out.println("Se toma el RunID del Proceso en Ejecucion");
		runId = repo.get_obj_lblRunIdRunning().getText();

		report.AddLine("Se obtuvo el RunID: " + runId);
		System.out.println("Se obtuvo el RunID: " + runId);

		return runId;
	}

	public String[] ValidacionesWeb (Reports report, Repo_WebRepository repo, DriverManager DM, String name, String runId) {

		// Variables
		String chkColor;
		String chkProcesado;
		String[] Status = new String[2];

		WebDriverWait wait = new WebDriverWait(DM.getActualDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo.get_def_lblRunIdRan(runId))));

		// Acciones
		try {

			if (report.validateObjectIsDisplayable(repo.get_obj_lblRunIdRan(runId))) {
				
				report.Screenshot(name);
				chkColor = repo.get_obj_iconRunIdRan(runId).getAttribute("style");
				chkProcesado = repo.get_obj_lblProcesadoRunIdRan(runId).getText();
			
				if (chkProcesado.equals("1/0")) {
					report.AddLine("Resultado Correcto. Se procesaron 1 Registros OK y 0 Errores");
					System.out.println("Resultado Correcto. Se procesaron 1 Registros OK y 0 Errores");
					Status[0] = "P";
				} else {
					report.AddLineAssertionError("Error - Se procesaron " + chkProcesado.split("/")[0] + " de 1 Registro y " + chkProcesado.split("/")[1] + " de 0 Errores");
					System.out.println("Error - Se procesaron " + chkProcesado.split("/")[0] + " de 1 Registro y " + chkProcesado.split("/")[1] + " de 0 Errores");
					Status[0] = "Fail - Se procesaron " + chkProcesado.split("/")[0] + " de 1 Registros y " + chkProcesado.split("/")[1] + " de 0 Errores";
				}
				
				switch(chkColor.split(";")[0]) {
				case "background: rgb(181, 235, 117)":
					report.AddLine("Resultado Correcto. El color de fondo es Verde");
					System.out.println("Resultado Correcto. El color de fondo es Verde");
					Status[1] = "P";
					break;
				case "background: rgb(252, 168, 77)":
					report.AddLineAssertionError("Error - El color de fondo es Naranja");
					System.out.println("Error - El color de fondo es Naranja");
					Status[1] = "Fail - Color de fondo es Naranja";
					break;
				case "background: rgb(252, 77, 77)":
					report.AddLineAssertionError("Error - El color de fondo es Rojo");
					System.out.println("Error - El color de fondo es Rojo");
					Status[1] = "Fail - Color de fondo es Rojo";
					break;
				default:
					Status[1] = "Fail - No es correcto es style del check: " + chkColor.split(";")[0];
				}
			}
		}catch(Exception e1) {
			System.out.println("No se encontro el runId");
			report.AddLineAssertionError("No se encontro el runId");
			Status[0] = "Fail - Excepcion en la ejecucion";
			Status[1] = "Fail - Excepcion en la ejecucion";
		}
		return Status;

	}

}