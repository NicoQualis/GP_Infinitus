package Tools;
import static io.restassured.RestAssured.given;

import Repositories.Repo_Variables;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AlphaApi {

	/*	BAERER TOKENS
 This specification describes how to use bearer tokens in HTTP
 requests to access OAuth 2.0 protected resources.  Any party in
 possession of a bearer token (a "bearer") can use it to get access to
 the associated resources (without demonstrating possession of a
 cryptographic key).  To prevent misuse, bearer tokens need to be
 protected from disclosure in storage and in transport.
*/	
	
	public String extractBaererToken() {	

		// VARIABLES
		
		String endPoint = "http://sso.global.globalprocessing.net.ar/auth/realms/GlobalProcessing/protocol/openid-connect/token";
		String baererToken = "";
		String token = "";
		
		// Parametros del "body" en formato "x-www-form-urlencoded"
		
		String grant_type = "password";
		String client_id = "AUTHORIZER";
		String client_secret = "e594b1ec-2d16-40d2-9a87-a52be97446b8";
		String username = "autorizador";
		String password = "GlobalProc";
		
		// Extraccion del token con RestAssured
		
		token = RestAssured.given()
				.config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.encodeContentTypeAs("x-www-form-urlencoded",ContentType.URLENC)))
				.log().all() //Loguea el Request
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.formParam("grant_type", grant_type)
				.formParam("client_id", client_id)
				.formParam("client_secret", client_secret)
				.formParam("username",username)
				.formParam("password",password)
				.when()
				.post(endPoint)
				.then()
				.log().all() //Loguea el Response
				.extract()
				.body()
				.asString();
		
		// Armado del string a devolver en 3 partes "baerer KEY" 
		baererToken = JsonPath.from(token).get("token_type") + " " + JsonPath.from(token).get("access_token");
		
		return baererToken;
	}
}
