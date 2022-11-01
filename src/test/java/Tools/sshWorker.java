package Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import CentaJava.Core.Reports;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class sshWorker {

	public String sshSendCmd(Reports report, String xmlFileRun, String configEntidad) {
		//Variables
		String privateKey = JsonPath.from(configEntidad).get("OPI_CONFIG.privateKey");
		String user = JsonPath.from(configEntidad).get("OPI_CONFIG.user");
		String host = JsonPath.from(configEntidad).get("OPI_CONFIG.host");
		int port = Integer.valueOf(JsonPath.from(configEntidad).get("OPI_CONFIG.port"));
		String result = "FAIL";

		try {
			//			//PreCondicion
			//			if (!getOpiStatus(configEntidad)) {
			//				report.AddLine("Se inicializa OPI");
			//				System.out.println("Se inicializa OPI");
			//				startOpiCmd(report,configEntidad);
			//			}

			//Instancias
			JSch jsch = new JSch();

			Session session = jsch.getSession(user, host, port);
			report.AddLine("Creating Session...");
			System.out.println("Creating Session...");

			jsch.addIdentity(privateKey);

			session.setConfig("StrictHostKeyChecking", "no");
			session.connect(2000);
			String variable = "";
			report.AddLine("Session connected" + variable);
			System.out.println("Session connected");

			Channel channel = session.openChannel("shell");
			report.AddLine("Opening Channel... ");
			System.out.println("Opening Channel... ");

			OutputStream inputstream_for_the_channel = channel.getOutputStream();
			PrintStream commander = new PrintStream(inputstream_for_the_channel, true);

			channel.setOutputStream(null);
			channel.connect(2000);
			report.AddLine("Channel connected");
			System.out.println("Channel connected");

			//shell script
			commander.println("cd /home/opi4qa/testClient");
			commander.println("pwd");
			commander.println("./tc-acq.sh " + xmlFileRun);
			commander.println("exit");
			commander.flush();

			System.out.println("" + channel.getExitStatus());

			InputStream outputstream_from_the_channel = channel.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(outputstream_from_the_channel));
			String line = null;
			StringBuilder sb = new StringBuilder();
			//boolean isloginStringPassed = false ;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
				if (line.contains("field id=\"39\"")) {
					result = line.split("=")[2].replace("\"", "").replace("/>","");
				}

				//Pasar line a un metodo para evaluar si tiene lo que busco
			}
			System.out.println("Console reslut:\r\n" + sb.toString());

			channel.disconnect();
			session.disconnect();

			report.AddLine("Completed");
			System.out.println("Completed");

		} catch (JSchException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	public String sshSendCmd(Reports report, String xmlFileRun, String configEntidad, String home) {
		//Variables
		String privateKey = JsonPath.from(configEntidad).get("OPI_CONFIG.privateKey");
		String user = JsonPath.from(configEntidad).get("OPI_CONFIG.user");
		String host = JsonPath.from(configEntidad).get("OPI_CONFIG.host");
		int port = Integer.valueOf(JsonPath.from(configEntidad).get("OPI_CONFIG.port"));
		String result = "FAIL";

		try {
			//PreCondicion
			//			if (!getOpiStatus(configEntidad)) {
			//				report.AddLine("Se inicializa OPI");
			//				System.out.println("Se inicializa OPI");
			//				startOpiCmd(report,configEntidad);
			//			}

			//Instancias
			JSch jsch = new JSch();

			Session session = jsch.getSession(user, host, port);
			report.AddLine("Creating Session...");
			System.out.println("Creating Session...");

			jsch.addIdentity(privateKey);

			session.setConfig("StrictHostKeyChecking", "no");
			session.connect(2000);
			String variable = "";
			report.AddLine("Session connected" + variable);
			System.out.println("Session connected");

			Channel channel = session.openChannel("shell");
			report.AddLine("Opening Channel... ");
			System.out.println("Opening Channel... ");

			OutputStream inputstream_for_the_channel = channel.getOutputStream();
			PrintStream commander = new PrintStream(inputstream_for_the_channel, true);

			channel.setOutputStream(null);
			channel.connect(2000);
			report.AddLine("Channel connected");
			System.out.println("Channel connected");

			//shell script
			commander.println("cd /home/" + home + "/testClient");
			commander.println("pwd");
			commander.println("./tc-acq.sh " + xmlFileRun);
			commander.println("exit");
			commander.flush();

			System.out.println("" + channel.getExitStatus());

			InputStream outputstream_from_the_channel = channel.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(outputstream_from_the_channel));
			String line = null;
			StringBuilder sb = new StringBuilder();
			//boolean isloginStringPassed = false ;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
				if (line.contains("field id=\"39\"")) {
					result = line.split("=")[2].replace("\"", "").replace("/>","");
				}

				//Pasar line a un metodo para evaluar si tiene lo que busco
			}
			System.out.println("Console reslut:\r\n" + sb.toString());

			channel.disconnect();
			session.disconnect();

			report.AddLine("Completed");
			System.out.println("Completed");

		} catch (JSchException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	public String[] sshSendCmdGetDE37(Reports report, String xmlFileRun, String configEntidad, String home) {
		//Variables
		String privateKey = JsonPath.from(configEntidad).get("OPI_CONFIG.privateKey");
		String user = JsonPath.from(configEntidad).get("OPI_CONFIG.user");
		String host = JsonPath.from(configEntidad).get("OPI_CONFIG.host");
		int port = Integer.valueOf(JsonPath.from(configEntidad).get("OPI_CONFIG.port"));
		String[] result = new String[2];

		//Inicialización de variables
		result[0] = "FAIL";

		try {
			//PreCondicion
			/*
			if (!getOpiStatus(configEntidad)) {
				report.AddLine("Se inicializa OPI");
				System.out.println("Se inicializa OPI");
				startOpiCmd(report,configEntidad);
			}
			 */

			//Instancias
			JSch jsch = new JSch();

			Session session = jsch.getSession(user, host, port);
			report.AddLine("Creating Session...");
			System.out.println("Creating Session...");

			jsch.addIdentity(privateKey);

			session.setConfig("StrictHostKeyChecking", "no");
			session.connect(2000);
			String variable = "";
			report.AddLine("Session connected" + variable);
			System.out.println("Session connected");

			Channel channel = session.openChannel("shell");
			report.AddLine("Opening Channel... ");
			System.out.println("Opening Channel... ");

			OutputStream inputstream_for_the_channel = channel.getOutputStream();
			PrintStream commander = new PrintStream(inputstream_for_the_channel, true);

			channel.setOutputStream(null);
			channel.connect(2000);
			report.AddLine("Channel connected");
			System.out.println("Channel connected");

			//shell script
			commander.println("cd /home/" + home + "/testClient");
			commander.println("pwd");
			commander.println("./tc-acq.sh " + xmlFileRun);
			commander.println("exit");
			commander.flush();

			System.out.println("" + channel.getExitStatus());

			InputStream outputstream_from_the_channel = channel.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(outputstream_from_the_channel));
			String line = null;
			StringBuilder sb = new StringBuilder();
			//boolean isloginStringPassed = false ;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
				//FIELD 37
				if (line.contains("field id=\"37\"")) {
					result[1] = line.split("=")[2].replace("\"", "").replace("/>","");
				}
				//FIELD 39
				if (line.contains("field id=\"39\"")) {
					result[0] = line.split("=")[2].replace("\"", "").replace("/>","");
				}

				//Pasar line a un metodo para evaluar si tiene lo que busco
			}
			System.out.println("Console reslut:\r\n" + sb.toString());

			channel.disconnect();
			session.disconnect();

			report.AddLine("Completed");
			System.out.println("Completed");

		} catch (JSchException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	public String[] sshPreCondi(Reports report, String xmlFileRun, String configEntidad, String home) {
		//Variables
		String privateKey = JsonPath.from(configEntidad).get("OPI_CONFIG.privateKey");
		String user = JsonPath.from(configEntidad).get("OPI_CONFIG.user");
		String host = JsonPath.from(configEntidad).get("OPI_CONFIG.host");
		int port = Integer.valueOf(JsonPath.from(configEntidad).get("OPI_CONFIG.port"));
		String[] result = new String[3];

		//Inicialización de variables
		result[0] = "FAIL";
		//Instancias
		JSch jsch = new JSch();

		try {
			//PreCondicion
			/*
			if (!getOpiStatus(configEntidad)) {
				report.AddLine("Se inicializa OPI");
				System.out.println("Se inicializa OPI");
				startOpiCmd(report,configEntidad);
			}
			 */
			for (int i=1; i<4; i++) {

				stopOpiCmd(report, configEntidad, "opi4qa");
				Thread.sleep(2000);
				startOpiCmd(report, configEntidad, "opi4qa");
				Thread.sleep(2000);
				getOpiStatus(configEntidad);

				Session session = jsch.getSession(user, host, port);
				report.AddLine("Creating Session...");
				System.out.println("Creating Session...");

				jsch.addIdentity(privateKey);

				session.setConfig("StrictHostKeyChecking", "no");
				session.connect(2000);
				String variable = "";
				report.AddLine("Session connected" + variable);
				System.out.println("Session connected");

				Channel channel = session.openChannel("shell");
				report.AddLine("Opening Channel... ");
				System.out.println("Opening Channel... ");

				OutputStream inputstream_for_the_channel = channel.getOutputStream();
				PrintStream commander = new PrintStream(inputstream_for_the_channel, true);

				channel.setOutputStream(null);
				channel.connect(2000);
				report.AddLine("Channel connected");
				System.out.println("Channel connected");

				//shell script
				commander.println("cd /home/" + home + "/testClient");
				commander.println("pwd");

				commander.println("./tc-acq.sh " + xmlFileRun);

				commander.println("exit");
				commander.flush();

				System.out.println("" + channel.getExitStatus());

				InputStream outputstream_from_the_channel = channel.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(outputstream_from_the_channel));
				String line = null;
				StringBuilder sb = new StringBuilder();
				//boolean isloginStringPassed = false ;

				while ((line = br.readLine()) != null) {
					sb.append(line + "\n");
					//FIELD 37
					if (line.contains("field id=\"37\"")) {
						result[1] = line.split("=")[2].replace("\"", "").replace("/>","");
					}
					//FIELD 38
					if (line.contains("field id=\"38\"")) {
						result[2] = line.split("=")[2].replace("\"", "").replace("/>","");
					}
					//FIELD 39
					if (line.contains("field id=\"39\"")) {
						result[0] = line.split("=")[2].replace("\"", "").replace("/>","");
					}

					//Pasar line a un metodo para evaluar si tiene lo que busco
				}
				System.out.println("Console reslut:\r\n" + sb.toString());

				channel.disconnect();
				session.disconnect();
				if(!result[0].equals("91")) 
					break;
			}

			report.AddLine("Completed");
			System.out.println("Completed");

		} catch (JSchException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	public void sshSendCmdCreateXml(Reports report, String createXmlFile, String configEntidad, String home, String xmlTcFile) {
		//Variables
		String privateKey = JsonPath.from(configEntidad).get("OPI_CONFIG.privateKey");
		String user = JsonPath.from(configEntidad).get("OPI_CONFIG.user");
		String host = JsonPath.from(configEntidad).get("OPI_CONFIG.host");
		int port = Integer.valueOf(JsonPath.from(configEntidad).get("OPI_CONFIG.port"));

		//Inicialización de variables

		try {
			//Instancias
			JSch jsch = new JSch();

			Session session = jsch.getSession(user, host, port);
			report.AddLine("Creating Session...");
			System.out.println("Creating Session...");

			jsch.addIdentity(privateKey);

			session.setConfig("StrictHostKeyChecking", "no");
			session.connect(2000);
			String variable = "";
			report.AddLine("Session connected" + variable);
			System.out.println("Session connected");

			Channel channel = session.openChannel("shell");
			report.AddLine("Opening Channel... ");
			System.out.println("Opening Channel... ");

			OutputStream inputstream_for_the_channel = channel.getOutputStream();
			PrintStream commander = new PrintStream(inputstream_for_the_channel, true);

			channel.setOutputStream(null);
			channel.connect(2000);
			report.AddLine("Channel connected");
			System.out.println("Channel connected");

			//shell script
			//Se copia el string al archivo temporal xmlBaseTemp.xml 
			commander.println("cd /home/" + home + "/testClient");
			commander.println("pwd");
			commander.println("cat > xmlBaseAux.xml << EOL");
			commander.println(createXmlFile);
			commander.println("EOL");
			//Se quitan los espacios en blanco (x windows) y se envía el resultado al archivo final xmlBase.xml
			//			commander.println("sed '/^[[:space:]]*$/d' xmlBaseAux.xml > " + xmlTcFile);
			commander.println("sudo cp xmlBaseAux.xml " + xmlTcFile);
			commander.println("exit");
			commander.flush();

			System.out.println("" + channel.getExitStatus());

			InputStream outputstream_from_the_channel = channel.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(outputstream_from_the_channel));
			String line = null;
			StringBuilder sb = new StringBuilder();

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}

			System.out.println("Console reslut:\r\n" + sb.toString());

			channel.disconnect();
			session.disconnect();

			report.AddLine("Completed");
			System.out.println("Completed");

		} catch (JSchException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void startOpiCmd(Reports report, String configEntidad, String home) {
		//Variables
		String privateKey = JsonPath.from(configEntidad).get("OPI_CONFIG.privateKey");
		String user = JsonPath.from(configEntidad).get("OPI_CONFIG.user");
		String host = JsonPath.from(configEntidad).get("OPI_CONFIG.host");
		int port = Integer.valueOf(JsonPath.from(configEntidad).get("OPI_CONFIG.port"));

		try {
			//Instancias
			JSch jsch = new JSch();

			Session session = jsch.getSession(user, host, port);
			report.AddLine("Creating Session...");
			System.out.println("Creating Session...");

			jsch.addIdentity(privateKey);

			session.setConfig("StrictHostKeyChecking", "no");
			session.connect(2000);
			String variable = "";
			report.AddLine("Session connected" + variable);
			System.out.println("Session connected");

			Channel channel = session.openChannel("shell");
			report.AddLine("Opening Channel... ");
			System.out.println("Opening Channel... ");

			OutputStream inputstream_for_the_channel = channel.getOutputStream();
			PrintStream commander = new PrintStream(inputstream_for_the_channel, true);

			channel.setOutputStream(null);
			channel.connect(2000);
			report.AddLine("Channel connected");
			System.out.println("Channel connected");

			//shell script
			commander.println("cd /home/" + home + "/opi-switch");
			commander.println("pwd");
			commander.println("./start.sh ");
			commander.println("exit");
			commander.flush();

			System.out.println("" + channel.getExitStatus());

			InputStream outputstream_from_the_channel = channel.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(outputstream_from_the_channel));
			String line = null;
			StringBuilder sb = new StringBuilder();
			//boolean isloginStringPassed = false ;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println("Console reslut:\r\n" + sb.toString());

			channel.disconnect();
			session.disconnect();

			report.AddLine("Completed");
			System.out.println("Completed");

		} catch (JSchException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void stopOpiCmd(Reports report, String configEntidad, String home) {
		//Variables
		String privateKey = JsonPath.from(configEntidad).get("OPI_CONFIG.privateKey");
		String user = JsonPath.from(configEntidad).get("OPI_CONFIG.user");
		String host = JsonPath.from(configEntidad).get("OPI_CONFIG.host");
		int port = Integer.valueOf(JsonPath.from(configEntidad).get("OPI_CONFIG.port"));

		try {
			//Instancias
			JSch jsch = new JSch();

			Session session = jsch.getSession(user, host, port);
			report.AddLine("Creating Session...");
			System.out.println("Creating Session...");

			jsch.addIdentity(privateKey);

			session.setConfig("StrictHostKeyChecking", "no");
			session.connect(2000);
			String variable = "";
			report.AddLine("Session connected" + variable);
			System.out.println("Session connected");

			Channel channel = session.openChannel("shell");
			report.AddLine("Opening Channel... ");
			System.out.println("Opening Channel... ");

			OutputStream inputstream_for_the_channel = channel.getOutputStream();
			PrintStream commander = new PrintStream(inputstream_for_the_channel, true);

			channel.setOutputStream(null);
			channel.connect(2000);
			report.AddLine("Channel connected");
			System.out.println("Channel connected");

			//shell script
			commander.println("cd /home/" + home + "/opi-switch");
			commander.println("pwd");
			commander.println("./stop.sh ");
			commander.println("exit");
			commander.flush();

			System.out.println("" + channel.getExitStatus());

			InputStream outputstream_from_the_channel = channel.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(outputstream_from_the_channel));
			String line = null;
			StringBuilder sb = new StringBuilder();
			//boolean isloginStringPassed = false ;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println("Console reslut:\r\n" + sb.toString());

			channel.disconnect();
			session.disconnect();

			report.AddLine("Completed");
			System.out.println("Completed");

		} catch (JSchException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean getOpiStatus(String configEntidad) {
		//Variables
		String privateKey = JsonPath.from(configEntidad).get("OPI_CONFIG.privateKey");
		String user = JsonPath.from(configEntidad).get("OPI_CONFIG.user");
		String host = JsonPath.from(configEntidad).get("OPI_CONFIG.host");
		int port = Integer.valueOf(JsonPath.from(configEntidad).get("OPI_CONFIG.port"));
		boolean result = false;

		try {			
			//Instancias
			JSch jsch = new JSch();

			Session session = jsch.getSession(user, host, port);
			System.out.println("Creating Session...");

			jsch.addIdentity(privateKey);

			session.setConfig("StrictHostKeyChecking", "no");
			session.connect(2000);
			System.out.println("Session connected");

			Channel channel = session.openChannel("shell");
			System.out.println("Opening Channel... ");

			OutputStream inputstream_for_the_channel = channel.getOutputStream();
			PrintStream commander = new PrintStream(inputstream_for_the_channel, true);

			channel.setOutputStream(null);
			channel.connect(2000);
			System.out.println("Channel connected");

			//shell script
			commander.println("cd /home/opi4qa/opi-switch");
			commander.println("./status.sh");
			commander.println("exit");
			commander.flush();

			System.out.println(channel.getExitStatus());

			InputStream outputstream_from_the_channel = channel.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(outputstream_from_the_channel));
			String line = null;
			StringBuilder sb = new StringBuilder();
			//boolean isloginStringPassed = false;

			while ((line = br.readLine()) != null) {
				sb.append(line.trim() + "\n");
				if (line.contains("is running.")) {
					System.out.println("OPI en Ejecucion");
					result = true;
				}
			}

			System.out.println("Console Result:\r\n" + sb.toString());

			channel.disconnect();
			session.disconnect();

			System.out.println("Completed");

		} catch (JSchException ex) {
			ex.printStackTrace();
			Assert.assertFalse("Error:\r\n" + ex, true);
		} catch (IOException ex) {
			ex.printStackTrace();
			Assert.assertFalse("Error:\r\n" + ex, true);
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.assertFalse("Error:\r\n" + ex, true);
		}

		return result;
	}

	/*Método para realizar el cambio de simulador. Se recibe la 'entidad' (700 o 701), 
	y la 'operacion' que se va a realizar con el cambio('compras' o 'reversos')*/	
	public void cambioSimuladorVisa(Reports report, String configEntidad, String home ,String entidad, String operacion) {
		//Variables
		String privateKey = JsonPath.from(configEntidad).get("OPI_CONFIG.privateKey");
		String user = JsonPath.from(configEntidad).get("OPI_CONFIG.user");
		String host = JsonPath.from(configEntidad).get("OPI_CONFIG.host");
		int port = Integer.valueOf(JsonPath.from(configEntidad).get("OPI_CONFIG.port"));

		try {
			//Instancias
			JSch jsch = new JSch();

			Session session = jsch.getSession(user, host, port);
			report.AddLine("Creating Session...");
			System.out.println("Creating Session...");

			jsch.addIdentity(privateKey);

			session.setConfig("StrictHostKeyChecking", "no");
			session.connect(2000);
			String variable = "";
			report.AddLine("Session connected" + variable);
			System.out.println("Session connected");

			Channel channel = session.openChannel("shell");
			report.AddLine("Opening Channel... ");
			System.out.println("Opening Channel... ");

			OutputStream inputstream_for_the_channel = channel.getOutputStream();
			PrintStream commander = new PrintStream(inputstream_for_the_channel, true);

			channel.setOutputStream(null);
			channel.connect(2000);
			report.AddLine("Channel connected");
			System.out.println("Channel connected");

			//shell script
			commander.println("cd /home/" + home + "/opi-switch");
			commander.println("pwd");
			commander.println("sudo cp opi-switch-"+entidad+"-"+operacion+".cfg opi-switch.cfg");
			commander.println("exit");
			commander.flush();
			System.out.println("" + channel.getExitStatus());

			InputStream outputstream_from_the_channel = channel.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(outputstream_from_the_channel));
			String line = null;
			StringBuilder sb = new StringBuilder();
			//boolean isloginStringPassed = false ;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println("Console reslut:\r\n" + sb.toString());

			channel.disconnect();
			session.disconnect();

			report.AddLine("Completed");
			System.out.println("Completed");

		} catch (JSchException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	
}