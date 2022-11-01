package TestCases.INFINITUS_API;

import java.sql.SQLException;

import CentaJava.Core.Reports;
import Pasos.Generales.AutorizadorInterno;
import Repositories.Repo_Variables;
import Tools.apiWorker;
import Tools.dbWorker;
import io.restassured.path.json.JsonPath;

public class TC_01_INFINITUS_API{
	private String Status;

	// Crédito - Local - Compra Manual 
	public boolean Test(Reports report, String name, String configEntidad, String enviroment) {
		//Validation var
		boolean result = true;
		try {	
			//Separador
			System.out.println("\r\n##################################################################################################################################################################################################################"
					+ "##################################################################################################################################################################################################################\r\n");

			System.out.println("Configuring " + name + "\r\n");

			//SET VARIABLES
			// Ruta donde se encuentra el archivo con el Body que se envia en el metodo Post
			String path = "./API_Requests/PrePagas/TC_Cuentas_Crear.txt";
			String base_url = JsonPath.from(enviroment).get("base_url");
			String producto = JsonPath.from(enviroment).get("producto");
			String base_uri = "https://"+ base_url + "/GP.Prepagas/Api/Productos/" + producto + "/Cuentas";
			String endPointToken = "https://"+ base_url + "/GP.IDS/connect/token";
			String token = "";
			String bodyData = "";
			String respBody = "";

			String responseIdCuenta = "";

			//SET INSTANCES
			apiWorker apiResp = new apiWorker();
			dbWorker oraResp = new dbWorker();
			Repo_Variables repoVar = new Repo_Variables();
			AutorizadorInterno AI = new AutorizadorInterno();

			//CONFIGURACIÓN DATABASE
			oraResp.setUser(JsonPath.from(configEntidad).get("DB.user"));
			oraResp.setPass(JsonPath.from(configEntidad).get("DB.pass"));
			oraResp.setEntidad(JsonPath.from(configEntidad).get("ENTIDAD.id_entidad"));
			oraResp.setHost(JsonPath.from(configEntidad).get("DB.host"));
			oraResp.setPort(JsonPath.from(configEntidad).get("DB.port"));
			oraResp.setSID(JsonPath.from(configEntidad).get("DB.SID"));

			//SET ENVIRONMENT
			AI.setEndpoint(repoVar, base_uri);

			System.out.println("<------ Initializating Test: " + name + " ------>\r\n");

			//GET TOKEN - NO ES NECESARIO EN AUT API
			System.out.println("##### EXTRACCION DE TOKEN #####");
			token = AI.getToken(report, apiResp, endPointToken, enviroment);
			//token = " ";

			System.out.println("##### EXTRACCION DE DATA BODY #####");			
			//GET POST BODY FROM FILE
			bodyData = AI.getBodyData(report, path);


			//POST - Con token y Body OK
			if (!bodyData.isEmpty() && !token.isEmpty())
			{
				System.out.println("##### EJECUCION DE POST CON EL TOKEN Y LA DATA DEL BODY #####");
				report.AddLine("##### EJECUCION DE POST CON EL TOKEN Y LA DATA DEL BODY #####");

				// Extraemos el response body y validamos el 200
				respBody = AI.post(report, repoVar, apiResp, bodyData, token, enviroment);

				System.out.println("##### EXTRACCION DE DATA JSON DEL RESPBODY #####");
				report.AddLine("##### EXTRACCION DE DATA JSON DEL RESPBODY #####");

				// Extraemos del responseData el valor de IdCuenta
				responseIdCuenta = JsonPath.from(respBody).getString("responseData.IdCuenta");
				System.out.println("##### VALOR OBTENIDO: " + responseIdCuenta + "#####");
				report.AddLine("##### VALOR OBTENIDO: " + responseIdCuenta + "#####");

				//VALIDACIONES
				result = validacionGral(oraResp, report, responseIdCuenta);		
				System.out.println("<------ Finished Test: " + name + " ------>\r\n");
				//Separador
				System.out.println("##################################################################################################################################################################################################################"
						+ "##################################################################################################################################################################################################################\r\n");

				// SIN POSTCONDICIONES
			} else {
				System.out.println("No se obtuvo un token o el body no existe");
				report.AddLineAssertionError("No se obtuvo un token o el body no existe\r\n");
				result = false;

				System.out.println("<------ Finished Test: " + name + " ------>\r\n");
				//Separador
				System.out.println("##################################################################################################################################################################################################################"
						+ "##################################################################################################################################################################################################################\r\n");
			}	

		} catch (Exception e) {
			e.printStackTrace();
			report.AddLineAssertionError(e.getStackTrace()[0].toString());
			report.AddLineAssertionError(e.getMessage());
			result = false;
		}
		return result;
	}

	private boolean validacionGral(dbWorker oraResp, Reports report, String idCuenta) throws SQLException {
		//Variables
		boolean result = true;
		String queryVerf;

		System.out.println("##### INICIO EJECUCION DE VALIDACIONES #####");
		report.AddLine("##### INICIO EJECUCION DE VALIDACIONES #####");

		//Primera Validación
		queryVerf = "select * from globalprod.tarjetapadron where solinume=" + idCuenta;

		primeraValidacion(oraResp, report, queryVerf);

		//Verificacion de todos los resultados obtenidos
		if (!Status.equals("P")) {
			report.AddLineAssertionError("===== " + Status + " =====");
			System.out.println("===== " + Status + " =====");
			result = false;
		}

		System.out.println("##### FIN DE EJECUCION DE VALIDACIONES #####");
		report.AddLine("##### FIN DE EJECUCION DE VALIDACIONES #####");
		return result;
	}

	private void primeraValidacion(dbWorker oraResp, Reports report, String query) throws SQLException {
		// Ejeciutamos el select con el dbWorker
		String respVerifBDD; 
		respVerifBDD = oraResp.oraOneQuery(query);

		//Validación Tiene que haber al menos 1 resultado
		if (!respVerifBDD.equals("0")) {
			report.AddLine("La verificacion responde con 1 o mas registros: " + respVerifBDD);
			System.out.println("PASS - La verificacion responde con 1 o mas registros " + respVerifBDD + "\r\n");
			Status = "P";
		}	else {
			report.AddLineAssertionError("La verificacion cuenta 0 registros: " + respVerifBDD);
			System.out.println("FAIL - La verificacion cuenta 0 registros: " + respVerifBDD + "\r\n");
			Status = "FAIL - No se generaron los datos correctamente";
		}
	}

}