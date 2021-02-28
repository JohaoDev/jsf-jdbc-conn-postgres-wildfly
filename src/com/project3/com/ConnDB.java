package com.project3.com;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnDB {
	private static String url = "jdbc:postgresql://localhost:5432/project3";
	private static final String user = "postgres";
	private static final String pass = "1234";
	private static Connection conn;
	
	public static void initConn() {
        try {
        	Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        
		try {
		 	conn = DriverManager.getConnection(url, user, pass);
		 	System.out.println("Conectado");
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos");
			e.printStackTrace();
			return;
		}
	}
	
	public static void postData(String name, String lastname) {
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into users(name, lastname) values(?,?)");
			stmt.setString(1, name);
			stmt.setString(2, lastname);
			stmt.execute();
			System.out.println("Data inserted: Name: " + name + " " + "Lastname: " + lastname);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
