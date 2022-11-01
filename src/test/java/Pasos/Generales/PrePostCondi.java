package Pasos.Generales;

import CentaJava.Core.Reports;

public class PrePostCondi {
	
	//Metodos para utilizar color en la consola
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";

	public void validaRollBackUpdate(Reports report, int rta) {
		if (rta != 0) {
			report.AddLine("Roll Back realizado, se actualizo el registro correctamente");
			System.out.println(ANSI_GREEN + "Roll Back realizado, se actualizo el registro correctamente\r\n" + ANSI_RESET);
		} else {
			report.AddLineAssertionError("Roll Back fallido, realizar la actualizacion manualmente");
			System.out.println("Roll Back fallido, realizar la actualizacion manualmente\r\n");
		}
	}
		
	public void validaRollBackUpdate(Reports report, int rta, String resp, String valor) {
		if (rta != 0) {
			report.AddLine("Roll Back realizado, se actualizo el registro correctamente");
			System.out.println(ANSI_GREEN + "Roll Back realizado, se actualizo el registro correctamente\r\n" + ANSI_RESET);
		} else {
			report.AddLineAssertionError("Roll Back fallido, realizar la actualizacion manualmente");
			System.out.println("Roll Back fallido, realizar la actualizacion manualmente\r\n");
		}

		if (rta != 0 && !resp.equals(valor)) {
			report.AddLineAssertionError("Error, realizar la actualizacion manualmente");
			System.out.println("Error, realizar la actualizacion manualmente\r\n");
		}	
	}

	public void validaRollBackDelete(Reports report, int rta) {
		if (rta != 0) {
			report.AddLine("Roll Back realizado, se elimino el registro correctamente");
			System.out.println(ANSI_GREEN + "Roll Back realizado, se elimino el registro correctamente\r\n" + ANSI_RESET);
		} else {
			report.AddLineAssertionError("Roll Back fallido, realizar la eliminacion manualmente");
			System.out.println("Roll Back fallido, realizar la eliminacion manualmente\r\n");
		}
	}
	
	public void validaRollBackDelete(Reports report, int rta, String resp) {
		if (rta != 0) {
			report.AddLine("Roll Back realizado, se elimino el registro correctamente");
			System.out.println(ANSI_GREEN + "Roll Back realizado, se elimino el registro correctamente\r\n" + ANSI_RESET);
		} else {
			report.AddLineAssertionError("Roll Back fallido, realizar la eliminacion manualmente");
			System.out.println("Roll Back fallido, realizar la eliminacion manualmente\r\n");
		}

		if (rta != 0 && !resp.equals("")) {
			report.AddLineAssertionError("Error, realizar la eliminacion manualmente");
			System.out.println("Error, realizar la eliminacion manualmente");
		}	
	}

	public void validaRollBackDelete(Reports report, int rta1, int rta2, String resp) {
		if (rta1 != 0 && rta2 != 0) {
			report.AddLine("Roll Back realizado, se eliminaron los registros correctamente");
			System.out.println(ANSI_GREEN + "Roll Back realizado, se eliminaron los registros correctamente\r\n" + ANSI_RESET);
		} else {
			report.AddLineAssertionError("Roll Back fallido, realizar la eliminacion manualmente");
			System.out.println("Roll Back fallido, realizar la eliminacion manualmente\r\n");
		}

		if (rta1 != 0 && rta2 != 0 && !resp.equals("")) {
			report.AddLineAssertionError("Error, realizar la eliminacion manualmente");
			System.out.println("Error, realizar la eliminacion manualmente\r\n");
		}	
	}

	public void rollBackBorrarId (Reports report, String dni, String idCuenta, boolean res) {
		if(res) {
			report.AddLine("Eliminacion de los datos exitosa");
			System.out.println(ANSI_GREEN + "Eliminacion de los datos exitosa\r\n" + ANSI_RESET);
		} else {
			report.AddLineAssertionError("Error al eliminar la cuenta; realizar su eliminacion manual");
			report.AddLineAssertionError("Datos para eliminacion manual:<br>ID de CUENTA: " + idCuenta + "<br>DOCUMENTO: " + dni);
			System.out.println("Error al eliminar la cuenta; realizar su eliminacion manual\r\n");
			System.out.println("Datos para eliminacion manual:\r\nID de CUENTA: " + idCuenta + "\r\nDOCUMENTO: " + dni + "\r\n");
		}
	}
	
	public void preCondicionBD (Reports report, int rta) {
		if (rta != 0) {
			report.AddLine("--- PreCondicion ejecutada correctamente ---");
			System.out.println(ANSI_GREEN + "--- PreCondicion ejecutada correctamente ---\r\n" + ANSI_RESET);
		} else  {
			report.AddLine("--- Error al ejecutar precondicion ---");
			System.out.println("--- Error al ejecutar precondicion ---\r\n");
		} 
	}
	
	public void preCondicionBD (Reports report, String rta) {
		if (rta.equals("")) {
			report.AddLine("--- Error al ejecutar precondicion ---");
			System.out.println("--- Error al ejecutar precondicion ---\r\n");
		} else {
			report.AddLine("--- PreCondicion ejecutada correctamente ---");
			System.out.println(ANSI_GREEN + "--- PreCondicion ejecutada correctamente ---\r\n" + ANSI_RESET);
		}
	}
	
	public void postCondicionBD (Reports report, int rta) {
		if (rta != 0) {
			report.AddLine("--- PostCondicion ejecutada correctamente ---");
			System.out.println(ANSI_GREEN + "--- PostCondicion ejecutada correctamente ---\r\n" + ANSI_RESET);
		}
		else {
			report.AddLineAssertionError("Error: Fallo la PostCondicion");
			System.out.println("Error: Fallo la PostCondicion\r\n");
		}
	}
	
	public void compWebConBD (Reports report, int rta, int valorWeb) {
		
		if (valorWeb == rta) {
			report.AddLine("Los valores mostrados en la web("+ valorWeb +") coiciden con los de la BDD("+ rta +").");
			System.out.println("Los valores mostrados en la web("+ valorWeb +") coiciden con los de la BDD("+ rta +").");
		} else {
			report.AddLineAssertionError("Error!! Los valores mostrados en la web("+ valorWeb +") no coiciden con los de la BDD("+ rta +").");
			System.out.println("Error!! Los valores mostrados en la web("+ valorWeb +") no coiciden con los de la BDD("+ rta +").");
		}
	}
}
