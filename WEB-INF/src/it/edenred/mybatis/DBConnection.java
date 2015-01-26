package it.edenred.mybatis;

import java.sql.*;


public class DBConnection {
	
    public static Connection connect() {	
		Connection conn = null;
		try {
		   Driver myDriver = new oracle.jdbc.driver.OracleDriver();
		   DriverManager.registerDriver( myDriver );
		   String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		   String user = "sys as sysdba";
		   String pass = "Industriagrea89";
		   conn = DriverManager.getConnection(url, user, pass);
		}
		catch(SQLException ex) {
		   System.out.println("Ups! nu ne putem conecta,te rugam sa revii!" + ex);
		   System.exit(1);
		}
		return conn;	
    }
}
