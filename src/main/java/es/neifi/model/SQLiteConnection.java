package es.neifi.model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteConnection {
	
	private final static String URL ="jdbc:sqlite:C:\\Users\\Neifi\\git\\App_Gestion\\Appgestion\\database\\building.db";
	private static Connection connection;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(URL);
			System.out.println("Exito al conectar");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("No se pudo conectar");
			e.printStackTrace();
		}
		return connection;
		
	}
	
	/**
	 * Cierra una conexión especifica
	 * @param conn conexion a cerrar
	 */
	
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
			System.out.println("Conexion cerrada correctamente");
		} catch (SQLException e) {
			System.out.println("No se pudo cerrar la conexión");
			e.printStackTrace();
		}
	}
	
	/**
	 *  Cierra la conexión actual
	 */
	public static void closeConnection() {
		try {
			connection.close();
			System.out.println("Conexion cerrada correctamente");
		} catch (SQLException e) {
			System.out.println("No se pudo cerrar la conexión");
			e.printStackTrace();
		}
	}
	
	public static void closeStmt(PreparedStatement stmt) {
		
	}
	
	public static void closeStmt(Statement stmt) {
		
	}
}
