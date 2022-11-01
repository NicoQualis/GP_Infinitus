package TestCases.GO_Adquirencia700;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Pasos.Generales.Acceso;
import Pasos.Generales.NavLateral;
import Pasos.GlobalOnLine_ADQ_700.TC_02_GO_PASOS_ADQ_700;
//import Pasos.*;
import Repositories.Repo_WebRepository;
import Tools.dbWorker;

public class TC_02_WEB_GO_700 {
	WebDriver driver;

	public boolean Test(Datasources data, Reports report, DriverManager DM, int iteration, String name, String configEntidad) {
		//validation 
		boolean result = true;
		try {		
			
			//SEPARADOR
			System.out.println("\r\n##################################################################################################################################################################################################################"
			                   + "##################################################################################################################################################################################################################\r\n");
			
			System.out.println("Configuring TC_02_WEB_GO\r\n");

			//SELECT THE DRIVER AND PATH
			driver = DM.CreateDriver(DM.CHROME);
			report.SetDriver(driver);

			//SET THE REPOSITORIES TO USE
			Repo_WebRepository repo = new Repo_WebRepository();
			repo.setDriver(driver);

			//SET STEPS INSTANCES
			Acceso acceso = new Acceso();
			NavLateral menu = new NavLateral();
			TC_02_GO_PASOS_ADQ_700 tc = new TC_02_GO_PASOS_ADQ_700();
			dbWorker oraResp = new dbWorker();
			
			// Carga de fecha de sistema
			DateTimeFormatter yearSystemDTF = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        String sysDate = yearSystemDTF.format(LocalDateTime.now()).replace("-", "/");
			
	        // VARIABLES
	        String cuit = "209571978340";
	        String establecimientoCreado = "";
	        int rtaBorrar = 0;
	        
			System.out.println("------ Initializating test: " + name + " ------\r\n");

			//SET THE URL
			driver.get("https://v2adquirenciaarg.web.qa.global.globalprocessing.net.ar/");

			//ADD THE STEPS BELOW
			
			
			// PRECONDICION
			
			// LOGIN
			report.AddLine("Acceso a la pagina de Global Online");
			System.out.println("Acceso a la pagina de Global Online\r\n");
			acceso.loginAdquirenciaAR(data, report, DM, iteration, name, repo, configEntidad);

			// NAVEGACION DEL MENU SIDEBAR
			menu.navegacion_lvl2(data, report, DM, iteration, name, repo, "Adquirencia", "Gestión de Establecimientos");

			// Página 1
			tc.pagina1(data, report, DM, iteration, name, repo);
			
			// Página 2
			tc.pagina2(data, report, DM, iteration, name, repo, sysDate, cuit);
			
			// Página 3
			tc.pagina3(data, report, DM, iteration, name, repo);
			
			tc.validar(data, report, DM, rtaBorrar, establecimientoCreado, repo);
			
			// CERRAMOS LA SESION
			acceso.logout(data, report, DM, iteration, name, repo);

			
			
			// BASE DE DATOS POST PRUEBA
			
			// Validacion de prueba ejecutada correctamente
			
			establecimientoCreado = oraResp.oraOneQuery("select id_establecimiento from establecimientos where id_establecimiento = '"+cuit+"'");
			
			if (establecimientoCreado.equals("1")) {
				
				report.AddLine("Establecimiento creado correctamente en la BD.");
				System.out.println("Establecimiento creado correctamente en la BD.\r\n");
				
			} else {
				report.AddLineAssertionError("Error al crear la cuenta.");
				System.out.println("Error al crear la cuenta. \r\n");
				result = false;
			}
			
			
			
			// Postcondicion - borrado de tabla establecimientos
	
			rtaBorrar = oraResp.oraDelete("delete establecimientos where id_establecimiento = '"+cuit+"'");
			
			if(rtaBorrar > 0) {
				report.AddLine("Eliminación de los datos exitosa");
				System.out.println("Eliminación de los datos exitosa\r\n");
			} else {
				report.AddLineAssertionError("Error al eliminar el establecimiento; realizar su eliminación manual");
				System.out.println("Error al eliminar el establecimiento; realizar su eliminación manual\r\n");
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