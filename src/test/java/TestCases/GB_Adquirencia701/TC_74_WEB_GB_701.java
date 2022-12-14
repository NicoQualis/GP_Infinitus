
package TestCases.GB_Adquirencia701;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Pasos.Generales.Acceso;
import Pasos.Generales.GBatch;
import Pasos.GlobalBatch_ADQ_701.TC_74_GB_PASOS_ADQ_701;
import Repositories.Repo_WebRepository;
import Tools.dbWorker;
import io.restassured.path.json.JsonPath;

public class TC_74_WEB_GB_701 {
	private WebDriver driver;
	private dbWorker oraWorker;
	String[] Status = new String[2];

	//String para reservar una Query para usar en validacion 4
	String NRO_LIQUIDACION;

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
			TC_74_GB_PASOS_ADQ_701 pasos = new TC_74_GB_PASOS_ADQ_701();
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
			gralBatch.buscarSeleccionar(report, repo, "Liquidaci??n Comercios", "701-Scanntech Uruguay Hosting SA");
			gralBatch.seleccionarLanzarProceso(report, repo, DM, name,  "Liquidaci??n Comercios");
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

	private boolean validacionesWeb(Reports report, Repo_WebRepository repo, DriverManager DM, String name, String runId, TC_74_GB_PASOS_ADQ_701 pasos) {

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

		//Primer validaci??n
		queryVerif ="select liq_comercio from consumos where id_consumo in('15728')";

		primeraValidacion(oraWorker, report, queryVerif);

		//Segunda validaci??n
		queryVerif ="select liq_comercio from consumos_cuotas where id_consumo in('15728')";

		segundaValidacion(oraWorker, report, queryVerif);

		//Tercera validaci??n
		queryVerif ="select c.fecha_pago,  c.nro_liquidacion from comercios_liq_cabecera c where c.id_comercio_central = '8228' and c.fecha_cierre_liquidacion = '14/07/2022' order by c.nro_liquidacion desc";

		terceraValidacion(oraWorker, report, queryVerif);

		//Cuarta validaci??n
		queryVerif ="select id_consumo from comercios_liq_detalles where id_consumo in('15728')";

		cuartaValidacion(oraWorker, report, queryVerif);

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

		//Validaci??n del LIQ_COMERCIO   - Tiene que ser igual a 1
		if (!respVerifBDD.equals("1")) {
			report.AddLineAssertionError("Resultado no esperado de la validacion 1.El campo LIQ_COMERCIO, de la tabla CONSUMOS tiene el registro :" + respVerifBDD.toString() + " Se esperaba: 1");
			System.out.println("Resultado no esperado de la validacion 1. El campo LIQ_COMERCIO, de la tabla CONSUMOS  tiene el registro :" + respVerifBDD.toString() + " Se esperaba: 1 \r\n");
			Status[0] = "FAIL - Validaci??n del LIQ_COMERCIO de la tabla CONSUMOS ";
		}	else {
			report.AddLine("Resultado correcto de la validacion 1. El campo LIQ_COMERCIO, de la tabla CONSUMOS  tiene el registro: " + respVerifBDD.toString());
			System.out.println("Resultado correcto de la validacion 1. El campo LIQ_COMERCIO,de la tabla CONSUMOS  tiene el registro: " + respVerifBDD.toString() + "\r\n");
			Status[0] = "P";
		}

	}		

	private void segundaValidacion(dbWorker oraResp, Reports report, String query) throws SQLException {
		String respVerifBDD; 
		respVerifBDD = oraResp.oraOneQuery(query);

		//Validaci??n del LIQ_COMERCIO   - Tiene que ser igual a 1
		if (!respVerifBDD.equals("1")) {
			report.AddLineAssertionError("Resultado no esperado de la validacion 2. El campo LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS  tiene el registro :" + respVerifBDD.toString() + " Se esperaba: 1");
			System.out.println("Resultado no esperado de la validacion 2. El campo LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS tiene el registro :" + respVerifBDD.toString() + " Se esperaba: 1 \r\n");
			Status[1] = "FAIL - Validaci??n del LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS  ";
		}	else {
			report.AddLine("Resultado Correcto de la validacion 2. El campo LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS   tiene el registro: " + respVerifBDD.toString());
			System.out.println("Resultado Correcto de la validacion 2. El campo LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS tiene el registro: " + respVerifBDD.toString() + "\r\n");
			Status[1] = "P";
		}
	}

	private void terceraValidacion(dbWorker oraResp, Reports report, String query) throws SQLException {
		String[] respVerifBDD=new String[2]; 
		respVerifBDD = oraResp.oraTwoQuery(query);
		NRO_LIQUIDACION=respVerifBDD[1];

		//Validaci??n del FECHA_PAGO    - Tiene que ser igual a 19/07/2022 00:00:00
		if (!respVerifBDD[0].equals("2022-07-19 00:00:00")) {
			report.AddLineAssertionError("Resultado no esperado de la validacion 2. El campo FECHA_PAGO  de la tabla comercios_liq_cabecera  tiene el registro :" + respVerifBDD[0].toString() + " Se esperaba: 2022-07-19 00:00:00");
			System.out.println("Resultado no esperado de la validacion 2. El campo FECHA_PAGO  de la tabla comercios_liq_cabecera tiene el registro :" + respVerifBDD[0].toString() + " Se esperaba: 2022-07-19 00:00:00 \r\n");
			Status[1] = "FAIL - Validaci??n del FECHA_PAGO  de la tabla comercios_liq_cabecera ";
		}	else {
			report.AddLine("Resultado Correcto de la validacion 2. El campo FECHA_PAGO de la tabla comercios_liq_cabecera tiene el registro: " + respVerifBDD[0].toString());
			System.out.println("Resultado Correcto de la validacion 2. El campo FECHA_PAGO de la tabla comercios_liq_cabecera tiene el registro: " + respVerifBDD[0].toString() + "\r\n");
			Status[1] = "P";
		}
	}

	private void cuartaValidacion(dbWorker oraResp, Reports report, String query) throws SQLException {
		String respVerifBDD; 
		respVerifBDD = oraResp.oraOneQuery(query);

		//Validaci??n del ID_CONSUMO    - Tiene que ser igual a 15728
		if (!respVerifBDD.equals("15728")) {
			report.AddLineAssertionError("Resultado no esperado de la validacion 2. El campo LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS  tiene el registro :" + respVerifBDD.toString() + " Se esperaba: "+NRO_LIQUIDACION+"");
			System.out.println("Resultado no esperado de la validacion 2. El campo LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS tiene el registro :" + respVerifBDD.toString() + " Se esperaba: "+NRO_LIQUIDACION+" "+" \r\n");
			Status[1] = "FAIL - Validaci??n del LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS  ";
		}	else {
			report.AddLine("Resultado Correcto de la validacion 2. El campo LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS   tiene el registro: " + respVerifBDD.toString());
			System.out.println("Resultado Correcto de la validacion 2. El campo LIQ_COMERCIO de la tabla CONSUMOS_CUOTAS tiene el registro: " + respVerifBDD.toString() + "\r\n");
			Status[1] = "P";
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
		//Acci??n 01 - 
		queryPre = "Insert into AUTORIZACION_ADQUIRENTE_LOG (ID_AUTORIZACION_ADQUIRENTE,IN_ID_ENTIDAD,IN_ID_ORIGEN,IN_ID_TIPO_RED,IN_TIPO_MENSAJE,IN_NRO_TARJETA,IN_COD_PROCESAMIENTO,IN_IMPORTE_OPERACION,IN_NRO_TRACE,IN_HORA_LOCAL,IN_FECHA_LOCAL,IN_FECHA_VTO_TARJETA,IN_MODO_INGRESO_TERMINAL,IN_NRO_SECUENCIA_TARJETA,IN_COD_CAPTURA_PIN_TERMINAL,IN_TRACK2,IN_NRO_REFER_RECUPERACION,IN_COD_AUTORIZACION,IN_TERMINAL,IN_COD_COMERCIO_EXTERNO,IN_TRACK1,IN_DATOS_ADICIONALES_046,IN_DATOS_ADICIONALES_048,IN_PIN_TARJETA,IN_COD_MONEDA_OPERACION,IN_IMPORTES_ADICIONALES,IN_DATOS_SEGURIDAD_PIN,IN_DATOS_ICC,IN_DATOS_ADICIONALES_059,IN_VERSION,IN_TIPO_TERMINAL,IN_NRO_TICKET,IN_PLAN_EXTERNO,IN_CUOTAS,IN_CVC2,IN_NRO_CUENTA1,IN_NRO_CUENTA2,IN_ID_USUARIO_ALTA,IN_FECHA_HORA_TRANSMISION,OUT_TIPO_MENSAJE,OUT_COD_PROCESAMIENTO,OUT_IMPORTE_OPERACION,OUT_MCC,OUT_COD_PAIS_CUENTA_PRIMARIA,OUT_IMPORTE_CARGO_TRANSACCION,OUT_ICA,OUT_ICA_REENVIO,OUT_NRO_REFER_RECUPERACION,OUT_COD_AUTORIZACION,OUT_COD_RESPUESTA,OUT_OBSERVACION,OUT_ID_RESPUESTA_INTERNA,OUT_DATOS_ADICIONALES_046,OUT_DATOS_ADICIONALES_048,OUT_IMPORTES_ADICIONALES,OUT_DATOS_PUNTO_SERVICIO,OUT_IMPORTE_REEMPLAZO,FECHA_TRANSACCION_INI,FECHA_TRANSACCION_FIN,ID_TIPO_AUTORIZACION_ADQ_LOG,PRESENTACION_PROCESADA,ID_CONSULTA_ORIGINAL,ID_AUTORIZACION_ORIGINAL,ANULAR_REVERSAR,ID_AUTO_ADQ_ANULAR_REVERSAR,ID_AUTO_ADQ_ORIGEN,OUT_ID_TIPO_RED_EMISOR,PRODUCTO,IN_TRACE_SWITCH,IN_FECHA_TRANSMISION_SWITCH,OUT_DATOS_ORIGINALES,IN_NRO_LOTE,TIPO_PRODUCTO,OUT_DATOS_ADICIONALES_112,IN_INGRESO_PIN,EXPONENTE_IMPORTE_OPERACION,OUT_CODIGO_MOTIVO_AVISO_60,OUT_DATOS_RED_ORIGINAL,OUT_COD_RESPUESTA_ORIGINAL,OUT_COMERCIO_43,OUT_FECHA_LIQUIDACION_ORIGINAL,IN_COD_RESPUESTA,IN_DE_25,OUT_DE_19,OUT_DE_59,OUT_DE_60,OUT_DE_61,OUT_DE_62,OUT_DE_104,OUT_DE_115,OUT_DE_117,OUT_DE_118,OUT_DE_121,OUT_DE_123,OUT_DE_125,OUT_DE_126,ID_MARCA,OUT_DE_63,IN_ESTADO_SENTINEL,OUT_DE_11,ICA_EMISOR,OUT_DE_124,OUT_DE_120,IN_CODIGO_POSTAL_COMERCIO,IN_TCC_COMERCIO,IN_PROVINCIA_COMERCIO,IN_IMPORTE_CASH_BACK,IN_IMPORTE_PROPINA,IN_TIPO_FINANCIACION,IN_CAPACIDAD_CAPTURA_PAN,IN_CAPACIDAD_CAPTURA_PIN,IN_METODO_VERIFICACION_SOCIO,IN_CIUDAD_COMERCIO,IN_NOMBRE_COMERCIO,IN_DIRECCION_COMERCIO,IN_SERVICE_PROVIDER_NAME,IN_NOMBRE_SOCIO,IN_DOCUMENTO_SOCIO,OUT_DE_22,IN_COD_SUB_COMERCIO,OUT_DE_49,IN_ORIGEN_FEC_HORA_TRANSMISION,IN_MOTIVO_CANCELACION,IN_PAN_MODO_INGRESO,OUT_DE_12,OUT_DE_13,OUT_DE_14,OUT_DE_110,OUT_DE_39,IN_ORIGEN_NRO_TRACE,IN_FECHA_LOCAL_TRANSACTION,IN_ORIGEN_FECHA_LOCAL_TRANSAC,OUT_DE_25,REFERENCIA_DA,PERIODO_DA,IN_3DS_TRANSACTION_ID,IN_3DS_PROTOCOL,IN_3DS_CRYPTOGRAM,IN_3DS_SLI,IN_3DS_CAVV,TRANSACCION_ORIGEN_DA,SERVICE_CODE,IN_DE_24,IN_MCC_COMERCIO,FORMATO_MENSAJE,IN_DE_61,IN_PLAN_FINANCIACION,STATUS_PIN,OUT_DE_114,OUT_DE_56,REQUEST_ID_SWITCH,OUT_DE_7,OUT_DE_108,OUT_DE_127) values ('20990','701','12','10','0200','2DB577840DAD361818EE01A6B7AC4540','000000','000007130000','003232','060001','0724',null,'900',null,null,'2DB577840DAD361818EE01A6B7AC454002B0E5D2C4D95346D72D14C42AAE36FF772C054F6593F6B1',null,null,'5001555','00008228',null,'12         #0112000000477701','001',null,'858',null,null,null,'0210001001070700100010022000000800040120010000001000000120020000005000000010032001004A0090002002001220070021111111','40iPOSS61','0','4','0','01',null,null,null,null,'1129101010','0100','000000','000007130000','7230',null,null,'019353',null,'219518020990',null,'00','OK, Sentinel OK','0',null,null,null,null,null,to_timestamp('14/07/2022 03:18:11,499589000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),to_timestamp('14/07/2022 03:18:11,843349000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),'1','1',null,null,null,null,null,'22',null,'8078','20220714181811',null,'567','C',null,'0','2',null,null,null,'AUTO-MANT.FECHA/DIARIO-D SARANDI      UY',null,null,'00','858',null,'050000000000',null,null,null,null,null,null,null,null,null,null,'2','{\"format\": \"BITMAP\" , \"sub1\": \"0000\" }','1','008078','476134',null,null,null,'',null,null,null,'0',null,null,null,null,null,null,null,null,null,'9000',null,'858',null,null,null,'060001','0724',null,null,null,null,to_timestamp('14/07/2022 03:18:11,530000000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),null,'00',null,null,null,null,null,null,null,null,'101','3',null,'1','10002','0','0','{\"format\":\"TLV\",\"dataset_6C\":{\"tag_C0\":\"0\",\"tag_C1\":\"02\",\"tag_C2\":\"000000001000\",\"tag_C3\":\"000000010000\",\"tag_C4\":\"000000000000\",\"tag_C5\":\"000000500000\",\"tag_C6\":\"0002\",\"tag_C7\":\"22\",\"tag_C8\":\"1111111\",\"tag_C9\":\"I\",\"tag_D1\":\"2200\",\"tag_D3\":\" \",\"tag_D5\":\"210140110011\"}}',null,'06005696-559a-446a-a517-3f9a1c9ab68d','0714121811',null,null)";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//Acci??n 02-
		queryPre = "Insert into RESPUESTA_MC_LOG (ID_RESPUESTA_MC,IN_ID_ENTIDAD,IN_ID_ORIGEN,IN_ID_TIPO_RED,IN_ID_AUTORIZACION_ADQUIRENTE,IN_TIPO_MENSAJE,IN_NRO_TARJETA,IN_COD_PROCESAMIENTO,IN_IMPORTE_OPERACION,IN_IMPORTE_LIQUIDACION,IN_IMPORTE_EMISOR,IN_FECHA_HORA_TRANSMISION,IN_TASA_LIQUIDACION,IN_TASA_EMISOR,IN_HORA_LOCAL,IN_FECHA_LOCAL,IN_NRO_TRACE,IN_FECHA_LIQUIDACION,IN_FECHA_CONVERSION,IN_COD_PAIS_CUENTA_PRIMARIA,IN_NRO_SECUENCIA_TARJETA,IN_IMPORTE_CARGO_TRANSACCION,IN_ICA,IN_ICA_REENVIO,IN_NRO_REFER_RECUPERACION,IN_COD_AUTORIZACION,IN_COD_RESPUESTA,IN_TERMINAL,IN_COD_COMERCIO_EXTERNO,IN_DATOS_ADICIONALES_RESPUESTA,IN_DATOS_ADICIONALES_048,IN_COD_MONEDA_OPERACION,IN_COD_MONEDA_LIQUIDACION,IN_COD_MONEDA_EMISOR,IN_IMPORTES_ADICIONALES,IN_DATOS_ICC,IN_DATOS_RED_INTERMEDIARIA,IN_DATOS_RED,IN_DATOS_MENSAJE_ORIGINAL,IN_DATOS_IMPORTE_REVERSA,IN_NRO_CUENTA1,IN_NRO_CUENTA2,IN_DATOS_REFERENCIA_MONEYSEND,IN_DATOS_ADICIONALES_112,IN_PLAN_EXTERNO,IN_CUOTAS,IN_DATOS_REGISTRO,IN_COD_PROCESO_STANDIN,IN_MENSAJE_TICKET,IN_DATOS_MIEMBRO,IN_DATOS_INICIADOR_MENSAJE,IN_ID_TIPO_RED_EMISOR,OUT_ID_RESPUESTA_INTERNA,OUT_OBSERVACION,OUT_COD_AUTORIZACION,OUT_COD_RESPUESTA,OUT_DATOS_ADICIONALES_046,OUT_IMPORTES_ADICIONALES,ID_AUTORIZACION_ADQUIRENTE,FECHA_TRANSACCION_INI,FECHA_TRANSACCION_FIN,IN_SWITCH_PRIVATE_DATA_126,IN_DE_19,IN_DE_25,IN_DE_62,IN_DE_63,IN_DE_73,IN_DE_91,IN_DE_101,IN_DE_104,IN_DE_115,IN_DE_116,IN_DE_117,IN_DE_118,IN_DE_121,IN_DE_123,IN_DE_126,IN_DE_127,ID_MARCA,IN_DE_124,IN_DE_56,IN_DE_58,IN_DE_100,IN_DE_105,OUT_DE_60,IN_DE_114,IN_DE_34) values ('14600','701','12','10','20990','0110','2DB577840DAD361818EE01A6B7AC4540','000000','000007130000',null,null,'0714121811',null,'61000000',null,null,'008078',null,null,null,null,null,'019353',null,'219518020990','019026','00','5001555 ','8228           ','          M',null,'858',null,'840',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'0','1','OK','019026','00','12      ',null,'20990',to_timestamp('14/07/2022 03:18:12,562063000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),to_timestamp('14/07/2022 03:18:12,593314000 PM','DD/MM/RRRR HH12:MI:SSXFF AM'),null,'858','00','40000000000000000312195075721051','8000000000',null,null,null,null,null,null,null,null,null,null,null,null,'2',null,null,null,null,null,null,null,null)";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//Acci??n 03-
		queryPre = "Insert into AUTORIZACION (ID_AUTORIZACION,ID_ENTIDAD,NRO_TARJETA,COD_AUTO_ENTIDAD,COD_AUTO_EMISOR,ID_MONEDA_ORIGEN,IMPORTE_ORIGEN,FECHA_AUTORIZACION,COTIZACION,ID_MONEDA,IMPORTE,IMPORTE_SIN_DTO,ID_ESTADO_TIPO,ID_ESTADO,FECHA_ANULACION,ID_USUARIO_ANULACION,ID_COMERCIO,COMERCIO_DESCRIPCION,CUOTAS,TASA_SOCIO,IMPORTE_CUOTAS,MCC,ID_RUBRO,ID_SUBRUBRO,TCC,COD_COMERCIO_EXTERNO,TERMINAL_POS,ID_COD_MOVIMIENTO,ID_GRUPO_TRANSACCION,ID_MODELO_TRANSACCION,ID_AUTORIZACION_ADQUIRENTE,ID_CODIGO_DEVOLUCION,IMPORTE_DEVOLUCION,ID_RESPUESTA_MC,FECHA_RELACION,OBSERVACION,MODO_INGRESO,FECHA_INFORMADA,COD_RESPUESTA,ID_RESPUESTA_INTERNA,ID_MOD_FINANC_COMERCIO,ID_PAIS_EMISOR,COD_PAIS_COMERCIO,COD_PAIS_EMISOR,PRESENTACION_PROCESADA,IMPORTE_TOTAL_PRESENTADO,ID_ORIGEN,COEFICIENTE_DIFERENCIA_CAMBIO,ID_CUENTA,ID_ADICIONAL,ID_MONEDA_LIQUIDACION,IMPORTE_LIQUIDACION,ID_AUTORIZACION_EMISOR,COD_SUB_COMERCIO,TRN_EXTERNAL_ID,ID_REGLA_FRAUDE,ID_MARCA,NRO_TARJETA_ENMASCARADA,DEBITO_AUTOMATICO,PORCENTAJE_DEVOLUCION,ECOMMERCE,TID,COD_RESPUESTA_POS,ES_CASHBACK,ID_AUTORIZACION_ORIGINAL,FECHA_DIFERIMIENTO,IMPORTE_CONVERTIDO,DIAS_DIFERIMIENTO,ES_PROPINA,MONTO_ACUM_DEVOLUCIONES,ID_SUBTIPO_AUTORIZACION) values ('23089','701','2DB577840DAD361818EE01A6B7AC4540','019026',null,'858','71300',to_date('14/07/2022','DD/MM/RRRR'),'1','858','71300','0','41','0',null,null,'8228','AUTO-MANT.FECHA/DIARIO-D SARANDI      UY','1','0','71300','7230','53000','53033','R','00008228','5001555','1','10','7','20990','A','-100','14600',to_date('14/07/2022','DD/MM/RRRR'),'OK, Sentinel OK','90',to_date('24/07/2022','DD/MM/RRRR'),'00','1','11',null,'UY','UY','2','0','12','1',null,null,null,null,null,null,null,null,'2','476134xxxxxx0035','0','2','0','312195075721051','00','0',null,null,null,null,'0','0',null)";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//Acci??n 04-
		queryPre = "Insert into CONSUMOS (ID_ENTIDAD,ID_CONSUMO,ID_CUENTA,ID_ADICIONAL,NRO_TARJETA,ID_COMERCIO,IMPORTE_TOTAL,COD_AUTORIZACION,IMPORTE_ARANCEL,CUOTAS,NRO_CUOTA,FECHA_OPER,FECHA_PRESENT,FECHA_CIERRE_COMERCIO,FECHA_AUTORIZ,FECHA_PROCESO,NOMBRE_FANTASIA,ID_MONEDA,ID_MONEDA_ORIG,IMPORTE_MONEDA_ORIG,ID_RUBRO,ID_COD_MOVIMIENTO,ID_MODELO_CIERRE_COMERCIO,ID_MODELO_PAGO_COMERCIO,ID_GRUPO_TRANSACCION,ID_FORMA_PAGO_COMERCIO,FECHA_PAGO_COMERCIO,LIQ_SOCIO,LIQ_COMERCIO,ID_COMERCIO_CENTRAL,CAIDA_CUOTAS,ID_AUTORIZACION,IMPORTE_INTERES_SOCIO,IMPORTE_IVA_INT_SOCIO,ID_MOD_FINANC_COMERCIO,IMPORTE_INTERES_COM,ARANCEL,PORCENTAJE_FINANC,NRO_TERMINAL,NRO_LOTE,NRO_COMPROBANTE,PLAZO_INSTRUMENTO_PAGO,APLICA_SOCIO,APLICA_COMERCIO,ID_SUCURSAL_SOCIO,ID_SUCURSAL_COMERCIO,ID_MOTIVO_CONTRAPARTIDA,IMPORTE_SIN_DTO,OBSERV_AUTO,ID_SISTEMA_FINANCIACION,TIPO_PORC_FINANC,TIPO_PRODUCTO,REFERENCIA,ID_AUDITORIA,ROW_VERSION,ROW_FECHA,ID_ESTADO_TIPO_CONFIRM,ID_ESTADO_CONFIRM,IMPORTE_IVA_INTERES_COM,COD_COMERCIO,DEBITO_AUTOMATICO,COTIZACION,FECHA_COTIZACION,COD_SUB_COMERCIO,FECHA_CIERRE_SOCIO,ID_MARCA,ECOMMERCE,ID_ORIGEN,TIENE_PROMOCION,ID_CONSUMO_ORIGINAL,IMPORTE_CONVERTIDO,IMPORTE_BASE) values ('701','15728',null,null,'2DB577840DAD361818EE01A6B7AC4540','8228','71300','019026','-21420','1','1',to_date('14/07/2022','DD/MM/RRRR'),to_date('14/07/2022','DD/MM/RRRR'),to_date('14/07/2022','DD/MM/RRRR'),to_date('14/07/2022','DD/MM/RRRR'),to_date('14/07/2022','DD/MM/RRRR'),'AUTO-MANT.FECHA/DIARIO-D SARANDI      UY','858','858','71300','53000','1','7','7','10','2',to_date('19/07/2022','DD/MM/RRRR'),'0','0','8228','0','23089','0','0',null,'0','30',null,'5001555','567','4',null,'0','1',null,'1',null,'0',null,null,null,'C',null,'15871','1',to_date('14/07/2022','DD/MM/RRRR'),'40','1','0','00008228','0','1',to_date('14/07/2022','DD/MM/RRRR'),null,null,'2','0','12',null,null,'0','71400')";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//Acci??n 05-
		queryPre = "Insert into PRESENTACIONES (ID_PRESENTACION,ID_ENTIDAD,ID_COMERCIO,FECHA_PRESENTACION,ID_CIERRE,ID_AUTORIZACION_ADQUIRENTE,ID_AUTORIZACION,ID_CONSUMO,ID_OFFLINE_PARAM,ID_ESTADO_TIPO,ID_ESTADO,OBSERVACION,ID_AUDITORIA,ROW_VERSION,ROW_FECHA,ID_ESTADO_TIPO_CONFIRM,ID_ESTADO_CONFIRM) values ('15593','701','8228',to_date('14/07/2022','DD/MM/RRRR'),null,'20990','23089','15728',null,'50','0','OK',null,null,null,'40',null)";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//Acci??n 06-
		queryPre = "Insert into CONSUMOS_DATOS_ADICIONALES (ID_ENTIDAD,ID_CONSUMO,FECHA_IPM,PRODUCTO,MCC,ICA_ADQUIRENTE,ICA_EMISOR,TASA_INTERCAMBIO,ID_AUDITORIA,ROW_VERSION,ROW_FECHA,ID_ESTADO_TIPO_CONFIRM,ID_ESTADO_CONFIRM,TYPE_SETTLEMENT,FECHA_SETTLEMENT,GROUP_CODE,CODIGO_MOTIVO,MODO_INGRESO,DECIMALPOSINDIC,IMPORTE_INTERES_DF,IMPORTE_IVA_INTERES_DF,TYPE_INSTALLMENT,VAT_INSTAL_PAY_RISK_FEE_AMOUNT,INSTAL_PAY_RISK_FEE_AMOUNT,DIAS_DIFERIMIENTO) values ('701','15728',to_date('15/07/2022','DD/MM/RRRR'),null,'7230','019353','476134','0','15871','1',to_date('14/07/2022','DD/MM/RRRR'),'40','0',' ',to_date('19/07/2022','DD/MM/RRRR'),null,null,'90','0',null,null,null,null,null,null)";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//Acci??n 07-
		queryPre = "Insert into CONSUMOS_CUOTAS (ID_CONSUMO,NRO_CUOTA,CUOTAS,IMPORTE_CUOTA,IMPORTE_INTERES,IMPORTE_IVA_INTERES,LIQ_SOCIO,LIQ_COMERCIO,CAIDA_CUOTAS,FIDEICOMISO,CONTRAPARTIDO,ID_AUDITORIA,ROW_VERSION,ROW_FECHA,ID_ESTADO_TIPO_CONFIRM,ID_ESTADO_CONFIRM,FECHA_CIERRE_COMERCIO,FECHA_PAGO_COMERCIO,FECHA_CIERRE_SOCIO,FECHA_IPM,ARANCEL,IMPORTE_ARANCEL) values ('15728','1','1','71300','0','0','0','0','0','0','0','15871','1',to_date('14/07/2022','DD/MM/RRRR'),'40','1',to_date('14/07/2022','DD/MM/RRRR'),to_date('19/07/2022','DD/MM/RRRR'),null,to_date('15/07/2022','DD/MM/RRRR'),'30','-21420')";
		res.add(oraWorker.oraInsert(queryPre, conn));

		//DELETES
		//Acci??n 08-
		queryPre = "update entidades set tipo_fecha_liq_comercio = 'P' where id_entidad = '701'";
		res.add(oraWorker.oraUpdate(queryPre, conn));

		oraWorker.getDisConn(conn);

		for(Integer resultados : res) {
			if (resultados < 1) {
				index ++;
				report.AddLineAssertionError("===== Error en la acci??n: " + index + " =====");
				System.out.println("===== Error en la acci??n" + index + " =====");
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

		//DELETES DE LAS TABLAS COMERCIOS
		//Accion 01		
		queryPost = "delete  from comercios_liq_detalles where id_comercio_central in (8228) and nro_liquidacion in (" + NRO_LIQUIDACION + ")";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 02		
		queryPost = "delete  from comercios_liq_conceptos where id_comercio_central in (8228) and nro_liquidacion in (" + NRO_LIQUIDACION + ")";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 03		
		queryPost = "delete  from comercios_liq_impuestos where id_comercio_central in (8228) and nro_liquidacion in (" + NRO_LIQUIDACION + ")";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 04		
		queryPost = "delete  from comercios_liq_leyendas where id_comercio_central in (8228) and nro_liquidacion in (" + NRO_LIQUIDACION + ")";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 05	
		queryPost = "delete  from comercios_liq_plazos where id_comercio_central in (8228) and nro_liquidacion in (" + NRO_LIQUIDACION + ")";
		res.add(oraWorker.oraDelete(queryPost, conn));


		//Accion 06		
		queryPost = "delete  from comercios_liq_rechazos where id_comercio_central in (8228) and nro_liquidacion in (" + NRO_LIQUIDACION + ")";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 07		
		queryPost = "delete  from comercios_liq_cabecera where id_comercio_central in (8228) and nro_liquidacion in (" + NRO_LIQUIDACION + ")";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//DELETES DE CONSUMO
		//Accion 08		
		queryPost = "delete ctf_visa where id_consumo = '15728'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 09		
		queryPost = "delete from consumos_cuotas where id_consumo = '15728'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 10		
		queryPost = "delete from consumos_datos_adicionales where id_consumo = '15728'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 11		
		queryPost = "delete from presentaciones where id_consumo = '15728'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 12		
		queryPost = "delete from consumos where id_consumo = '15728'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Deletes de la autorizador
		//Accion 13		
		queryPost = "delete from autorizacion where id_autorizacion_adquirente = '20990'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 14		
		queryPost = "delete from respuesta_mc_log where id_autorizacion_adquirente = '20990'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 15		
		queryPost = "delete from autorizacion_adquirente_log where id_autorizacion_adquirente = '20990'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//UPDATES
		//Accion 16		
		queryPost = "update entidades set tipo_fecha_liq_comercio = 'C' where id_entidad = '701'";
		res.add(oraWorker.oraUpdate(queryPost, conn));

		oraWorker.getDisConn(conn);

		//Validaci??n PRECONDICIONES
		for(Integer resultados : res) {
			if (resultados < 1) {
				index ++;
				report.AddLineAssertionError("===== Error en la acci??n: " + index + " =====");
				System.out.println("===== Error en la acci??n: " + index + " =====");
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

		//Deletes referidas al consumo
		oraWorker.oraDelete("delete  from comercios_liq_detalles where id_comercio_central in (8228) and nro_liquidacion in (" + NRO_LIQUIDACION + ")", conn);
		oraWorker.oraDelete("delete  from comercios_liq_conceptos where id_comercio_central in (8228) and nro_liquidacion in (" + NRO_LIQUIDACION + ")", conn);
		oraWorker.oraDelete("delete  from comercios_liq_impuestos where id_comercio_central in (8228) and nro_liquidacion in (" + NRO_LIQUIDACION + ")", conn);
		oraWorker.oraDelete("delete  from comercios_liq_leyendas where id_comercio_central in (8228) and nro_liquidacion in (" + NRO_LIQUIDACION + ")", conn);
		oraWorker.oraDelete("delete  from comercios_liq_plazos where id_comercio_central in (8228) and nro_liquidacion in (" + NRO_LIQUIDACION + ")", conn);
		oraWorker.oraDelete("delete  from comercios_liq_rechazos where id_comercio_central in (8228) and nro_liquidacion in (" + NRO_LIQUIDACION + ")", conn);
		oraWorker.oraDelete("delete  from comercios_liq_cabecera where id_comercio_central in (8228) and nro_liquidacion in (" + NRO_LIQUIDACION + ")", conn);
		
		oraWorker.oraDelete("delete ctf_visa where id_consumo = '15728'", conn);
		oraWorker.oraDelete("delete from consumos_cuotas where id_consumo = '15728'", conn);
		oraWorker.oraDelete("delete from consumos_datos_adicionales where id_consumo = '15728'", conn);
		oraWorker.oraDelete("delete from presentaciones where id_consumo = '15728'", conn);
		oraWorker.oraDelete("delete from consumos where id_consumo = '15728'", conn);
		
		oraWorker.oraDelete("delete from autorizacion where id_autorizacion_adquirente = '20990'", conn);
		oraWorker.oraDelete("delete from respuesta_mc_log where id_autorizacion_adquirente = '20990'", conn);
		oraWorker.oraDelete("delete from autorizacion_adquirente_log where id_autorizacion_adquirente = '20990'", conn);
		
		oraWorker.oraUpdate("update entidades set tipo_fecha_liq_comercio = 'C' where id_entidad = '701'", conn);

		oraWorker.getDisConn(conn);

	}

}