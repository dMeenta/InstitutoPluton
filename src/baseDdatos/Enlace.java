package baseDdatos;

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
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_proyectoG5", "root", "");
			System.out.println("Success Connection");
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return cn;
	}
	public static void main(String[]args){
		getEnlace();
	}
}
