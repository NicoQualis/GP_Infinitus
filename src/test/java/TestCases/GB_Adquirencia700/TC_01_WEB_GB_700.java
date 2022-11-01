package TestCases.GB_Adquirencia700;

import org.openqa.selenium.WebDriver;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Pasos.Generales.Acceso;
import Repositories.Repo_Variables;
import Repositories.Repo_WebRepository;
import io.restassured.path.json.JsonPath;

public class TC_01_WEB_GB_700 {

    WebDriver driver;

    public boolean Test(Datasources data, Reports report, DriverManager DM, int iteration, String name, String configEntidad) {
        //Variables
    	String user;
    	String pass;
    	String URL;
    	
    	//validation
        boolean result = true;
        
        try {

        	//SEPARADOR
            System.out.println("\r\n##################################################################################################################################################################################################################"
                    + "##################################################################################################################################################################################################################\r\n");
            
            System.out.println("Configuring TC_01_WEB_GB_AR\r\n");
            
            //SELECT THE DRIVER AND PATH
            driver = DM.CreateDriver(DM.CHROME);
            report.SetDriver(driver);

            //SET THE REPOSITORIES TO USE
            Repo_WebRepository repo = new Repo_WebRepository();
            repo.setDriver(driver);

            //SET STEPS INSTANCES
            Acceso acceso = new Acceso();

            //SET VARIABLES
            URL = JsonPath.from(configEntidad).getString("GBATCH.url_gbatch");
            user = JsonPath.from(configEntidad).getString("GBATCH.user");
            pass = JsonPath.from(configEntidad).getString("GBATCH.pass");

            System.out.println("------ Initializating test: " + name + " ------\r\n");
            
            //SET THE URL
            driver.get(URL);

            //ADD THE STEPS BELOW
            //LOGIN
            report.AddLine("Acceso a la pagina de Global Online");
            System.out.println("Acceso a la pagina de Global Online\r\n");
            acceso.loginUsernameGB(data, report, DM, iteration, name, repo, user, pass);

            // CERRAMOS LA SESION
            acceso.logoutBA(data, report, DM, iteration, name, repo);

            System.out.println("------ Finished test: " + name + " ------\r\n");

            //SEPARADOR
            System.out.println("##################################################################################################################################################################################################################"
                    + "##################################################################################################################################################################################################################\r\n");

        } catch(Exception e) {
            e.printStackTrace();
            report.AddLineAssertionError(e.getMessage());
            result = false;
        }
        //Try to erase the driver
        try {
            if (driver!=null){
                driver.quit();
            }
        } catch(Exception e2) {
            //return the test result
        }
        return result;
    }

}
