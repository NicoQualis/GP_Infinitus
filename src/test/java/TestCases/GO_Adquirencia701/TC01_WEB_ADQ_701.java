package TestCases.GO_Adquirencia701;

import org.openqa.selenium.WebDriver;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Pasos.Generales.Acceso;
import Pasos.Generales.NavLateral;
import Pasos.Generales.NavSuperior;
import Repositories.Repo_WebRepository;

public class TC01_WEB_ADQ_701 {
	WebDriver driver;

	public boolean Test(Datasources data,Reports report, DriverManager DM, int iteration,String name) {
		//validation 
		boolean result = true;
		try {		
			
			//SEPARADOR
			System.out.println("\r\n##################################################################################################################################################################################################################"
			                   + "##################################################################################################################################################################################################################\r\n");
			
			
			System.out.println("Configuring TC_01_WEB_GO\r\n");

			//SELECT THE DRIVER AND PATH
			driver = DM.CreateDriver(DM.CHROME);
			report.SetDriver(driver);

			//SET THE REPOSITORIES TO USE
			Repo_WebRepository repo = new Repo_WebRepository();
			repo.setDriver(driver);

			//SET STEPS INSTANCES
			Acceso acceso = new Acceso();
			NavLateral menu = new NavLateral();
			NavSuperior nav = new NavSuperior();

			System.out.println("------ Initializating test: " + name + " ------\r\n");

			//SET THE URL
			driver.get("https://v2scanntech.web.qa.global.globalprocessing.net.ar/");

			//ADD THE STEPS BELOW
			// LOGIN
			report.AddLine("Acceso a la pagina de Global Online");
			System.out.println("Acceso a la pagina de Global Online\r\n");
			acceso.loginAdquirenciaUY(data, report, DM, iteration, name, repo);

			// NAVEGACION DEL MENU SIDEBAR
			menu.navegacion_lvl2(data, report, DM, iteration, name, repo, "Usuarios", "Gestión de Usuarios");


			// CERRAMOS LA SESION
			acceso.logout(data, report, DM, iteration, name, repo);

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

	private void WaitTime(int i) {
		try
		{
			Thread.sleep(i);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	} 
}