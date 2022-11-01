package Tools;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Repositories.Repo_Variables;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class apiWorker {
		
	public String GetAccessTokenPP() {	
		//Base Configuration
		//RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

		//Variables
		String endPoint = "http://sso.global.globalprocessing.net.ar/auth/realms/GlobalProcessing/protocol/openid-connect/token";
		
		System.out.println("Iniciando restAssured"); 
		
		String token = RestAssured.given()
				.config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.encodeContentTypeAs("x-www-form-urlencoded",ContentType.URLENC)))
				.log().all() //Loguea el Request
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.formParam("grant_type", "password")
				.formParam("client_id", "AUTHORIZER")
				.formParam("client_secret", "e594b1ec-2d16-40d2-9a87-a52be97446b8")
				.formParam("username","autorizador")
				.formParam("password","GlobalProc")
				.when()
				.post(endPoint)
				.then()
				.log().all() //Loguea el Response
				.extract()
				.body()
				.asString();

		return JsonPath.from(token).get("token_type") + " " + JsonPath.from(token).get("access_token");
	}
	
	public String GetAccessTokenAI(String endPointToken, String enviroment) throws IOException {
		String fileToken = "./API_Request/Token/Prepagas_QA.json";
		String bodyToken = new String(Files.readAllBytes(Paths.get(fileToken)));	
		String grant_type = JsonPath.from(bodyToken).get("grant_type");
		String client_id = JsonPath.from(enviroment).get("Cliente");
		String client_secret = JsonPath.from(bodyToken).get("client_secret");
		String scope = JsonPath.from(bodyToken).get("scope");
		
		System.out.println("Iniciando restAssured"); 
		String token = RestAssured.given()
				.config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.encodeContentTypeAs("x-www-form-urlencoded",ContentType.URLENC)))
				.log().all() //Loguea el Request
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.formParam("grant_type", grant_type)
				.formParam("client_id", client_id)
				.formParam("client_secret", client_secret)
				.formParam("scope", scope)
				.when()
				.post(endPointToken)
				.then()
				.log().all() //Loguea el Response
				.extract()
				.body()
				.asString();

		return JsonPath.from(token).get("access_token");
	}

	public Response postMethod(Repo_Variables repoVar, String basePath, String endPoint, String bodyData, String token, String enviroment) throws Exception {
		
		String requestId = JsonPath.from(enviroment).get("RequestId");
		//Base Configuration
		RestAssured.baseURI = repoVar.getBaseUri();
		RestAssured.basePath = basePath;
		
		System.out.println("Iniciando restAssured"); 
		
		return given()
				.log().all()
				.relaxedHTTPSValidation()
				.header("Authorization", "bearer " + token)
				.header("Content-Type","application/json")
				.header("RequestId", requestId)
				.body(bodyData)
				.post(endPoint)
				.then()
				.log().all()
				.extract()
				.response();
	}

	public Response getMethod(Repo_Variables repoVar, String basePath, String endPoint, String token) {
		//Base Configuration
		//RestAssured.baseURI = repoVar.getBaseUri();
		//RestAssured.basePath = basePath;

		System.out.println("Iniciando restAssured"); 
		
		return given()
				.log().all()
				.relaxedHTTPSValidation()
				.header("Authorization",token)
				.header("Content-Type","application/json")
				.get(endPoint)
				.then()
				.log().all()
				.extract()
				.response();
	}

	public Response getMethod(Repo_Variables repoVar, String basePath, String endPoint, String body, String token) {
		//Base Configuration
		RestAssured.baseURI = repoVar.getBaseUri();
		RestAssured.basePath = basePath;

		System.out.println("Iniciando restAssured"); 
		
		return given()
				.log().all()
				.relaxedHTTPSValidation()
				.header("Authorization",token)
				.header("Content-Type","application/json")
				.body(body)
				.get(endPoint)
				.then()
				.log().all()
				.extract()
				.response();
	}

	public Response putMethod(Repo_Variables repoVar, String basePath, String endPoint, String token) {
		//Base Configuration
		RestAssured.baseURI = repoVar.getBaseUri();
		RestAssured.basePath = basePath;

		System.out.println("Iniciando restAssured"); 
		
		return given()
				.log().all()
				.relaxedHTTPSValidation()
				.header("Authorization",token)
				.header("Content-Type","application/json")
				.when()
				.put(endPoint)
				.then()
				.log().all()
				.extract()
				.response();
	}

	public Response putMethod(Repo_Variables repoVar, String basePath, String endPoint, String body, String token) {
		//Base Configuration
		RestAssured.baseURI = repoVar.getBaseUri();
		RestAssured.basePath = basePath;

		System.out.println("Iniciando restAssured"); 
		
		return given()
				.log().all()
				.relaxedHTTPSValidation()
				.header("Authorization",token)
				.header("Content-Type","application/json")
				.body(body)
				.put(endPoint)
				.then()
				.log().all()
				.extract()
				.response();
	}

}
