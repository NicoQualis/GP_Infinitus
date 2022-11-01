package Pasos.Generales;

import static org.hamcrest.Matchers.equalTo;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.hamcrest.MatcherAssert;

import CentaJava.Core.Reports;
import Repositories.Repo_Variables;
import Tools.apiWorker;
import io.restassured.response.Response;


public class AutorizadorInterno {
	//Metodos para utilizar color en la consola
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	
	// Configuracion del endpoint de la API
	public void setEndpoint(Repo_Variables repoVar, String base_uri) {
		repoVar.setBaseUri(base_uri);
	}
		
	// Solicitud del token de acceso.
	public String getToken(Reports report, apiWorker apiResp, String endPointToken, String enviroment) {
		String token = ""; 
		
		try {
			token = apiResp.GetAccessTokenAI(endPointToken, enviroment);
		} catch (Exception E) {
			report.AddLineAssertionError("No se obtuvo un token.\r\nError: " + E);
			System.out.println("No se obtuvo un token.\r\nError: " + E);
		}
		return token;
	}
	
	// Extraccion del body del archivo txt
	public String getBodyData(Reports report, String path) {
		String bodyData = ""; 

		try {
			bodyData = new String(Files.readAllBytes(Paths.get(path)));			
		} catch (Exception E) {
			report.AddLine("Error al abrir el archivo.<br>Error: " + E);
			System.out.println("Error al abrir el archivo.\r\nError: " + E);
		}
		
		return bodyData;
	}
	
	// Realizamos un post a travez del api wroker, verificamos que el status code sea el correcto y devolvemos la respuesta
	public String post(Reports report, Repo_Variables repoVar, apiWorker apiResp, String bodyData, String token, String enviroment) throws Exception {
		Response response;
		//sshWorker apiCmd = new sshWorker();
		String bodyResponse = "";
		
		response = apiResp.postMethod(repoVar,"" , "", bodyData, token, enviroment);
		//Se reporta el Status Code
		report.AddLine("Resultado POST - Status Code: " + String.valueOf(response.getStatusCode()));
		System.out.println("Resultado POST - Status Code: " + String.valueOf(response.getStatusCode()) + "\r\n");
		//Se valida el status code
		if(response.getStatusCode()!=201) {
			report.AddLineAssertionError("Fallo la validacion del StatusCode<br>Esperado: 201 - Obtenido: " + String.valueOf(response.getStatusCode()));
			System.out.println("Fallo la validacion del StatusCode\r\nEsperado: 201 - Obtenido: " + String.valueOf(response.getStatusCode()) + "\r\n");
			MatcherAssert.assertThat("Validacion del Status code", String.valueOf(response.getStatusCode()), equalTo("201"));				
		}else if(response.getStatusCode() == 201) {
			bodyResponse = response.getBody().asPrettyString();
		}
		bodyResponse = response.getBody().asPrettyString();
		
		//Se obtiene el body del response//Obteniendo el numero de cuenta creado
		return bodyResponse;
	}
	
	// VALIDACIONES de la respuesta
	public boolean validacionCuentasMoneda(Reports report, String[] rtaQuery, String[] resulEsperado) {
		String[] res = new String[17];

		if(!rtaQuery[0].equals(resulEsperado[0])) {
			report.AddLineAssertionError("Error:<br>El DISPONIBLE es: " + rtaQuery[0] + " Se esperaba DISPONIBLE: " + resulEsperado[0]);
			System.out.println(ANSI_YELLOW + "Error:\r\nEl DISPONIBLE es: " + rtaQuery[0] + " Se esperaba DISPONIBLE: " + resulEsperado[0] + "\r\n" + ANSI_RESET);
			res[0] = "KO";
		} else {
			report.AddLine("Validacion exitosa<br>El DISPONIBLE esperado es: " + resulEsperado[0] + "y es igual al de la base de datos: " + rtaQuery[0]);
			System.out.println(ANSI_GREEN + "Validacion exitosa:\r\nEl DISPONIBLE esperado es: " + resulEsperado[0] + " y es igual al de la base de datos: " + rtaQuery[0] + "\r\n" + ANSI_RESET);
			res[0] = "OK";
		}

		if(!rtaQuery[1].equals(resulEsperado[1])) {
			report.AddLineAssertionError("Error:<br>El IMPORTE_PEND_COMPRAS es: " + rtaQuery[1] + " Se esperaba IMPORTE_PEND_COMPRAS: " + resulEsperado[1]);
			System.out.println(ANSI_YELLOW + "Error:\r\nEl IMPORTE_PEND_COMPRAS  es: " + rtaQuery[1] + " Se esperaba IMPORTE_PEND_COMPRAS: " + resulEsperado[1] + "\r\n" + ANSI_RESET);
			res[1] = "KO";
		} else {
			report.AddLine("Validacion exitosa:<br>El IMPORTE_PEND_COMPRAS esperado es : " + resulEsperado[1] + " y es igual al de la base de datos: " + rtaQuery[1]);
			System.out.println(ANSI_GREEN + "Validacion exitosa:\r\nEl IMPORTE_PEND_COMPRAS esperado es : " + resulEsperado[1] + " y es igual al de la base de datos: " + rtaQuery[1] + "\r\n" + ANSI_RESET);
			res[1] = "OK";
		}
		
		if (res[0].equals("OK") && res[1].equals("OK"))
		{
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validacionAutorizacion(Reports report, String respuesta, String[] resulEsperado) {
		if(!respuesta.equals(resulEsperado[2])) {
			report.AddLineAssertionError("Error:<br>El ID_ESTADO de la autorizacion es: " + respuesta + " Se esperaba el ID_ESTADO: " + resulEsperado[2]);
			System.out.println(ANSI_YELLOW + "Error:\r\nEl ID_ESTADO de la autorizacion es: " + respuesta + " Se esperaba el ID_ESTADO: " + resulEsperado[2] + "\r\n" + ANSI_RESET);
			return false;	
		} else {
			report.AddLine("Validacion exitosa:<br>El ID_ESTADO de la autorizacion es: " + respuesta  + " y es igual al ID_ESTADO esperado = " + resulEsperado[2]);
			System.out.println(ANSI_GREEN + "Validacion exitosa:\r\nEl ID_ESTADO de la autorizacion es: " + respuesta  + " y es igual al ID_ESTADO esperado = " + resulEsperado[2] + "\r\n" + ANSI_RESET);
			return true;
		}
	}
	
	public boolean validacionDE39EnResponse(Reports report, String respuesta, String[] resulEsperado) {
		if(!respuesta.equals(resulEsperado[3])) {
			report.AddLineAssertionError("Error:<br>El DE39 del response es: " + respuesta + " Se esperaba el DE39: " + resulEsperado[3]);
			System.out.println(ANSI_YELLOW + "Error:\r\nEl DE39 del response es: " + respuesta + " Se esperaba el DE39: " + resulEsperado[3] + "\r\n" + ANSI_RESET);
			return false;	
		} else {
			report.AddLine("Validacion exitosa:<br>El DE39 del response es: " + respuesta  + " y es igual al DE39 esperado: " + resulEsperado[3]);
			System.out.println(ANSI_GREEN + "Validacion exitosa:\r\nEl DE39 del response es: " + respuesta  + " y es igual al DE39 esperado: " + resulEsperado[3] + "\r\n" + ANSI_RESET);
			return true;
		}
	}
	
	public boolean validacionesRespBase(Reports report, String valorResponse, String valorBD) {
		if(valorResponse.equals(valorBD)) {
			System.out.println(ANSI_GREEN + "Validacion exitosa: Los datos del response son iguales a los de la base\r\n" + ANSI_RESET);
			return true;
		} else {
			System.out.println("Validacion incorrecta: Los datos del response no son iguales a los de la base\r\n");
			return false;
		}	
	}
	
	public boolean resultadoPostCondiciones(Reports report, Integer postCond1, Integer postCond2, Integer postCond3) {
		// Si los 3 deletes se ejecutaron correctamente cada uno deberia devolver la cantidad de registros editados siendo mayor que 0 en todas para que sea correcto
		if (postCond1 != 0 & postCond2 != 0 & postCond3 != 0) {
			report.AddLine("OK! Todas las PostCondiciones de pruebas ejecutadas correctamente");
			System.out.println("OK! Todas las PostCondiciones de pruebas ejecutadas correctamente");
			return true;
		} else {	
			report.AddLine("Error en PostCondiciones!! Delete 1: "+postCond1+" / Delete 2: "+postCond2+" / Delete 3: "+postCond1);
			System.out.println("Error en PostCondiciones!! Delete 1: "+postCond1+" / Delete 2: "+postCond2+" / Delete 3: "+postCond1);
			return false;
		}
	}
	
	public boolean resultadoPostCondiciones(Reports report, Integer postCond1, Integer postCond2, Integer postCond3, Integer postCond4) {
		// Si los 3 deletes se ejecutaron correctamente cada uno deberia devolver la cantidad de registros editados siendo mayor que 0 en todas para que sea correcto
		if (postCond1 != 0 & postCond2 != 0 & postCond3 != 0 & postCond4 != 0) {
			report.AddLine("OK! Todas las PostCondiciones de pruebas ejecutadas correctamente");
			System.out.println("OK! Todas las PostCondiciones de pruebas ejecutadas correctamente");
			return true;
		} else {
			report.AddLine("Error en PostCondiciones!! Query 1: " + postCond1 + " / Query 2: " + postCond2 + " / Query 3: " + postCond1 + " / Query 4: " + postCond4);
			System.out.println("Error en PostCondiciones!! Query 1: " + postCond1 + " / Query 2: " + postCond2 + " / Query 3: " + postCond1 + " / Query 4: " + postCond4);
			return false;
		}
	}
}
