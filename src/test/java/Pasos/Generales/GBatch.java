package Pasos.Generales;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_Variables;
import Repositories.Repo_WebRepository;
import Tools.dbWorker;

public class GBatch {
	private WebDriverWait waitFor;
	//Metodos para utilizar color en la consola
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";

	// VALIDACIONES EN EL ESQUEMA PARAM

	public void verifProcesosEjecParam(Reports report, Repo_Variables repoVar, String verifQueryParam, String registrosOK) throws SQLException {

		//SET STEPS INSTANCES
		dbWorker oraResp = new dbWorker();

		// SET VARIABLES
		String[] rtaParam = new String[2];
		// "0" es estado es exitoso.
		String estado = "0";

		// Ejecutamos la query de verificacion con el dbWorker
		// rtaParam[0] = ID_ESTADO y 
		rtaParam = oraResp.oraTwoQueryParam(verifQueryParam);

		// Si rtaParam[0] es 0 finalizo correctamente.
		if (rtaParam[0].equals(estado)) {
			report.AddLine("PROCESO EXITOSO. ID ESTADO: " + rtaParam[0]);
			System.out.println(ANSI_GREEN + "PROCESO EXITOSO. ID ESTADO: " + rtaParam[0] + ANSI_RESET);
		} else {
			report.AddLineAssertionError("PROCESO FALLIDO!! (X) . ID ESTADO: " + rtaParam[0] );
			System.out.println("PROCESO FALLIDO!! (X) . ID ESTADO: " + rtaParam[0]);
		}

		// Se verifica que la cantidad de registros sea igual a registrosOK
		// rtaParam[1] = OBJETOS_PROCESADOS_OK
		if (rtaParam[1].equals(registrosOK)) {
			report.AddLine("CANT. DE OBJETOS PROCESADOS OK CORRECTA: " + rtaParam[1]);
			System.out.println(ANSI_GREEN + "CANT. DE OBJETOS PROCESADOS OK CORRECTA: " + rtaParam[1] + ANSI_RESET);
		} else {
			report.AddLineAssertionError("SE ESPERABAN "+registrosOK+" REGISTROS PERO SE OBTUVIERON " + rtaParam[1] + " REGISTROS");
			System.out.println("SE ESPERABAN "+registrosOK+" REGISTROS PERO SE OBTUVIERON " + rtaParam[1] + " REGISTROS");
		}
	}

	public boolean verifProcesosEjec(Reports report, Repo_Variables repoVar, String[] rtaParam, String registrosOK) throws SQLException {
		
		// SET VARIABLES
		// "0" es estado es exitoso.
		String estado = "0";
		String res[] = new String[2];

		// Si rtaParam[0] es 0 finalizo correctamente.
		if (rtaParam[0].equals(estado)) {
			report.AddLine("PROCESO EXITOSO: ID ESTADO: " + rtaParam[0]);
			System.out.println(ANSI_GREEN + "PROCESO EXITOSO: ID ESTADO: " + rtaParam[0] + "\r\n" + ANSI_RESET);
			res[0] = "OK";
		} else {
			report.AddLineAssertionError("PROCESO FALLIDO!! (X) . ID ESTADO: " + rtaParam[0] );
			System.out.println("PROCESO FALLIDO!! (X) . ID ESTADO: " + rtaParam[0] + "\r\n");
			res[0] = "KO";
		}

		// Se verifica que la cantidad de registros sea igual a registrosOK
		// rtaParam[1] = OBJETOS_PROCESADOS_OK
		if (rtaParam[1].equals(registrosOK)) {
			report.AddLine("VALIDACION CORRECTA: CANTIDAD DE OBJETOS PROCESADOS OK CORRECTA: " + rtaParam[1]);
			System.out.println(ANSI_GREEN + "VALIDACION CORRECTA: CANTIDAD DE OBJETOS PROCESADOS OK CORRECTA: " + rtaParam[1] + "\r\n" + ANSI_RESET);
			res[1] = "OK";
		} else {
			report.AddLineAssertionError("ERROR: SE ESPERABAN " + registrosOK + " REGISTROS PERO SE OBTUVIERON " + rtaParam[1] + " REGISTROS");
			System.out.println("ERROR: SE ESPERABAN " + registrosOK + " REGISTROS PERO SE OBTUVIERON " + rtaParam[1] + " REGISTROS" + "\r\n");
			res[1] = "KO";
		}

		if (res[0].equals("OK") && res[1].equals("OK"))
		{
			return true;
		} else {
			return false;
		}
	}

	public boolean verifCantRegistros(Reports report, Repo_Variables repoVar, String resultadoEsperado, String rtaAut8118) throws SQLException {

		// Se verifica que la cantidad de registros sea igual a los procesados que los esperados
		if (resultadoEsperado.equals(rtaAut8118)) {
			report.AddLine("VALIDACION CORRECTA: CANTIDAD DE REGISTROS EN EL ESQUEMA 8118: " + rtaAut8118 + " ES IGUAL A LA CANTIDAD ESPERADA: " + resultadoEsperado);
			System.out.println(ANSI_GREEN + "VALIDACION CORRECTA: CANTIDAD DE REGISTROS EN EL ESQUEMA 8118: " + rtaAut8118 + " ES IGUAL A LA CANTIDAD ESPERADA: " + resultadoEsperado + "\r\n" + ANSI_RESET);
			return true;
		} else {
			report.AddLineAssertionError("VALIDACION FALLIDA!! REGISTROS ESQUEMA 8118: " + rtaAut8118 + " REGISTROS ESPERADOS: " + resultadoEsperado);
			System.out.println("VALIDACION FALLIDA!! REGISTROS ESQUEMA 8118: " + rtaAut8118 + " REGISTROS ESPERADOS: " + resultadoEsperado + "\r\n" + ANSI_RESET);
			return false;
		}
	}

	public boolean cuentasMoneda8118(Reports report, Repo_Variables repoVar, String verifQuery8118a, String SALDO, String DISPONIBLE, String IMPORTE_COMPRAS, String IMPORTE_PEND_COMPRAS ) throws SQLException {

		//SET STEPS INSTANCES
		dbWorker oraResp = new dbWorker();
		String res[] = new String[4];

		// SET VARIABLES
		// CUENTAS_MONEDA - VERIFICACION DEL SALDO, DISPONIBLE, IMPORTE_COMPRAS Y IMPORTE_PEND_COMPRAS
		String[] rtaAut8118a = new String[4];

		rtaAut8118a = oraResp.oraFourQuery(verifQuery8118a);

		if (rtaAut8118a[0].equals(SALDO)) {
			report.AddLine("VALIDACION CORRECTA: SALDO: $" + rtaAut8118a[0]);
			System.out.println(ANSI_GREEN + "VALIDACION CORRECTA: SALDO: $" + rtaAut8118a[0] + "\r\n" + ANSI_RESET);
			res[0] = "OK";
		} else {
			report.AddLineAssertionError("ERROR: EL SALDO ESPERADO ES: $" + SALDO + " PERO SE OBTUVO $ " + rtaAut8118a[0]);
			System.out.println("ERROR: EL SALDO ESPERADO ES:  $"+SALDO+" PERO SE OBTUVO $" + rtaAut8118a[0] + "\r\n");
			res[0] = "KO";
		}

		if (rtaAut8118a[1].equals(DISPONIBLE)) {
			report.AddLine("VALIDACION CORRECTA: DISPONIBLE: $" + rtaAut8118a[1]);
			System.out.println(ANSI_GREEN + "VALIDACION CORRECTA: DISPONIBLE: $" + rtaAut8118a[1] + "\r\n" + ANSI_RESET);
			res[1] = "OK";
		} else {
			report.AddLineAssertionError("ERROR: EL DISPONIBLE ESPERADO ES: $" + DISPONIBLE + " PERO SE OBTUVO $" + rtaAut8118a[1]);
			System.out.println(ANSI_GREEN + "ERROR: EL DISPONIBLE ESPERADO ES: $" + DISPONIBLE + " PERO SE OBTUVO $" + rtaAut8118a[1] + "\r\n" + ANSI_RESET);
			res[1] = "KO";
		}

		if (rtaAut8118a[2].equals(IMPORTE_COMPRAS)) {
			report.AddLine("VALIDACION CORRECTA: IMPORTE_COMPRAS: $" + rtaAut8118a[2]);
			System.out.println(ANSI_GREEN + "VALIDACION CORRECTA: IMPORTE_COMPRAS: $" + rtaAut8118a[2] + "\r\n" + ANSI_RESET);
			res[2] = "OK";
		} else {
			report.AddLineAssertionError("ERROR: EL IMPORTE_COMPRAS ESPERADO ES: $" + IMPORTE_COMPRAS + " PERO SE OBTUVO $" + rtaAut8118a[2]);
			System.out.println("ERROR: EL IMPORTE_COMPRAS ESPERADO ES: $" + IMPORTE_COMPRAS + " PERO SE OBTUVO $" + rtaAut8118a[2] + "\r\n");
			res[2] = "KO";
		}

		if (rtaAut8118a[3].equals(IMPORTE_PEND_COMPRAS)) {
			report.AddLine("VALIDACION CORRECTA: IMPORTE_PEND_COMPRAS: $" + rtaAut8118a[3]);
			System.out.println(ANSI_GREEN + "VALIDACION CORRECTA: IMPORTE_PEND_COMPRAS: $" + rtaAut8118a[3] + "\r\n" + ANSI_RESET);
			res[3] = "OK";
		} else {
			report.AddLineAssertionError("ERROR: EL IMPORTE_PEND_COMPRAS ESPERADO ES : $" + IMPORTE_PEND_COMPRAS + " PERO SE OBTUVO $" + rtaAut8118a[3]);
			System.out.println("ERROR: EL IMPORTE_PEND_COMPRAS ESPERADO ES : $" + IMPORTE_PEND_COMPRAS + " PERO SE OBTUVO $" + rtaAut8118a[3] + "\r\n");
			res[3] = "KO";
		}
		if (res[0].equals("OK") && res[1].equals("OK") && res[2].equals("OK") && res[3].equals("OK"))
		{
			return true;
		} else {
			return false;
		}

	}

	public boolean consumos8118(Reports report, String rtaAut8118c) {

		// CONSUMOS
		if (rtaAut8118c.equals("1")) {
			report.AddLine("VALIDACION DE CONSUMOS CORRECTA: REGISTROS: " + rtaAut8118c + ". SE CREO UN REGISTRO EN LAS TABLAS CONSUMOS, CONSUMOS_CUOTAS Y CONSUMOS_DATOS_ADICIONALES CORRECTAMENTE");
			System.out.println(ANSI_GREEN + "VALIDACION DE CONSUMOS CORRECTA: REGISTROS: " + rtaAut8118c + ". SE CREO UN REGISTRO EN LAS TABLAS CONSUMOS, CONSUMOS_CUOTAS Y CONSUMOS_DATOS_ADICIONALES CORRECTAMENTE\r\n" + ANSI_RESET);
			return true;
		} else {
			report.AddLineAssertionError("VALIDACION FALLIDA (X) NO HAY REGISTROS EN CONSUMOS");
			System.out.println("VALIDACION FALLIDA (X) NO HAY REGISTROS EN CONSUMOS\r\n");
			return false;
		}
	}

	public void menuProcesos (Reports report, Repo_WebRepository repo, DriverManager DM, String name) {
		
		report.AddLine("Se hace click en el boton Procesos");
		System.out.println("Se hace click en el boton Procesos");
		repo.get_obj_btnProceso().click();
		
	}
	
	public void buscarSeleccionar (Reports report, Repo_WebRepository repo, String nombreProceso, String entidad) {
		
		report.AddLine("Se ingresa el proceso a buscar " + nombreProceso);
		System.out.println("Se ingresa el proceso a buscar " + nombreProceso);
		repo.get_obj_inputById("nombre_proceso").sendKeys(nombreProceso);
		
		report.AddLine("Se selecciona la entidad " + nombreProceso);
		System.out.println("Se selecciona la entidad " + entidad);
		Select item_TipoSoc = new Select(repo.get_obj_selectById("entidades"));
		item_TipoSoc.selectByVisibleText(entidad);
		
		report.AddLine("Se presiona el boton Buscar");
		System.out.println("Se presiona el boton Buscar");
		repo.get_obj_btnBuscar().click();
	}
	
	public void seleccionarLanzarProceso (Reports report, Repo_WebRepository repo, DriverManager DM, String name, String nombre) {
		
		//Inicialización de variables
		waitFor = new WebDriverWait(DM.getActualDriver(),15);
		
		report.AddLine("Se selecciona " + nombre);
		System.out.println("Se selecciona " + nombre);
		repo.get_obj_btnLancarProceso(nombre).click();
		
		report.AddLine("Se Verifica el ingreso al lanzador del proceso: " + nombre);
		System.out.println("Se Verifica el ingreso al lanzador del proceso: " + nombre);
		waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo.get_def_tituloLanzaProceso(nombre))));
		//report.validateObjectIsDisplayable(repo.get_obj_tituloLanzaProceso("Presentación Comercios"));
		report.Screenshot(name);
		
	}
	
}
