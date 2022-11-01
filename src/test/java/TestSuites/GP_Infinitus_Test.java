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
import TestCases.INFINITUS_API.*;
import Tools.msgWorker;
import junit.framework.Assert;

public class GP_Infinitus_Test 
{
	static 

	//Init
	DriverManager DM;
	static Datasources data;
	static Reports report;
	static Repo_Variables repoVar;
	static String pathConfigEntidad;
	static String configEntidad;
	static String pathEnviroment;
	static String enviroment;

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

		pathConfigEntidad = "./Datasources/config_entidad.json";

		configEntidad = new String(Files.readAllBytes(Paths.get(pathConfigEntidad)));
		
		pathEnviroment = "./API_Request/Enviroment/Prepagas_QA.json";

		enviroment = new String(Files.readAllBytes(Paths.get(pathEnviroment)));
	}

	@BeforeEach
	void init() {
	}

	//#################### TCs APIs INFINITUS PrePagas ####################
	@Test
	@Tag("TC_01_INFINITUS")
	void TC_01_INFINITUS() {
		//DEFINITIONS
		TC_01_INFINITUS_API TC01_INFINITUS_API = new TC_01_INFINITUS_API();

		//SET INDIVIDUAL DATASOURCE

		//Nombre Real del TC
		String name = "TC_01_INFINITUS_API - Cuenta Crear";
		boolean status = false;
		String msg = "True;Resultado de la ejecucion OK. TC: " + name;

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("API");
		repoVar.setResult(status);
		repoVar.setDataMsg(name);

		//SET THE EXECUTION PLAN
		report.AddLine(name);
		status = TC01_INFINITUS_API.Test(report, name, configEntidad, enviroment);
		
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

