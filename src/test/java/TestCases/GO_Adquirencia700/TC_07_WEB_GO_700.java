package TestCases.GO_Adquirencia700;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Pasos.Generales.Acceso;
import Pasos.Generales.NavLateral;
import Pasos.GlobalOnLine_ADQ_700.TC_07_GO_PASOS_ADQ_700;
import Repositories.Repo_WebRepository;
import Tools.dbWorker;

public class TC_07_WEB_GO_700 {
	WebDriver driver;

	public boolean Test(Datasources data,Reports report, DriverManager DM, int iteration,String name, String configEntidad) {
		//validation 
		boolean result = true;
		try {		
			
			//SEPARADOR
			System.out.println("\r\n##################################################################################################################################################################################################################"
			                   + "##################################################################################################################################################################################################################\r\n");
			
			System.out.println("Configuring TC_07_WEB_GO\r\n");

			//SELECT THE DRIVER AND PATH
			driver = DM.CreateDriver(DM.CHROME);
			report.SetDriver(driver);

			//SET THE REPOSITORIES TO USE
			Repo_WebRepository repo = new Repo_WebRepository();
			repo.setDriver(driver);

			//SET STEPS INSTANCES
			Acceso acceso = new Acceso();
			NavLateral menu = new NavLateral();
			TC_07_GO_PASOS_ADQ_700 tc = new TC_07_GO_PASOS_ADQ_700();
			dbWorker oraResp = new dbWorker();
			
			// Carga de fecha de sistema
			DateTimeFormatter yearSystemDTF = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        String sysDate = yearSystemDTF.format(LocalDateTime.now()).replace("-", "/");
			
	        // VARIABLES
	        String altaArancel = "";
	        int rtaBorrar = 0;
	        
			System.out.println("------ Initializating test: " + name + " ------\r\n");

			//SET THE URL
			driver.get("https://v2adquirenciaarg.web.qa.global.globalprocessing.net.ar/");

			//ADD THE STEPS BELOW
			
			// PRECONDICIONES
			
			// Precondicion 1
			report.AddLine("### Inicio de Precondicion 1###");
			System.out.println("### Inicio de Precondicion 1###\r\n");
			
			rtaBorrar = oraResp.oraDelete("delete modelos_arancel_param where id_modelo_arancel in (select id_modelo_arancel from modelos_arancel where descripcion = 'Arancel Automation')");
			System.out.println(rtaBorrar);
			if(rtaBorrar > 0) {
				report.AddLine("Existia un registro de modelos_arancel_param");
				System.out.println("Existia un registro de modelos_arancel_para \r\n");
			} else {
				report.AddLineAssertionError(" Sin registros de modelos_arancel_para en la bdd ");
				System.out.println("Sin registros de modelos_arancel_para en la bdd ");
				result = false;
			}
			
			// Precondicion 2
			report.AddLine("### Inicio de Precondicion 2 ###");
			System.out.println("### Inicio de Precondicion 2 ###\r\n");
			
			rtaBorrar = oraResp.oraDelete("delete modelos_arancel where descripcion = 'Arancel Automation'");
			System.out.println(rtaBorrar);
			if(rtaBorrar > 0) {
				report.AddLine("Existia al menosn un registro de modelos_arancel en la bdd ");
				System.out.println("Existia al menos un registro de modelos_arancel en la bdd\r\n");
			} else {
				report.AddLineAssertionError(" Sin registros de modelos_arancel en la bdd ");
				System.out.println("Sin registros de modelos_arancel en la bdd ");
				result = false;
			}
			
			// NAVEGACION FRONTEND
			
			// LOGIN
			report.AddLine("Acceso a la pagina de Global Online");
			System.out.println("Acceso a la pagina de Global Online\r\n");
			acceso.loginAdquirenciaAR(data, report, DM, iteration, name, repo, configEntidad);

			// NAVEGACION DEL MENU SIDEBAR
			menu.navegacion_lvl4(data, report, DM, iteration, name, repo, "Adquirencia", "Comercios", "Parametría", "Modelos de Aranceles");

			// Página 1
			tc.pagina1(data, report, DM, iteration, name, repo);
			
			// Página 2
			tc.pagina2(data, report, DM, iteration, name, repo, sysDate);
			
			tc.validar(data, report, DM, rtaBorrar, altaArancel, repo);
			
			
			// CERRAMOS LA SESION
			acceso.logout(data, report, DM, iteration, name, repo);

			
			
			// BASE DE DATOS POST PRUEBA
			
			// VALIDACIONES
			
			// Validacion de prueba ejecutada correctamente
			report.AddLine("## Iniciando validacion.. ");
			System.out.println("## Iniciando validacion.. ");
			
			// VERICAR TEMA QUERY DE SELECT DE VALIDACION
			
			altaArancel = oraResp.oraOneQuery("select * from modelos_arancel where descripcion = 'Arancel Automation'");
			
			System.out.println(altaArancel);
			
			if (altaArancel.equals("1")) {
				
				report.AddLine("modelos_arancel creado correctamente en la BD.");
				System.out.println("modelos_arancel creado correctamente en la BD.\r\n");
				
			} else {
				report.AddLineAssertionError("Error al crear la modelos_arancel.");
				System.out.println("Error al crear la modelos_arancel. \r\n");
				result = false;
			}
			
			
			// Postcondicion - borrado de tabla estyablecimientos
			report.AddLine("## Iniciando Postcondicion ");
			System.out.println("## Iniciando Postcondicion.. ");
			
			rtaBorrar = oraResp.oraDelete("delete modelos_arancel where descripcion = 'Arancel Automation'");
			
			if(rtaBorrar > 0) {
				report.AddLine("Eliminación de los datos exitosa");
				System.out.println("Eliminación de los datos exitosa\r\n");
			} else {
				report.AddLineAssertionError("Error al eliminar el modelos_arancel; realizar su eliminación manual");
				System.out.println("Error al eliminar el modelos_arancel; realizar su eliminación manual\r\n");
				result = false;
			}
			
			
		System.out.println("------ Finished test: " + name + " ------\r\n");
			
		//SEPARADOR
		System.out.println("##################################################################################################################################################################################################################"
		                + "##################################################################################################################################################################################################################\r\n");

		} catch(Exception e) {
			e.printStackTrace();
			report.AddLineAssertionError(e.getMessage());			
			result = false;
		}
		//Try to erase the driver
		try {
			driver.quit();
		} catch(Exception e2) {
			//return the test result
		}
		return result;
	}

}