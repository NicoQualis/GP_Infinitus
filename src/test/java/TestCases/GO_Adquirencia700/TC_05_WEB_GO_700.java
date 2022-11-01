package TestCases.GO_Adquirencia700;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Pasos.Generales.Acceso;
import Pasos.Generales.NavLateral;
import Pasos.GlobalOnLine_ADQ_700.TC_05_GO_PASOS_ADQ_700;
import Repositories.Repo_WebRepository;
import Tools.dbWorker;

public class TC_05_WEB_GO_700 {
	WebDriver driver;

	public boolean Test(Datasources data,Reports report, DriverManager DM, int iteration,String name, String configEntidad) {
		//validation 
		boolean result = true;
		try {		
			
			//SEPARADOR
			System.out.println("\r\n##################################################################################################################################################################################################################"
			                   + "##################################################################################################################################################################################################################\r\n");
			
			System.out.println("Configuring TC_05_WEB_GO\r\n");

			//SELECT THE DRIVER AND PATH
			driver = DM.CreateDriver(DM.CHROME);
			report.SetDriver(driver);

			//SET THE REPOSITORIES TO USE
			Repo_WebRepository repo = new Repo_WebRepository();
			repo.setDriver(driver);

			//SET STEPS INSTANCES
			Acceso acceso = new Acceso();
			NavLateral menu = new NavLateral();
			TC_05_GO_PASOS_ADQ_700 tc = new TC_05_GO_PASOS_ADQ_700();
			dbWorker oraResp = new dbWorker();
			
			// Carga de fecha de sistema
			DateTimeFormatter yearSystemDTF = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        String sysDate = yearSystemDTF.format(LocalDateTime.now()).replace("-", "/");
			
	        // VARIABLES
	        String DAF = "Financiacion Automation";
	        String altaFinanciacion = "";
	        int rtaBorrar = 0;
	        
			System.out.println("------ Initializating test: " + name + " ------\r\n");

			//SET THE URL
			driver.get("https://v2adquirenciaarg.web.qa.global.globalprocessing.net.ar/");

			//ADD THE STEPS BELOW
			
			
			// PRECONDICIONES
			
			// Precondicion 1
			report.AddLine("### Inicio de Precondicion 1###");
			System.out.println("### Inicio de Precondicion 1###\r\n");
			
			rtaBorrar = oraResp.oraDelete("delete modelos_financ_com_param where id_mod_financ_comercio in (select id_mod_financ_comercio from modelos_financ_comercio where descripcion = 'Financiacion Automation')");
			System.out.println(rtaBorrar);
			if(rtaBorrar > 0) {
				report.AddLine("Existia un registro de modelos_financ_com_param (Pago Automation)");
				System.out.println("Existia un registro de modelos_financ_com_param (Pago Automation)\r\n");
			} else {
				report.AddLineAssertionError(" Sin registros de modelos_financ_com_param en la bdd (Pago Automation)");
				System.out.println("Sin registros de modelos_financ_com_param en la bdd (Pago Automation)");
				result = false;
			}
			
			/*/ Precondicion 2
			report.AddLine("### Inicio de Precondicion 2###");
			System.out.println("### Inicio de Precondicion 2###\r\n");
			
			rtaBorrar = oraResp.oraDelete("delete modelos_financ_comercio where descripcion = 'Financiacion Automation'");
			System.out.println(rtaBorrar);
			if(rtaBorrar > 0) {
				report.AddLine("Existia al menosn un registro de modelos_financ_comercio en la bdd (Financiacion Automation)");
				System.out.println("Existia al menos un registro de modelos_financ_comercio en la bdd(Financiacion Automation)\r\n");
			} else {
				report.AddLineAssertionError(" Sin registros de modelos_financ_comercio en la bdd (Financiacion Automation)");
				System.out.println("Sin registros de modelos_financ_comercio en la bdd (Financiacion Automation)");
				result = false;
			}*/
			
			// NAVEGACION FRONTEND
			// LOGIN
			report.AddLine("Acceso a la pagina de Global Online");
			System.out.println("Acceso a la pagina de Global Online\r\n");
			acceso.loginAdquirenciaAR(data, report, DM, iteration, name, repo, configEntidad);

			// NAVEGACION DEL MENU SIDEBAR
			menu.navegacion_lvl4(data, report, DM, iteration, name, repo, "Adquirencia", "Comercios", "Parametría", "Modelos de Financiación");

			// Página 1
			tc.pagina1(data, report, DM, iteration, name, repo);
			
			// Página 2
			tc.pagina2(data, report, DM, iteration, name, repo, sysDate);
			
			tc.validar(data, report, DM, rtaBorrar, altaFinanciacion, repo);
			
			
			// CERRAMOS LA SESION
			acceso.logout(data, report, DM, iteration, name, repo);

			
			
			// VALIDACION POR BDD
			
			// Validacion de prueba ejecutada correctamente
			report.AddLine("## Iniciando validacion.. ");
			System.out.println("## Iniciando validacion.. ");
			
			altaFinanciacion = oraResp.oraOneQuery("select descripcion from modelos_financ_comercio where descripcion = 'Financiacion Automation'");
			
			if (altaFinanciacion .equals(DAF)) {
				
				report.AddLine("modelos_financ_comercio creado correctamente en la BD.");
				System.out.println("modelos_financ_comercio creado correctamente en la BD.\r\n");
				
			} else {
				report.AddLineAssertionError("Error al crear la modelos_financ_comercio.");
				System.out.println("Error al crear la modelos_financ_comercio. \r\n");
				result = false;
			}
			
			
			
			// Postcondicion 
			report.AddLine("## Iniciando Postcondicion ");
			System.out.println("## Iniciando Postcondicion.. ");
			
			rtaBorrar = oraResp.oraDelete("delete modelos_financ_comercio where descripcion = 'Financiacion Automation'");
			
			if(rtaBorrar > 0) {
				report.AddLine("Eliminación de los datos exitosa");
				System.out.println("Eliminación de los datos exitosa\r\n");
			} else {
				report.AddLineAssertionError("Error al eliminar el modelos_financ_comercio; realizar su eliminación manual");
				System.out.println("Error al eliminar el modelos_financ_comercio; realizar su eliminación manual\r\n");
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