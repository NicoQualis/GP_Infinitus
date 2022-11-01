
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
import Pasos.GlobalBatch_ADQ_700.TC_36_GB_PASOS_ADQ_700;
import Repositories.Repo_WebRepository;
import Tools.dbWorker;
import io.restassured.path.json.JsonPath;

public class TC_36_WEB_GB_700 {
	private WebDriver driver;
	private dbWorker oraWorker;

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
			System.out.println("Configuring" + name + "\r\n");

			//SELECT THE DRIVER AND PATH
			driver = DM.CreateDriver(DM.CHROME);
			report.SetDriver(driver);

			//SET THE REPOSITORIES TO USE
			Repo_WebRepository repo = new Repo_WebRepository();
			repo.setDriver(driver);

			//SET STEPS INSTANCES
			Acceso acceso = new Acceso();
			GBatch gralBatch = new GBatch();
			TC_36_GB_PASOS_ADQ_700 pasos = new TC_36_GB_PASOS_ADQ_700();
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
			result = validacionesBD(oraWorker, report);

			//POSTCONDICIONES
			System.out.println("##### INICIA EJECUCION DE POSTCONDICIONES #####");
			report.AddLine("##### INICIA EJECUCION DE POSTCONDICIONES #####");

			execPostCondiciones(report, oraWorker);

			System.out.println("##### FIN DE EJECUCION DE POSTCONDICIONES #####");
			report.AddLine("##### FIN DE EJECUCION DE POSTCONDICIONES #####");

			System.out.println("------ Finished test: " + name + " ------\r\n");

			//SEPARADOR
			System.out.println("##################################################################################################################################################################################################################"
					+ "##################################################################################################################################################################################################################\r\n");

		} catch (Exception e) {
			e.printStackTrace();
			report.AddLineAssertionError(e.getMessage());
			execPrePostCondi(report, oraWorker);
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

	private boolean validacionesWeb(Reports report, Repo_WebRepository repo, DriverManager DM, String name, String runId, TC_36_GB_PASOS_ADQ_700 pasos) {

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

	private boolean validacionesBD (dbWorker oraWorker, Reports report) throws SQLException {

		//Variables
		boolean result = true;
		String[] Status = new String[6];
		String[] rta = new String[6];
		String queryVerif;

		System.out.println("##### INICIO EJECUCION DE VALIDACIONES #####");
		report.AddLine("##### INICIO EJECUCION DE VALIDACIONES #####");

		queryVerif = "select c.id_mod_financ_comercio, c.importe_interes_com, c.porcentaje_financ, c.id_sistema_financiacion, c.tipo_porc_financ, c.importe_iva_interes_com "
				+ "from consumos c "
				+ "inner join consumos_datos_adicionales cda on c.id_consumo = cda.id_consumo "
				+ "inner join consumos_cuotas cc on c.id_consumo = cc.id_consumo "
				+ "inner join presentaciones p on c.id_consumo = p.id_consumo "
				+ "inner join autorizacion a on c.id_autorizacion = a.id_autorizacion "
				+ "inner join autorizacion_adquirente_log aal on a.id_autorizacion_adquirente = aal.id_autorizacion_adquirente "
				+ "where a.id_autorizacion_adquirente in ('348412')";

		rta = oraWorker.oraSixQuery(queryVerif);

		// Validacion 01
		if (rta[0].equals("17")) { 
			report.AddLine("Resultado Correcto. El campo ID_MOD_FINANC_COMERCIO tiene el registro " + rta[0]);
			System.out.println("Resultado Correcto. El campo ID_MOD_FINANC_COMERCIO  tiene el registro "  + rta[0]+"\r\n");
			Status[0] = "P";

		} else {
			report.AddLineAssertionError("El campo ID_MOD_FINANC_COMERCIO tiene el registro: "+rta[0]+", se esperaba el registro 17");
			System.out.println("El campo ID_MOD_FINANC_COMERCIO  tiene el registro: "+rta[0]+", se esperaba el registro 17 \r\n");
			Status[0] = "FAIL - ID_MOD_FINANC_COMERCIO";
		}

		// Validacion 02
		if (rta[1].equals("-1800")) { 
			report.AddLine("Resultado Correcto. El campo IMPORTE_INTERES_COM tiene el registro " + rta[1]);
			System.out.println("Resultado Correcto. El campo IMPORTE_INTERES_COM tiene el registro "  + rta[1]+"\r\n");
			Status[1] = "P";

		} else {
			report.AddLineAssertionError("El campo IMPORTE_INTERES_COM tiene el registro: "+rta[1]+", se esperaba el registro -1800");
			System.out.println("El campo IMPORTE_INTERES_COM tiene el registro: "+rta[1]+", se esperaba el registro -1800 \r\n");
			Status[1] = "FAIL - IMPORTE_INTERES_COM";
		}

		// Validacion 03
		if (rta[2].equals("10")) { 
			report.AddLine("Resultado Correcto. El campo PORCENTAJE_FINANC tiene el registro: " + rta[2]);
			System.out.println("Resultado Correcto. El campo PORCENTAJE_FINANC tiene el registro: "  + rta[2] +"\r\n");
			Status[2] = "P";

		} else {
			report.AddLineAssertionError("El campo PORCENTAJE_FINANC tiene el registro: "+rta[2]+", se esperaba el registro 10");
			System.out.println("El campo PORCENTAJE_FINANC tiene el registro: "+rta[2]+", se esperaba el registro 10 \r\n");
			Status[2] = "FAIL - PORCENTAJE_FINANC";
		}

		// Validacion 04
		if (rta[3].equals("4")) { 
			report.AddLine("Resultado Correcto. El campo  ID_SISTEMA_FINANCIACION tiene el registro: " + rta[3]);
			System.out.println("Resultado Correcto. El campo ID_SISTEMA_FINANCIACION  tiene el registro: "  + rta[3]+"\r\n");
			Status[3] = "P";

		} else {
			report.AddLineAssertionError("El campo ID_SISTEMA_FINANCIACION tiene el registro: "+rta[3]+", se esperaba el registro 4");
			System.out.println("el campo ID_SISTEMA_FINANCIACION  tiene el registro: "+rta[3]+", se esperaba el registro 4 \r\n");
			Status[3] = "FAIL - ID_SISTEMA_FINANCIACION";
		}

		// Validacion 05
		if (rta[4].equals("1")) { 
			report.AddLine("Resultado Correcto. El campo  TIPO_PORC_FINANC tiene el registro: " + rta[4]);
			System.out.println("Resultado Correcto. El campo TIPO_PORC_FINANC   tiene el registro: "  + rta[4]+"\r\n");
			Status[4] = "P";

		} else {
			report.AddLineAssertionError("El campo TIPO_PORC_FINANC tiene el registro: "+rta[4]+", se esperaba el registro 1");
			System.out.println("El campo TIPO_PORC_FINANC   tiene el registro: "+rta[4]+", se esperaba el registro 1 \r\n");
			Status[4] = "FAIL - TIPO_PORC_FINANC";
		}

		// Validacion 06
		if (rta[5].equals("-378")) { 
			report.AddLine("Resultado Correcto. El campo  IMPORTE_IVA_INTERES_COM tiene el registro: " + rta[5]);
			System.out.println("Resultado Correcto. El campo IMPORTE_IVA_INTERES_COM tiene el registro: "  + rta[5]+"\r\n");
			Status[5] = "P";

		} else {
			report.AddLineAssertionError("El campo IMPORTE_IVA_INTERES_COM tiene el registro: "+rta[5]+", se esperaba el registro -378");
			System.out.println("El campo IMPORTE_IVA_INTERES_COM tiene el registro: "+rta[5]+", se esperaba el registro -378 \r\n");
			Status[5] = "FAIL - IMPORTE_IVA_INTERES_COM";
		}

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
		queryPre = "update autorizacion set fecha_relacion = sysdate where fecha_relacion is null and id_estado = '0' and id_comercio in ('8258')";
		res.add(oraWorker.oraUpdate(queryPre, conn));

		//Accion 02 - 
		queryPre = "update autorizacion_adquirente_log set presentacion_procesada = '1' where presentacion_procesada = '0' and in_cod_comercio_externo in ('8258')";
		res.add(oraWorker.oraUpdate(queryPre, conn));

		//Accion 03 - 
		queryPre = "update presentaciones set id_estado = '0' where id_estado != '0' and id_comercio in ('8258')";
		res.add(oraWorker.oraUpdate(queryPre, conn));

		//--INSERT--
		//Accion 04  -
		queryPre = "Insert into AUTORIZACION_ADQUIRENTE_LOG (ID_AUTORIZACION_ADQUIRENTE,IN_ID_ENTIDAD,IN_ID_ORIGEN,IN_ID_TIPO_RED,IN_TIPO_MENSAJE,IN_NRO_TARJETA,IN_COD_PROCESAMIENTO,IN_IMPORTE_OPERACION,IN_NRO_TRACE,IN_HORA_LOCAL,IN_FECHA_LOCAL,IN_FECHA_VTO_TARJETA,IN_MODO_INGRESO_TERMINAL,IN_NRO_SECUENCIA_TARJETA,IN_COD_CAPTURA_PIN_TERMINAL,IN_TRACK2,IN_NRO_REFER_RECUPERACION,IN_COD_AUTORIZACION,IN_TERMINAL,IN_COD_COMERCIO_EXTERNO,IN_TRACK1,IN_DATOS_ADICIONALES_046,IN_DATOS_ADICIONALES_048,IN_PIN_TARJETA,IN_COD_MONEDA_OPERACION,IN_IMPORTES_ADICIONALES,IN_DATOS_SEGURIDAD_PIN,IN_DATOS_ICC,IN_DATOS_ADICIONALES_059,IN_VERSION,IN_TIPO_TERMINAL,IN_NRO_TICKET,IN_PLAN_EXTERNO,IN_CUOTAS,IN_CVC2,IN_NRO_CUENTA1,IN_NRO_CUENTA2,IN_ID_USUARIO_ALTA,IN_FECHA_HORA_TRANSMISION,OUT_TIPO_MENSAJE,OUT_COD_PROCESAMIENTO,OUT_IMPORTE_OPERACION,OUT_MCC,OUT_COD_PAIS_CUENTA_PRIMARIA,OUT_IMPORTE_CARGO_TRANSACCION,OUT_ICA,OUT_ICA_REENVIO,OUT_NRO_REFER_RECUPERACION,OUT_COD_AUTORIZACION,OUT_COD_RESPUESTA,OUT_OBSERVACION,OUT_ID_RESPUESTA_INTERNA,OUT_DATOS_ADICIONALES_046,OUT_DATOS_ADICIONALES_048,OUT_IMPORTES_ADICIONALES,OUT_DATOS_PUNTO_SERVICIO,OUT_IMPORTE_REEMPLAZO,FECHA_TRANSACCION_INI,FECHA_TRANSACCION_FIN,ID_TIPO_AUTORIZACION_ADQ_LOG,PRESENTACION_PROCESADA,ID_CONSULTA_ORIGINAL,ID_AUTORIZACION_ORIGINAL,ANULAR_REVERSAR,ID_AUTO_ADQ_ANULAR_REVERSAR,ID_AUTO_ADQ_ORIGEN,OUT_ID_TIPO_RED_EMISOR,PRODUCTO,IN_TRACE_SWITCH,IN_FECHA_TRANSMISION_SWITCH,OUT_DATOS_ORIGINALES,IN_NRO_LOTE,TIPO_PRODUCTO,OUT_DATOS_ADICIONALES_112,IN_INGRESO_PIN,EXPONENTE_IMPORTE_OPERACION,OUT_CODIGO_MOTIVO_AVISO_60,OUT_DATOS_RED_ORIGINAL,OUT_COD_RESPUESTA_ORIGINAL,OUT_COMERCIO_43,OUT_FECHA_LIQUIDACION_ORIGINAL,IN_COD_RESPUESTA,IN_DE_25,OUT_DE_19,OUT_DE_59,OUT_DE_60,OUT_DE_61,OUT_DE_62,OUT_DE_104,OUT_DE_115,OUT_DE_117,OUT_DE_118,OUT_DE_121,OUT_DE_123,OUT_DE_125,OUT_DE_126,ID_MARCA,OUT_DE_63,IN_ESTADO_SENTINEL,OUT_DE_11,ICA_EMISOR,OUT_DE_124,OUT_DE_120,IN_CODIGO_POSTAL_COMERCIO,IN_TCC_COMERCIO,IN_PROVINCIA_COMERCIO,IN_IMPORTE_CASH_BACK,IN_IMPORTE_PROPINA,IN_TIPO_FINANCIACION,IN_CAPACIDAD_CAPTURA_PAN,IN_CAPACIDAD_CAPTURA_PIN,IN_METODO_VERIFICACION_SOCIO,IN_CIUDAD_COMERCIO,IN_NOMBRE_COMERCIO,IN_DIRECCION_COMERCIO,IN_SERVICE_PROVIDER_NAME,IN_NOMBRE_SOCIO,IN_DOCUMENTO_SOCIO,OUT_DE_22,IN_COD_SUB_COMERCIO,OUT_DE_49,IN_ORIGEN_FEC_HORA_TRANSMISION,IN_MOTIVO_CANCELACION,IN_PAN_MODO_INGRESO,OUT_DE_12,OUT_DE_13,OUT_DE_14,OUT_DE_110,OUT_DE_39,IN_ORIGEN_NRO_TRACE,IN_FECHA_LOCAL_TRANSACTION,IN_ORIGEN_FECHA_LOCAL_TRANSAC,OUT_DE_25,REFERENCIA_DA,PERIODO_DA,IN_3DS_TRANSACTION_ID,IN_3DS_PROTOCOL,IN_3DS_CRYPTOGRAM,IN_3DS_SLI,IN_3DS_CAVV,TRANSACCION_ORIGEN_DA,SERVICE_CODE,IN_DE_24,IN_MCC_COMERCIO,FORMATO_MENSAJE,IN_DE_61,IN_PLAN_FINANCIACION,STATUS_PIN,OUT_DE_114,OUT_DE_56,REQUEST_ID_SWITCH,OUT_DE_7) values ('348412','700','12','10','0200','BD0EBC8CCD10A14AF22303C5DAC1A6D6','000000','000003000000','123456','165646','0215','2512','0110','000',null,null,null,null,'1','8258',null,null,null,null,'032',null,null,null,null,null,'3','9999','0','03',null,null,null,null,'2022-02-15T16:56:46.779Z','0100','000000','000003000000','5499',null,null,'446809',null,'220016348412',null,'00','OK, Sentinel OK','0',null,null,null,null,null,to_timestamp('19/07/2022 01:01:15,551359000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),to_timestamp('19/07/2022 01:01:15,777292000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),'1','0',null,null,null,null,null,'22',null,'4476','20220719160115',null,'99','C',null,'0','2',null,null,null,'AUTO-CALENDARIO-FINANC.  SARANDI      AR',null,null,null,'032',null,'920000000310',null,null,'{ \"format\": \"TLV\"  , \"dataset_67\": { \"tag_01\": \"032\", \"tag_02\": \"003\" } }',null,null,null,null,null,null,'{ \"format\": \"BITMAP\" , \"sub13\": \"I\"  }','2','{\"format\": \"BITMAP\" , \"sub1\": \"0000\" }','1','004476','400103',null,null,'5555',' ','009',null,null,'0','7','1','4','CABACABACABA','Soy*isto','Genova 3365','SoyListo',null,null,'0110','124','032',null,null,'1','165646','0215','2512',null,null,null,to_timestamp('15/02/2022 04:56:46,779000000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),null,'00',null,null,null,null,null,null,null,null,null,'0','8011','2',null,'0','0',null,null,'a8b5d36c-ae87-42a9-b61d-f037fe05b966','0719100115')";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//Accion 05
		queryPre = "Insert into RESPUESTA_MC_LOG (ID_RESPUESTA_MC,IN_ID_ENTIDAD,IN_ID_ORIGEN,IN_ID_TIPO_RED,IN_ID_AUTORIZACION_ADQUIRENTE,IN_TIPO_MENSAJE,IN_NRO_TARJETA,IN_COD_PROCESAMIENTO,IN_IMPORTE_OPERACION,IN_IMPORTE_LIQUIDACION,IN_IMPORTE_EMISOR,IN_FECHA_HORA_TRANSMISION,IN_TASA_LIQUIDACION,IN_TASA_EMISOR,IN_HORA_LOCAL,IN_FECHA_LOCAL,IN_NRO_TRACE,IN_FECHA_LIQUIDACION,IN_FECHA_CONVERSION,IN_COD_PAIS_CUENTA_PRIMARIA,IN_NRO_SECUENCIA_TARJETA,IN_IMPORTE_CARGO_TRANSACCION,IN_ICA,IN_ICA_REENVIO,IN_NRO_REFER_RECUPERACION,IN_COD_AUTORIZACION,IN_COD_RESPUESTA,IN_TERMINAL,IN_COD_COMERCIO_EXTERNO,IN_DATOS_ADICIONALES_RESPUESTA,IN_DATOS_ADICIONALES_048,IN_COD_MONEDA_OPERACION,IN_COD_MONEDA_LIQUIDACION,IN_COD_MONEDA_EMISOR,IN_IMPORTES_ADICIONALES,IN_DATOS_ICC,IN_DATOS_RED_INTERMEDIARIA,IN_DATOS_RED,IN_DATOS_MENSAJE_ORIGINAL,IN_DATOS_IMPORTE_REVERSA,IN_NRO_CUENTA1,IN_NRO_CUENTA2,IN_DATOS_REFERENCIA_MONEYSEND,IN_DATOS_ADICIONALES_112,IN_PLAN_EXTERNO,IN_CUOTAS,IN_DATOS_REGISTRO,IN_COD_PROCESO_STANDIN,IN_MENSAJE_TICKET,IN_DATOS_MIEMBRO,IN_DATOS_INICIADOR_MENSAJE,IN_ID_TIPO_RED_EMISOR,OUT_ID_RESPUESTA_INTERNA,OUT_OBSERVACION,OUT_COD_AUTORIZACION,OUT_COD_RESPUESTA,OUT_DATOS_ADICIONALES_046,OUT_IMPORTES_ADICIONALES,ID_AUTORIZACION_ADQUIRENTE,FECHA_TRANSACCION_INI,FECHA_TRANSACCION_FIN,IN_SWITCH_PRIVATE_DATA_126,IN_DE_19,IN_DE_25,IN_DE_62,IN_DE_63,IN_DE_73,IN_DE_91,IN_DE_101,IN_DE_104,IN_DE_115,IN_DE_116,IN_DE_117,IN_DE_118,IN_DE_121,IN_DE_123,IN_DE_126,IN_DE_127,ID_MARCA,IN_DE_124,IN_DE_56,IN_DE_58,IN_DE_100,IN_DE_105,OUT_DE_60,IN_DE_114,IN_DE_34,IN_RESPONSE_STATUS) values ('104177','700','12','10','348412','0110','BD0EBC8CCD10A14AF22303C5DAC1A6D6','000000','000003000000',null,null,'0719160115',null,'61000000',null,null,'004476',null,null,null,null,null,'446809',null,'220016348412','026670','00','1       ','8258           ',null,null,'032',null,'840',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'0','1','OK','026670','00',null,null,'348412',to_timestamp('19/07/2022 01:01:16,075546000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),to_timestamp('19/07/2022 01:01:16,133479000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),null,null,null,'40000000000000000312200058364078','8000000000',null,null,null,null,null,null,null,null,null,null,null,null,'2',null,null,null,null,null,null,null,null,null)";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//Accion 06
		queryPre = "Insert into AUTORIZACION (ID_AUTORIZACION,ID_ENTIDAD,NRO_TARJETA,COD_AUTO_ENTIDAD,COD_AUTO_EMISOR,ID_MONEDA_ORIGEN,IMPORTE_ORIGEN,FECHA_AUTORIZACION,COTIZACION,ID_MONEDA,IMPORTE,IMPORTE_SIN_DTO,ID_ESTADO_TIPO,ID_ESTADO,FECHA_ANULACION,ID_USUARIO_ANULACION,ID_COMERCIO,COMERCIO_DESCRIPCION,CUOTAS,TASA_SOCIO,IMPORTE_CUOTAS,MCC,ID_RUBRO,ID_SUBRUBRO,TCC,COD_COMERCIO_EXTERNO,TERMINAL_POS,ID_COD_MOVIMIENTO,ID_GRUPO_TRANSACCION,ID_MODELO_TRANSACCION,ID_AUTORIZACION_ADQUIRENTE,ID_CODIGO_DEVOLUCION,IMPORTE_DEVOLUCION,ID_RESPUESTA_MC,FECHA_RELACION,OBSERVACION,MODO_INGRESO,FECHA_INFORMADA,COD_RESPUESTA,ID_RESPUESTA_INTERNA,ID_MOD_FINANC_COMERCIO,ID_PAIS_EMISOR,COD_PAIS_COMERCIO,COD_PAIS_EMISOR,PRESENTACION_PROCESADA,IMPORTE_TOTAL_PRESENTADO,ID_ORIGEN,COEFICIENTE_DIFERENCIA_CAMBIO,ID_CUENTA,ID_ADICIONAL,ID_MONEDA_LIQUIDACION,IMPORTE_LIQUIDACION,ID_AUTORIZACION_EMISOR,COD_SUB_COMERCIO,TRN_EXTERNAL_ID,ID_REGLA_FRAUDE,ID_MARCA,NRO_TARJETA_ENMASCARADA,DEBITO_AUTOMATICO,PORCENTAJE_DEVOLUCION,ECOMMERCE,TID,COD_RESPUESTA_POS,ES_CASHBACK,ID_AUTORIZACION_ORIGINAL,FECHA_DIFERIMIENTO,IMPORTE_CONVERTIDO,DIAS_DIFERIMIENTO,ES_PROPINA,MONTO_ACUM_DEVOLUCIONES,MOTIVO_REVERSO,CANT_INTENTOS_REVERSOS,INTENTOS_REVERSOS_EXCEDIDOS) values ('342433','700','BD0EBC8CCD10A14AF22303C5DAC1A6D6','026670',null,'32','30000',to_date('19/07/2022 13:01:15','DD/MM/RRRR HH24:MI:SS'),'1','32','30000','0','41','0',null,null,'8258','AUTO-CALENDARIO-FINANC.  SARANDI      AR','3','0','10000','5499','82000','82040','R','8258','1','1','1','9','348412','0','0','104177',null,'OK, Sentinel OK','01',to_date('19/07/2022 13:01:15','DD/MM/RRRR HH24:MI:SS'),'00','1','17',null,'AR','AR','2','0','12','1',null,null,null,null,null,'124',null,null,'2','412322xxxxxx0222','0','0','0','312200058364078','00','0',null,null,null,null,'0','0',null,null,null)";
		res.add(oraWorker.oraInsert(queryPre, conn));

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
	private boolean execPostCondiciones (Reports report, dbWorker oraWorker) {

		boolean result = true;
		int index = 0;
		Connection conn;
		String queryPost;
		List<Integer> res = new ArrayList<Integer>();

		//Connectamos la BD
		conn = oraWorker.getConn();

		//Accion 01		
		queryPost = "DELETE FROM PRESENTACIONES where id_autorizacion_adquirente in ('348412')";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 02	
		queryPost = "DELETE FROM CONSUMOS_CUOTAS WHERE ID_CONSUMO in (select id_consumo from consumos where id_autorizacion in (select id_autorizacion from autorizacion where id_autorizacion_adquirente in ('348412')))";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 03	
		queryPost = "DELETE FROM CONSUMOS_DATOS_ADICIONALES WHERE ID_CONSUMO in (select id_consumo from consumos where id_autorizacion in (select id_autorizacion from autorizacion where id_autorizacion_adquirente in ('348412')))";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 04	
		queryPost = "DELETE FROM CONSUMOS WHERE ID_CONSUMO in (select id_consumo from consumos where id_autorizacion in (select id_autorizacion from autorizacion where id_autorizacion_adquirente in ('348412')))";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 05	
		queryPost = "DELETE FROM AUTORIZACION WHERE ID_AUTORIZACION_ADQUIRENTE = '348412'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 06	
		queryPost = "DELETE FROM RESPUESTA_MC_LOG WHERE ID_AUTORIZACION_ADQUIRENTE = '348412'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 07	
		queryPost = "DELETE FROM AUTORIZACION_ADQUIRENTE_LOG WHERE ID_AUTORIZACION_ADQUIRENTE = '348412'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		oraWorker.getDisConn(conn);

		//Validación PRECONDICIONES
		for(Integer resultados : res) {
			if (resultados < 1) {
				index ++;
				report.AddLineAssertionError("===== Error en la acción: " + index + " =====");
				System.out.println("===== Error en la acción: " + index + " =====");
				System.out.println("===== Se obtuvieron: " + resultados + " Resultados =====");
				result = false;
			}
		}

		return result;

	}

	private void execPrePostCondi(Reports report, dbWorker oraWorker) {

		//Variables
		Connection conn;

		conn = oraWorker.getConn();

		oraWorker.oraDelete("DELETE FROM PRESENTACIONES where id_autorizacion_adquirente in ('348412')", conn);
		oraWorker.oraDelete("DELETE FROM CONSUMOS_CUOTAS WHERE ID_CONSUMO in (select id_consumo from consumos where id_autorizacion in (select id_autorizacion from autorizacion where id_autorizacion_adquirente in ('348412')))", conn);
		oraWorker.oraDelete("DELETE FROM CONSUMOS_DATOS_ADICIONALES WHERE ID_CONSUMO in (select id_consumo from consumos where id_autorizacion in (select id_autorizacion from autorizacion where id_autorizacion_adquirente in ('348412')))", conn);
		oraWorker.oraDelete("DELETE FROM CONSUMOS WHERE ID_CONSUMO in (select id_consumo from consumos where id_autorizacion in (select id_autorizacion from autorizacion where id_autorizacion_adquirente in ('348412')))", conn);
		oraWorker.oraDelete("DELETE FROM AUTORIZACION WHERE ID_AUTORIZACION_ADQUIRENTE = '348412'", conn);
		oraWorker.oraDelete("DELETE FROM RESPUESTA_MC_LOG WHERE ID_AUTORIZACION_ADQUIRENTE = '348412'", conn);
		oraWorker.oraDelete("DELETE FROM AUTORIZACION_ADQUIRENTE_LOG WHERE ID_AUTORIZACION_ADQUIRENTE = '348412'", conn);

		oraWorker.getDisConn(conn);

	}

}