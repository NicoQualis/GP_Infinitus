
package TestCases.GB_Adquirencia700;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Pasos.Generales.Acceso;
import Pasos.Generales.GBatch;
import Pasos.GlobalBatch_ADQ_700.TC_53_GB_PASOS_ADQ_700;
import Repositories.Repo_WebRepository;
import Tools.dbWorker;
import io.restassured.path.json.JsonPath;

public class TC_53_WEB_GB_700 {
	private WebDriver driver;
	private dbWorker oraWorker;
	String[] Status = new String[4];

	public boolean Test(Datasources data, Reports report, DriverManager DM, int iteration, String name, String configEntidad) {
		//VARIABLES
		String user;
		String pass;
		String URL;
		String runId;

		//VALIDACION
		boolean result = true;

		try {
			//SEPARADOR
			System.out.println("\r\n##################################################################################################################################################################################################################"
					+ "##################################################################################################################################################################################################################\r\n");
			System.out.println("Configuring " + name + "\r\n");

			//SELECT THE DRIVER AND PATH
			driver = DM.CreateDriver(DM.CHROME);
			report.SetDriver(driver);

			//SET THE REPOSITORIES TO USE
			Repo_WebRepository repo = new Repo_WebRepository();
			repo.setDriver(driver);

			//SET STEPS INSTANCES
			Acceso acceso = new Acceso();
			GBatch gralBatch = new GBatch();
			TC_53_GB_PASOS_ADQ_700 pasos = new TC_53_GB_PASOS_ADQ_700();
			oraWorker = new dbWorker();

			//SET VARIABLES       
			URL = JsonPath.from(configEntidad).getString("GBATCH.url_gbatch");
			user = JsonPath.from(configEntidad).getString("GBATCH.user");
			pass = JsonPath.from(configEntidad).getString("GBATCH.pass");

			oraWorker.setUser(JsonPath.from(configEntidad).getString("DB.user"));
			oraWorker.setPass(JsonPath.from(configEntidad).getString("DB.pass"));
			oraWorker.setHost(JsonPath.from(configEntidad).getString("DB.host"));
			oraWorker.setEntidad(JsonPath.from(configEntidad).getString("ENTIDAD.id_entidad"));

			System.out.println("------ Initializating test: " + name + " ------\r\n");

			//PRECONDICIONES
			report.AddLine("##### INICIA EJECUCION DE PRECONDICIONES #####");
			System.out.println("##### INICIA EJECUCION DE PRECONDICIONES #####");
			execPreCondiciones(report,oraWorker);
			report.AddLine("##### FIN DE EJECUCION DE PRECONDICIONES #####");
			System.out.println("##### FIN DE EJECUCION DE PRECONDICIONES #####");


			System.out.println("##### INICIO EJECUCION DEL TESCT CASE #####");
			report.AddLine("##### INICIO EJECUCION DEL TEST CASE#####");
			//SET THE URL
			driver.get(URL);

			//ADD THE STEPS BELOW
			//LOGIN
			report.AddLine("Acceso a la pagina de Global Online");
			System.out.println("Acceso a la pagina de Global Online");
			//PASOS
			acceso.loginUsernameGB(data, report, DM, iteration, name, repo, user, pass);
			gralBatch.menuProcesos(report, repo, DM, name);
			gralBatch.buscarSeleccionar(report, repo, "Presentación Comercios", "700-Adquirencia Argentina");
			gralBatch.seleccionarLanzarProceso(report, repo, DM, name,  "Presentación Comercios");
			pasos.pagina3(report, repo, DM, name);
			pasos.pagina4(report, repo, DM, name);
			runId = pasos.pagina5(report, repo, DM, name);
			result = validacionesWeb(report, repo, DM, name, runId, pasos);
			//CERRAMOS LA SESION
			acceso.logOutAdqGB(data, report, DM, iteration, name, repo);

			report.AddLine("##### FIN DE EJECUCION DEL TEST CASE#####");
			System.out.println("##### FIN DE EJECUCION DEL TESCT CASE #####\r\n");

			//VALIDACIONES

			//POSTCONDICIONES

			System.out.println("------ Finished test: " + name + " ------\r\n");

			//SEPARADOR
			System.out.println("##################################################################################################################################################################################################################"
					+ "##################################################################################################################################################################################################################\r\n");

		} catch (Exception e) {
			e.printStackTrace();
			report.AddLineAssertionError(e.getMessage());
			result = false;
		} 
		//Try to erase the driver
		try {
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e2) {}

		return result;
	}

	private boolean validacionesWeb(Reports report, Repo_WebRepository repo, DriverManager DM, String name, String runId, TC_53_GB_PASOS_ADQ_700 pasos) {

		// Variables
		boolean result = true;
		String[] Status = new String[2];

		Status = pasos.ValidacionesWeb(report, repo, DM, name, runId);

		//Verificacion de todos los resultados obtenidos
		for (String estado : Status) {
			if (!estado.equals("P")) {
				report.AddLineAssertionError("===== " + estado + " =====");
				System.out.println("===== " + estado + " =====");
				result = false;
			}
		}
		return result;
	}


	private boolean execPreCondiciones(Reports report, dbWorker oraWorker) {
		//Variables
		boolean result = true;
		int index = 0;
		Connection conn;
		String queryPre;
		List<Integer> res = new ArrayList<Integer>();

		conn = oraWorker.getConn();
		
		//--UPDATE--
		//Acción 01 - 
		queryPre = "update autorizacion set fecha_relacion = sysdate where fecha_relacion is null and id_estado = '0' and id_comercio in ('8228')";
		res.add(oraWorker.oraUpdate(queryPre, conn));

		//Accion 02 - 
		queryPre = "update autorizacion_adquirente_log set presentacion_procesada = '1' where presentacion_procesada = '0' and in_cod_comercio_externo in ('8228')";
		res.add(oraWorker.oraUpdate(queryPre, conn));

		//Accion 03 - 
		queryPre = "update presentaciones set id_estado = '0' where id_estado != '0' and id_comercio in ('8228')";
		res.add(oraWorker.oraUpdate(queryPre, conn));

		oraWorker.getDisConn(conn);

		//Validación PRECONDICIONES
		for(Integer resultados : res) {
			if (resultados < 1) {
				index ++;
				report.AddLineAssertionError("===== Error en la acción: " + index + " =====");
				System.out.println("===== Error en la acción" + index + " =====");
				result = false;
			}
		}

		return result;

	}

}