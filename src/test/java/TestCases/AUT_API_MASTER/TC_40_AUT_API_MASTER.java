package TestCases.AUT_API_MASTER;

import static org.hamcrest.Matchers.equalTo;

import java.sql.SQLException;

import org.hamcrest.MatcherAssert;

import CentaJava.Core.Reports;
import Pasos.Generales.AutorizadorInterno;
import Repositories.Repo_Variables;
import Tools.apiWorker;
import Tools.dbWorker;
import io.restassured.path.json.JsonPath;

public class TC_40_AUT_API_MASTER{
	private String Status;

	public boolean Test(Reports report, String name, String configEntidad) {
		//Validation var
		boolean result = true;
		try {	
			//Separador
			System.out.println("\r\n##################################################################################################################################################################################################################"
					+ "##################################################################################################################################################################################################################\r\n");

			System.out.println("Configuring "+ name + "\r\n");

			//SET VARIABLES
			// Ruta donde se encuentra el archivo con el Body que se envia en el metodo Post
			String path = "./API_Requests/Autorizador/MASTER/TC_40_Debito_DevoluciónLocal_Ecommerce.txt";
			String pathPre = "./API_Requests/Autorizador/MASTER/PRE_ECOMMERCE_DEBITO_MC.txt";
			String[] resp = new String[2];
			String token = "";
			String bodyData = "";
			String respBody = "";
			String rrnLast6 = "0";
			String responseCodeData = "";

			//SET INSTANCES
			apiWorker apiResp = new apiWorker();
			dbWorker oraResp = new dbWorker();
			Repo_Variables repoVar = new Repo_Variables();
			AutorizadorInterno AI = new AutorizadorInterno();

			System.out.println("<------ Initializating Test: " + name + " ------>\r\n");

			//PRECONDICIONES
			System.out.println("##### INICIA EJECUCION DE PRECONDICIONES #####");
			report.AddLine("##### INICIA EJECUCION DE PRECONDICIONES #####");

			//SET ENVIRONMENT - PRECONDICIONES
			AI.setEndpoint(report, repoVar, "http://10.72.0.22:8293/approval/debit");

			bodyData = AI.getBodyData(report, pathPre);

			//GET POST BODY FROM PRECONDI
			resp = execPreCondicion(report, repoVar, AI, apiResp, bodyData, path, configEntidad);
			bodyData = resp[0];
			rrnLast6 = resp[1];

			System.out.println("##### FIN DE EJECUCION DE PRECONDICIONES #####");
			report.AddLine("##### FIN DE EJECUCION DE PRECONDICIONES #####");

			//GET TOKEN - NO ES NECESARIO EN AUT API
//			System.out.println("##### EXTRACCION DE TOKEN #####");
//			token = AI.getToken(report, apiResp);
			token = " ";

			//SET ENVIRONMENT - EXEC
			AI.setEndpoint(report, repoVar, "http://10.72.0.22:8293/Refund");

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
					rrnLast6 = rrnLast6.substring(rrnLast6.length() -6);
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
				} else {
					report.AddLineAssertionError("FAIL<br>responseCode: " + responseCodeData + " Se esperaba: 00");
					System.out.println("FAIL\r\nresponseCode: " + responseCodeData + " Se esperaba: 00\r\n");
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

	private String[] execPreCondicion(Reports report, Repo_Variables repoVar, AutorizadorInterno AI, apiWorker apiResp, String bodyData, String path, String configEntidad) throws Exception {
		//VARIABLES
		String rtaPost;
		String RespcodeData;
		String[] rta = new String[2];
		String newBodyData;

		//SE LEE EL BODY BASE
		newBodyData = AI.getBodyData(report, path);

		rtaPost = AI.post(report, repoVar, apiResp, bodyData, "", configEntidad);

		// Extraemos el responseCode que tiene que ser "00"
		RespcodeData = JsonPath.from(rtaPost).getString("responseData.responseCode");

		if (RespcodeData.equals("00")) {
			newBodyData = newBodyData
					.replace("{{dateTimeTransmission}}", JsonPath.from(rtaPost).getString("controlData.dateTimeTransmission"))
					.replace("{{dateTimeLocalTransaction}}", JsonPath.from(rtaPost).getString("controlData.dateTimeLocalTransaction"))
					.replace("{{stan}}", JsonPath.from(rtaPost).getString("controlData.stan"))
					.replace("{{amountTransaction}}", JsonPath.from(rtaPost).getString("financialData.amountTransaction"))
					.replace("{{transactionCurrencyCode}}", JsonPath.from(rtaPost).getString("financialData.transactionCurrencyCode"))
					.replace("{{terminalId}}", JsonPath.from(rtaPost).getString("terminalData.terminalId"))
					.replace("{{rrn}}", JsonPath.from(rtaPost).getString("responseData.rrn"))
					.replace("{{panNumber}}", JsonPath.from(rtaPost).getString("cardData.panNumber"))
					.replace("{{authorizationId}}", JsonPath.from(rtaPost).getString("responseData.authorizationId"));
		} else {
			report.AddLineAssertionError("FAIL<br>responseCode: " + RespcodeData + " Se esperaba: 00");
			System.out.println("##[warning] : FAIL : \r\nresponseCode: " + RespcodeData + " Se esperaba: 00\r\n");
			MatcherAssert.assertThat("Validacion del Status code", RespcodeData, equalTo("00"));
		}

		rta[0] = newBodyData;
		rta[1] = JsonPath.from(rtaPost).getString("responseData.rrn");

		return rta;
	}

	private boolean validacionGral(dbWorker oraResp, Reports report, String rrnLast6) throws SQLException {
		//Variables
		boolean result = true;
		String queryVerf;

		System.out.println("##### INICIO EJECUCION DE VALIDACIONES #####");
		report.AddLine("##### INICIO EJECUCION DE VALIDACIONES #####");

		//Primera Validación
		queryVerf = "select count (*) from autorizacion a\r\n"
				+ "inner join autorizacion_adquirente_log aal on a.id_autorizacion_adquirente = aal.id_autorizacion_adquirente\r\n"
				+ "inner join respuesta_mc_log rmc on a.id_autorizacion_adquirente = rmc.id_autorizacion_adquirente\r\n"
				+ "where a.id_autorizacion_adquirente = '" + rrnLast6 + "' and a.id_estado = 0 and a.modo_ingreso = 81";

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

		//Validación del Resultado - Tiene que ser igual a 1
				if (!respVerifBDD.equals("1")) {
					report.AddLineAssertionError("Cantidad de resultados: " + respVerifBDD.toString() + ". Se esperaba: 1");
					System.out.println("ID_Cantidad de resultados: " + respVerifBDD.toString() + ". Se esperaba: 1\r\n");
					Status = "FAIL - Validación del ID_ESTADO";
				}	else {
					report.AddLine("Resultado Correcto. Se esperaba " + respVerifBDD + " resultado");
					System.out.println("Resultado Correcto. Se esperaba " + respVerifBDD + " resultado\r\n");
					Status = "P";
				}
			}
}