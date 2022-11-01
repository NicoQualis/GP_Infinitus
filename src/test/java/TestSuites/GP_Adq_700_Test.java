package TestSuites;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_Variables;
import TestCases.AUT_API_MASTER.*;
import TestCases.AUT_API_VISA.*;
import TestCases.GB_Adquirencia700.*;
import TestCases.GO_Adquirencia700.*;
import TestCases.OPI_MASTER.*;
import TestCases.OPI_VISA.*;
import Tools.msgWorker;
import junit.framework.Assert;

public class GP_Adq_700_Test 
{
	static 

	//Init
	DriverManager DM;
	static Datasources data;
	static Reports report;
	static Repo_Variables repoVar;
	static String path;
	static String configEntidad;

	@BeforeAll
	static void initAll() throws IOException {
		//DriverManager
		DM = new DriverManager();
		//DataSource
		data = new Datasources();
		//Reports
		report = new Reports();
		//Variables Repository/
		repoVar = new Repo_Variables();
		//PRUEBA VARIABLES GLOBALES PARA UTILIZAR URL,CONEXIONES, ETC
		//comentamos para probar

		path = "./Datasources/config_entidad.json";

		configEntidad = new String(Files.readAllBytes(Paths.get(path)));
	}

	@BeforeEach
	void init() {
	}

	//#################### TCs APIs WEB Global Online ADQUIRENCIA ARGENTINA ####################
	@Test
	@Tag("TC_01_GO_700")
	@Tag("GO_700")
	@Tag("GO_700_LOGIN")
	void TC_01_WEB_GO_700() {
		//DEFINITIONS
		TC_01_WEB_GO_700 TC01_GO_ADQ_700 = new TC_01_WEB_GO_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_01_WEB_GO_700 - Login";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		//for(int x=0;x<data.getTotalIterations();x++) {
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			status = TC01_GO_ADQ_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
			report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
			report.saveTestCaseReport(name + "_Iteracion_" + x);
			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_02_GO_700")
	@Tag("GO_700")
	@Tag("GO_700_PRESENTACION")
	void TC_02_WEB_GO_700() {
		//DEFINITIONS
		TC_02_WEB_GO_700 TC02_GO_ADQ_700 = new TC_02_WEB_GO_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_02_WEB_GO_700 - Alta de establecimiento";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		//for(int x=0;x<data.getTotalIterations();x++) {
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			status = TC02_GO_ADQ_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
			report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
			report.saveTestCaseReport(name + "_Iteracion_" + x);
			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}	

	@Test
	@Tag("TC_03_GO_700")
	@Tag("GO_700")
	@Tag("GO_700_PRESENTACION")
	void TC_03_WEB_GO_700() {
		//DEFINITIONS
		TC_03_WEB_GO_700 TC03_GO_ADQ_700 = new TC_03_WEB_GO_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_03_WEB_GO_700 - Alta modelos de cierre";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		//for(int x=0;x<data.getTotalIterations();x++) {
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			status = TC03_GO_ADQ_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
			report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
			report.saveTestCaseReport(name + "_Iteracion_" + x);
			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_04_GO_700")
	@Tag("GO_700")
	@Tag("GO_700_PRESENTACION")
	void TC_04_WEB_GO_700() {
		//DEFINITIONS
		TC_04_WEB_GO_700 TC04_GO_ADQ_700 = new TC_04_WEB_GO_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_04_WEB_GO_700 - Alta modelos de pago";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		//for(int x=0;x<data.getTotalIterations();x++) {
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			status = TC04_GO_ADQ_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
			report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
			report.saveTestCaseReport(name + "_Iteracion_" + x);
			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}	

	@Test
	@Tag("TC_05_GO_700")
	@Tag("GO_700")
	@Tag("GO_700_PRESENTACION")
	void TC_05_WEB_GO_700() {
		//DEFINITIONS
		TC_05_WEB_GO_700 TC05_GO_ADQ_700 = new TC_05_WEB_GO_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_05_WEB_GO_700 - Alta modelos de financiacion";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		//for(int x=0;x<data.getTotalIterations();x++) {
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			status = TC05_GO_ADQ_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
			report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
			report.saveTestCaseReport(name + "_Iteracion_" + x);
			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}	

	@Test
	@Tag("TC_06_GO_700")
	@Tag("GO_700")
	@Tag("GO_700_PRESENTACION")
	void TC_06_WEB_GO_700() {
		//DEFINITIONS
		TC_06_WEB_GO_700 TC06_GO_ADQ_700 = new TC_06_WEB_GO_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_06_WEB_GO_700 - Alta modelos de transaccion";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		//for(int x=0;x<data.getTotalIterations();x++) {
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			status = TC06_GO_ADQ_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
			report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
			report.saveTestCaseReport(name + "_Iteracion_" + x);
			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}	

	@Test
	@Tag("TC_07_GO_700")
	@Tag("GO_700")
	@Tag("GO_700_PRESENTACION")
	void TC_07_WEB_GO_700() {
		//DEFINITIONS
		TC_07_WEB_GO_700 TC07_GO_ADQ_700 = new TC_07_WEB_GO_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_07_WEB_GO_700 - Alta modelos de arancel";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		//for(int x=0;x<data.getTotalIterations();x++) {
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			status = TC07_GO_ADQ_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
			report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
			report.saveTestCaseReport(name + "_Iteracion_" + x);
			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}	

	//#################### TCs APIs WEB Global BATCH ADQUIRENCIA ARGENTINA ####################
	
	@Test
	@Tag("TC_01_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_LOGIN")
	void TC_01_WEB_GB_700() {
		//DEFINITIONS
		TC_01_WEB_GB_700 TC01_WEB_GB_700 = new TC_01_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_01_GB_700 - Login";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			status = TC01_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
			report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
			report.saveTestCaseReport(name + "_Iteracion_" + x);
			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_02_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_02_WEB_GB_700() {
		//DEFINITIONS
		TC_02_WEB_GB_700 TC02_WEB_GB_700 = new TC_02_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_02_GB_700 - Modelo de pago - Validación básica";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC02_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}
			
			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
		
	@Test
	@Tag("TC_03_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_03_WEB_GB_700() {
		//DEFINITIONS
		TC_03_WEB_GB_700 TC03_WEB_GB_700 = new TC_03_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_03_GB_700 - Modelo de pago - Días corridos - Parametría por defecto - Compra Maestro";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC03_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}
			
			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_04_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_04_WEB_GB_700() {
		//DEFINITIONS
		TC_04_WEB_GB_700 TC_04_WEB_GB_700 = new TC_04_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_04_GB_700 - Modelo de pago - Días corridos - Parametría por defecto - Compra Crédito";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;
				
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_04_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_05_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_05_WEB_GB_700() {
		//DEFINITIONS
		TC_05_WEB_GB_700 TC05_WEB_GB_700 = new TC_05_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_05_GB_700 - Modelo de pago - Días corridos - Parametría por defecto - Compra Débito";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;
		
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC05_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_06_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_06_WEB_GB_700() {
		//DEFINITIONS
		TC_06_WEB_GB_700 TC_06_WEB_GB_700 = new TC_06_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_06_GB_700 - Modelo de pago - Días corridos - Parametría por defecto - Compra Prepaga";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;
		
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_06_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_07_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_07_WEB_GB_700() {
		//DEFINITIONS
		TC_07_WEB_GB_700 TC_07_WEB_GB_700 = new TC_07_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_07_GB_700 - Modelo de pago - Días corridos - Parametría Parametría Específica - Compra Crédito";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;
		
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_07_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_08_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_08_WEB_GB_700() {
		//DEFINITIONS
		TC_08_WEB_GB_700 TC08_WEB_GB_700 = new TC_08_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_08_GB_700 - Modelo de pago - Días Habiles - Parametría por defecto - Compra Maestro";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;
		
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC08_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_09_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_09_WEB_GB_700() {
		//DEFINITIONS
		TC_09_WEB_GB_700 TC09_WEB_GB_700 = new TC_09_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_09_GB_700 - Modelo de pago - Días Habiles - Parametría por defecto - Compra Crédito";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC09_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_10_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_10_WEB_GB_700() {
		//DEFINITIONS
		TC_10_WEB_GB_700 TC10_WEB_GB_700 = new TC_10_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_10_GB_700 - Modelo de pago - Días Habiles - Parametría por defecto - Compra Débito";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC10_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_11_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_11_WEB_GB_700() {
		//DEFINITIONS
		TC_11_WEB_GB_700 TC11_WEB_GB_700 = new TC_11_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_11_GB_700 - Modelo de pago - Días Habiles - Parametría por defecto - Compra Prepaga";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC11_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_12_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_12_WEB_GB_700() {
		//DEFINITIONS
		TC_12_WEB_GB_700 TC12_WEB_GB_700 = new TC_12_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_12_GB_700 - Modelo de pago - Días Habiles - Parametría Parametría Específica - Compra Crédito";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC12_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_13_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_13_WEB_GB_700() {
		//DEFINITIONS
		TC_13_WEB_GB_700 TC13_WEB_GB_700 = new TC_13_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_13_GB_700 - Modelo de pago - Día Feriado";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC13_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_14_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_14_WEB_GB_700() {
		//DEFINITIONS
		TC_14_WEB_GB_700 TC14_WEB_GB_700 = new TC_14_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_14_GB_700 - Modelo de cierre - Crédito - Cierre Diario";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC14_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_15_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_15_WEB_GB_700() {
		//DEFINITIONS
		TC_15_WEB_GB_700 TC15_WEB_GB_700 = new TC_15_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_15_GB_700 - Modelo de cierre - Crédito - Cierre Semanal";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC15_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_16_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_16_WEB_GB_700() {
		//DEFINITIONS
		TC_16_WEB_GB_700 TC16_WEB_GB_700 = new TC_16_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_16_GB_700 - Modelo de cierre - Crédito - Cierre Mensual";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC16_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_17_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_17_WEB_GB_700() {
		//DEFINITIONS
		TC_17_WEB_GB_700 TC17_WEB_GB_700 = new TC_17_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_17_GB_700 - Modelo de cierre - Compra Maestro";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC17_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_18_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_18_WEB_GB_700() {
		//DEFINITIONS
		TC_18_WEB_GB_700 TC18_WEB_GB_700 = new TC_18_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_18_GB_700 - Modelo de cierre - Compra Débito";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC18_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_19_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_19_WEB_GB_700() {
		//DEFINITIONS
		TC_19_WEB_GB_700 TC19_WEB_GB_700 = new TC_19_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_19_GB_700 - Modelo de cierre - Compra Prepaga";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC19_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_20_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_20_WEB_GB_700() {
		//DEFINITIONS
		TC_20_WEB_GB_700 TC20_WEB_GB_700 = new TC_20_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_20_GB_700 - Modelo de Cierre - Feriado Mantiene Fecha";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC20_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_21_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_21_WEB_GB_700() {
		//DEFINITIONS
		TC_21_WEB_GB_700 TC21_WEB_GB_700 = new TC_21_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_21_GB_700 - Modelo de Cierre - Feriado Hábil Siguiente";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC21_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_22_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_22_WEB_GB_700() {
		//DEFINITIONS
		TC_22_WEB_GB_700 TC22_WEB_GB_700 = new TC_22_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_22_GB_700 - Modelo de Cierre - Feriado Hábil Anterior";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC22_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_23_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_23_WEB_GB_700() {
		//DEFINITIONS
		TC_23_WEB_GB_700 TC23_WEB_GB_700 = new TC_23_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_23_GB_700 - Modelo de Cierre - Crédito - Cierre Calendario";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC23_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_24_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_24_WEB_GB_700() {
		//DEFINITIONS
		TC_24_WEB_GB_700 TC24_WEB_GB_700 = new TC_24_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_24_GB_700 - Modelo de Arancel - Debito Local";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC24_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_25_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_25_WEB_GB_700() {
		//DEFINITIONS
		TC_25_WEB_GB_700 TC25_WEB_GB_700 = new TC_25_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_25_GB_700 - Modelo de Arancel - Debito Extranjero";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC25_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_26_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_26_WEB_GB_700() {
		//DEFINITIONS
		TC_26_WEB_GB_700 TC26_WEB_GB_700 = new TC_26_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_26_GB_700 - Modelo de Arancel - Prepaga Local";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC26_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_27_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")	
	void TC_27_WEB_GB_700() {
		//DEFINITIONS
		TC_27_WEB_GB_700 TC27_WEB_GB_700 = new TC_27_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_27_GB_700 - Modelo de Arancel - Prepaga Extranjero";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC27_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_28_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_28_WEB_GB_700() {
		//DEFINITIONS
		TC_28_WEB_GB_700 TC28_WEB_GB_700 = new TC_28_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_28_GB_700 - Modelo de Arancel - Credito Local";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC28_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_29_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_29_WEB_GB_700() {
		//DEFINITIONS
		TC_29_WEB_GB_700 TC29_WEB_GB_700 = new TC_29_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_29_GB_700 - Modelo de Arancel - Credito Extranjero";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC29_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_30_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")	
	void TC_30_WEB_GB_700() {
		//DEFINITIONS
		TC_30_WEB_GB_700 TC30_WEB_GB_700 = new TC_30_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_30_GB_700 - Modelo de Arancel - Credito Local en cuotas";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC30_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	
	@Test
	@Tag("TC_31_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")	
	void TC_31_WEB_GB_700() {
		//DEFINITIONS
		TC_31_WEB_GB_700 TC31_WEB_GB_700 = new TC_31_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_31_GB_700 - Modelo de financiación - 1 cuota";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC31_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_32_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_32_WEB_GB_700() {
		//DEFINITIONS
		TC_32_WEB_GB_700 TC32_WEB_GB_700 = new TC_32_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_32_GB_700 - Modelo de financiación - Mod. Financ. Sin vigencia";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC32_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_33_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_33_WEB_GB_700() {
		//DEFINITIONS
		TC_33_WEB_GB_700 TC33_WEB_GB_700 = new TC_33_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_33_GB_700 - Modelo de financiación - Cuotas - Formula Directa - Financiacion otorgante - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC33_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_34_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_34_WEB_GB_700() {
		//DEFINITIONS
		TC_34_WEB_GB_700 TC34_WEB_GB_700 = new TC_34_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_34_GB_700 - Modelo de financiación - Cuotas - Formula Directa - Financiacion adquirente - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC34_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_35_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_35_WEB_GB_700() {
		//DEFINITIONS
		TC_35_WEB_GB_700 TC35_WEB_GB_700 = new TC_35_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_35_GB_700 - Modelo de financiación - Cuotas - Formula Directa - Financiacion Comercio - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC35_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_36_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_36_WEB_GB_700() {
		//DEFINITIONS
		TC_36_WEB_GB_700 TC36_WEB_GB_700 = new TC_36_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_36_GB_700 - Modelo de financiación - Cuotas - Formula Directa - Plazo Pago Promedio Ponderado (PPP) - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC36_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_37_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_37_WEB_GB_700() {
		//DEFINITIONS
		TC_37_WEB_GB_700 TC37_WEB_GB_700 = new TC_37_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_37_GB_700 - Modelo de financiación - Cuotas - Formula Directa - Plan Gobierno - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC37_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_38_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_38_WEB_GB_700() {
		//DEFINITIONS
		TC_38_WEB_GB_700 TC38_WEB_GB_700 = new TC_38_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_38_GB_700 - Modelo de financiación - Cuotas - Formula TNA/TEA - Financiacion otorgante - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC38_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_39_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_39_WEB_GB_700() {
		//DEFINITIONS
		TC_39_WEB_GB_700 TC39_WEB_GB_700 = new TC_39_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_39_GB_700 - Modelo de financiación - Cuotas - Formula TNA-TEA - Financiacion adquirente - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC39_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_40_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_40_WEB_GB_700() {
		//DEFINITIONS
		TC_40_WEB_GB_700 TC40_WEB_GB_700 = new TC_40_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_40_GB_700 - Modelo de financiación - Cuotas - Formula TNA-TEA - Financiacion Comercio - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC40_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_41_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_41_WEB_GB_700() {
		//DEFINITIONS
		TC_41_WEB_GB_700 TC41_WEB_GB_700 = new TC_41_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_41_GB_700 - Modelo de financiación - Cuotas - Formula TNA-TEA - Financiacion Comercio - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC41_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_42_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_42_WEB_GB_700() {
		//DEFINITIONS
		TC_42_WEB_GB_700 TC42_WEB_GB_700 = new TC_42_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_42_GB_700 - Modelo de financiación - Cuotas - Formula TNA-TEA - Financiacion Comercio - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC42_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_43_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_43_WEB_GB_700() {
		//DEFINITIONS
		TC_43_WEB_GB_700 TC43_WEB_GB_700 = new TC_43_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_43_GB_700 - Modelo de financiación - Financiacion otorgante - Fechas de Liquidación De cuotas";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC43_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_44_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_44_WEB_GB_700() {
		//DEFINITIONS
		TC_44_WEB_GB_700 TC44_WEB_GB_700 = new TC_44_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_44_GB_700 - Modelo de financiación - Financiacion Adquirente - Fechas de Liquidación De cuotas";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC44_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_45_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_45_WEB_GB_700() {
		//DEFINITIONS
		TC_45_WEB_GB_700 TC45_WEB_GB_700 = new TC_45_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_45_GB_700 - Modelo de financiación - Financiacion Comercio - Fechas de Liquidación De cuotas";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC45_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_46_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_46_WEB_GB_700() {
		//DEFINITIONS
		TC_46_WEB_GB_700 TC46_WEB_GB_700 = new TC_46_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_46_GB_700 - Modelo de financiación - Financiacion PPP - Fechas de Liquidación De cuotas";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC46_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_47_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_47_WEB_GB_700() {
		//DEFINITIONS
		TC_47_WEB_GB_700 TC47_WEB_GB_700 = new TC_47_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_47_GB_700 - Modelo de financiación - Financiacion Plan Gobierno - Fechas de Liquidación De cuotas";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC47_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_48_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_48_WEB_GB_700() {
		//DEFINITIONS
		TC_48_WEB_GB_700 TC48_WEB_GB_700 = new TC_48_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_48_GB_700 - Control Liquidación Comercio - Consumo 1 cuota";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC48_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_49_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_49_WEB_GB_700() {
		//DEFINITIONS
		TC_49_WEB_GB_700 TC49_WEB_GB_700 = new TC_49_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_49_GB_700 - Control Liquidación Comercio - Consumo Cuotas - 1 pago";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC49_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_50_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_50_WEB_GB_700() {
		//DEFINITIONS
		TC_50_WEB_GB_700 TC50_WEB_GB_700 = new TC_50_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_50_GB_700 - Control Liquidación Comercio - Consumo Cuotas - Pago Cuota a Cuota";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC50_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_51_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_51_WEB_GB_700() {
		//DEFINITIONS
		TC_51_WEB_GB_700 TC51_WEB_GB_700 = new TC_51_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_51_GB_700 - Devolución";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC51_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_52_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_52_WEB_GB_700() {
		//DEFINITIONS
		TC_52_WEB_GB_700 TC52_WEB_GB_700 = new TC_52_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_52_GB_700 - Autorizacion Anulada/reversada";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC52_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_53_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_53_WEB_GB_700() {
		//DEFINITIONS
		TC_53_WEB_GB_700 TC53_WEB_GB_700 = new TC_53_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_53_GB_700 - Autorizacion Anulada/reversada";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC53_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_54_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_54_WEB_GB_700() {
		//DEFINITIONS
		TC_54_WEB_GB_700 TC54_WEB_GB_700 = new TC_54_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_54_GB_700 - Parametría - Identificador de comercio = null";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC54_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_55_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_55_WEB_GB_700() {
		//DEFINITIONS
		TC_55_WEB_GB_700 TC55_WEB_GB_700 = new TC_55_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_55_GB_700 - Parametría - Identificador de comercio con valor";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC55_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_56_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_56_WEB_GB_700() {
		//DEFINITIONS
		TC_56_WEB_GB_700 TC56_WEB_GB_700 = new TC_56_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_56_GB_700 - Parametría - Identificador de comercio - Formato inválido";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC56_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_57_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_57_WEB_GB_700() {
		//DEFINITIONS
		TC_57_WEB_GB_700 TC57_WEB_GB_700 = new TC_57_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_57_GB_700 - Parametría - Fecha de procesamiento menor a fecha_autorización ";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC57_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_58_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_58_WEB_GB_700() {
		//DEFINITIONS
		TC_58_WEB_GB_700 TC58_WEB_GB_700 = new TC_58_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_58_GB_700 - Parametría - Fecha de procesamiento Igual a fecha_autorización";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC58_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_59_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_59_WEB_GB_700() {
		//DEFINITIONS
		TC_59_WEB_GB_700 TC59_WEB_GB_700 = new TC_59_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_59_GB_700 - Parametría - Fecha de procesamiento Mayor a fecha_autorización";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC59_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_60_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_60_WEB_GB_700() {
		//DEFINITIONS
		TC_60_WEB_GB_700 TC_60_WEB_GB_700 = new TC_60_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_60_GB_700 - Parametria - Fecha de procesamiento Mayor de fecha de ejecucion";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_60_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	
	@Test
	@Tag("TC_61_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_61_WEB_GB_700() {
		//DEFINITIONS
		TC_61_WEB_GB_700 TC_61_WEB_GB_700 = new TC_61_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_61_GB_700 - Parametría - Fecha de procesamiento - Formato inválido";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_61_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_62_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_62_WEB_GB_700() {
		//DEFINITIONS
		TC_62_WEB_GB_700 TC_62_WEB_GB_700 = new TC_62_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_62_GB_700 - Parametría - Identificador de terminal - null";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_62_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_63_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_63_WEB_GB_700() {
		//DEFINITIONS
		TC_63_WEB_GB_700 TC_63_WEB_GB_700 = new TC_63_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_63_GB_700 - Parametría - Identificador de terminal - con valor";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_63_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_64_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_64_WEB_GB_700() {
		//DEFINITIONS
		TC_64_WEB_GB_700 TC_64_WEB_GB_700 = new TC_64_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_64_GB_700 - Parametría - Identificador de terminal - formato inválido";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_64_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_65_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_PRESENTACION")
	void TC_65_WEB_GB_700() {
		//DEFINITIONS
		TC_65_WEB_GB_700 TC_65_WEB_GB_700 = new TC_65_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_65_GB_700 - Compra con propina";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_65_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_71_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_LIQUIDACION_COMERCIOS")
	void TC_71_WEB_GB_700() {
		//DEFINITIONS
		TC_71_WEB_GB_700 TC71_WEB_GB_700 = new TC_71_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_71_GB_700 - Tipo Fecha Liquidacion - Fecha de cierre ";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC71_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_73_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_LIQUIDACION_COMERCIOS")
	void TC_73_WEB_GB_700() {
		//DEFINITIONS
		TC_73_WEB_GB_700 TC73_WEB_GB_700 = new TC_73_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_73_GB_700 - Fecha de ejecución menor a fecha de cierre de consumo ";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC73_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_74_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_LIQUIDACION_COMERCIOS")
	void TC_74_WEB_GB_700() {
		//DEFINITIONS
		TC_74_WEB_GB_700 TC74_WEB_GB_700 = new TC_74_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_74_GB_700 - Tipo Fecha Liquidacion - Fecha de pago ";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC74_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_76_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_LIQUIDACION_COMERCIOS")
	void TC_76_WEB_GB_700() {
		//DEFINITIONS
		TC_76_WEB_GB_700 TC76_WEB_GB_700 = new TC_76_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_76_GB_700 - Fecha de ejecución menor a fecha de pago de consumo ";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC76_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_77_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_LIQUIDACION_COMERCIOS")
	void TC_77_WEB_GB_700() {
		//DEFINITIONS
		TC_77_WEB_GB_700 TC77_WEB_GB_700 = new TC_77_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_77_GB_700 - CONSUMOS.LIQ_COMERCIO = '1' ";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC77_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_80_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_LIQUIDACION_COMERCIOS")
	void TC_80_WEB_GB_700() {
		//DEFINITIONS
		TC_80_WEB_GB_700 TC80_WEB_GB_700 = new TC_80_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_80_WEB_700 - CONSUMOS_CUOTAS.CONTRAPARTIDO = 1";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC80_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_81_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_LIQUIDACION_COMERCIOS")
	void TC_81_WEB_GB_700() {
		//DEFINITIONS
		TC_81_WEB_GB_700 TC_81_WEB_GB_700 = new TC_81_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_81_GB_700 -Parámetros de ejecución - Fecha - Formato inválido";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_81_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_82_GB_700")
	@Tag("GB_700")
	@Tag("GB_700_LIQUIDACION_COMERCIOS")
	void TC_82_WEB_GB_700() {
		//DEFINITIONS
		TC_82_WEB_GB_700 TC_82_WEB_GB_700 = new TC_82_WEB_GB_700();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_82_GB_700 - Parámetros de ejecución - Fecha - Fecha futura";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_82_WEB_GB_700.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			} catch (AssertionError aErr) {
				report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
				report.saveTestCaseReport(name + "_Iteracion_" + x);	
			}

			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	//#################### TCs APIs Autorizador - VISA #################### 
	@Test
	@Tag("TC_01_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_01_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_01_AUT_API_VISA TC01_AI_ADQ_VISA = new TC_01_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_01_AUTH_API_VISA_700 - Crédito - Local - Compra Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC01_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_02_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_02_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_02_AUT_API_VISA TC02_AI_ADQ_VISA = new TC_02_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_02_AUTH_API_VISA_700 - Crédito - Local - Compra Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC02_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_03_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_03_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_03_AUT_API_VISA TC03_AI_ADQ_VISA = new TC_03_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_03_AUTH_API_VISA_700 - Crédito - Local - Compra Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC03_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_04_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_04_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_04_AUT_API_VISA TC04_AI_ADQ_VISA = new TC_04_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_04_AUTH_API_VISA_700 - Crédito - Local - Compra Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC04_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_05_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_05_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_05_AUT_API_VISA TC05_AI_ADQ_VISA = new TC_05_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_05_AUTH_API_VISA_700 - Crédito - Local - Compra Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC05_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_06_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_06_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_06_AUT_API_VISA TC06_AI_ADQ_VISA = new TC_06_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_06_AUTH_API_VISA_700 - Crédito - Local - Anulación Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC06_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_07_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_07_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_07_AUT_API_VISA TC07_AI_ADQ_VISA = new TC_07_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_07_AUTH_API_VISA_700 - Crédito - Local - Anulación Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC07_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_08_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_08_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_08_AUT_API_VISA TC08_AI_ADQ_VISA = new TC_08_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_08_AUTH_API_VISA_700 - Crédito - Local - Anulación Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC08_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_09_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_09_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_09_AUT_API_VISA TC09_AI_ADQ_VISA = new TC_09_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_09_AUTH_API_VISA_700 - Crédito - Local - Anulación Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC09_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_10_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_10_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_10_AUT_API_VISA TC10_AI_ADQ_VISA = new TC_10_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_10_AUTH_API_VISA_700 - Crédito - Local - Anulación Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC10_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_11_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")	
	@Tag("AUTH_700_VISA_API_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_11_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_11_AUT_API_VISA TC11_AI_ADQ_VISA = new TC_11_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_11_AUTH_API_VISA_700 - Crédito - Local - Reverso Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC11_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_12_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_12_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_12_AUT_API_VISA TC12_AI_ADQ_VISA = new TC_12_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_12_AUTH_API_VISA_700 - Crédito - Local - Reverso Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC12_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_13_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_13_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_13_AUT_API_VISA TC13_AI_ADQ_VISA = new TC_13_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_13_AUTH_API_VISA_700 - Crédito - Local - Reverso Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC13_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_14_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")	
	@Tag("AUTH_700_VISA_API_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_14_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_14_AUT_API_VISA TC14_AI_ADQ_VISA = new TC_14_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_14_AUTH_API_VISA_700 - Crédito - Local - Reverso Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC14_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_15_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_15_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_15_AUT_API_VISA TC15_AI_ADQ_VISA = new TC_15_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_15_AUTH_API_VISA_700 - Crédito - Local - Reverso Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC15_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_16_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_16_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_16_AUT_API_VISA TC16_AI_ADQ_VISA = new TC_16_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_16_AUTH_API_VISA_700 - Crédito - Local - Devolución Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC16_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_17_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_17_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_17_AUT_API_VISA TC17_AI_ADQ_VISA = new TC_17_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_17_AUTH_API_VISA_700 - Crédito - Local - Devolución Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC17_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_18_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_18_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_18_AUT_API_VISA TC18_AI_ADQ_VISA = new TC_18_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_18_AUTH_API_VISA_700 - Crédito - Local - Devolución Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC18_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_19_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_19_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_19_AUT_API_VISA TC19_AI_ADQ_VISA = new TC_19_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_19_AUTH_API_VISA_700 - Crédito - Local - Devolución Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC19_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_20_AUTH_API_VISA_700")
	@Tag("AUTH_API_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_API_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_20_API_AI_ADQ_VISA() {
		//DEFINITIONS
		TC_20_AUT_API_VISA TC20_AI_ADQ_VISA = new TC_20_AUT_API_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_20_AUTH_API_VISA_700 - Crédito - Local - Devolución Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC20_AI_ADQ_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	//#################### TCs APIs Autorizador - MASTER ####################
	@Test
	@Tag("TC_01_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_01_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_01_AUT_API_MASTER TC01_AI_ADQ_MASTER = new TC_01_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_01_AUTH_API_MC_700 - Crédito - Local - Compra Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC01_AI_ADQ_MASTER.Test(report, name, configEntidad);
		
		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_02_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_02_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_02_AUT_API_MASTER TC02_AI_ADQ_MASTER = new TC_02_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_02_AUTH_API_MC_700 - Crédito - Local - Compra Banda";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC02_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_03_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_03_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_03_AUT_API_MASTER TC03_AI_ADQ_MASTER = new TC_03_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_03_AUTH_API_MC_700 - Crédito - Local - Compra Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC03_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_04_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_04_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_04_AUT_API_MASTER TC04_AI_ADQ_MASTER = new TC_04_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_04_AUTH_API_MC_700 - Crédito - Local - Compra Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC04_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_05_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_05_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_05_AUT_API_MASTER TC05_AI_ADQ_MASTER = new TC_05_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_05_AUTH_API_MC_700 - Crédito - Local - Compra Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC05_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_06_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_06_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_06_AUT_API_MASTER TC06_AI_ADQ_MASTER = new TC_06_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_06_AUTH_API_MC_700 - Crédito - Local - Anulación Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC06_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_07_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_07_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_07_AUT_API_MASTER TC07_AI_ADQ_MASTER = new TC_07_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_07_AUTH_API_MC_700 - Crédito - Local - Anulación Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC07_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_08_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_08_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_08_AUT_API_MASTER TC08_AI_ADQ_MASTER = new TC_08_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_08_AUTH_API_MC_700 - Crédito - Local - Anulación Chip";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC08_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_09_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_09_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_09_AUT_API_MASTER TC09_AI_ADQ_MASTER = new TC_09_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_09_AUTH_API_MC_700 - Crédito - Local - Anulación Contactless";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC09_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_10_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_10_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_10_AUT_API_MASTER TC10_AI_ADQ_MASTER = new TC_10_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_10_AUTH_API_MC_700 - Crédito - Local - Anulación Ecommerce";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC10_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_11_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_11_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_11_AUT_API_MASTER TC11_AI_ADQ_MASTER = new TC_11_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_11_AUTH_API_MC_700 - Crédito - Local - Reverso Manual";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC11_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_12_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_12_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_12_AUT_API_MASTER TC12_AI_ADQ_MASTER = new TC_12_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_12_AUTH_API_MC_700 - Crédito - Local - Reverso Banda";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC12_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_13_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_13_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_13_AUT_API_MASTER TC13_AI_ADQ_MASTER = new TC_13_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_13_AUTH_API_MC_700 - Crédito - Local - Reverso Chip";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC13_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_14_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_14_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_14_AUT_API_MASTER TC14_AI_ADQ_MASTER = new TC_14_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_14_AUTH_API_MC_700 - Crédito - Local - Reverso Contactless";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC14_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_15_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_15_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_15_AUT_API_MASTER TC15_AI_ADQ_MASTER = new TC_15_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_15_AUTH_API_MC_700 - Crédito - Local - Reverso Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC15_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_16_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_16_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_16_AUT_API_MASTER TC16_AI_ADQ_MASTER = new TC_16_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_16_AUTH_API_MC_700 - Crédito - Local - Devolución Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC16_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_17_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_17_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_17_AUT_API_MASTER TC17_AI_ADQ_MASTER = new TC_17_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_17_AUTH_API_MC_700 - Crédito - Local - Devolución Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC17_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_18_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_18_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_18_AUT_API_MASTER TC18_AI_ADQ_MASTER = new TC_18_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_18_AUTH_API_MC_700 - Crédito - Local - Devolución Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC18_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_19_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_19_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_19_AUT_API_MASTER TC19_AI_ADQ_MASTER = new TC_19_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_19_AUTH_API_MC_700 - Crédito - Local - Devolución Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC19_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_20_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_20_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_20_AUT_API_MASTER TC20_AI_ADQ_MASTER = new TC_20_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_20_AUTH_API_MC_700 - Crédito - Local - Devolución Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC20_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_21_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_21_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_21_AUT_API_MASTER TC01_AI_ADQ_MASTER = new TC_21_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_21_AUTH_API_MC_700 - Débito - Local - Compra Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC01_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_22_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_22_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_22_AUT_API_MASTER TC22_AI_ADQ_MASTER = new TC_22_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_22_AUTH_API_MC_700 - Débito - Local - Compra Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC22_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_23_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_23_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_23_AUT_API_MASTER TC23_AI_ADQ_MASTER = new TC_23_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_23_AUTH_API_MC_700 - Débito - Local - Compra Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC23_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_24_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_24_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_24_AUT_API_MASTER TC24_AI_ADQ_MASTER = new TC_24_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_24_AUTH_API_MC_700 - Débito - Local - Compra Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC24_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_25_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_API_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_25_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_25_AUT_API_MASTER TC25_AI_ADQ_MASTER = new TC_25_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_25_AUTH_API_MC_700 - Débito - Local - Compra Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC25_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_26_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")	
	@Tag("AUTH_700_MC_API_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_26_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_26_AUT_API_MASTER TC06_AI_ADQ_MASTER = new TC_26_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_26_AUTH_API_MC_700 - Débito - Local - Anulación Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC06_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_27_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_27_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_27_AUT_API_MASTER TC27_AI_ADQ_MASTER = new TC_27_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_27_AUTH_API_MC_700 - Débito - Local - Anulación Banda";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC27_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_28_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_28_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_28_AUT_API_MASTER TC28_AI_ADQ_MASTER = new TC_28_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_28_AUTH_API_MC_700 - Crédito - Local - Anulación Chip ";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC28_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_29_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_29_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_29_AUT_API_MASTER TC29_AI_ADQ_MASTER = new TC_29_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_29_AUTH_API_MC_700 - Débito - Local - Anulación Contactless ";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC29_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_30_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_API_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_30_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_30_AUT_API_MASTER TC30_AI_ADQ_MASTER = new TC_30_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_30_AUTH_API_MC_700 - Débito - Local - Anulación Ecommerce ";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC30_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_31_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_31_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_31_AUT_API_MASTER TC31_AI_ADQ_MASTER = new TC_31_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_31_AUTH_API_MC_700 - Débito - Local - Reveso Manual ";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC31_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_32_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_32_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_32_AUT_API_MASTER TC32_AI_ADQ_MASTER = new TC_32_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_32_AUTH_API_MC_700 - Débito - Local - Reveso Banda\r\n";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC32_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_33_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_33_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_33_AUT_API_MASTER TC33_AI_ADQ_MASTER = new TC_33_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_33_AUTH_API_MC_700 - Débito - Local - Reveso Chip";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC33_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_34_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_34_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_34_AUT_API_MASTER TC34_AI_ADQ_MASTER = new TC_34_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_34_AUTH_API_MC_700 - Débito - Local - Reveso Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC34_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_35_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_API_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_35_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_35_AUT_API_MASTER TC35_AI_ADQ_MASTER = new TC_35_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_35_AUTH_API_MC_700 - Débito - Local - Reveso Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC35_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_36_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")	
	@Tag("AUTH_700_MC_API_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_36_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_36_AUT_API_MASTER TC36_AI_ADQ_MASTER = new TC_36_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_36_AUTH_API_MC_700 - Débito - Local - Devolución Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC36_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_37_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_37_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_37_AUT_API_MASTER TC37_AI_ADQ_MASTER = new TC_37_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_37_AUTH_API_MC_700 - Débito - Local - Devolución Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC37_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_38_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_38_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_38_AUT_API_MASTER TC38_AI_ADQ_MASTER = new TC_38_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_38_AUTH_API_MC_700 - Débito - Local - Devolución Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC38_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_39_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_39_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_39_AUT_API_MASTER TC39_AI_ADQ_MASTER = new TC_39_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_39_AUTH_API_MC_700 - Débito - Local - Devolución Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC39_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_40_AUTH_API_MC_700")
	@Tag("AUTH_API_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_API_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_API_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_API_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_40_API_AI_ADQ_MASTER() {
		//DEFINITIONS
		TC_40_AUT_API_MASTER TC40_AI_ADQ_MASTER = new TC_40_AUT_API_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_40_AUTH_API_MC_700 - Débito - Local - Devolución Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC40_AI_ADQ_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	//#################### TCs OPI - VISA ####################
	@Test
	@Tag("TC_01_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_01_OPI_VISA() {
		//DEFINITIONS
		TC_01_OPI_VISA TC01_OPI_VISA = new TC_01_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_01_AUTH_OPI_VISA_700 - Crédito - Compra Local - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC01_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_02_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_02_OPI_VISA() {
		//DEFINITIONS
		TC_02_OPI_VISA TC02_OPI_VISA = new TC_02_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_02_AUTH_OPI_VISA_700 - Crédito - Compra Local - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC02_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_03_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_03_OPI_VISA() {
		//DEFINITIONS
		TC_03_OPI_VISA TC03_OPI_VISA = new TC_03_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_03_AUTH_OPI_VISA_700 - Crédito - Compra Local - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC03_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_04_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_04_OPI_VISA() {
		//DEFINITIONS
		TC_04_OPI_VISA TC04_OPI_VISA = new TC_04_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_04_AUTH_OPI_VISA_700 - Crédito - Compra Local - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC04_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_05_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_05_OPI_VISA() {
		//DEFINITIONS
		TC_05_OPI_VISA TC05_OPI_VISA = new TC_05_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_05_AUTH_OPI_VISA_700 - Crédito - Compra Local - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC05_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_06_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_06_OPI_VISA() {
		//DEFINITIONS
		TC_06_OPI_VISA TC06_OPI_VISA = new TC_06_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_06_AUTH_OPI_VISA_700 - Local - Anulación - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC06_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_07_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_07_OPI_VISA() {
		//DEFINITIONS
		TC_07_OPI_VISA TC07_OPI_VISA = new TC_07_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_07_AUTH_OPI_VISA_700 - Local - Anulación - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC07_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_08_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_08_OPI_VISA() {
		//DEFINITIONS
		TC_08_OPI_VISA TC08_OPI_VISA = new TC_08_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_08_AUTH_OPI_VISA_700 - Local - Anulación - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC08_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_09_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_09_OPI_VISA() {
		//DEFINITIONS
		TC_09_OPI_VISA TC09_OPI_VISA = new TC_09_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_09_AUTH_OPI_VISA_700 - Local - Anulación - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC09_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_10_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_10_OPI_VISA() {
		//DEFINITIONS
		TC_10_OPI_VISA TC10_OPI_VISA = new TC_10_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_10_AUTH_OPI_VISA_700 - Local - Anulación - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC10_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_11_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_11_OPI_VISA() {
		//DEFINITIONS
		TC_11_OPI_VISA TC11_OPI_VISA = new TC_11_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_11_AUTH_OPI_VISA_700 - Local - Reverso - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC11_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_12_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_12_OPI_VISA() {
		//DEFINITIONS
		TC_12_OPI_VISA TC12_OPI_VISA = new TC_12_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_12_AUTH_OPI_VISA_700 - Local - Reverso - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC12_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_13_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_13_OPI_VISA() {
		//DEFINITIONS
		TC_13_OPI_VISA TC13_OPI_VISA = new TC_13_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_13_AUTH_OPI_VISA_700 - Local - Reverso - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC13_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_14_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_14_OPI_VISA() {
		//DEFINITIONS
		TC_14_OPI_VISA TC14_OPI_VISA = new TC_14_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_14_AUTH_OPI_VISA_700 - Local - Reverso - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC14_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_15_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_15_OPI_VISA() {
		//DEFINITIONS
		TC_15_OPI_VISA TC15_OPI_VISA = new TC_15_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_15_AUTH_OPI_VISA_700 - Local - Reverso - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC15_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_16_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_16_OPI_VISA() {
		//DEFINITIONS
		TC_16_OPI_VISA TC16_OPI_VISA = new TC_16_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_16_AUTH_OPI_VISA_700 - Local - Devolución - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC16_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_17_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_17_OPI_VISA() {
		//DEFINITIONS
		TC_17_OPI_VISA TC17_OPI_VISA = new TC_17_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_17_AUTH_OPI_VISA_700 - Local - Devolución - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC17_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_18_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_18_OPI_VISA() {
		//DEFINITIONS
		TC_18_OPI_VISA TC18_OPI_VISA = new TC_18_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_18_AUTH_OPI_VISA_700 - Local - Devolución - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC18_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_19_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_19_OPI_VISA() {
		//DEFINITIONS
		TC_19_OPI_VISA TC19_OPI_VISA = new TC_19_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_19_AUTH_OPI_VISA_700 - Local - Devolución - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC19_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_20_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_20_OPI_VISA() {
		//DEFINITIONS
		TC_20_OPI_VISA TC20_OPI_VISA = new TC_20_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_20_AUTH_OPI_VISA_700 - Local - Devolución - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC20_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_21_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_21_OPI_VISA() {
		//DEFINITIONS
		TC_21_OPI_VISA TC21_OPI_VISA = new TC_21_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_21_AUTH_OPI_VISA_700 - Débito - Compra Local - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC21_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_22_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_22_OPI_VISA() {
		//DEFINITIONS
		TC_22_OPI_VISA TC22_OPI_VISA = new TC_22_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_22_AUTH_OPI_VISA_700 - Débito - Compra Local - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC22_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_23_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_23_OPI_VISA() {
		//DEFINITIONS
		TC_23_OPI_VISA TC23_OPI_VISA = new TC_23_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_23_AUTH_OPI_VISA_700 - Débito - Compra Local - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC23_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_24_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_24_OPI_VISA() {
		//DEFINITIONS
		TC_24_OPI_VISA TC24_OPI_VISA = new TC_24_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_24_AUTH_OPI_VISA_700 - Débito - Compra Local - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC24_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_25_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_COMPRA")
	@Tag("AUTH_700_VISA_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_25_OPI_VISA() {
		//DEFINITIONS
		TC_25_OPI_VISA TC25_OPI_VISA = new TC_25_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_25_AUTH_OPI_VISA_700 - Débito - Compra Local - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC25_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_26_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_26_OPI_VISA() {
		//DEFINITIONS
		TC_26_OPI_VISA TC26_OPI_VISA = new TC_26_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_26_AUTH_OPI_VISA_700 - Débito - Local - Anulación - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC26_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	
	@Test
	@Tag("TC_27_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_27_OPI_VISA() {
		//DEFINITIONS
		TC_27_OPI_VISA TC27_OPI_VISA = new TC_27_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_27_AUTH_OPI_VISA_700 - Débito - Local - Anulación - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC27_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_28_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_28_OPI_VISA() {
		//DEFINITIONS
		TC_28_OPI_VISA TC28_OPI_VISA = new TC_28_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_28_AUTH_OPI_VISA_700 - Débito - Local - Anulación - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC28_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_29_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_29_OPI_VISA() {
		//DEFINITIONS
		TC_29_OPI_VISA TC29_OPI_VISA = new TC_29_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_29_AUTH_OPI_VISA_700 - Débito - Local - Anulación - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC29_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_30_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_ANULACION")
	@Tag("AUTH_700_VISA_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_30_OPI_VISA() {
		//DEFINITIONS
		TC_30_OPI_VISA TC30_OPI_VISA = new TC_30_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_30_AUTH_OPI_VISA_700 - Débito - Local - Anulación - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC30_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_31_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_31_OPI_VISA() {
		//DEFINITIONS
		TC_31_OPI_VISA TC31_OPI_VISA = new TC_31_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_31_AUTH_OPI_VISA_700 - Débito - Local - Reverso - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC31_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_32_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_32_OPI_VISA() {
		//DEFINITIONS
		TC_32_OPI_VISA TC32_OPI_VISA = new TC_32_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_32_AUTH_OPI_VISA_700 - Débito - Local - Reverso - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC32_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	

	@Test
	@Tag("TC_33_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_33_OPI_VISA() {
		//DEFINITIONS
		TC_33_OPI_VISA TC33_OPI_VISA = new TC_33_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC

		String name = "TC_33_AUTH_OPI_VISA_700 - Débito - Local - Reverso - Chip";

		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN

		report.AddLine(name);

		status = TC33_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	
	@Test
	@Tag("TC_34_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_34_OPI_VISA() {
		//DEFINITIONS
		TC_34_OPI_VISA TC34_OPI_VISA = new TC_34_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_34_AUTH_OPI_VISA_700 - Débito - Local - Reverso - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC34_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_35_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_REVERSO")
	@Tag("AUTH_700_VISA_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_35_OPI_VISA() {
		//DEFINITIONS
		TC_35_OPI_VISA TC35_OPI_VISA = new TC_35_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_35_AUTH_OPI_VISA_700 - Débito - Local - Reverso - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC35_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_36_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_36_OPI_VISA() {
		//DEFINITIONS
		TC_36_OPI_VISA TC36_OPI_VISA = new TC_36_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_36_AUTH_OPI_VISA_700 - Débito - Local - Devolución - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC36_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_37_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_37_OPI_VISA() {
		//DEFINITIONS
		TC_37_OPI_VISA TC37_OPI_VISA = new TC_37_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_37_AUTH_OPI_VISA_700 - Débito - Local - Devolución - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC37_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_38_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_38_OPI_VISA() {
		//DEFINITIONS
		TC_38_OPI_VISA TC38_OPI_VISA = new TC_38_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_38_AUTH_OPI_VISA_700 - Débito - Local - Devolución - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC38_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_39_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_39_OPI_VISA() {
		//DEFINITIONS
		TC_39_OPI_VISA TC39_OPI_VISA = new TC_39_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_39_AUTH_OPI_VISA_700 - Débito - Local - Devolución - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC39_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_40_AUTH_OPI_VISA_700")
	@Tag("AUTH_OPI_VISA_700")
	@Tag("AUTH_VISA_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_VISA_OPI_DEVOLUCION")
	@Tag("AUTH_700_VISA_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_40_OPI_VISA() {
		//DEFINITIONS
		TC_40_OPI_VISA TC40_OPI_VISA = new TC_40_OPI_VISA();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_40_AUTH_OPI_VISA_700 - Débito - Local - Devolución - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC40_OPI_VISA.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	

	//#################### TCs OPI - MASTER ####################
	@Test
	@Tag("TC_01_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_01_OPI_MASTER() {
		//DEFINITIONS
		TC_01_OPI_MASTER TC01_OPI_MASTER = new TC_01_OPI_MASTER();
		
		//SET INDIVIDUAL DATASOURCE
		
		//Nombre Real del TC
		String name = "TC_01_AUTH_OPI_MC_700 - Crédito - Compra Local - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC01_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_02_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_02_OPI_MASTER() {
		//DEFINITIONS
		TC_02_OPI_MASTER TC02_OPI_MASTER = new TC_02_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_02_AUTH_OPI_MC_700 - Crédito - Compra Local - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC02_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_03_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_03_OPI_MASTER() {
		//DEFINITIONS
		TC_03_OPI_MASTER TC03_OPI_MASTER = new TC_03_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_03_AUTH_OPI_MC_700 - Crédito - Compra Local - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC03_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_04_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_04_OPI_MASTER() {
		//DEFINITIONS
		TC_04_OPI_MASTER TC04_OPI_MASTER = new TC_04_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_04_AUTH_OPI_MC_700 - Crédito - Compra Local - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC04_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_05_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_05_OPI_MASTER() {
		//DEFINITIONS
		TC_05_OPI_MASTER TC05_OPI_MASTER = new TC_05_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_05_AUTH_OPI_MC_700 - Crédito - Compra Local - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC05_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_06_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_06_OPI_MASTER() {
		//DEFINITIONS
		TC_06_OPI_MASTER TC06_OPI_MASTER = new TC_06_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_06_AUTH_OPI_MC_700 - Local - Anulación - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC06_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_07_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_07_OPI_MASTER() {
		//DEFINITIONS
		TC_07_OPI_MASTER TC07_OPI_MASTER = new TC_07_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_07_AUTH_OPI_MC_700 - Local - Anulación - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC07_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_08_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_08_OPI_MASTER() {
		//DEFINITIONS
		TC_08_OPI_MASTER TC08_OPI_MASTER = new TC_08_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_08_AUTH_OPI_MC_700 - Local - Anulación - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC08_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_09_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_09_OPI_MASTER() {
		//DEFINITIONS
		TC_09_OPI_MASTER TC09_OPI_MASTER = new TC_09_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_09_AUTH_OPI_MC_700 - Local - Anulación - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC09_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_10_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_10_OPI_MASTER() {
		//DEFINITIONS
		TC_10_OPI_MASTER TC10_OPI_MASTER = new TC_10_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_10_AUTH_OPI_MC_700 - Local - Anulación - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC10_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_11_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_11_OPI_MASTER() {
		//DEFINITIONS
		TC_11_OPI_MASTER TC11_OPI_MASTER = new TC_11_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_11_AUTH_OPI_MC_700 - Local - Reverso - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC11_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_12_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_12_OPI_MASTER() {
		//DEFINITIONS
		TC_12_OPI_MASTER TC12_OPI_MASTER = new TC_12_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_12_AUTH_OPI_MC_700 - Local - Reverso - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC12_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_13_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_13_OPI_MASTER() {
		//DEFINITIONS
		TC_13_OPI_MASTER TC13_OPI_MASTER = new TC_13_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_13_AUTH_OPI_MC_700 - Local - Reverso - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC13_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_14_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_14_OPI_MASTER() {
		//DEFINITIONS
		TC_14_OPI_MASTER TC14_OPI_MASTER = new TC_14_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_14_AUTH_OPI_MC_700 - Local - Reverso - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC14_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_15_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_15_OPI_MASTER() {
		//DEFINITIONS
		TC_15_OPI_MASTER TC15_OPI_MASTER = new TC_15_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_15_AUTH_OPI_MC_700 - Local - Reverso - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC15_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_16_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_16_OPI_MASTER() {
		//DEFINITIONS
		TC_16_OPI_MASTER TC16_OPI_MASTER = new TC_16_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_16_AUTH_OPI_MC_700 - Local - Devolución - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC16_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_17_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_17_OPI_MASTER() {
		//DEFINITIONS
		TC_17_OPI_MASTER TC17_OPI_MASTER = new TC_17_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_17_AUTH_OPI_MC_700 - Local - Devolución - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC17_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_18_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_18_OPI_MASTER() {
		//DEFINITIONS
		TC_18_OPI_MASTER TC18_OPI_MASTER = new TC_18_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_18_AUTH_OPI_MC_700 - Local - Devolución - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC18_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_19_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_19_OPI_MASTER() {
		//DEFINITIONS
		TC_19_OPI_MASTER TC19_OPI_MASTER = new TC_19_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_19_AUTH_OPI_MC_700 - Local - Devolución - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC19_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_20_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_20_OPI_MASTER() {
		//DEFINITIONS
		TC_20_OPI_MASTER TC20_OPI_MASTER = new TC_20_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_20_AUTH_OPI_MC_700 - Local - Devolución - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC20_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_21_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_21_OPI_MASTER() {
		//DEFINITIONS
		TC_21_OPI_MASTER TC21_OPI_MASTER = new TC_21_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_21_AUTH_OPI_MC_700 - Débito - Compra Local - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC21_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_22_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_22_OPI_MASTER() {
		//DEFINITIONS
		TC_22_OPI_MASTER TC22_OPI_MASTER = new TC_22_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_22_AUTH_OPI_MC_700 - Débito - Compra Local - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC22_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_23_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_23_OPI_MASTER() {
		//DEFINITIONS
		TC_23_OPI_MASTER TC23_OPI_MASTER = new TC_23_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_23_AUTH_OPI_MC_700 - Débito - Compra Local - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC23_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_24_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_24_OPI_MASTER() {
		//DEFINITIONS
		TC_24_OPI_MASTER TC24_OPI_MASTER = new TC_24_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_24_AUTH_OPI_MC_700 - Débito - Compra Local - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC24_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_25_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_COMPRA")
	@Tag("AUTH_700_MC_COMPRA")
	@Tag("AUTH_700_OPI_COMPRA")
	@Tag("AUTH_700_COMPRA")
	void TC_25_OPI_MASTER() {
		//DEFINITIONS
		TC_25_OPI_MASTER TC25_OPI_MASTER = new TC_25_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_25_AUTH_OPI_MC_700 - Débito - Compra Local - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC25_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_26_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_26_OPI_MASTER() {
		//DEFINITIONS
		TC_26_OPI_MASTER TC26_OPI_MASTER = new TC_26_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_26_AUTH_OPI_MC_700 - Débito - Local - Anulación - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC26_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_27_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_27_OPI_MASTER() {
		//DEFINITIONS
		TC_27_OPI_MASTER TC27_OPI_MASTER = new TC_27_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_27_AUTH_OPI_MC_700 - Débito - Local - Anulación - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC27_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_28_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_28_OPI_MASTER() {
		//DEFINITIONS
		TC_28_OPI_MASTER TC28_OPI_MASTER = new TC_28_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_28_AUTH_OPI_MC_700 - Débito - Local - Anulación - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC28_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@Test
	@Tag("TC_29_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_29_OPI_MASTER() {
		//DEFINITIONS
		TC_29_OPI_MASTER TC29_OPI_MASTER = new TC_29_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_29_AUTH_OPI_MC_700 - Débito - Local - Anulación - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC29_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_30_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_ANULACION")
	@Tag("AUTH_700_MC_ANULACION")
	@Tag("AUTH_700_OPI_ANULACION")
	@Tag("AUTH_700_ANULACION")
	void TC_30_OPI_MASTER() {
		//DEFINITIONS
		TC_30_OPI_MASTER TC30_OPI_MASTER = new TC_30_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_30_AUTH_OPI_MC_700 - Débito - Local - Anulación - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC30_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_31_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_31_OPI_MASTER() {
		//DEFINITIONS
		TC_31_OPI_MASTER TC31_OPI_MASTER = new TC_31_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_31_AUTH_OPI_MC_700 - Débito - Local - Reverso - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC31_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_32_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_32_OPI_MASTER() {
		//DEFINITIONS
		TC_32_OPI_MASTER TC32_OPI_MASTER = new TC_32_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_32_AUTH_OPI_MC_700 - Débito - Local - Reverso - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC32_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_33_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_33_OPI_MASTER() {
		//DEFINITIONS
		TC_33_OPI_MASTER TC33_OPI_MASTER = new TC_33_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_33_AUTH_OPI_MC_700 - Débito - Local - Reverso - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC33_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_34_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_34_OPI_MASTER() {
		//DEFINITIONS
		TC_34_OPI_MASTER TC34_OPI_MASTER = new TC_34_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_34_AUTH_OPI_MC_700 - Débito - Local - Reverso - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC34_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_35_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_REVERSO")
	@Tag("AUTH_700_MC_REVERSO")
	@Tag("AUTH_700_OPI_REVERSO")
	@Tag("AUTH_700_REVERSO")
	void TC_35_OPI_MASTER() {
		//DEFINITIONS
		TC_35_OPI_MASTER TC35_OPI_MASTER = new TC_35_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_35_AUTH_OPI_MC_700 - Débito - Local - Reverso - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC35_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_36_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_36_OPI_MASTER() {
		//DEFINITIONS
		TC_36_OPI_MASTER TC36_OPI_MASTER = new TC_36_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_36_AUTH_OPI_MC_700 - Débito - Local - Devolución - Manual";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC36_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_37_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_37_OPI_MASTER() {
		//DEFINITIONS
		TC_37_OPI_MASTER TC37_OPI_MASTER = new TC_37_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_37_AUTH_OPI_MC_700 - Débito - Local - Devolución - Banda";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC37_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_38_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_38_OPI_MASTER() {
		//DEFINITIONS
		TC_38_OPI_MASTER TC38_OPI_MASTER = new TC_38_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_38_AUTH_OPI_MC_700 - Débito - Local - Devolución - Chip";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC38_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_39_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_39_OPI_MASTER() {
		//DEFINITIONS
		TC_39_OPI_MASTER TC39_OPI_MASTER = new TC_39_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_39_AUTH_OPI_MC_700 - Débito - Local - Devolución - Contactless";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC39_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@Test
	@Tag("TC_40_AUTH_OPI_MC_700")
	@Tag("AUTH_OPI_MC_700")
	@Tag("AUTH_MC_700")
	@Tag("AUTH_OPI_700")
	@Tag("AUTH_700")
	@Tag("AUTH_700_MC_OPI_DEVOLUCION")
	@Tag("AUTH_700_MC_DEVOLUCION")
	@Tag("AUTH_700_OPI_DEVOLUCION")
	@Tag("AUTH_700_DEVOLUCION")
	void TC_40_OPI_MASTER() {
		//DEFINITIONS
		TC_40_OPI_MASTER TC40_OPI_MASTER = new TC_40_OPI_MASTER();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_40_AUTH_OPI_MC_700 - Débito - Local - Devolución - Ecommerce";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		status = TC40_OPI_MASTER.Test(report, name, configEntidad);

		//Configuracion de variables para el armado del reporte
		repoVar.setResult(status);

		//Verificamos si la ejecucion falla y guardamos el status Gral.
		if (status == false)
		{
			msg = "Fail;Fallo la ejecucion. TC: " + name;
		}

		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}
	
	@AfterEach
	void tearDown() {
		if (repoVar.getTipoTc().equals("API")) {
			report.addTestCaseToGeneralReport(repoVar.getResult(), repoVar.getDataMsg(), "");
			report.saveTestCaseReport(repoVar.getDataMsg());
		} else {
			System.out.println("El caso de prueba no es: API");
		}
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("Execution finished");
		report.saveGeneralReport();
	}

}

