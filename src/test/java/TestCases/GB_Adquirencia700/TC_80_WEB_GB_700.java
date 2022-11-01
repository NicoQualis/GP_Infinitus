
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
import Pasos.GlobalBatch_ADQ_700.TC_80_GB_PASOS_ADQ_700;
import Repositories.Repo_WebRepository;
import Tools.dbWorker;
import io.restassured.path.json.JsonPath;

public class TC_80_WEB_GB_700 {
	private WebDriver driver;
	private dbWorker oraWorker;
	String[] Status = new String[3];

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
			TC_80_GB_PASOS_ADQ_700 pasos = new TC_80_GB_PASOS_ADQ_700();
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
			gralBatch.buscarSeleccionar(report, repo, "Liquidación Comercios", "700-Adquirencia Argentina");
			gralBatch.seleccionarLanzarProceso(report, repo, DM, name,  "Liquidación Comercios");
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

	private boolean validacionesWeb(Reports report, Repo_WebRepository repo, DriverManager DM, String name, String runId, TC_80_GB_PASOS_ADQ_700 pasos) {

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
		String queryVerif;


		System.out.println("##### INICIO EJECUCION DE VALIDACIONES #####");
		report.AddLine("##### INICIO EJECUCION DE VALIDACIONES #####");

		//Primer validación
		queryVerif ="select liq_comercio from consumos where id_consumo in('473647')";

		primeraValidacion(oraWorker, report, queryVerif);

		//Segunda validación
		queryVerif ="select liq_comercio from consumos_cuotas where id_consumo in('473647')";

		segundaValidacion(oraWorker, report, queryVerif);
		
		//tercera validación
		queryVerif = "select id_consumo from comercios_liq_detalles where id_consumo in('473647')";

		terceraValidacion(oraWorker, report, queryVerif);

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
		String respVerifBDD; 
		respVerifBDD = oraResp.oraOneQuery(query);

		//Validación del LIQ_COMERCIO   - Tiene que ser igual a 0
		if (!respVerifBDD.equals("0")) {
			report.AddLineAssertionError("Resultado no esperado de la validacion 1.El campo LIQ_COMERCIO, de la tabla CONSUMOS tiene el registro :" + respVerifBDD.toString() + " Se esperaba: 0");
			System.out.println("Resultado no esperado de la validacion 1. El campo LIQ_COMERCIO, de la tabla CONSUMOS  tiene el registro :" + respVerifBDD.toString() + " Se esperaba: 0 \r\n");
			Status[0] = "FAIL - Validación del LIQ_COMERCIO de la tabla CONSUMOS ";
		}	else {
			report.AddLine("Resultado correcto de la validacion 1. El campo LIQ_COMERCIO, de la tabla CONSUMOS  tiene el registro: " + respVerifBDD.toString());
			System.out.println("Resultado correcto de la validacion 1. El campo LIQ_COMERCIO,de la tabla CONSUMOS  tiene el registro: " + respVerifBDD.toString() + "\r\n");
			Status[0] = "P";
		}

	}		

	private void segundaValidacion(dbWorker oraResp, Reports report, String query) throws SQLException {
		String respVerifBDD; 
		respVerifBDD = oraResp.oraOneQuery(query);

		//Validación del LIQ_COMERCIO   - Tiene que ser igual a 0
		if (!respVerifBDD.equals("0")) {
			report.AddLineAssertionError("Resultado no esperado de la validacion 2. El campo LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS  tiene el registro :" + respVerifBDD.toString() + " Se esperaba: 0");
			System.out.println("Resultado no esperado de la validacion 2. El campo LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS tiene el registro :" + respVerifBDD.toString() + " Se esperaba: 0 \r\n");
			Status[1] = "FAIL - Validación del LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS  ";
		}	else {
			report.AddLine("Resultado Correcto de la validacion 2. El campo LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS   tiene el registro: " + respVerifBDD.toString());
			System.out.println("Resultado Correcto de la validacion 2. El campo LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS tiene el registro: " + respVerifBDD.toString() + "\r\n");
			Status[1] = "P";
		}


	}

	private void terceraValidacion(dbWorker oraResp, Reports report, String query) throws SQLException {
		String respVerifBDD = new String(); 
		respVerifBDD = oraResp.oraOneQuery(query);

		//Se verifica que no se procesara el dato - No se espera registro de respuesta.
		if (!respVerifBDD.isEmpty()) {
			report.AddLineAssertionError("Resultado no esperado de la validacion 3. El campo ID_CONSUMO tiene el registro :" + respVerifBDD.toString() + " Se esperaba: NULL");
			System.out.println("Resultado no esperado de la validacion 3. El campo ID_CONSUMO tiene el registro :" + respVerifBDD.toString() + " Se esperaba: NULL \r\n");
			Status[2] = "FAIL - Validación del ID_CONSUMO ";
		}	else {
			report.AddLine("Resultado correcto de la validacion 3. El campo ID_CONSUMO  tiene el registro: " + respVerifBDD.toString());
			System.out.println("Resultado Correcto correcto de la validacion 3. El campo ID_CONSUMO tiene el registro: " + respVerifBDD.toString() + "\r\n");
			Status[2] = "P";
		}

	}

	private boolean execPreCondiciones(Reports report, dbWorker oraWorker) {
		//Variables
		boolean result = true;
		int index = 0;
		Connection conn;
		String queryPre;
		List<Integer> res = new ArrayList<Integer>();

		conn = oraWorker.getConn();

		//--INSERT--
		//Acción 01 - 
		queryPre = "Insert into AUTORIZACION_ADQUIRENTE_LOG (ID_AUTORIZACION_ADQUIRENTE,IN_ID_ENTIDAD,IN_ID_ORIGEN,IN_ID_TIPO_RED,IN_TIPO_MENSAJE,IN_NRO_TARJETA,IN_COD_PROCESAMIENTO,IN_IMPORTE_OPERACION,IN_NRO_TRACE,IN_HORA_LOCAL,IN_FECHA_LOCAL,IN_FECHA_VTO_TARJETA,IN_MODO_INGRESO_TERMINAL,IN_NRO_SECUENCIA_TARJETA,IN_COD_CAPTURA_PIN_TERMINAL,IN_TRACK2,IN_NRO_REFER_RECUPERACION,IN_COD_AUTORIZACION,IN_TERMINAL,IN_COD_COMERCIO_EXTERNO,IN_TRACK1,IN_DATOS_ADICIONALES_046,IN_DATOS_ADICIONALES_048,IN_PIN_TARJETA,IN_COD_MONEDA_OPERACION,IN_IMPORTES_ADICIONALES,IN_DATOS_SEGURIDAD_PIN,IN_DATOS_ICC,IN_DATOS_ADICIONALES_059,IN_VERSION,IN_TIPO_TERMINAL,IN_NRO_TICKET,IN_PLAN_EXTERNO,IN_CUOTAS,IN_CVC2,IN_NRO_CUENTA1,IN_NRO_CUENTA2,IN_ID_USUARIO_ALTA,IN_FECHA_HORA_TRANSMISION,OUT_TIPO_MENSAJE,OUT_COD_PROCESAMIENTO,OUT_IMPORTE_OPERACION,OUT_MCC,OUT_COD_PAIS_CUENTA_PRIMARIA,OUT_IMPORTE_CARGO_TRANSACCION,OUT_ICA,OUT_ICA_REENVIO,OUT_NRO_REFER_RECUPERACION,OUT_COD_AUTORIZACION,OUT_COD_RESPUESTA,OUT_OBSERVACION,OUT_ID_RESPUESTA_INTERNA,OUT_DATOS_ADICIONALES_046,OUT_DATOS_ADICIONALES_048,OUT_IMPORTES_ADICIONALES,OUT_DATOS_PUNTO_SERVICIO,OUT_IMPORTE_REEMPLAZO,FECHA_TRANSACCION_INI,FECHA_TRANSACCION_FIN,ID_TIPO_AUTORIZACION_ADQ_LOG,PRESENTACION_PROCESADA,ID_CONSULTA_ORIGINAL,ID_AUTORIZACION_ORIGINAL,ANULAR_REVERSAR,ID_AUTO_ADQ_ANULAR_REVERSAR,ID_AUTO_ADQ_ORIGEN,OUT_ID_TIPO_RED_EMISOR,PRODUCTO,IN_TRACE_SWITCH,IN_FECHA_TRANSMISION_SWITCH,OUT_DATOS_ORIGINALES,IN_NRO_LOTE,TIPO_PRODUCTO,OUT_DATOS_ADICIONALES_112,IN_INGRESO_PIN,EXPONENTE_IMPORTE_OPERACION,OUT_CODIGO_MOTIVO_AVISO_60,OUT_DATOS_RED_ORIGINAL,OUT_COD_RESPUESTA_ORIGINAL,OUT_COMERCIO_43,OUT_FECHA_LIQUIDACION_ORIGINAL,IN_COD_RESPUESTA,IN_DE_25,OUT_DE_19,OUT_DE_59,OUT_DE_60,OUT_DE_61,OUT_DE_62,OUT_DE_104,OUT_DE_115,OUT_DE_117,OUT_DE_118,OUT_DE_121,OUT_DE_123,OUT_DE_125,OUT_DE_126,ID_MARCA,OUT_DE_63,IN_ESTADO_SENTINEL,OUT_DE_11,ICA_EMISOR,OUT_DE_124,OUT_DE_120,IN_CODIGO_POSTAL_COMERCIO,IN_TCC_COMERCIO,IN_PROVINCIA_COMERCIO,IN_IMPORTE_CASH_BACK,IN_IMPORTE_PROPINA,IN_TIPO_FINANCIACION,IN_CAPACIDAD_CAPTURA_PAN,IN_CAPACIDAD_CAPTURA_PIN,IN_METODO_VERIFICACION_SOCIO,IN_CIUDAD_COMERCIO,IN_NOMBRE_COMERCIO,IN_DIRECCION_COMERCIO,IN_SERVICE_PROVIDER_NAME,IN_NOMBRE_SOCIO,IN_DOCUMENTO_SOCIO,OUT_DE_22,IN_COD_SUB_COMERCIO,OUT_DE_49,IN_ORIGEN_FEC_HORA_TRANSMISION,IN_MOTIVO_CANCELACION,IN_PAN_MODO_INGRESO,OUT_DE_12,OUT_DE_13,OUT_DE_14,OUT_DE_110,OUT_DE_39,IN_ORIGEN_NRO_TRACE,IN_FECHA_LOCAL_TRANSACTION,IN_ORIGEN_FECHA_LOCAL_TRANSAC,OUT_DE_25,REFERENCIA_DA,PERIODO_DA,IN_3DS_TRANSACTION_ID,IN_3DS_PROTOCOL,IN_3DS_CRYPTOGRAM,IN_3DS_SLI,IN_3DS_CAVV,TRANSACCION_ORIGEN_DA,SERVICE_CODE,IN_DE_24,IN_MCC_COMERCIO,FORMATO_MENSAJE,IN_DE_61,IN_PLAN_FINANCIACION,STATUS_PIN,OUT_DE_114,OUT_DE_56,REQUEST_ID_SWITCH,OUT_DE_7,OUT_DE_108,OUT_DE_127) values ('350211','700','12','10','0200','2DB577840DAD361818EE01A6B7AC4540','000000','000003000000','123456','212038','0317','2512','0110',null,null,null,null,null,'8238','8228',null,null,null,null,'032',null,null,null,null,null,'3','9999','0','01',null,null,null,null,'2022-03-17T21:20:38.073Z','0100','000000','000003000000','5712',null,null,'446809',null,'221620350211',null,'00','OK, No consultado en Sentinel','0',null,null,null,null,null,to_timestamp('04/08/2022 05:33:37,771666000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),to_timestamp('04/08/2022 05:33:37,823925000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),'1','1',null,null,null,null,null,'22',null,'9528','20220804203337',null,'99','C',null,'0','2',null,null,null,'AUTO-MANT.FECHA/DIARIO-D SARANDI      AR',null,null,null,'032',null,'920000000010',null,null,null,null,null,null,null,null,null,null,'2','{\"\"format\"\": \"\"BITMAP\"\" , \"\"sub1\"\": \"\"0000\"\" }','-1','009528','476134',null,null,null,' ',null,null,null,'0','7','1','4',null,null,null,'SoyListo',null,null,'0110',null,'032',null,null,'1','212038','0317','2512',null,null,null,to_timestamp('17/03/2022 09:20:38,073000000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),null,'00',null,null,null,null,null,null,null,null,null,'0',null,'2',null,'0','0',null,null,'ff76a4eb-e341-4e32-a355-d66256d3b9f7','0803213337',null,null)";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//Acción 02-
		queryPre = "Insert into RESPUESTA_MC_LOG (ID_RESPUESTA_MC,IN_ID_ENTIDAD,IN_ID_ORIGEN,IN_ID_TIPO_RED,IN_ID_AUTORIZACION_ADQUIRENTE,IN_TIPO_MENSAJE,IN_NRO_TARJETA,IN_COD_PROCESAMIENTO,IN_IMPORTE_OPERACION,IN_IMPORTE_LIQUIDACION,IN_IMPORTE_EMISOR,IN_FECHA_HORA_TRANSMISION,IN_TASA_LIQUIDACION,IN_TASA_EMISOR,IN_HORA_LOCAL,IN_FECHA_LOCAL,IN_NRO_TRACE,IN_FECHA_LIQUIDACION,IN_FECHA_CONVERSION,IN_COD_PAIS_CUENTA_PRIMARIA,IN_NRO_SECUENCIA_TARJETA,IN_IMPORTE_CARGO_TRANSACCION,IN_ICA,IN_ICA_REENVIO,IN_NRO_REFER_RECUPERACION,IN_COD_AUTORIZACION,IN_COD_RESPUESTA,IN_TERMINAL,IN_COD_COMERCIO_EXTERNO,IN_DATOS_ADICIONALES_RESPUESTA,IN_DATOS_ADICIONALES_048,IN_COD_MONEDA_OPERACION,IN_COD_MONEDA_LIQUIDACION,IN_COD_MONEDA_EMISOR,IN_IMPORTES_ADICIONALES,IN_DATOS_ICC,IN_DATOS_RED_INTERMEDIARIA,IN_DATOS_RED,IN_DATOS_MENSAJE_ORIGINAL,IN_DATOS_IMPORTE_REVERSA,IN_NRO_CUENTA1,IN_NRO_CUENTA2,IN_DATOS_REFERENCIA_MONEYSEND,IN_DATOS_ADICIONALES_112,IN_PLAN_EXTERNO,IN_CUOTAS,IN_DATOS_REGISTRO,IN_COD_PROCESO_STANDIN,IN_MENSAJE_TICKET,IN_DATOS_MIEMBRO,IN_DATOS_INICIADOR_MENSAJE,IN_ID_TIPO_RED_EMISOR,OUT_ID_RESPUESTA_INTERNA,OUT_OBSERVACION,OUT_COD_AUTORIZACION,OUT_COD_RESPUESTA,OUT_DATOS_ADICIONALES_046,OUT_IMPORTES_ADICIONALES,ID_AUTORIZACION_ADQUIRENTE,FECHA_TRANSACCION_INI,FECHA_TRANSACCION_FIN,IN_SWITCH_PRIVATE_DATA_126,IN_DE_19,IN_DE_25,IN_DE_62,IN_DE_63,IN_DE_73,IN_DE_91,IN_DE_101,IN_DE_104,IN_DE_115,IN_DE_116,IN_DE_117,IN_DE_118,IN_DE_121,IN_DE_123,IN_DE_126,IN_DE_127,ID_MARCA,IN_DE_124,IN_DE_56,IN_DE_58,IN_DE_100,IN_DE_105,OUT_DE_60,IN_DE_114,IN_DE_34,IN_RESPONSE_STATUS) values ('105092','700','12','10','350211','0110','2DB577840DAD361818EE01A6B7AC4540','000000','000003000000',null,null,'0803213337',null,'61000000',null,null,'009528',null,null,null,null,null,'446809',null,'221620350211','006853','00','8238    ','8228           ',' U',null,'032',null,'840',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'0','1','OK','006853','00',null,null,'350211',to_timestamp('04/08/2022 05:33:38,514772000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),to_timestamp('04/08/2022 05:33:38,660490000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),null,null,null,'40000000000000000312216092182937','8000000000',null,null,null,null,null,null,null,null,null,null,null,null,'2',null,null,null,null,null,null,null,null,null)";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//Acción 03-
		queryPre = "Insert into AUTORIZACION (ID_AUTORIZACION,ID_ENTIDAD,NRO_TARJETA,COD_AUTO_ENTIDAD,COD_AUTO_EMISOR,ID_MONEDA_ORIGEN,IMPORTE_ORIGEN,FECHA_AUTORIZACION,COTIZACION,ID_MONEDA,IMPORTE,IMPORTE_SIN_DTO,ID_ESTADO_TIPO,ID_ESTADO,FECHA_ANULACION,ID_USUARIO_ANULACION,ID_COMERCIO,COMERCIO_DESCRIPCION,CUOTAS,TASA_SOCIO,IMPORTE_CUOTAS,MCC,ID_RUBRO,ID_SUBRUBRO,TCC,COD_COMERCIO_EXTERNO,TERMINAL_POS,ID_COD_MOVIMIENTO,ID_GRUPO_TRANSACCION,ID_MODELO_TRANSACCION,ID_AUTORIZACION_ADQUIRENTE,ID_CODIGO_DEVOLUCION,IMPORTE_DEVOLUCION,ID_RESPUESTA_MC,FECHA_RELACION,OBSERVACION,MODO_INGRESO,FECHA_INFORMADA,COD_RESPUESTA,ID_RESPUESTA_INTERNA,ID_MOD_FINANC_COMERCIO,ID_PAIS_EMISOR,COD_PAIS_COMERCIO,COD_PAIS_EMISOR,PRESENTACION_PROCESADA,IMPORTE_TOTAL_PRESENTADO,ID_ORIGEN,COEFICIENTE_DIFERENCIA_CAMBIO,ID_CUENTA,ID_ADICIONAL,ID_MONEDA_LIQUIDACION,IMPORTE_LIQUIDACION,ID_AUTORIZACION_EMISOR,COD_SUB_COMERCIO,TRN_EXTERNAL_ID,ID_REGLA_FRAUDE,ID_MARCA,NRO_TARJETA_ENMASCARADA,DEBITO_AUTOMATICO,PORCENTAJE_DEVOLUCION,ECOMMERCE,TID,COD_RESPUESTA_POS,ES_CASHBACK,ID_AUTORIZACION_ORIGINAL,FECHA_DIFERIMIENTO,IMPORTE_CONVERTIDO,DIAS_DIFERIMIENTO,ES_PROPINA,MONTO_ACUM_DEVOLUCIONES,MOTIVO_REVERSO,CANT_INTENTOS_REVERSOS,INTENTOS_REVERSOS_EXCEDIDOS,ID_SUBTIPO_AUTORIZACION) values ('344034','700','2DB577840DAD361818EE01A6B7AC4540','006853',null,'32','30000',to_date('04/08/2022 17:33:37','DD/MM/RRRR HH24:MI:SS'),'1','32','30000','0','41','0',null,null,'8228','AUTO-MANT.FECHA/DIARIO-D SARANDI      AR','1','0','30000','5712','41000','41020','R','8228','8238','1','1','9','350211','0','0','105092',to_date('04/08/2022 17:36:35','DD/MM/RRRR HH24:MI:SS'),'OK, No consultado en Sentinel','01',to_date('04/08/2022 17:33:37','DD/MM/RRRR HH24:MI:SS'),'00','1','14',null,'AR','UY','2','0','12','1',null,null,null,null,null,null,null,null,'2','476134xxxxxx0035','0','0','0','312216092182937','00','0',null,null,null,null,'0','0',null,null,null,null)";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//Acción 04-
		queryPre = "Insert into CONSUMOS (ID_ENTIDAD,ID_CONSUMO,ID_CUENTA,ID_ADICIONAL,NRO_TARJETA,ID_COMERCIO,IMPORTE_TOTAL,COD_AUTORIZACION,IMPORTE_ARANCEL,CUOTAS,NRO_CUOTA,FECHA_OPER,FECHA_PRESENT,FECHA_CIERRE_COMERCIO,FECHA_AUTORIZ,FECHA_PROCESO,NOMBRE_FANTASIA,ID_MONEDA,ID_MONEDA_ORIG,IMPORTE_MONEDA_ORIG,ID_RUBRO,ID_COD_MOVIMIENTO,ID_MODELO_CIERRE_COMERCIO,ID_MODELO_PAGO_COMERCIO,ID_GRUPO_TRANSACCION,ID_FORMA_PAGO_COMERCIO,FECHA_PAGO_COMERCIO,LIQ_SOCIO,LIQ_COMERCIO,ID_COMERCIO_CENTRAL,CAIDA_CUOTAS,ID_AUTORIZACION,IMPORTE_INTERES_SOCIO,IMPORTE_IVA_INT_SOCIO,ID_MOD_FINANC_COMERCIO,IMPORTE_INTERES_COM,ARANCEL,PORCENTAJE_FINANC,NRO_TERMINAL,NRO_LOTE,NRO_COMPROBANTE,PLAZO_INSTRUMENTO_PAGO,APLICA_SOCIO,APLICA_COMERCIO,ID_SUCURSAL_SOCIO,ID_SUCURSAL_COMERCIO,ID_MOTIVO_CONTRAPARTIDA,IMPORTE_SIN_DTO,OBSERV_AUTO,ID_SISTEMA_FINANCIACION,TIPO_PORC_FINANC,TIPO_PRODUCTO,REFERENCIA,ID_AUDITORIA,ROW_VERSION,ROW_FECHA,ID_ESTADO_TIPO_CONFIRM,ID_ESTADO_CONFIRM,IMPORTE_IVA_INTERES_COM,COD_COMERCIO,DEBITO_AUTOMATICO,COTIZACION,FECHA_COTIZACION,COD_SUB_COMERCIO,FECHA_CIERRE_SOCIO,ID_MARCA,ECOMMERCE,ID_ORIGEN,TIENE_PROMOCION,ID_CONSUMO_ORIGINAL,IMPORTE_CONVERTIDO,IMPORTE_BASE) values ('700','473647',null,null,'2DB577840DAD361818EE01A6B7AC4540','8228','30000','006853','-15000','1','1',to_date('04/08/2022 17:33:37','DD/MM/RRRR HH24:MI:SS'),to_date('04/08/2022 00:00:00','DD/MM/RRRR HH24:MI:SS'),to_date('04/08/2022 00:00:00','DD/MM/RRRR HH24:MI:SS'),to_date('04/08/2022 17:33:37','DD/MM/RRRR HH24:MI:SS'),to_date('04/08/2022 17:36:35','DD/MM/RRRR HH24:MI:SS'),'AUTO-MANT.FECHA/DIARIO-D SARANDI      AR','32','32','30000','41000','1','14','12','1','2',to_date('09/08/2022 00:00:00','DD/MM/RRRR HH24:MI:SS'),'0','0','8228','0','344034','0','0',null,'0','50',null,'8238','99','9999',null,'0','1',null,'1',null,'0',null,null,null,'C',null,'19000','3',to_date('10/08/2022 18:12:47','DD/MM/RRRR HH24:MI:SS'),'40','1','0','8228','0','1',to_date('04/08/2022 17:33:37','DD/MM/RRRR HH24:MI:SS'),null,null,'2','0','12',null,null,'0','30000')";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//Acción 05-
		queryPre = "Insert into PRESENTACIONES (ID_PRESENTACION,ID_ENTIDAD,ID_COMERCIO,FECHA_PRESENTACION,ID_CIERRE,ID_AUTORIZACION_ADQUIRENTE,ID_AUTORIZACION,ID_CONSUMO,ID_OFFLINE_PARAM,ID_ESTADO_TIPO,ID_ESTADO,OBSERVACION,ID_AUDITORIA,ROW_VERSION,ROW_FECHA,ID_ESTADO_TIPO_CONFIRM,ID_ESTADO_CONFIRM) values ('153425','700','8228',to_date('04/08/2022 00:00:00','DD/MM/RRRR HH24:MI:SS'),null,'350211','344034','473647',null,'50','0','OK',null,null,null,'40',null)";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//Acción 06-
		queryPre = "Insert into CONSUMOS_DATOS_ADICIONALES (ID_ENTIDAD,ID_CONSUMO,FECHA_IPM,PRODUCTO,MCC,ICA_ADQUIRENTE,ICA_EMISOR,TASA_INTERCAMBIO,ID_AUDITORIA,ROW_VERSION,ROW_FECHA,ID_ESTADO_TIPO_CONFIRM,ID_ESTADO_CONFIRM,TYPE_SETTLEMENT,FECHA_SETTLEMENT,GROUP_CODE,CODIGO_MOTIVO,MODO_INGRESO,DECIMALPOSINDIC,IMPORTE_INTERES_DF,IMPORTE_IVA_INTERES_DF,TYPE_INSTALLMENT,VAT_INSTAL_PAY_RISK_FEE_AMOUNT,INSTAL_PAY_RISK_FEE_AMOUNT,DIAS_DIFERIMIENTO) values ('700','473647',to_date('04/08/2022 20:53:34','DD/MM/RRRR HH24:MI:SS'),null,'5712','446809','476134','0','18858','1',to_date('04/08/2022 20:36:35','DD/MM/RRRR HH24:MI:SS'),'40','0',' ',to_date('05/08/2022 00:00:00','DD/MM/RRRR HH24:MI:SS'),null,null,'01','0',null,null,null,null,null,null)";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//Acción 07-
		queryPre = "Insert into CONSUMOS_CUOTAS (ID_CONSUMO,NRO_CUOTA,CUOTAS,IMPORTE_CUOTA,IMPORTE_INTERES,IMPORTE_IVA_INTERES,LIQ_SOCIO,LIQ_COMERCIO,CAIDA_CUOTAS,FIDEICOMISO,CONTRAPARTIDO,ID_AUDITORIA,ROW_VERSION,ROW_FECHA,ID_ESTADO_TIPO_CONFIRM,ID_ESTADO_CONFIRM,FECHA_CIERRE_COMERCIO,FECHA_PAGO_COMERCIO,FECHA_CIERRE_SOCIO,FECHA_IPM,ARANCEL,IMPORTE_ARANCEL) values ('473647','1','1','30000','0','0','0','0','0','0','1','19000','3',to_date('10/08/2022 18:12:48','DD/MM/RRRR HH24:MI:SS'),'40','1',to_date('04/08/2022 00:00:00','DD/MM/RRRR HH24:MI:SS'),to_date('09/08/2022 00:00:00','DD/MM/RRRR HH24:MI:SS'),null,to_date('04/08/2022 20:53:34','DD/MM/RRRR HH24:MI:SS'),'50','-15000')";
		res.add(oraWorker.oraInsert(queryPre, conn));

		oraWorker.getDisConn(conn);

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

		//Deletes referidas al consumo
		//Accion 01
		queryPost = "delete from consumos_cuotas where id_consumo = '473647'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 02	
		queryPost = "delete from consumos_datos_adicionales where id_consumo = '473647'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 03	
		queryPost = "delete from presentaciones where id_consumo = '473647'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 04	
		queryPost = "delete from consumos where id_consumo = '473647'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 05	
		queryPost = "delete from autorizacion where id_autorizacion_adquirente = '350211'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 06	
		queryPost = "delete from respuesta_mc_log where id_autorizacion_adquirente = '350211'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 07		
		queryPost = "delete from autorizacion_adquirente_log where id_autorizacion_adquirente = '350211'";
		res.add(oraWorker.oraDelete(queryPost, conn));
		
		oraWorker.getDisConn(conn);

		//Validación POSTCONDICIONES
		for(Integer resultados : res) {
			if (resultados == 1 || resultados == 0) {
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
		String queryPost;
		conn = oraWorker.getConn();

		//Accion 01
		queryPost = "delete from consumos_cuotas where id_consumo = '473647'";
		oraWorker.oraDelete(queryPost, conn);

		//Accion 02	
		queryPost = "delete from consumos_datos_adicionales where id_consumo = '473647'";
		oraWorker.oraDelete(queryPost, conn);

		//Accion 03	
		queryPost = "delete from presentaciones where id_consumo = '473647'";
		oraWorker.oraDelete(queryPost, conn);

		//Accion 04	
		queryPost = "delete from consumos where id_consumo = '473647'";
		oraWorker.oraDelete(queryPost, conn);

		//Accion 05	
		queryPost = "delete from autorizacion where id_autorizacion_adquirente = '350211'";
		oraWorker.oraDelete(queryPost, conn);

		//Accion 06	
		queryPost = "delete from respuesta_mc_log where id_autorizacion_adquirente = '350211'";
		oraWorker.oraDelete(queryPost, conn);

		//Accion 07		
		queryPost = "delete from autorizacion_adquirente_log where id_autorizacion_adquirente = '350211'";
		oraWorker.oraDelete(queryPost, conn);
		
		oraWorker.getDisConn(conn);
	}
}