package TestCases.AUT_API_MASTER;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CentaJava.Core.Reports;
import Pasos.Generales.AutorizadorInterno;
import Repositories.Repo_Variables;
import Tools.apiWorker;
import Tools.dbWorker;
import io.restassured.path.json.JsonPath;

public class TC_05_AUT_API_MASTER{
	private String Status;
	 
	// Crédito - Local - Compra Ecommerce
	public boolean Test(Reports report, String name, String configEntidad) {
		//Validation var
		boolean result = true;
		try {	
			//Separador
			System.out.println("\r\n##################################################################################################################################################################################################################"
							 + "##################################################################################################################################################################################################################\r\n");
			
			System.out.println("Configuring " + name + "\r\n");

			//SET VARIABLES
			// Ruta donde se encuentra el archivo con el Body que se envia en el metodo Post
			String path = "./API_Requests/Autorizador/MASTER/TC_46_Crédito_Compra Local_Ecommerce.txt";
			String token = "";
			String bodyData = "";
			String respBody = "";

			String responseCodeData = "";
			String rrn = "";
			String rrnLast6 = "";
			
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
			
			//SET ENVIRONMENT
			AI.setEndpoint(report, repoVar, "http://10.72.0.22:8293/approval/credit");

			System.out.println("<------ Initializating Test: " + name + " ------>\r\n");
			
			//GET TOKEN - NO ES NECESARIO EN AUT API
//			System.out.println("##### EXTRACCION DE TOKEN #####");
//			token = AI.getToken(report, apiResp);
			token = " ";
			
			System.out.println("##### EXTRACCION DE DATA BODY #####");
			
			//GET POST BODY FROM FILE
			bodyData = AI.getBodyData(report, path);

			
			//POST - Con token y Body OK
			if (!bodyData.isEmpty() && !token.isEmpty())
			{
				System.out.println("##### EJECUCION DE POST CON EL TOKEN Y LA DATA DEL BODY #####");
				report.AddLine("##### EJECUCION DE POST CON EL TOKEN Y LA DATA DEL BODY #####");
				
				// Extraemos el response body y validamos el 200
				respBody = AI.post(report, repoVar, apiResp, bodyData, token, configEntidad);
				
				System.out.println("##### EXTRACCION DE DATA JSON DEL RESPBODY #####");
				report.AddLine("##### EXTRACCION DE DATA JSON DEL RESPBODY #####");
				
				// Extraemos el responseCode que tiene que ser "00"
				responseCodeData = JsonPath.from(respBody).getString("responseData.responseCode");
				
				if (responseCodeData.equals("00")) {
					rrn = JsonPath.from(respBody).getString("responseData.rrn");
					rrnLast6 = rrn.substring(rrn.length() - 6);
					report.AddLine("Response code data OK: " + responseCodeData);
					System.out.println("Response code data OK: " + responseCodeData + "\r\n");
					//ESPERA PARA EL PROCESAMIENTO DEL REGISTRO EN EL BACKEND
					System.out.println("##### TRHEAD SLEEP MIENTRAS EL REGISTRO SE PROCESA EN EL BACKEND 8 SEGS #####");
					report.AddLine("##### TRHEAD SLEEP MIENTRAS EL REGISTRO SE PROCESA EN EL BACKEND 8 SEGS #####");
					Thread.sleep(8000);
					//VALIDACIONES
					report.AddLine("RRN last 6: " + rrnLast6);
					System.out.println("##[section] : RRN last 6: " + rrnLast6 + "\r\n");
					result = validacionGral(oraResp, report, rrnLast6);
					System.out.println("<------ Finished Test: " + name + " ------>\r\n");
					//Separador
					System.out.println("##################################################################################################################################################################################################################"
							+ "##################################################################################################################################################################################################################\r\n");

					// POSTCONDICIONES
					System.out.println("##### INICIA EJECUCION DE POSTCONDICIONES #####");
					report.AddLine("##### INICIA EJECUCION DE POSTCONDICIONES #####");

					execPostCondiciones(report, oraResp, rrnLast6);

					System.out.println("##### FIN DE EJECUCION DE POSTCONDICIONES #####");
					report.AddLine("##### FIN DE EJECUCION DE POSTCONDICIONES #####");		
				} else {
					report.AddLineAssertionError("Response code data FAIL!!: " + responseCodeData);
					System.out.println("Response code data FAIL!!: " + responseCodeData + "\r\n");
					result = false;
				}
				
				// POSTCONDICION
								
			} else {
				System.out.println("No se obtuvo un token o el body no existe");
				report.AddLineAssertionError("No se obtuvo un token o el body no existe\r\n");
				result = false;
			}	
			
			System.out.println("<------ Finished Test: " + name + " ------>\r\n");
			
			//Separador
			System.out.println("##################################################################################################################################################################################################################"
					 + "##################################################################################################################################################################################################################\r\n");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			report.AddLineAssertionError(e.getStackTrace()[0].toString());
			report.AddLineAssertionError(e.getMessage());
			result = false;
		}

		return result;

	}
	
	private boolean validacionGral(dbWorker oraResp, Reports report, String rrnLast6) throws SQLException {
		//Variables
		boolean result = true;
		String queryVerf;

		System.out.println("##### INICIO EJECUCION DE VALIDACIONES #####");
		report.AddLine("##### INICIO EJECUCION DE VALIDACIONES #####");

		//Primera Validación
		queryVerf = "select count(*) from autorizacion a \r\n"
				+ "inner join autorizacion_adquirente_log aal on a.id_autorizacion_adquirente = aal.id_autorizacion_adquirente \r\n"
				+ "inner join respuesta_mc_log r on a.id_autorizacion_adquirente = r.id_autorizacion_adquirente \r\n"
				+ "where a.id_autorizacion_adquirente = '" + rrnLast6 + "' and a.modo_ingreso = '81' and a.id_marca = '1'";

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
	private boolean execPostCondiciones(Reports report, dbWorker oraResp, String rrnLast6) {

		boolean result = true;
		int index = 0;
		Connection conn;
		String queryPost;
		List<Integer> res = new ArrayList<Integer>();

		// Connectamos la BD
		conn = oraResp.getConn();

		// ACCION 01 - TABLA AUTORIZACION
		queryPost = "delete from  autorizacion where id_autorizacion_adquirente = " + rrnLast6;
		res.add(oraResp.oraDelete(queryPost, conn));

		// ACCION 02 - TABLA respuesta_mc_log
		queryPost = "delete from respuesta_mc_log where id_autorizacion_adquirente = " + rrnLast6;
		res.add(oraResp.oraDelete(queryPost, conn));
		
		// ACCION 03 - TABLA autorizacion_adquirente_log
		queryPost = "delete from autorizacion_adquirente_log where id_autorizacion_adquirente = " + rrnLast6;
		res.add(oraResp.oraDelete(queryPost, conn));
		
		oraResp.getDisConn(conn);

		// Validacion PRECONDICIONES
		for (Integer resultados : res) {
			if (resultados < 1) {
				index++;
				report.AddLineAssertionError("===== Error en la accion: " + index + " =====");
				System.out.println("===== Error en la accion: " + index + " =====");
				result = false;
			}
		}

		return result;

	}


}