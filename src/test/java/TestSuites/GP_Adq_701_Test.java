package TestSuites;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_Variables;

import org.junit.jupiter.api.Tag;

import Tools.msgWorker;
import junit.framework.Assert;
import TestCases.GB_Adquirencia701.*;
import TestCases.GO_Adquirencia701.*;

public class GP_Adq_701_Test 
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
		//Variables Repository
		repoVar = new Repo_Variables();
		path = "./Datasources/config701.json";
		configEntidad = new String(Files.readAllBytes(Paths.get(path)));
	}

	@BeforeEach
	void init() {
	}


	//#################### TCs WEB Global BATCH ADQUIRENCIA URUGUAY ####################
	
	@Test
	@Tag("TC_01_GB_701")
	@Tag("GB_701")
	@Tag("GB_LOGIN")
	void TC_01_WEB_GB_701() {
		//DEFINITIONS
		TC_01_WEB_GB_701 TC01_WEB_GB_701 = new TC_01_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_01_WEB_GB_701 - Login";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			status = TC01_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_02_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_02_WEB_GB_701() {
		//DEFINITIONS
		TC_02_WEB_GB_701 TC02_WEB_GB_701 = new TC_02_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_02_WEB_GB_701 - Modelo de pago - Validación básica";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC02_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_03_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_03_WEB_GB_701() {
		//DEFINITIONS
		TC_03_WEB_GB_701 TC03_WEB_GB_701 = new TC_03_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_03_WEB_GB_701 - Modelo de pago - Días corridos - Parametría por defecto - Compra Maestro";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC03_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_04_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_04_WEB_GB_701() {
		//DEFINITIONS
		TC_04_WEB_GB_701 TC04_WEB_GB_701 = new TC_04_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_04_WEB_GB_701 - Modelo de pago - Días corridos - Parametría por defecto - Compra Crédito";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC04_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_05_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_05_WEB_GB_701() {
		//DEFINITIONS
		TC_05_WEB_GB_701 TC05_WEB_GB_701 = new TC_05_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_05_WEB_GB_701 - Modelo de pago - Días corridos - Parametría por defecto - Compra Débito";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC05_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_06_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_06_WEB_GB_701() {
		//DEFINITIONS
		TC_06_WEB_GB_701 TC06_WEB_GB_701 = new TC_06_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_06_WEB_GB_701 - Modelo de pago - Días corridos - Parametría por defecto - Compra Prepaga";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC06_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_07_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_07_WEB_GB_701() {
		//DEFINITIONS
		TC_07_WEB_GB_701 TC07_WEB_GB_701 = new TC_07_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_07_WEB_GB_701 - Modelo de pago - Días corridos - Parametría Parametría Específica - Compra Crédito";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC07_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_08_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_08_WEB_GB_701() {
		//DEFINITIONS
		TC_08_WEB_GB_701 TC08_WEB_GB_701 = new TC_08_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_08_WEB_GB_701 - Modelo de pago - Días Habiles - Parametría por defecto - Compra Maestro";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC08_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_09_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_09_WEB_GB_701() {
		//DEFINITIONS
		TC_09_WEB_GB_701 TC09_WEB_GB_701 = new TC_09_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_09_WEB_GB_701 - Modelo de pago - Días Habiles - Parametría por defecto - Compra Crédito";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC09_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_10_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_10_WEB_GB_701() {
		//DEFINITIONS
		TC_10_WEB_GB_701 TC10_WEB_GB_701 = new TC_10_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_10_WEB_GB_701 - Modelo de pago - Días Habiles - Parametría por defecto - Compra Débito";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC10_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_11_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_11_WEB_GB_701() {
		//DEFINITIONS
		TC_11_WEB_GB_701 TC11_WEB_GB_701 = new TC_11_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_11_WEB_GB_701 - Modelo de pago - Días Habiles - Parametría por defecto - Compra Prepaga";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC11_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_12_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_12_WEB_GB_701() {
		//DEFINITIONS
		TC_12_WEB_GB_701 TC12_WEB_GB_701 = new TC_12_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_12_WEB_GB_701 - Modelo de pago - Días Habiles - Parametría Parametría Específica - Compra Crédito";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC12_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_13_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_13_WEB_GB_701() {
		//DEFINITIONS
		TC_13_WEB_GB_701 TC13_WEB_GB_701 = new TC_13_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_13_WEB_GB_701 - Modelo de pago - Día Feriado";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC13_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_14_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_14_WEB_GB_701() {
		//DEFINITIONS
		TC_14_WEB_GB_701 TC14_WEB_GB_701 = new TC_14_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_14_WEB_GB_701 - Modelo de cierre - Crédito - Cierre Diario";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC14_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_15_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_15_WEB_GB_701() {
		//DEFINITIONS
		TC_15_WEB_GB_701 TC15_WEB_GB_701 = new TC_15_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_15_WEB_GB_701 - Modelo de cierre - Crédito - Cierre Semanal";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC15_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_16_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_16_WEB_GB_701() {
		//DEFINITIONS
		TC_16_WEB_GB_701 TC16_WEB_GB_701 = new TC_16_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_16_WEB_GB_701 - Modelo de cierre - Crédito - Cierre Mensual";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC16_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_17_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_17_WEB_GB_701() {
		//DEFINITIONS
		TC_17_WEB_GB_701 TC17_WEB_GB_701 = new TC_17_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_17_WEB_GB_701 - Modelo de cierre - Compra Maestro";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC17_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_18_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_18_WEB_GB_701() {
		//DEFINITIONS
		TC_18_WEB_GB_701 TC18_WEB_GB_701 = new TC_18_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_18_WEB_GB_701 - Modelo de cierre - Compra Débito";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC18_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_19_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_19_WEB_GB_701() {
		//DEFINITIONS
		TC_19_WEB_GB_701 TC19_WEB_GB_701 = new TC_19_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_19_WEB_GB_701 - Modelo de cierre - Compra Prepaga";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC19_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_20_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_20_WEB_GB_701() {
		//DEFINITIONS
		TC_20_WEB_GB_701 TC20_WEB_GB_701 = new TC_20_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_20_WEB_GB_701 - Modelo de Cierre - Feriado Mantiene Fecha";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC20_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_21_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_21_WEB_GB_701() {
		//DEFINITIONS
		TC_21_WEB_GB_701 TC21_WEB_GB_701 = new TC_21_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_21_WEB_GB_701 - Modelo de Cierre - Feriado Hábil Siguiente";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC21_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_22_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_22_WEB_GB_701() {
		//DEFINITIONS
		TC_22_WEB_GB_701 TC22_WEB_GB_701 = new TC_22_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_22_WEB_GB_701 - Modelo de Cierre - Feriado Hábil Anterior";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC22_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_23_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_23_WEB_GB_701() {
		//DEFINITIONS
		TC_23_WEB_GB_701 TC23_WEB_GB_701 = new TC_23_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_23_WEB_GB_701 - Modelo de Cierre - Crédito - Cierre Calendario";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC23_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_24_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_24_WEB_GB_701() {
		//DEFINITIONS
		TC_24_WEB_GB_701 TC24_WEB_GB_701 = new TC_24_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_24_WEB_GB_701 - Modelo de Arancel - Debito Local";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC24_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_25_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_25_WEB_GB_701() {
		//DEFINITIONS
		TC_25_WEB_GB_701 TC25_WEB_GB_701 = new TC_25_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_25_WEB_GB_701 - Modelo de Arancel - Debito Extranjero";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC25_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_26_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_26_WEB_GB_701() {
		//DEFINITIONS
		TC_26_WEB_GB_701 TC26_WEB_GB_701 = new TC_26_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_26_WEB_GB_701 - Modelo de Arancel - Prepaga Local";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC26_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_27_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")	
	void TC_27_WEB_GB_701() {
		//DEFINITIONS
		TC_27_WEB_GB_701 TC27_WEB_GB_701 = new TC_27_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_27_WEB_GB_701 - Modelo de Arancel - Prepaga Extranjero";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC27_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_28_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")	
	void TC_28_WEB_GB_701() {
		//DEFINITIONS
		TC_28_WEB_GB_701 TC28_WEB_GB_701 = new TC_28_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_28_WEB_GB_701 - Modelo de Arancel - Credito Local";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC28_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_29_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_29_WEB_GB_701() {
		//DEFINITIONS
		TC_29_WEB_GB_701 TC29_WEB_GB_701 = new TC_29_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_29_WEB_GB_701 - Modelo de Arancel - Credito Extranjero";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC29_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_30_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")	
	void TC_30_WEB_GB_701() {
		//DEFINITIONS
		TC_30_WEB_GB_701 TC30_WEB_GB_701 = new TC_30_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_30_WEB_GB_701 - Modelo de Arancel - Credito Local en cuotas";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC30_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_31_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")	
	void TC_31_WEB_GB_701() {
		//DEFINITIONS
		TC_31_WEB_GB_701 TC31_WEB_GB_701 = new TC_31_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_31_WEB_GB_701 - Modelo de financiación - 1 cuota";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC31_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_32_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_32_WEB_GB_701() {
		//DEFINITIONS
		TC_32_WEB_GB_701 TC32_WEB_GB_701 = new TC_32_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_32_WEB_GB_701 - Modelo de financiación - Mod. Financ. Sin vigencia";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC32_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_33_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_33_WEB_GB_701() {
		//DEFINITIONS
		TC_33_WEB_GB_701 TC33_WEB_GB_701 = new TC_33_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_33_WEB_GB_701 - Modelo de financiación - Cuotas - Formula Directa - Financiacion otorgante - Importes Intereses";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC33_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_34_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_34_WEB_GB_701() {
		//DEFINITIONS
		TC_34_WEB_GB_701 TC34_WEB_GB_701 = new TC_34_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_34_WEB_GB_701 - Modelo de financiación - Cuotas - Formula Directa - Financiacion adquirente - Importes Intereses";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC34_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_35_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_35_WEB_GB_701() {
		//DEFINITIONS
		TC_35_WEB_GB_701 TC35_WEB_GB_701 = new TC_35_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_35_WEB_GB_701 - Modelo de financiación - Cuotas - Formula Directa - Financiacion Comercio - Importes Intereses";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC35_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_36_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_36_WEB_GB_701() {
		//DEFINITIONS
		TC_36_WEB_GB_701 TC36_WEB_GB_701 = new TC_36_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_36_WEB_GB_701 - Modelo de financiación - Cuotas - Formula Directa - Plazo Pago Promedio Ponderado (PPP) - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC36_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_37_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_37_WEB_GB_701() {
		//DEFINITIONS
		TC_37_WEB_GB_701 TC37_WEB_GB_701 = new TC_37_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_37_WEB_GB_701 - Modelo de financiación - Cuotas - Formula Directa - Plan Gobierno - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC37_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_38_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_38_WEB_GB_701() {
		//DEFINITIONS
		TC_38_WEB_GB_701 TC38_WEB_GB_701 = new TC_38_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_38_WEB_GB_701 - Modelo de financiación - Cuotas - Formula TNA/TEA - Financiacion otorgante - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC38_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_39_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_39_WEB_GB_701() {
		//DEFINITIONS
		TC_39_WEB_GB_701 TC39_WEB_GB_701 = new TC_39_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_39_WEB_GB_701 - Modelo de financiación - Cuotas - Formula TNA/TEA - Financiacion adquirente - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC39_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_40_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_40_WEB_GB_701() {
		//DEFINITIONS
		TC_40_WEB_GB_701 TC40_WEB_GB_701 = new TC_40_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_40_WEB_GB_701 - Modelo de financiación - Cuotas - Formula TNA/TEA - Financiacion Comercio - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC40_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_41_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_41_WEB_GB_701() {
		//DEFINITIONS
		TC_41_WEB_GB_701 TC41_WEB_GB_701 = new TC_41_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_41_WEB_GB_701 - Modelo de financiación - Cuotas - Formula TNA/TEA - Financiacion Comercio - Importes Intereses";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC41_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_42_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_42_WEB_GB_701() {
		//DEFINITIONS
		TC_42_WEB_GB_701 TC42_WEB_GB_701 = new TC_42_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_42_WEB_GB_701 - Modelo de financiación - Cuotas - Formula TNA/TEA - Financiacion Comercio - Importes Intereses";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC42_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_43_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")	
	void TC_43_WEB_GB_701() {
		//DEFINITIONS
		TC_43_WEB_GB_701 TC_43_WEB_GB_701 = new TC_43_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_43_WEB_GB_701 - Modelo de financiación - Financiacion otorgante - Fechas de Liquidación De cuotas";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC_43_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_44_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")	
	void TC_44_WEB_GB_701() {
		//DEFINITIONS
		TC_44_WEB_GB_701 TC_44_WEB_GB_701 = new TC_44_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_44_WEB_GB_701 - Modelo de financiación - Financiacion Adquirente - Fechas de Liquidación De cuotas";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC_44_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_45_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_45_WEB_GB_701() {
		//DEFINITIONS
		TC_45_WEB_GB_701 TC45_WEB_GB_701 = new TC_45_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_45_WEB_GB_701 - Modelo de financiación - Financiacion Comercio - Fechas de Liquidación De cuotas";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC45_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_46_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_46_WEB_GB_701() {
		//DEFINITIONS
		TC_46_WEB_GB_701 TC46_WEB_GB_701 = new TC_46_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_46_WEB_GB_701 - Modelo de financiación - Financiacion PPP - Fechas de Liquidación De cuotas";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC46_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_47_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_47_WEB_GB_701() {
		//DEFINITIONS
		TC_47_WEB_GB_701 TC47_WEB_GB_701 = new TC_47_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_47_WEB_GB_701 - Modelo de financiación - Financiacion Plan Gobierno - Fechas de Liquidación De cuotas";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC47_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_48_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_48_WEB_GB_701() {
		//DEFINITIONS
		TC_48_WEB_GB_701 TC48_WEB_GB_701 = new TC_48_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_48_WEB_GB_701 - Control Liquidación Comercio - Consumo 1 cuota";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC48_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_49_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_49_WEB_GB_701() {
		//DEFINITIONS
		TC_49_WEB_GB_701 TC49_WEB_GB_701 = new TC_49_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_49_WEB_GB_701 - Control Liquidación Comercio - Consumo Cuotas - 1 pago";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC49_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_50_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_50_WEB_GB_701() {
		//DEFINITIONS
		TC_50_WEB_GB_701 TC50_WEB_GB_701 = new TC_50_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_50_WEB_GB_701 - Control Liquidación Comercio - Consumo Cuotas - Pago Cuota a Cuota";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC50_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_51_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_51_WEB_GB_701() {
		//DEFINITIONS
		TC_51_WEB_GB_701 TC51_WEB_GB_701 = new TC_51_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_51_WEB_GB_701 - Devolución";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC51_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_52_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_52_WEB_GB_701() {
		//DEFINITIONS
		TC_52_WEB_GB_701 TC52_WEB_GB_701 = new TC_52_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_52_WEB_GB_701 - Autorizacion Anulada/reversada";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC52_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_53_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_53_WEB_GB_701() {
		//DEFINITIONS
		TC_53_WEB_GB_701 TC53_WEB_GB_701 = new TC_53_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_53_WEB_GB_701 - Autorizacion Anulada/reversada";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC53_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_54_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_54_WEB_GB_701() {
		//DEFINITIONS
		TC_54_WEB_GB_701 TC54_WEB_GB_701 = new TC_54_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_54_WEB_GB_701 - Parametría - Identificador de comercio = null";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC54_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_55_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_55_WEB_GB_701() {
		//DEFINITIONS
		TC_55_WEB_GB_701 TC55_WEB_GB_701 = new TC_55_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_55_WEB_GB_701 - Parametría - Identificador de comercio con valor";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC55_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_56_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_56_WEB_GB_701() {
		//DEFINITIONS
		TC_56_WEB_GB_701 TC56_WEB_GB_701 = new TC_56_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_56_WEB_GB_701 - Parametría - Identificador de comercio - Formato inválido";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC56_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_57_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_57_WEB_GB_701() {
		//DEFINITIONS
		TC_57_WEB_GB_701 TC57_WEB_GB_701 = new TC_57_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_57_WEB_GB_701 - Parametría - Fecha de procesamiento menor a fecha_autorización ";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC57_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_58_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_58_WEB_GB_701() {
		//DEFINITIONS
		TC_58_WEB_GB_701 TC58_WEB_GB_701 = new TC_58_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_58_WEB_GB_701 - Parametría - Fecha de procesamiento Igual a fecha_autorización";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC58_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_59_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_59_WEB_GB_701() {
		//DEFINITIONS
		TC_59_WEB_GB_701 TC59_WEB_GB_701 = new TC_59_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_59_WEB_GB_701 - Parametría - Fecha de procesamiento Mayor a fecha_autorización";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			report.AddLine(name);
			try {
				status = TC59_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_60_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_60_WEB_GB_701() {
		//DEFINITIONS
		TC_60_WEB_GB_701 TC_60_WEB_GB_701 = new TC_60_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_60_WEB_GB_701 - Parametria - Fecha de procesamiento Mayor de fecha de ejecucion";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_60_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_61_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_61_WEB_GB_701() {
		//DEFINITIONS
		TC_61_WEB_GB_701 TC_61_WEB_GB_701 = new TC_61_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_61_WEB_GB_701 - Parametría - Fecha de procesamiento - Formato inválido";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_61_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_62_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_62_WEB_GB_701() {
		//DEFINITIONS
		TC_62_WEB_GB_701 TC_62_WEB_GB_701 = new TC_62_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_62_WEB_GB_701 - Parametría - Identificador de terminal - null";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_62_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_63_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_63_WEB_GB_701() {
		//DEFINITIONS
		TC_63_WEB_GB_701 TC_63_WEB_GB_701 = new TC_63_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_63_WEB_GB_701 - Parametría - Identificador de terminal - con valor";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_63_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_64_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_64_WEB_GB_701() {
		//DEFINITIONS
		TC_64_WEB_GB_701 TC_64_WEB_GB_701 = new TC_64_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_64_WEB_GB_701 - Parametría - Identificador de terminal - formato inválido";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_64_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_65_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_PRESENTACION")
	void TC_65_WEB_GB_701() {
		//DEFINITIONS
		TC_65_WEB_GB_701 TC_65_WEB_GB_701 = new TC_65_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_65_WEB_GB_701 - Compra con propina";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_65_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_71_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_LIQUIDACION_COMERCIOS")
	void TC_71_WEB_GB_701() {
		//DEFINITIONS
		TC_71_WEB_GB_701 TC_71_WEB_GB_701 = new TC_71_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_71_WEB_GB_701 - Tipo Fecha Liquidacion - Fecha de cierre ";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_71_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_73_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_LIQUIDACION_COMERCIOS")
	void TC_73_WEB_GB_701() {
		//DEFINITIONS
		TC_73_WEB_GB_701 TC_73_WEB_GB_701 = new TC_73_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_73_GB_701 - Fecha de ejecución menor a fecha de cierre de consumo";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_73_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_74_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_LIQUIDACION_COMERCIOS")
	void TC_74_WEB_GB_701() {
		//DEFINITIONS
		TC_74_WEB_GB_701 TC_74_WEB_GB_701 = new TC_74_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_74_GB_701 - Tipo Fecha Liquidacion - Fecha de pago";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_74_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_76_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_LIQUIDACION_COMERCIOS")
	void TC_76_WEB_GB_701() {
		//DEFINITIONS
		TC_76_WEB_GB_701 TC_76_WEB_GB_701 = new TC_76_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_76_GB_701 - Fecha de ejecución menor a fecha de pago de consumo";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_76_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_77_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_LIQUIDACION_COMERCIOS")
	void TC_77_WEB_GB_701() {
		//DEFINITIONS
		TC_77_WEB_GB_701 TC_77_WEB_GB_701 = new TC_77_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_77_GB_701 - CONSUMOS.LIQ_COMERCIO = '1'";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_77_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_81_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_LIQUIDACION_COMERCIOS")
	void TC_81_WEB_GB_701() {
		//DEFINITIONS
		TC_81_WEB_GB_701 TC_81_WEB_GB_701 = new TC_81_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_81_GB_701 - Parámetros de ejecución - Fecha - Formato inválido";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_81_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	@Tag("TC_82_GB_701")
	@Tag("GB_701")
	@Tag("GB_701_LIQUIDACION_COMERCIOS")
	void TC_82_WEB_GB_701() {
		//DEFINITIONS
		TC_82_WEB_GB_701 TC_82_WEB_GB_701 = new TC_82_WEB_GB_701();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "TC_82_GB_701 - Parámetros de ejecución - Fecha - Fecha futura";
		report.AddLine(name);
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			try {
				status = TC_82_WEB_GB_701.Test(data, report, DM, x, name + "_Iteracion_" + x, configEntidad);
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
	
	@AfterEach
	void tearDown() {
		if (repoVar.getTipoTc().equals("API")) {
			report.addTestCaseToGeneralReport(repoVar.getResult(), repoVar.getDataStr(), "");
			report.saveTestCaseReport(repoVar.getDataStr());
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

