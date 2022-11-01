package Pasos.Generales;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_WebRepository;
import io.restassured.path.json.JsonPath;

 
public class Acceso {
	WebDriver driver;
	
	public void loginAdquirenciaAR(Datasources data, Reports report, DriverManager DM, int iteration, String name, Repo_WebRepository repo, String configEntidad) {
		
		// PALEATIVO AL CERTIFICADO SSL, AGREGAR EN CENTA ADD_ARGUMENT EL CHROMEOPTIONS()
		DM.getActualDriver().findElement(By.xpath("//button[@id='details-button']")).click();
		DM.getActualDriver().findElement(By.xpath("//a[@id='proceed-link']")).click();
		
		String user = JsonPath.from(configEntidad).getString("GO.user");
		String pass = JsonPath.from(configEntidad).getString("GO.pass");
		
		//ADD THE STEPS BELOW
		report.AddLine("Se ingresa el username: " + user);
		System.out.println("Se ingresa el username: " + user + "\r\n");
		repo.get_obj_inputUsername().sendKeys(user);
		
		report.AddLine("Se ingresa el password");
		System.out.println("Se ingresa el password\r\n");
		repo.get_obj_inputPassword().sendKeys(pass);
		
		report.Screenshot(name);
		
		report.AddLine("Se hace click en el boton Log in");
		System.out.println("Se hace click en el boton Log in\r\n");
		repo.get_obj_btnLogin().click();
		
		//ADD VALIDATIONS AT THE END
		// ESPERAMOS A QUE CARGUE UN ELEMENTO DEL MENU PARA VALIDAR EL INGRESO
		System.out.println("Esperamos que la pagina se cargue\r\n");
		WebDriverWait waitFor = new WebDriverWait(DM.getActualDriver(), 15);
		waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo.get_def_sideBarItem1("Adquirencia")[1])));
		
		report.AddLine("Screenshoot de pagina cargada correctamente");
		System.out.println("Screenshoot de pagina cargada correctamente\r\n");
		report.Screenshot(name);

	}
	
	public void loginAdquirenciaUY(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo) {
		
		// PALEATIVO AL CERTIFICADO SSL, AGREGAR EN CENTA ADD_ARGUMENT EL CHROMEOPTIONS()
		DM.getActualDriver().findElement(By.xpath("//button[@id='details-button']")).click();
		DM.getActualDriver().findElement(By.xpath("//a[@id='proceed-link']")).click();
		
		String user = "admin701";
		String pass = "GlobalProc";
		
		//ADD THE STEPS BELOW
		report.AddLine("Se ingresa el username: " + user);
		System.out.println("Se ingresa el username: " + user + "\r\n");
		repo.get_obj_inputUsername().sendKeys(user);
		
		report.AddLine("Se ingresa el password");
		System.out.println("Se ingresa el password\r\n");
		repo.get_obj_inputPassword().sendKeys(pass);
		
		report.Screenshot(name);
		
		report.AddLine("Se hace click en el boton Log in");
		System.out.println("Se hace click en el boton Log in\r\n");
		repo.get_obj_btnLogin().click();
		
		//ADD VALIDATIONS AT THE END
		// ESPERAMOS A QUE CARGUE UN ELEMENTO DEL MENU PARA VALIDAR EL INGRESO
		System.out.println("Esperamos que la pagina se cargue\r\n");
		WebDriverWait waitFor = new WebDriverWait(DM.getActualDriver(), 15);
		waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo.get_def_sideBarItem1("Adquirencia")[1])));
		
		report.AddLine("Screenshoot de pagina cargada correctamente");
		System.out.println("Screenshoot de pagina cargada correctamente\r\n");
		report.Screenshot(name);

	}
	
	public void login(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo) {
		
		// PALEATIVO AL CERTIFICADO SSL, AGREGAR EN CENTA ADD_ARGUMENT EL CHROMEOPTIONS()
		DM.getActualDriver().findElement(By.xpath("//button[@id='details-button']")).click();
		DM.getActualDriver().findElement(By.xpath("//a[@id='proceed-link']")).click();
		
		String user = "admin700";
		String pass = "GlobalProc";
		
		//ADD THE STEPS BELOW
		report.AddLine("Se ingresa el username: " + user);
		System.out.println("Se ingresa el username: " + user + "\r\n");
		repo.get_obj_inputUsername().sendKeys(user);
		
		report.AddLine("Se ingresa el password");
		System.out.println("Se ingresa el password\r\n");
		repo.get_obj_inputPassword().sendKeys(pass);
		
		report.Screenshot(name);
		
		report.AddLine("Se hace click en el boton Log in");
		System.out.println("Se hace click en el boton Log in\r\n");
		repo.get_obj_btnLogin().click();
		
		//ADD VALIDATIONS AT THE END
		// ESPERAMOS A QUE CARGUE UN ELEMENTO DEL MENU PARA VALIDAR EL INGRESO
		System.out.println("Esperamos que la pagina se cargue\r\n");
		WebDriverWait waitFor = new WebDriverWait(DM.getActualDriver(), 15);
		waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo.get_def_sideBarItem1("Adquirencia")[1])));
		
		report.AddLine("Screenshoot de pagina cargada correctamente");
		System.out.println("Screenshoot de pagina cargada correctamente\r\n");
		report.Screenshot(name);

	}
	
	public void loginUsername(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo, String username, String password) {
		
		// PALEATIVO AL CERTIFICADO SSL ( ADD_ARGUMENT EL CHROMEOPTIONS() )
		System.out.println("Certificado SSL");
		DM.getActualDriver().findElement(By.xpath("//button[@id='details-button']")).click();
		DM.getActualDriver().findElement(By.xpath("//a[@id='proceed-link']")).click();
		
		//ADD THE STEPS BELOW
		report.Screenshot(name);
		
		report.AddLine("Se ingresa el username: " + username);
		System.out.println("Se ingresa el username: " + username + "\r\n");
		repo.get_obj_inputUsername().sendKeys(username);
		
		report.AddLine("Se ingresa el password");
		System.out.println("Se ingresa el password\r\n");
		repo.get_obj_inputPassword().sendKeys(password);
		
		report.AddLine("Se hace click en el boton Log in");
		System.out.println("Se hace click en el boton Log in\r\n");
		repo.get_obj_btnLogin().click();
		
		//ADD VALIDATIONS AT THE END
		// ESPERAMOS A QUE CARGUE UN ELEMENTO DEL MENU PARA VALIDAR EL INGRESO
		
		System.out.println("Esperamos que la pagina se cargue");
		WebDriverWait waitFor = new WebDriverWait(DM.getActualDriver(), 15);
		waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo.get_def_sideBarItem1("Adquirencia")[1])));
		
		report.AddLine("Screenshoot de pagina cargada correctamente");
		System.out.println("Screenshoot de pagina cargada correctamente\r\n");
		report.Screenshot(name);

	}
	
	public void loginUsernameGB(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo, String username, String password) {
		
		// PALEATIVO AL CERTIFICADO SSL ( ADD_ARGUMENT EL CHROMEOPTIONS() )
		System.out.println("Certificado SSL");
		DM.getActualDriver().findElement(By.xpath("//button[@id='details-button']")).click();
		DM.getActualDriver().findElement(By.xpath("//a[@id='proceed-link']")).click();
		
		//ADD THE STEPS BELOW
		report.Screenshot(name);
		
		report.AddLine("Se ingresa el username: " + username);
		System.out.println("Se ingresa el username: " + username + "\r\n");
		repo.get_obj_inputUsername().sendKeys(username);
		
		report.AddLine("Se ingresa el password");
		System.out.println("Se ingresa el password\r\n");
		repo.get_obj_inputPassword().sendKeys(password);
		
		report.AddLine("Se hace click en el boton Log in");
		System.out.println("Se hace click en el boton Log in\r\n");
		repo.get_obj_btnLogin().click();
		
		//ADD VALIDATIONS AT THE END
		//ESPERAMOS A QUE CARGUE UN ELEMENTO DEL MENU PARA VALIDAR EL INGRESO
		
		System.out.println("Esperamos que la pagina se cargue");
		WebDriverWait waitFor = new WebDriverWait(DM.getActualDriver(), 15);
		waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo.get_def_sideBarItem1("Últimos Procesos Terminados")[1])));
		
		report.AddLine("Screenshoot de pagina cargada correctamente");
		System.out.println("Screenshoot de pagina cargada correctamente\r\n");
		report.Screenshot(name);

	}
	
	public void logout(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo) {
		
		//ADD THE STEPS BELOW
		report.AddLine("Se hace click en el boton Salir");
		System.out.println("Se hace click en el boton Salir\r\n");
		repo.get_obj_btnSalir().click();
		
		report.AddLine("Se hace click en el boton ACEPTAR del Modal");
		System.out.println("Se hace click en el boton ACEPTAR del Modal\r\n");
		repo.get_obj_btnAceptarModal().click();
		
		//ADD VALIDATIONS AT THE END
		System.out.println("Esperamos que la pagina se cargue luego de cerrar sesion\r\n");
		WebDriverWait waitFor = new WebDriverWait(DM.getActualDriver(), 15);
		waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo.get_def_h1Login()[1])));
	}
	
public void logOutAdqGO(Datasources data, Reports report, DriverManager DM, int iteration, String name, Repo_WebRepository repo) {
		
		//ADD THE STEPS BELOW
		report.AddLine("Se hace click en el boton Salir");
		System.out.println("Se hace click en el boton Salir\r\n");
		repo.get_obj_btnLogOff().click();
		
		//ADD VALIDATIONS AT THE END
		System.out.println("Esperamos que la pagina se cargue luego de cerrar sesion\r\n");
		WebDriverWait waitFor = new WebDriverWait(DM.getActualDriver(), 15);
		waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo.get_def_h1Login()[1])));
	}

public void logOutAdqGB(Datasources data, Reports report, DriverManager DM, int iteration, String name, Repo_WebRepository repo) {
	
	//ADD THE STEPS BELOW
	report.AddLine("Se hace click en el boton Salir");
	System.out.println("Se hace click en el boton Salir\r\n");
	repo.get_obj_btnLogOff().click();
	
	//ADD VALIDATIONS AT THE END
	System.out.println("Esperamos que la pagina se cargue luego de cerrar sesion\r\n");
	WebDriverWait waitFor = new WebDriverWait(DM.getActualDriver(), 15);
	waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo.get_def_TitleLogin()[1])));
}
	
	public void loginUsernameBA(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo, String username, String password) throws InterruptedException {
		
		// PALEATIVO AL CERTIFICADO SSL ( ADD_ARGUMENT EL CHROMEOPTIONS() )
		report.AddLine("Certificado SSL");
		System.out.println("Certificado SSL\r\n");
		DM.getActualDriver().findElement(By.xpath("//button[@id='details-button']")).click();
		DM.getActualDriver().findElement(By.xpath("//a[@id='proceed-link']")).click();
		
		//ADD THE STEPS BELOW
		Thread.sleep(500);
		report.Screenshot(name);
		
		report.AddLine("Se ingresa el username: " + username);
		System.out.println("Se ingresa el username: "+ username + "\r\n");
		repo.get_obj_inputUsername().sendKeys(username);
		
		report.AddLine("Se ingresa el password: " + password + "\r\n");
		System.out.println("Se ingresa el password: " + password + "\r\n");
		repo.get_obj_inputPassword().sendKeys(password);
		
		Thread.sleep(200);
		report.Screenshot(name);
		
		report.AddLine("Se hace click en el boton Log in");
		System.out.println("Se hace click en el boton Log in\r\n");
		repo.get_obj_btnLogin().click();
		
		//ADD VALIDATIONS AT THE END
		// ESPERAMOS A QUE CARGUE UN ELEMENTO DEL MENU PARA VALIDAR EL INGRESO
		

		System.out.println("Esperamos que la pagina se cargue\r\n");
		report.AddLine("Esperamos que la pagina se cargue");

		WebDriverWait waitFor = new WebDriverWait(DM.getActualDriver(), 15);
		waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo.get_def_navBarLink("/")[1])));
		
		report.AddLine("Screenshoot de pagina cargada correctamente");
		System.out.println("Screenshoot de pagina cargada correctamente\r\n");
		Thread.sleep(300);
		report.Screenshot(name);

	}
	
	public void logoutBA(Datasources data,Reports report, DriverManager DM, int iteration,String name,Repo_WebRepository repo) {
		
		//ADD THE STEPS BELOW
		report.AddLine("Se hace click en el boton LogOff");
		System.out.println("Se hace click en el boton LogOff\r\n");
		repo.get_obj_logOut().click();
		
	}
	
}