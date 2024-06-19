package baseDdatos;

import gui.VinicioSesion;
import java.sql.Connection;
import java.sql.DriverManager;

public class Enlace {
	public static Connection getEnlace(){
            System.getenv();
		Connection cn = null;
		try {
			//Adjunta el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Success Driver");
			//Inicia el Enlace
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_institutopluton", "root", "DM12345**");
			System.out.println("Success Connection");
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return cn;
	}
	public static void main(String[]args){
		getEnlace();
                VinicioSesion frame = new VinicioSesion();
                frame.setVisible(true);
                
	}
}
