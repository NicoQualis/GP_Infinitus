package TestCases.OPI_VISA;

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

public class TC_17_OPI_VISA {
	private String Status;
		
	public boolean Test(Reports report, String name, String configEntidad) {
		//Validation var
		boolean result = true;
		try {		
			//Separador
			System.out.println("\r\n##################################################################################################################################################################################################################"
					+ "##################################################################################################################################################################################################################\r\n");

			System.out.println("Configuring " + name +"\r\n");

			//Set Variables
			String[] res = new String[2];
			String f37Last6 = "0";
			String xmlFileCreate;
			//Set Reusltados Esperados
			String de39 = "00";

			//Instancias
			sshWorker opiCmd = new sshWorker();
			dbWorker oraResp = new dbWorker();	
			
			//SETEO DBWORKER
			oraResp.setUser(JsonPath.from(configEntidad).getString("DB.user"));
			oraResp.setPass(JsonPath.from(configEntidad).getString("DB.pass"));
			oraResp.setHost(JsonPath.from(configEntidad).getString("DB.host"));
			oraResp.setEntidad(JsonPath.from(configEntidad).getString("ENTIDAD.id_entidad"));

			System.out.println("##[command] : <------ Initializating Test: " + name + " ------>\r\n");
			report.AddLine("<------ Initializating Test: " + name + " ------>");
			
			//PRECONDICIONES
			System.out.println("##### INICIA EJECUCION DE PRECONDICIONES #####");
			report.AddLine("##### INICIA EJECUCION DE PRECONDICIONES #####");
			
			//Cambio de simulador para 'compras'
			System.out.println("##### INICIO CAMBIO DE SIMULADOR PARA COMPRAS #####");
			report.AddLine("##### INICIO CAMBIO DE SIMULADOR PARA COMPRAS #####");

			//Se realiza el STOP de OPI
			opiCmd.stopOpiCmd(report, configEntidad, "opi4qa");
			
			//Cambio de simulador
			opiCmd.cambioSimuladorVisa(report, configEntidad, "opi4qa", oraResp.getEntidad(), "compras");

			System.out.println("##### FIN CAMBIO DE SIMULADOR PARA COMPRAS #####");
			report.AddLine("##### FIN CAMBIO DE SIMULADOR PARA COMPRAS #####");
			
			//Se espera 5 segundos para volver a iniciar OPI
			Thread.sleep(5000);
			
			//Se realiza el START de OPI
			opiCmd.startOpiCmd(report, configEntidad, "opi4qa");
			
			//Se espera 5 segundos para iniciar la prueba
			Thread.sleep(10000);

			//Se valida el funcionamiento de OPI
			if (!opiCmd.getOpiStatus(configEntidad))
				MatcherAssert.assertThat("OPI no se encuentra operativo ", opiCmd.getOpiStatus(configEntidad), equalTo(true));
			
			String xmlFile = Files.readString(Paths.get("./OPI_Files/VISA/PRE_BANDA_VISA.xml"));
            //Enviar a OPI el archivo generado
            opiCmd.sshSendCmdCreateXml(report, xmlFile, configEntidad, "opi4qa", "PRE_BANDA_VISA.xml");
            
            //Creación del XML a subir
            xmlFileCreate = execPreCondicion(report, configEntidad, opiCmd, "PRE_BANDA_VISA.xml", "VISA/TC_17_VISA.xml");
            
           //Enviar a OPI el archivo generado
			opiCmd.sshSendCmdCreateXml(report, xmlFileCreate, configEntidad, "opi4qa", "TC_17_VISA.xml");		
			
			System.out.println("##### FIN DE EJECUCION DE PRECONDICIONES #####");
			report.AddLine("##### FIN DE EJECUCION DE PRECONDICIONES #####");
			
			//EJECUCION OPI
			System.out.println("##### INICIO EJECUCION OPI #####");
			report.AddLine("##### INICIO EJECUCION OPI #####");
			
			res = opiCmd.sshSendCmdGetDE37(report, "TC_17_VISA.xml", configEntidad, "opi4qa");

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
		queryVerf = "select count(*) from autorizacion a "
				+ "inner join autorizacion_adquirente_log aal on a.id_autorizacion_adquirente = aal.id_autorizacion_adquirente "
				+ "inner join respuesta_mc_log rmc on a.id_autorizacion_adquirente = rmc.id_autorizacion_adquirente "
				+ "where a.id_autorizacion_adquirente = '" +  f37Last6 + "' and a.id_estado = 0 and a.modo_ingreso = 90";
		
		primeraValidacion(oraResp, report, queryVerf);

		//Verificacion de todos los resultados obtenidos
		if (!Status.equals("P")) {
			report.AddLine("===== " + Status + " =====");
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