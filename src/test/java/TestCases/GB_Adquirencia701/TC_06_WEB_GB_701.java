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
import Pasos.GlobalBatch_ADQ_701.TC_06_GB_PASOS_ADQ_701;
import Repositories.Repo_WebRepository;
import Tools.dbWorker;
import io.restassured.path.json.JsonPath;

public class TC_06_WEB_GB_701 {
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
		
		//SEPARADOR
		System.out.println("\r\n##################################################################################################################################################################################################################"
				+ "##################################################################################################################################################################################################################\r\n");

		System.out.println("Configuring "+name+"\r\n");

		//SELECT THE DRIVER AND PATH
		driver = DM.CreateDriver(DM.CHROME);
		report.SetDriver(driver);

		//SET THE REPOSITORIES TO USE
		Repo_WebRepository repo = new Repo_WebRepository();
		repo.setDriver(driver);

		//SET STEPS INSTANCES
		Acceso acceso = new Acceso();
		GBatch gralBatch = new GBatch();
		TC_06_GB_PASOS_ADQ_701 pasos = new TC_06_GB_PASOS_ADQ_701();
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
		report.AddLine("<------ Initializating Test: " + name + " ------>");

		try {
			//PRECONDICIONES
			report.AddLine("##### INICIA EJECUCION DE PRECONDICIONES #####");
			System.out.println("##### INICIA EJECUCION DE PRECONDICIONES #####");

			execPreCondiciones(report, oraWorker);

			report.AddLine("##### FIN DE EJECUCION DE PRECONDICIONES #####");
			System.out.println("##### FIN DE EJECUCION DE PRECONDICIONES #####\r\n");

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
			gralBatch.buscarSeleccionar(report, repo, "Presentación Comercios", "701-Scanntech Uruguay Hosting SA");
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

	private boolean execPreCondiciones(Reports report, dbWorker oraWorker) {
		
		//Variables
		boolean result = true;
		int index = 0;
		Connection conn;
		String queryPre;
		List<Integer> res = new ArrayList<Integer>();

		//Conectamos con la DB
		conn = oraWorker.getConn();

		//--UPDATES--//		
		//Accion 01
		queryPre="update autorizacion set fecha_relacion = sysdate where fecha_relacion is null and id_estado = '0' and id_comercio in ('8228','8238')";
		res.add(oraWorker.oraUpdate(queryPre, conn));

		//Accion 02
		queryPre="update autorizacion_adquirente_log set presentacion_procesada = '1' where presentacion_procesada = '0' and in_cod_comercio_externo in ('8228','8238')";
		res.add(oraWorker.oraUpdate(queryPre, conn));
		
		//Accion 03
		queryPre="update presentaciones set id_estado = '0' where id_estado != '0' and id_comercio in ('8228','8238')";
		res.add(oraWorker.oraUpdate(queryPre, conn));
		
		//--INSERTS--//		
		//Accion 04 - TABLA AUTORIZACION_ADQUIRENTE_LOG 		
		queryPre="Insert into AUTORIZACION_ADQUIRENTE_LOG (ID_AUTORIZACION_ADQUIRENTE,IN_ID_ENTIDAD,IN_ID_ORIGEN,IN_ID_TIPO_RED,IN_TIPO_MENSAJE,IN_NRO_TARJETA,IN_COD_PROCESAMIENTO,IN_IMPORTE_OPERACION,IN_NRO_TRACE,IN_HORA_LOCAL,IN_FECHA_LOCAL,IN_FECHA_VTO_TARJETA,IN_MODO_INGRESO_TERMINAL,IN_NRO_SECUENCIA_TARJETA,IN_COD_CAPTURA_PIN_TERMINAL,IN_TRACK2,IN_NRO_REFER_RECUPERACION,IN_COD_AUTORIZACION,IN_TERMINAL,IN_COD_COMERCIO_EXTERNO,IN_TRACK1,IN_DATOS_ADICIONALES_046,IN_DATOS_ADICIONALES_048,IN_PIN_TARJETA,IN_COD_MONEDA_OPERACION,IN_IMPORTES_ADICIONALES,IN_DATOS_SEGURIDAD_PIN,IN_DATOS_ICC,IN_DATOS_ADICIONALES_059,IN_VERSION,IN_TIPO_TERMINAL,IN_NRO_TICKET,IN_PLAN_EXTERNO,IN_CUOTAS,IN_CVC2,IN_NRO_CUENTA1,IN_NRO_CUENTA2,IN_ID_USUARIO_ALTA,IN_FECHA_HORA_TRANSMISION,OUT_TIPO_MENSAJE,OUT_COD_PROCESAMIENTO,OUT_IMPORTE_OPERACION,OUT_MCC,OUT_COD_PAIS_CUENTA_PRIMARIA,OUT_IMPORTE_CARGO_TRANSACCION,OUT_ICA,OUT_ICA_REENVIO,OUT_NRO_REFER_RECUPERACION,OUT_COD_AUTORIZACION,OUT_COD_RESPUESTA,OUT_OBSERVACION,OUT_ID_RESPUESTA_INTERNA,OUT_DATOS_ADICIONALES_046,OUT_DATOS_ADICIONALES_048,OUT_IMPORTES_ADICIONALES,OUT_DATOS_PUNTO_SERVICIO,OUT_IMPORTE_REEMPLAZO,FECHA_TRANSACCION_INI,FECHA_TRANSACCION_FIN,ID_TIPO_AUTORIZACION_ADQ_LOG,PRESENTACION_PROCESADA,ID_CONSULTA_ORIGINAL,ID_AUTORIZACION_ORIGINAL,ANULAR_REVERSAR,ID_AUTO_ADQ_ANULAR_REVERSAR,ID_AUTO_ADQ_ORIGEN,OUT_ID_TIPO_RED_EMISOR,PRODUCTO,IN_TRACE_SWITCH,IN_FECHA_TRANSMISION_SWITCH,OUT_DATOS_ORIGINALES,IN_NRO_LOTE,TIPO_PRODUCTO,OUT_DATOS_ADICIONALES_112,IN_INGRESO_PIN,EXPONENTE_IMPORTE_OPERACION,OUT_CODIGO_MOTIVO_AVISO_60,OUT_DATOS_RED_ORIGINAL,OUT_COD_RESPUESTA_ORIGINAL,OUT_COMERCIO_43,OUT_FECHA_LIQUIDACION_ORIGINAL,IN_COD_RESPUESTA,IN_DE_25,OUT_DE_19,OUT_DE_59,OUT_DE_60,OUT_DE_61,OUT_DE_62,OUT_DE_104,OUT_DE_115,OUT_DE_117,OUT_DE_118,OUT_DE_121,OUT_DE_123,OUT_DE_125,OUT_DE_126,ID_MARCA,OUT_DE_63,IN_ESTADO_SENTINEL,OUT_DE_11,ICA_EMISOR,OUT_DE_124,OUT_DE_120,IN_CODIGO_POSTAL_COMERCIO,IN_TCC_COMERCIO,IN_PROVINCIA_COMERCIO,IN_IMPORTE_CASH_BACK,IN_IMPORTE_PROPINA,IN_TIPO_FINANCIACION,IN_CAPACIDAD_CAPTURA_PAN,IN_CAPACIDAD_CAPTURA_PIN,IN_METODO_VERIFICACION_SOCIO,IN_CIUDAD_COMERCIO,IN_NOMBRE_COMERCIO,IN_DIRECCION_COMERCIO,IN_SERVICE_PROVIDER_NAME,IN_NOMBRE_SOCIO,IN_DOCUMENTO_SOCIO,OUT_DE_22,IN_COD_SUB_COMERCIO,OUT_DE_49,IN_ORIGEN_FEC_HORA_TRANSMISION,IN_MOTIVO_CANCELACION,IN_PAN_MODO_INGRESO,OUT_DE_12,OUT_DE_13,OUT_DE_14,OUT_DE_110,OUT_DE_39,IN_ORIGEN_NRO_TRACE,IN_FECHA_LOCAL_TRANSACTION,IN_ORIGEN_FECHA_LOCAL_TRANSAC,OUT_DE_25,REFERENCIA_DA,PERIODO_DA,IN_3DS_TRANSACTION_ID,IN_3DS_PROTOCOL,IN_3DS_CRYPTOGRAM,IN_3DS_SLI,IN_3DS_CAVV,TRANSACCION_ORIGEN_DA,SERVICE_CODE,IN_DE_24,IN_MCC_COMERCIO,FORMATO_MENSAJE,IN_DE_61,IN_PLAN_FINANCIACION,STATUS_PIN,OUT_DE_114,OUT_DE_56,REQUEST_ID_SWITCH) values ('19229','701','12','10','0200','09B2DACA69AED2BA2D2DB540BA4E4C10','000000','000003000000','123456','115428','0530','2512','0110','000',null,null,null,null,'1','8228',null,null,null,null,'858',null,null,null,null,null,'3','9999','0','01',null,null,null,null,'2022-05-30T11:54:28.710Z','0100','000000','000003000000','7230',null,null,'019353',null,'215011019229',null,'00','OK, No consultado en Sentinel','0',null,null,null,null,null,to_timestamp('30/05/2022 08:54:29,265005000 AM','DD/MM/RRRR HH12:MI:SSXFF AM'),to_timestamp('30/05/2022 08:54:31,327600000 AM','DD/MM/RRRR HH12:MI:SSXFF AM'),'1','0',null,null,null,null,null,'22',null,'2169','20220530115429',null,'99','P',null,'0','2',null,null,null,'COMERCIO AUTOMATION - DI SARANDI      UY',null,null,null,'858',null,'920000000010',null,null,null,null,null,null,null,null,null,null,'2','{\"\"format\"\": \"\"BITMAP\"\" , \"\"sub1\"\": \"\"0000\"\" }','-1','002169','493526',null,null,'5555',' ','009',null,null,'0','7','1','4','CABACABACABA','Soy*isto','Genova 3365','SoyListo',null,null,'0110','124','858',null,null,'1','115428','0530','2512',null,null,null,to_timestamp('30/05/2022 11:54:28,710000000 AM','DD/MM/RRRR HH12:MI:SSXFF AM'),null,'00',null,null,null,null,null,null,null,null,null,'0','8011','2',null,'0','0',null,null,null)";
		res.add(oraWorker.oraInsert(queryPre, conn));
		
		//Accion 05 - TABLA RESPUESTA_MC_LOG		
		queryPre="Insert into RESPUESTA_MC_LOG (ID_RESPUESTA_MC,IN_ID_ENTIDAD,IN_ID_ORIGEN,IN_ID_TIPO_RED,IN_ID_AUTORIZACION_ADQUIRENTE,IN_TIPO_MENSAJE,IN_NRO_TARJETA,IN_COD_PROCESAMIENTO,IN_IMPORTE_OPERACION,IN_IMPORTE_LIQUIDACION,IN_IMPORTE_EMISOR,IN_FECHA_HORA_TRANSMISION,IN_TASA_LIQUIDACION,IN_TASA_EMISOR,IN_HORA_LOCAL,IN_FECHA_LOCAL,IN_NRO_TRACE,IN_FECHA_LIQUIDACION,IN_FECHA_CONVERSION,IN_COD_PAIS_CUENTA_PRIMARIA,IN_NRO_SECUENCIA_TARJETA,IN_IMPORTE_CARGO_TRANSACCION,IN_ICA,IN_ICA_REENVIO,IN_NRO_REFER_RECUPERACION,IN_COD_AUTORIZACION,IN_COD_RESPUESTA,IN_TERMINAL,IN_COD_COMERCIO_EXTERNO,IN_DATOS_ADICIONALES_RESPUESTA,IN_DATOS_ADICIONALES_048,IN_COD_MONEDA_OPERACION,IN_COD_MONEDA_LIQUIDACION,IN_COD_MONEDA_EMISOR,IN_IMPORTES_ADICIONALES,IN_DATOS_ICC,IN_DATOS_RED_INTERMEDIARIA,IN_DATOS_RED,IN_DATOS_MENSAJE_ORIGINAL,IN_DATOS_IMPORTE_REVERSA,IN_NRO_CUENTA1,IN_NRO_CUENTA2,IN_DATOS_REFERENCIA_MONEYSEND,IN_DATOS_ADICIONALES_112,IN_PLAN_EXTERNO,IN_CUOTAS,IN_DATOS_REGISTRO,IN_COD_PROCESO_STANDIN,IN_MENSAJE_TICKET,IN_DATOS_MIEMBRO,IN_DATOS_INICIADOR_MENSAJE,IN_ID_TIPO_RED_EMISOR,OUT_ID_RESPUESTA_INTERNA,OUT_OBSERVACION,OUT_COD_AUTORIZACION,OUT_COD_RESPUESTA,OUT_DATOS_ADICIONALES_046,OUT_IMPORTES_ADICIONALES,ID_AUTORIZACION_ADQUIRENTE,FECHA_TRANSACCION_INI,FECHA_TRANSACCION_FIN,IN_SWITCH_PRIVATE_DATA_126,IN_DE_19,IN_DE_25,IN_DE_62,IN_DE_63,IN_DE_73,IN_DE_91,IN_DE_101,IN_DE_104,IN_DE_115,IN_DE_116,IN_DE_117,IN_DE_118,IN_DE_121,IN_DE_123,IN_DE_126,IN_DE_127,ID_MARCA,IN_DE_124,IN_DE_56,IN_DE_58,IN_DE_100,IN_DE_105,OUT_DE_60,IN_DE_114,IN_DE_34) values ('13842','701','12','10','19229','0110','09B2DACA69AED2BA2D2DB540BA4E4C10','000000','000003000000',null,null,'0530115429',null,'61000000',null,null,'002169',null,null,null,null,null,'019353',null,'215011019229','026797','00','1       ','8228           ',null,null,'858',null,'840',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'0','1','OK','026797','00',null,null,'19229',to_timestamp('30/05/2022 08:54:31,671319000 AM','DD/MM/RRRR HH12:MI:SSXFF AM'),to_timestamp('30/05/2022 08:54:31,796320000 AM','DD/MM/RRRR HH12:MI:SSXFF AM'),null,null,null,'40000000000000000312150072312508','8000000000',null,null,null,null,null,null,null,null,null,null,null,null,'2',null,null,null,null,null,null,null,null)";
		res.add(oraWorker.oraInsert(queryPre, conn));
		
		//Accion 06 - TABLA AUTORIZACION		
		queryPre="Insert into AUTORIZACION (ID_AUTORIZACION,ID_ENTIDAD,NRO_TARJETA,COD_AUTO_ENTIDAD,COD_AUTO_EMISOR,ID_MONEDA_ORIGEN,IMPORTE_ORIGEN,FECHA_AUTORIZACION,COTIZACION,ID_MONEDA,IMPORTE,IMPORTE_SIN_DTO,ID_ESTADO_TIPO,ID_ESTADO,FECHA_ANULACION,ID_USUARIO_ANULACION,ID_COMERCIO,COMERCIO_DESCRIPCION,CUOTAS,TASA_SOCIO,IMPORTE_CUOTAS,MCC,ID_RUBRO,ID_SUBRUBRO,TCC,COD_COMERCIO_EXTERNO,TERMINAL_POS,ID_COD_MOVIMIENTO,ID_GRUPO_TRANSACCION,ID_MODELO_TRANSACCION,ID_AUTORIZACION_ADQUIRENTE,ID_CODIGO_DEVOLUCION,IMPORTE_DEVOLUCION,ID_RESPUESTA_MC,FECHA_RELACION,OBSERVACION,MODO_INGRESO,FECHA_INFORMADA,COD_RESPUESTA,ID_RESPUESTA_INTERNA,ID_MOD_FINANC_COMERCIO,ID_PAIS_EMISOR,COD_PAIS_COMERCIO,COD_PAIS_EMISOR,PRESENTACION_PROCESADA,IMPORTE_TOTAL_PRESENTADO,ID_ORIGEN,COEFICIENTE_DIFERENCIA_CAMBIO,ID_CUENTA,ID_ADICIONAL,ID_MONEDA_LIQUIDACION,IMPORTE_LIQUIDACION,ID_AUTORIZACION_EMISOR,COD_SUB_COMERCIO,TRN_EXTERNAL_ID,ID_REGLA_FRAUDE,ID_MARCA,NRO_TARJETA_ENMASCARADA,DEBITO_AUTOMATICO,PORCENTAJE_DEVOLUCION,ECOMMERCE,TID,COD_RESPUESTA_POS,ES_CASHBACK,ID_AUTORIZACION_ORIGINAL,FECHA_DIFERIMIENTO,IMPORTE_CONVERTIDO,DIAS_DIFERIMIENTO,ES_PROPINA,MONTO_ACUM_DEVOLUCIONES) values ('21780','701','09B2DACA69AED2BA2D2DB540BA4E4C10','026797',null,'858','30000',to_date('30/05/2022 08:54:29','DD/MM/RRRR HH24:MI:SS'),'1','858','30000','0','41','0',null,null,'8228','COMERCIO AUTOMATION - DI SARANDI      UY','1','0','30000','7230','53000','53033','R','8228','1','1','10','7','19229','0','0','13842',null,'OK, No consultado en Sentinel','01',to_date('30/05/2022 08:54:29','DD/MM/RRRR HH24:MI:SS'),'00','1','11',null,'UY','UY','0','0','12','1',null,null,null,null,null,'124',null,null,'2','493526xxxxxx6654','0','0','0','312150072312508','00','0',null,null,null,null,'0','0')";
		res.add(oraWorker.oraInsert(queryPre, conn));

		oraWorker.getDisConn(conn);

		//Validaci�n PRECONDICIONES
		for(Integer resultados : res) {
			if (resultados < 1) {
				index ++;
				report.AddLine("===== Error en la acci�n: " + index + " =====");
				System.out.println("===== Error en la acci�n" + index + " =====");
				result = false;
			}
		}
		return result;
	}

	private boolean validacionesWeb(Reports report, Repo_WebRepository repo, DriverManager DM, String name, String runId, TC_06_GB_PASOS_ADQ_701 pasos) {

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
		String[] Status = new String[2];
		String rta;
		String queryVerif;

		System.out.println("##### INICIO EJECUCION DE VALIDACIONES #####");
		report.AddLine("##### INICIO EJECUCION DE VALIDACIONES #####");

		//Validacion 01
		queryVerif = "select c.tipo_producto from consumos c inner join consumos_datos_adicionales cda on c.id_consumo = cda.id_consumo inner join consumos_cuotas cc on c.id_consumo = cc.id_consumo inner join presentaciones p on c.id_consumo = p.id_consumo inner join autorizacion a on c.id_autorizacion = a.id_autorizacion inner join autorizacion_adquirente_log aal on a.id_autorizacion_adquirente = aal.id_autorizacion_adquirente where a.id_autorizacion_adquirente = '19229'";
		
		rta = oraWorker.oraOneQuery(queryVerif);	
		queryVerif = "";
	
		if (rta.equals("P")) {
			report.AddLine("Resultado correcto. El campo tipo_producto tiene el registro: "+rta+".");
			System.out.println("Resultado Correcto. El campo tipo_producto tiene el registro: "+rta+".");
			Status[0] = "P";
		} else {
			report.AddLineAssertionError("El campo tipo_producto tiene el registro: "+rta+", se esperaba el registro P.");
			System.out.println("El campo tipo_producto tiene el registro: "+rta+", se esperaba el registro P.");
			Status[0] = "FAIL - TIPO_PRODUCTO";
		}
			
		//Validacion 02
		queryVerif = "select c.fecha_pago_comercio from consumos c inner join consumos_datos_adicionales cda on c.id_consumo = cda.id_consumo inner join consumos_cuotas cc on c.id_consumo = cc.id_consumo inner join presentaciones p on c.id_consumo = p.id_consumo inner join autorizacion a on c.id_autorizacion = a.id_autorizacion inner join autorizacion_adquirente_log aal on a.id_autorizacion_adquirente = aal.id_autorizacion_adquirente where a.id_autorizacion_adquirente = '19229'";
		
		rta = oraWorker.oraOneQuery(queryVerif);
		queryVerif = "";

		if (rta.equals("2022-06-09 00:00:00")) {
			report.AddLine("Resultado correcto. El campo fecha_pago_comercio tiene el registro: " + rta+".");
			System.out.println("Resultado correcto. El campo fecha_pago_comercio tiene el registro: " + rta+".");
			Status[1] = "P";
		} else {
			report.AddLineAssertionError("El campo fecha_pago_comercio tiene el registro: "+rta+", se esperaba el registro 2022-06-09 00:00:00");
			System.out.println("El campo fecha_pago_comercioO tiene el registro: "+rta+", se esperaba el registro 2022-06-09 00:00:00");
			Status[1] = "FAIL - FECHA_PAGO_COMERCIO";
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

	private boolean execPostCondiciones (Reports report, dbWorker oraWorker) {

		boolean result = true;
		int index = 0;
		Connection conn;
		String queryPost;
		List<Integer> res = new ArrayList<Integer>();

		//Connectamos la BD
		conn = oraWorker.getConn();

		//Accion 01 - TABLA PRESENTACIONES
		queryPost = "DELETE FROM PRESENTACIONES WHERE id_autorizacion_adquirente = '19229'";
		res.add(oraWorker.oraDelete(queryPost, conn));
		
		//Accion 02 - TABLA CONSUMOS_CUOTAS
		queryPost = "DELETE FROM CONSUMOS_CUOTAS WHERE ID_CONSUMO in (select id_consumo from consumos where id_autorizacion in (select id_autorizacion from autorizacion where id_autorizacion_adquirente = '19229'))";
		res.add(oraWorker.oraDelete(queryPost, conn));

		//Accion 03 - TABLA CONSUMOS_DATOS_ADICIONALES
		queryPost = "DELETE FROM CONSUMOS_DATOS_ADICIONALES WHERE ID_CONSUMO in (select id_consumo from consumos where id_autorizacion in (select id_autorizacion from autorizacion where id_autorizacion_adquirente = '19229'))";
		res.add(oraWorker.oraDelete(queryPost, conn));
		
		//Accion 04 - TABLA CONSUMOS
		queryPost = "DELETE FROM CONSUMOS WHERE ID_CONSUMO in (select id_consumo from consumos where id_autorizacion in (select id_autorizacion from autorizacion where id_autorizacion_adquirente = '19229'))";
		res.add(oraWorker.oraDelete(queryPost, conn));
		
		//Accion 05 - TABLA AUTORIZACION
		queryPost = "DELETE FROM AUTORIZACION WHERE ID_AUTORIZACION_ADQUIRENTE = '19229'";
		res.add(oraWorker.oraDelete(queryPost, conn));
		
		//Accion 06 - TABLA RESPUESTA_MC_LOG
		queryPost = "DELETE FROM RESPUESTA_MC_LOG WHERE ID_AUTORIZACION_ADQUIRENTE = '19229'";
		res.add(oraWorker.oraDelete(queryPost, conn));
		
		//Accion 07 - TABLA AUTORIZACION_ADQUIRENTE_LOG
		queryPost = "DELETE FROM AUTORIZACION_ADQUIRENTE_LOG WHERE ID_AUTORIZACION_ADQUIRENTE = '19229'";
		res.add(oraWorker.oraDelete(queryPost, conn));

		oraWorker.getDisConn(conn);

		//Validacion PRECONDICIONES
		for(Integer resultados : res) {
			if (resultados < 1) {
				index ++;
				report.AddLineAssertionError("===== Error en la acci�n: " + index + " =====");
				System.out.println("===== Error en la acci�n: " + index + " =====");
				result = false;
			}
		}
		return result;
	}

	private void execPrePostCondi(Reports report, dbWorker oraWorker) {

		//Variables
		Connection conn;
		conn = oraWorker.getConn();

		oraWorker.oraDelete("DELETE FROM PRESENTACIONES WHERE id_autorizacion_adquirente = '19229'", conn);
		oraWorker.oraDelete("DELETE FROM CONSUMOS_CUOTAS WHERE ID_CONSUMO in (select id_consumo from consumos where id_autorizacion in (select id_autorizacion from autorizacion where id_autorizacion_adquirente = '19229'))",conn);		
		oraWorker.oraDelete("DELETE FROM CONSUMOS_DATOS_ADICIONALES WHERE ID_CONSUMO in (select id_consumo from consumos where id_autorizacion in (select id_autorizacion from autorizacion where id_autorizacion_adquirente = '19229'))", conn);
		oraWorker.oraDelete("DELETE FROM CONSUMOS WHERE ID_CONSUMO in (select id_consumo from consumos where id_autorizacion in (select id_autorizacion from autorizacion where id_autorizacion_adquirente = '19229'))",conn);
		oraWorker.oraDelete("DELETE FROM AUTORIZACION WHERE ID_AUTORIZACION_ADQUIRENTE = '19229'",conn);
		oraWorker.oraDelete("DELETE FROM RESPUESTA_MC_LOG WHERE ID_AUTORIZACION_ADQUIRENTE = '19229'",conn);
		oraWorker.oraDelete("DELETE FROM AUTORIZACION_ADQUIRENTE_LOG WHERE ID_AUTORIZACION_ADQUIRENTE = '19229'",conn);

		oraWorker.getDisConn(conn);
	}
}
