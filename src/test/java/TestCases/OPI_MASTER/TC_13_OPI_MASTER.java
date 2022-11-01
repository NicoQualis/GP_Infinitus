package TestCases.OPI_MASTER;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

import org.hamcrest.MatcherAssert;

import CentaJava.Core.Reports;
import Tools.dbWorker;
import Tools.sshWorker;
import io.restassured.path.json.JsonPath;

public class TC_13_OPI_MASTER {
	private String[] Status = new String[11];
	private String id_Auto;
	private String id_AutoAdq;
	
	public boolean Test(Reports report, String name, String configEntidad) {
		//Validation var
		boolean result = true;
		try {		
			//Separador
			System.out.println("\r\n##################################################################################################################################################################################################################"
					+ "##################################################################################################################################################################################################################\r\n");

			System.out.println("Configuring " + name + "\r\n");

			//Set Variables
			String[] res = new String[2];
			String f37Last6 = "0";
			String xmlFileCreate;
			//Set Reusltados Esperados
			String de39 = "00";

			//Instancias
			sshWorker opiCmd = new sshWorker();
			dbWorker oraResp = new dbWorker();	
			
			//SET dbWorker
			oraResp.setUser(JsonPath.from(configEntidad).getString("DB.user"));
			oraResp.setPass(JsonPath.from(configEntidad).getString("DB.pass"));
			oraResp.setHost(JsonPath.from(configEntidad).getString("DB.host"));
			oraResp.setEntidad(JsonPath.from(configEntidad).getString("ENTIDAD.id_entidad"));

			System.out.println("##[command] : <------ Initializating Test: " + name + " ------>\r\n");
			report.AddLine("<------ Initializating Test: " + name + " ------>");
			
			//PRECONDICIONES
			System.out.println("##### INICIA EJECUCION DE PRECONDICIONES #####");
			report.AddLine("##### INICIA EJECUCION DE PRECONDICIONES #####");

			//Creación del XML a subir
			xmlFileCreate = execPreCondicion(report, configEntidad, opiCmd, "PRE_CHIP_MC.xml", "MASTER/TC_13_MC.xml");
			
			//Enviar a OPI el archivo generado
			opiCmd.sshSendCmdCreateXml(report, xmlFileCreate, configEntidad, "opi4qa", "TC_13_MC.xml");
			
			System.out.println("##### FIN DE EJECUCION DE PRECONDICIONES #####");
			report.AddLine("##### FIN DE EJECUCION DE PRECONDICIONES #####");
			
			//EJECUCION OPI
			System.out.println("##### INICIO EJECUCION OPI #####");
			report.AddLine("##### INICIO EJECUCION OPI #####");
			
			res = opiCmd.sshSendCmdGetDE37(report, "TC_13_MC.xml", configEntidad, "opi4qa");

			if (res[0].equals(de39))
			{
				f37Last6 = res[1].substring(res[1].length() -6);
				report.AddLine("Ejecucion Correcta<br>DE39: " + res[0]);
				System.out.println("##[section] : Ejecucion Correcta\r\nDE39: " + res[0] + "\r\n");
				//VALIDACIONES
				report.AddLine("Field 37 last 6: " + f37Last6);
				System.out.println("##[section] : Field 37 last 6: " + f37Last6 + "\r\n");
				result = validacionGral(oraResp, report, f37Last6);
			} else {
				report.AddLineAssertionError("FAIL<br>DE39: " + res[0] + " Se esperaba: " + de39);
				System.out.println("##[warning] : FAIL : \r\nDE39: " + res[0] + " Se esperaba: " + de39 + "\r\n");
				result = false;
			}

			System.out.println("##### FIN DE EJECUCION OPI #####");
			report.AddLine("##### FIN DE EJECUCION OPI #####");
			
			// POSTCONDICION
			
			//Separador
			System.out.println("##################################################################################################################################################################################################################"
					+ "##################################################################################################################################################################################################################\r\n");


		} catch (Exception e) {
			report.AddLine("Error:<br>" + e);
			System.out.println("##[warning] : Error:\r\n" + e);
			result = false;
		}

		return result;
	}

	private String execPreCondicion(Reports report, String configEntidad, sshWorker opiCmd, String xmlPreFile, String xmlFileRead) throws IOException {
		//VARIABLES
		String[] rta = new String[3];
		String DE37;
		String DE38;
		String DE39 = "00";
		String xmlFile;
		
		//Se lee el archivo del TC
		xmlFile = Files.readString(Paths.get("./OPI_Files/" + xmlFileRead));
		
		//Se obtienen los datos de la precondición
		rta = opiCmd.sshPreCondi(report, xmlPreFile, configEntidad, "opi4qa");

		//Se verifica la correcta ejecución y se generan los datos
		if (rta[0].equals("00"))
		{
			DE37 = rta[1];
			DE38 = rta[2];
			report.AddLine("Ejecucion Correcta<br>DE39: " + rta[0]);
			System.out.println("##[section] : Ejecucion Correcta\r\nDE37: " + DE37 + "\r\n");
			System.out.println("##[section] : Ejecucion Correcta\r\nDE38: " + DE38 + "\r\n");
			xmlFile = xmlFile.replace("{{DE37}}", DE37).replace("{{DE38}}", DE38);
		} else {
			report.AddLineAssertionError("FAIL<br>DE39: " + rta[0] + " Se esperaba: " + DE39);
			System.out.println("##[warning] : FAIL : \r\nDE39: " + rta[0] + " Se esperaba: " + DE39 + "\r\n");
			MatcherAssert.assertThat("Resultado DE39", rta[0], equalTo("00"));
		}
	
		System.out.println("Contenido xmlBase:\r\n" + xmlFile);
		
		return xmlFile;
	}
	
	private boolean validacionGral(dbWorker oraResp, Reports report, String f37Last6) throws SQLException {
		//Variables
		boolean result = true;
		String queryVerf;
		
		System.out.println("##### INICIO EJECUCION DE VALIDACIONES #####");
		report.AddLine("##### INICIO EJECUCION DE VALIDACIONES #####");
		
		//Primera Validación
		queryVerf = "select id_estado, modo_ingreso, id_marca, id_autorizacion, id_autorizacion_adquirente from autorizacion where id_autorizacion_adquirente = "  + f37Last6;
		
		primeraValidacion(oraResp, report, queryVerf);
		
		//Segunda Validación
		queryVerf = "select anular_reversar, COALESCE(id_auto_adq_anular_reversar, (-1)) from autorizacion_adquirente_log where id_autorizacion_adquirente = " + f37Last6;

		segundaValidacion(oraResp, report, queryVerf);
		
		//Tercera Validación
		queryVerf = "select  in_cod_procesamiento, in_modo_ingreso_terminal, id_tipo_autorizacion_adq_log, out_tipo_mensaje, id_autorizacion_original, id_auto_adq_origen "
				+ "from autorizacion_adquirente_log "
				+ "where id_autorizacion_adquirente in (select id_auto_adq_anular_reversar from autorizacion_adquirente_log where id_autorizacion_adquirente = " + f37Last6 + ")";

		tercerValidacion(oraResp, report, queryVerf);
					
		//Cuarta Validación
		queryVerf = "select in_tipo_mensaje from respuesta_mc_log "
				+ "where id_autorizacion_adquirente in (select id_auto_adq_anular_reversar from autorizacion_adquirente_log where id_autorizacion_adquirente = " + f37Last6 + ")";

		cuartaValidacion(oraResp, report, queryVerf);
		
		//Verificacion de todos los resultados obtenidos
		for (String estado : Status) {
			if (!estado.equals("P")) {
				report.AddLine("===== " + estado + " =====");
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
		String[] respVerifBDD = new String[5]; 
		respVerifBDD = oraResp.oraFiveQuery(query);
		
		id_Auto = respVerifBDD[3];
		id_AutoAdq = respVerifBDD[4];

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

		//Validación del MODO_INGRESO - Tiene que ser igual a 05
		if (!respVerifBDD[1].equals("05")) {
			report.AddLine("MODO_INGRESO: " + respVerifBDD[1] + ". Se esperaba: 05");
			System.out.println("MODO_INGRESO: " + respVerifBDD[1] + ". Se esperaba: 05\r\n");
			Status[1] = "FAIL - Validación del MODO_INGRESO";
		}	else {
			report.AddLine("Resultado Correcto. MODO_INGRESO: " + respVerifBDD[1]);
			System.out.println("Resultado Correcto. MODO_INGRESO: " + respVerifBDD[1] + "\r\n");
			Status[1] = "P";
		}

		//Validación del ID_MARCA - Tiene que ser igual a 1
		if (!respVerifBDD[2].equals("1")) {
			report.AddLine("ID_MARCA: " + respVerifBDD[2] + ". Se esperaba: 1");
			System.out.println("ID_MARCA: " + respVerifBDD[2] + ". Se esperaba: 1\r\n");
			Status[2] = "FAIL - Validación del ID_MARCA";
		}	else {
			report.AddLine("Resultado Correcto. ID_MARCA: " + respVerifBDD[2]);
			System.out.println("Resultado Correcto. ID_MARCA: " + respVerifBDD[2] + "\r\n");
			Status[2] = "P";
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
			Status[3] = "FAIL - Validación de ANULAR_REVERSAR";
		}	else {
			report.AddLine("Resultado Correcto. ANULAR_REVERSAR: " + respVerifBDD[0].toString());
			System.out.println("Resultado Correcto. ANULAR_REVERSAR: " + respVerifBDD[0] + "\r\n");
			Status[3] = "P";
		}

		//Validación del ID_AUTO_ADQ_ANULAR_REVERSAR - Tiene que ser distinto de NULL
		if (respVerifBDD[1].equals("-1")) {
			report.AddLineAssertionError("La verificacion responde sin registros - " + respVerifBDD[1]);
			System.out.println("La verificacion responde sin registros - " + respVerifBDD[1] + "\r\n");
			Status[4] = "FAIL - Validación del ID_AUTO_ADQ_ANULAR_REVERSAR";
		}	else {
			report.AddLine("Resultado Correcto. ID_AUTO_ADQ_ANULAR_REVERSAR: " + respVerifBDD[1]);
			System.out.println("Resultado Correcto. ID_AUTO_ADQ_ANULAR_REVERSAR: " + respVerifBDD[1] + "\r\n");
			Status[4] = "P";
		}
	}

	private void tercerValidacion(dbWorker oraResp, Reports report, String query) throws SQLException {
		// Ejeciutamos el select con el dbWorker
		String[] respVerifBDD = new String[6]; 
		respVerifBDD = oraResp.oraSixQuery(query);

		//Validación de IN_COD_PROCESAMIENTO - Tiene que ser: '000000'
		if (!respVerifBDD[0].equals("000000")) {
			report.AddLineAssertionError("IN_COD_PROCESAMIENTO: " + respVerifBDD[0] + ". Se esperaba: 000000");
			System.out.println("IN_COD_PROCESAMIENTO: " + respVerifBDD[0] + ". Se esperaba: 000000\r\n");
			Status[5] = "FAIL - Validación de IN_COD_PROCESAMIENTO";
		}	else {
			report.AddLine("Resultado Correcto. IN_COD_PROCESAMIENTO: " + respVerifBDD[0]);
			System.out.println("Resultado Correcto. IN_COD_PROCESAMIENTO: " + respVerifBDD[0] + "\r\n");
			Status[5] = "P";
		}

		//Validación del ID_TIPO_AUTORIZACION_ADQ_LOG - Tieme qie ser: '9'
		if (!respVerifBDD[2].equals("9")) {
			report.AddLine("ID_TIPO_AUTORIZACION_ADQ_LOG: " + respVerifBDD[2] + ". Se esperaba: 9");
			System.out.println("ID_TIPO_AUTORIZACION_ADQ_LOG: " + respVerifBDD[2] + ". Se esperaba: 9\r\n");
			Status[6] = "FAIL - Validación del ID_TIPO_AUTORIZACION_ADQ_LOG";
		}	else {
			report.AddLine("Resultado Correcto. ID_TIPO_AUTORIZACION_ADQ_LOG: " + respVerifBDD[2]);
			System.out.println("Resultado Correcto. ID_TIPO_AUTORIZACION_ADQ_LOG: " + respVerifBDD[2] + "\r\n");
			Status[6] = "P";
		}

		//Validación del OUT_TIPO_MENSAJE - Tiene que ser: '0400'
		if (!respVerifBDD[3].equals("0400")) {
			report.AddLine("OUT_TIPO_MENSAJE: " + respVerifBDD[3] + ". Se esperaba: 0400");
			System.out.println("OUT_TIPO_MENSAJE: " + respVerifBDD[3] + ". Se esperaba: 0400\r\n");
			Status[7] = "FAIL - Validación del OUT_TIPO_MENSAJE";
		}	else {
			report.AddLine("Resultado Correcto. OUT_TIPO_MENSAJE: " + respVerifBDD[3]);
			System.out.println("Resultado Correcto. OUT_TIPO_MENSAJE: " + respVerifBDD[3] + "\r\n");
			Status[7] = "P";
		}

		//Validación del ID_AUTORIZACION_ORIGINAL - Tiene que ser: 'ID_AUTO'
		if (!respVerifBDD[4].equals(id_Auto)) {
			report.AddLine("ID_AUTORIZACION_ORIGINAL: " + respVerifBDD[4] + ". Se esperaba: " + id_Auto);
			System.out.println("ID_AUTORIZACION_ORIGINAL: " + respVerifBDD[4] + ". Se esperaba: " + id_Auto + "\r\n");
			Status[8] = "FAIL - Validación del ID_AUTORIZACION_ORIGINAL";
		}	else {
			report.AddLine("Resultado Correcto. ID_AUTORIZACION_ORIGINAL: " + respVerifBDD[4]);
			System.out.println("Resultado Correcto. ID_AUTORIZACION_ORIGINAL: " + respVerifBDD[4] + "\r\n");
			Status[8] = "P";
		}

		//Validación del ID_AUTO_ADQ_ORIGEN - Tiene que ser: 'ID_AUTOADQ'
		if (!respVerifBDD[5].equals(id_AutoAdq)) {
			report.AddLine("ID_AUTO_ADQ_ORIGEN: " + respVerifBDD[5] + ". Se esperaba: " + id_AutoAdq);
			System.out.println("ID_AUTO_ADQ_ORIGEN: " + respVerifBDD[5] + ". Se esperaba: " + id_AutoAdq + "\r\n");
			Status[9] = "FAIL - Validación del ID_AUTO_ADQ_ORIGEN";
		}	else {
			report.AddLine("Resultado Correcto. ID_AUTO_ADQ_ORIGEN: " + respVerifBDD[5]);
			System.out.println("Resultado Correcto. ID_AUTO_ADQ_ORIGEN: " + respVerifBDD[5] + "\r\n");
			Status[9] = "P";
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
			Status[10] = "FAIL - Validación de IN_TIPO_MENSAJE";
		}	else {
			report.AddLine("Resultado Correcto. IN_TIPO_MENSAJE: " + respVerifBDD);
			System.out.println("Resultado Correcto. IN_TIPO_MENSAJE: " + respVerifBDD + "\r\n");
			Status[10] = "P";
		}
	}
}
