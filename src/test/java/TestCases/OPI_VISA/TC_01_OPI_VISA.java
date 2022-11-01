package TestCases.OPI_VISA;

import static org.hamcrest.Matchers.equalTo;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import org.hamcrest.MatcherAssert;
import CentaJava.Core.Reports;
import Tools.dbWorker;
import Tools.sshWorker;
import io.restassured.path.json.JsonPath;

public class TC_01_OPI_VISA {
	private String Status;
	
	public boolean Test(Reports report,String name, String configEntidad) {
		boolean result = true;
		//SET INSTANCES
		sshWorker opiCmd = new sshWorker();
		dbWorker oraResp = new dbWorker();
				
		try {		
			//Separador
			System.out.println("\r\n##################################################################################################################################################################################################################"
					+ "##################################################################################################################################################################################################################\r\n");

			System.out.println("Configuring "+name+ "\r\n");

			//Set Variables
			String[] res = new String[2];
			String f37Last6 = "0";
			//Set Reusltados Esperados
			String de39 = "00";
			
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
			
			//Preparación del archivo XML del TC
			System.out.println("##### PREPARACION DEL ARCHIVO XML DEL TC #####");
			report.AddLine("##### PREPARACION DEL ARCHIVO XML DEL TC #####");
			String xmlFile = Files.readString(Paths.get("./OPI_Files/VISA/TC_01_VISA.xml"));
			
			//Enviar a OPI el archivo generado
			opiCmd.sshSendCmdCreateXml(report, xmlFile, configEntidad, "opi4qa", "TC_01_VISA.xml");
			
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
			
			System.out.println("##### FIN DE EJECUCION DE PRECONDICIONES #####");
			report.AddLine("##### FIN DE EJECUCION DE PRECONDICIONES #####");
						
			//EJECUCION OPI
			System.out.println("##### INICIO EJECUCION OPI #####");
			report.AddLine("##### INICIO EJECUCION OPI #####");
			
			res = opiCmd.sshSendCmdGetDE37(report, "TC_01_VISA.xml", configEntidad, "opi4qa");

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

						
			//POSTCONDICIONES

			//Separador
			System.out.println("##################################################################################################################################################################################################################"
					+ "##################################################################################################################################################################################################################\r\n");


		} catch (Exception e) {
			opiCmd.cambioSimuladorVisa(report, configEntidad, "opi4qa", oraResp.getEntidad(), "compras");
			report.AddLine("Error:<br>" + e);
			System.out.println("##[warning] : Error:\r\n" + e);
			result = false;
		}

		return result;
	}

	private boolean validacionGral(dbWorker oraResp, Reports report, String f37Last6) throws SQLException {
		//Variables
		boolean result = true;
		String queryVerf;
		
		System.out.println("##### INICIO EJECUCION DE VALIDACIONES #####");
		report.AddLine("##### INICIO EJECUCION DE VALIDACIONES #####");

		//Primera Validación
		queryVerf = "select count(*) from autorizacion a\r\n"
				+ "inner join autorizacion_adquirente_log aal on a.id_autorizacion_adquirente = aal.id_autorizacion_adquirente\r\n"
				+ "inner join respuesta_mc_log rml on a.id_autorizacion_adquirente = rml.id_autorizacion_adquirente\r\n"
				+ "where a.id_autorizacion_adquirente = '" + f37Last6 + "' and a.id_marca = '2' and a.modo_ingreso = '01' and id_estado = '0'";

		Validacion(oraResp, report, queryVerf);

		//Verificacion de todos los resultados obtenidos
		if (!Status.equals("P")) {
			report.AddLineAssertionError("===== " + Status + " =====");;
			System.out.println("===== " + Status + " =====");
			result = false;
		}

		System.out.println("##### FIN DE EJECUCION DE VALIDACIONES #####");
		report.AddLine("##### FIN DE EJECUCION DE VALIDACIONES #####");

		return result;
	}
	
	private void Validacion(dbWorker oraResp, Reports report , String queryVerf) throws SQLException {
		
		String validaRes;
		
		validaRes = oraResp.oraOneQuery(queryVerf);
		System.out.println("la query devuelve"+validaRes);
		if (!validaRes.equals("1")) {
			report.AddLineAssertionError("FAIL<br>No se cumplieron todas las validaciones");
			System.out.println("##[warning] : FAIL:\r\nNo se cumplieron todas las validaciones\r\n");
			Status = "FAIL - Cantidad de resultados";
		} else {
			report.AddLine("Ejecucion Correcta:<br>Se cumplieron todas las validaciones");
			System.out.println("##[section] : Ejecucion Correcta:\r\nSe cumplieron todas las validaciones\r\n");
			Status = "P";
		}
	}

}