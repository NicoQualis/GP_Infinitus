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

public class TC_31_AUT_API_MASTER{
	private String[] Status = new String[10];
	private String id_Auto;
	private String id_AutoAdq;

	public boolean Test(Reports report, String name, String configEntidad) {
		//Validation var
		boolean result = true;
		try {	
			//Separador
			System.out.println("\r\n##################################################################################################################################################################################################################"
					+ "##################################################################################################################################################################################################################\r\n");


			System.out.println("Configuring "+ name +"\r\n" );


			//SET VARIABLES 
			// Ruta donde se encuentra el archivo con el Body que se envia en el metodo Post

			String path = "./API_Requests/Autorizador/MASTER/TC_31_Debito_ReversoLocal_Manual.txt";

			String pathPre = "./API_Requests/Autorizador/MASTER/PRE_MANUAL_DEBITO_MC.TXT";
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
			
			//CONFIGURACIÓN DATABASE
			oraResp.setUser(JsonPath.from(configEntidad).get("DB.user"));
			oraResp.setPass(JsonPath.from(configEntidad).get("DB.pass"));
			oraResp.setEntidad(JsonPath.from(configEntidad).get("ENTIDAD.id_entidad"));
			oraResp.setHost(JsonPath.from(configEntidad).get("DB.host"));
			
			System.out.println("<------ Initializating Test: " + name + " ------>\r\n");
						
			//PRECONDICIONES
			System.out.println("##### INICIA EJECUCION DE PRECONDICIONES #####");
			report.AddLine("##### INICIA EJECUCION DE PRECONDICIONES #####");
			
			//SET ENVIRONMENT - PRECONDICIONES
			AI.setEndpoint(report, repoVar, "http://10.72.0.22:8293/approval/credit");
			
			bodyData = AI.getBodyData(report, pathPre);
			
			//GET POST BODY FROM PRECONDI
			resp = execPreCondicion(report, repoVar, AI, apiResp, bodyData, path, configEntidad);
			bodyData = resp[0];
			rrnLast6 = resp[1];
			
			System.out.println("##### FIN DE EJECUCION DE PRECONDICIONES #####\r\n");
			report.AddLine("##### FIN DE EJECUCION DE PRECONDICIONES #####");
			
			//GET TOKEN - NO ES NECESARIO EN AUT API
			//System.out.println("##### EXTRACCION DE TOKEN #####");
			//token = AI.getToken(report, apiResp);
			token = " ";

			//SET ENVIRONMENT - EXEC
			AI.setEndpoint(report, repoVar, "http://10.72.0.22:8293/approval/credit/reversal");

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
		queryVerf = "select id_estado, modo_ingreso, id_autorizacion, id_autorizacion_adquirente "
				+ "from autorizacion "
				+ "where id_autorizacion_adquirente = " + rrnLast6;
		
		primeraValidacion(oraResp, report, queryVerf);
		
		//Segunda Validación
		queryVerf = "select anular_reversar, id_auto_adq_anular_reversar, (-1) "
				+ "from autorizacion_adquirente_log "
				+ "where id_autorizacion_adquirente = " + rrnLast6;

		segundaValidacion(oraResp, report, queryVerf);
		
		//Tercera Validación
		queryVerf = "select  in_cod_procesamiento, id_tipo_autorizacion_adq_log, out_tipo_mensaje, id_autorizacion_original, id_auto_adq_origen "
				+ "from autorizacion_adquirente_log "
				+ "where id_autorizacion_adquirente in (select id_auto_adq_anular_reversar from autorizacion_adquirente_log where id_autorizacion_adquirente = " + rrnLast6 + ")";

		tercerValidacion(oraResp, report, queryVerf);
					
		//Cuarta Validación
		queryVerf = "select in_tipo_mensaje "
				+ "from respuesta_mc_log "
				+ "where id_autorizacion_adquirente in (select id_auto_adq_anular_reversar from autorizacion_adquirente_log where id_autorizacion_adquirente = " + rrnLast6 + ")";

		cuartaValidacion(oraResp, report, queryVerf);
		
		//Verificacion de todos los resultados obtenidos
		for (String estado : Status) {
			if (!estado.equals("P")) {
				report.AddLineAssertionError("===== " + estado + " =====");
				System.out.println("===== " + estado + " =====");
				result = false;
			}
		}
		
		System.out.println("##### FIN DE EJECUCION DE VALIDACIONES #####");
		report.AddLine("##### FIN DE EJECUCION DE VALIDACIONES #####");
		return result;
	}
	
	private void primeraValidacion(dbWorker oraResp, Reports report, String query) throws SQLException {
		// Ejeciutamos el select con el dbWorker
		String[] respVerifBDD = new String[4]; 
		respVerifBDD = oraResp.oraFourQuery(query);
				
		id_Auto = respVerifBDD[2];
		id_AutoAdq = respVerifBDD[3];

		//Validación del ID_ESTADO - Tiene que ser igual a 2
		if (!respVerifBDD[0].equals("2")) {
			report.AddLineAssertionError("ID_ESTADO: " + respVerifBDD[0].toString() + ". Se esperaba: 2");
			System.out.println("ID_ESTADO: " + respVerifBDD[0].toString() + ". Se esperaba: 2\r\n");
			Status[0] = "FAIL - Validación del ID_ESTADO";
		}	else {
			report.AddLine("Resultado Correcto. ID_ESTADO: " + respVerifBDD[0]);
			System.out.println("Resultado Correcto. ID_ESTADO: " + respVerifBDD[0] + "\r\n");
			Status[0] = "P";
		}

		//Validación del MODO_INGRESO - Tiene que ser igual a 01
		if (!respVerifBDD[1].equals("01")) {
			report.AddLineAssertionError("MODO_INGRESO: " + respVerifBDD[1] + ". Se esperaba: 01");
			System.out.println("MODO_INGRESO: " + respVerifBDD[1] + ". Se esperaba: 01\r\n");
			Status[1] = "FAIL - Validación del MODO_INGRESO";
		}	else {
			report.AddLine("Resultado Correcto. MODO_INGRESO: " + respVerifBDD[1]);
			System.out.println("Resultado Correcto. MODO_INGRESO: " + respVerifBDD[1] + "\r\n");
			Status[1] = "P";
		}
	}

	private void segundaValidacion(dbWorker oraResp, Reports report, String query) throws SQLException {
		// Ejeciutamos el select con el dbWorker
		String[] respVerifBDD = new String[2]; 
		respVerifBDD = oraResp.oraTwoQuery(query);

		//Validación de ANULAR_REVERSAR - Tiene que ser 'R'
		if (!respVerifBDD[0].equals("R")) {
			report.AddLineAssertionError("ANULAR_REVERSAR: " + respVerifBDD[0].toString() + ". Se esperaba: R");
			System.out.println("ANULAR_REVERSAR: " + respVerifBDD[0].toString() + ". Se esperaba: R\r\n");
			Status[2] = "FAIL - Validación de ANULAR_REVERSAR";
		}	else {
			report.AddLine("Resultado Correcto. ANULAR_REVERSAR: " + respVerifBDD[0].toString());
			System.out.println("Resultado Correcto. ANULAR_REVERSAR: " + respVerifBDD[0] + "\r\n");
			Status[2] = "P";
		}

		//Validación del ID_AUTO_ADQ_ANULAR_REVERSAR - Tiene que ser distinto de NULL
		if (respVerifBDD[1].equals("-1")) {
			report.AddLineAssertionError("La verificacion responde sin registros" + respVerifBDD[1]);
			System.out.println("La verificacion responde sin registros" + respVerifBDD[1] + "\r\n");
			Status[3] = "FAIL - Validación del ID_AUTO_ADQ_ANULAR_REVERSAR";
		}	else {
			report.AddLine("Resultado Correcto. ID_AUTO_ADQ_ANULAR_REVERSAR: " + respVerifBDD[1]);
			System.out.println("Resultado Correcto. ID_AUTO_ADQ_ANULAR_REVERSAR: " + respVerifBDD[1] + "\r\n");
			Status[3] = "P";
		}
	}

	private void tercerValidacion(dbWorker oraResp, Reports report, String query) throws SQLException {
		// Ejeciutamos el select con el dbWorker
		String[] respVerifBDD = new String[5]; 
		respVerifBDD = oraResp.oraFiveQuery(query);

		//Validación de IN_COD_PROCESAMIENTO - Tiene que ser: '000000'
		if (!respVerifBDD[0].equals("000000")) {
			report.AddLineAssertionError("IN_COD_PROCESAMIENTO: " + respVerifBDD[0] + ". Se esperaba: 000000");
			System.out.println("IN_COD_PROCESAMIENTO: " + respVerifBDD[0] + ". Se esperaba: 000000\r\n");
			Status[4] = "FAIL - Validación de IN_COD_PROCESAMIENTO";
		}	else {
			report.AddLine("Resultado Correcto. IN_COD_PROCESAMIENTO: " + respVerifBDD[0]);
			System.out.println("Resultado Correcto. IN_COD_PROCESAMIENTO: " + respVerifBDD[0] + "\r\n");
			Status[4] = "P";
		}

		//Validación del ID_TIPO_AUTORIZACION_ADQ_LOG - Tieme que ser: '9'
		if (!respVerifBDD[1].equals("9")) {
			report.AddLineAssertionError("ID_TIPO_AUTORIZACION_ADQ_LOG: " + respVerifBDD[1] + ". Se esperaba: 9");
			System.out.println("ID_TIPO_AUTORIZACION_ADQ_LOG: " + respVerifBDD[1] + ". Se esperaba: 9\r\n");
			Status[5] = "FAIL - Validación del ID_TIPO_AUTORIZACION_ADQ_LOG";
		}	else {
			report.AddLine("Resultado Correcto. ID_TIPO_AUTORIZACION_ADQ_LOG: " + respVerifBDD[1]);
			System.out.println("Resultado Correcto. ID_TIPO_AUTORIZACION_ADQ_LOG: " + respVerifBDD[1] + "\r\n");
			Status[5] = "P";
		}

		//Validación del OUT_TIPO_MENSAJE - Tiene que ser: '0400'
		if (!respVerifBDD[2].equals("0400")) {
			report.AddLineAssertionError("OUT_TIPO_MENSAJE: " + respVerifBDD[2] + ". Se esperaba: 0400");
			System.out.println("OUT_TIPO_MENSAJE: " + respVerifBDD[2] + ". Se esperaba: 0400\r\n");
			Status[6] = "FAIL - Validación del OUT_TIPO_MENSAJE";
		}	else {
			report.AddLine("Resultado Correcto. OUT_TIPO_MENSAJE: " + respVerifBDD[2]);
			System.out.println("Resultado Correcto. OUT_TIPO_MENSAJE: " + respVerifBDD[2] + "\r\n");
			Status[6] = "P";
		}

		//Validación del ID_AUTORIZACION_ORIGINAL - Tiene que ser: 'ID_AUTO'
		if (!respVerifBDD[3].equals(id_Auto)) {
			report.AddLineAssertionError("ID_AUTORIZACION_ORIGINAL: " + respVerifBDD[3] + ". Se esperaba: " + id_Auto);
			System.out.println("ID_AUTORIZACION_ORIGINAL: " + respVerifBDD[3] + ". Se esperaba: " + id_Auto + "\r\n");
			Status[7] = "FAIL - Validación del ID_AUTORIZACION_ORIGINAL";
		}	else {
			report.AddLine("Resultado Correcto. ID_AUTORIZACION_ORIGINAL: " + respVerifBDD[3]);
			System.out.println("Resultado Correcto. ID_AUTORIZACION_ORIGINAL: " + respVerifBDD[3] + "\r\n");
			Status[7] = "P";
		}

		//Validación del ID_AUTO_ADQ_ORIGEN - Tiene que ser: 'ID_AUTOADQ'
		if (!respVerifBDD[4].equals(id_AutoAdq)) {
			report.AddLineAssertionError("ID_AUTO_ADQ_ORIGEN: " + respVerifBDD[4] + ". Se esperaba: " + id_AutoAdq);
			System.out.println("ID_AUTO_ADQ_ORIGEN: " + respVerifBDD[4] + ". Se esperaba: " + id_AutoAdq + "\r\n");
			Status[8] = "FAIL - Validación del ID_AUTO_ADQ_ORIGEN";
		}	else {
			report.AddLine("Resultado Correcto. ID_AUTO_ADQ_ORIGEN: " + respVerifBDD[4]);
			System.out.println("Resultado Correcto. ID_AUTO_ADQ_ORIGEN: " + respVerifBDD[4] + "\r\n");
			Status[8] = "P";
		}
	}

	private void cuartaValidacion(dbWorker oraResp, Reports report, String query) throws SQLException {
		// Ejeciutamos el select con el dbWorker
		String respVerifBDD; 
		respVerifBDD = oraResp.oraOneQuery(query);

		//Validación de IN_TIPO_MENSAJE - Tiene que ser: '0410'
		if (!respVerifBDD.equals("0410")) {
			report.AddLineAssertionError("IN_TIPO_MENSAJE: " + respVerifBDD + ". Se esperaba: 0410");
			System.out.println("IN_TIPO_MENSAJE: " + respVerifBDD + ". Se esperaba: 0410\r\n");
			Status[9] = "FAIL - Validación de IN_TIPO_MENSAJE";
		}	else {
			report.AddLine("Resultado Correcto. IN_TIPO_MENSAJE: " + respVerifBDD);
			System.out.println("Resultado Correcto. IN_TIPO_MENSAJE: " + respVerifBDD + "\r\n");
			Status[9] = "P";
		}
	}
}