package br.com.ccroccia.dao.jdbc;

import java.sql.*;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;

public class ConnectionFactory {
	private static Connection connection;
	
	private static final Dotenv dotenv = Dotenv.load();
	
	private static final String url = dotenv.get("DB_URL");
	
	private static final String user = dotenv.get("DB_USER");
	
	private static final String password = dotenv.get("DB_PASS");
	

	private ConnectionFactory(Connection connection) {

	};
	

	public static Connection getConnection() throws SQLException {
		if(connection == null) {
			connection = initConnection();
		} else if(connection.isClosed() && connection != null) {
			connection = initConnection();
		}
		return connection;
	}

	private static Connection initConnection() {
		try {
			return DriverManager.getConnection(
					url,
					user, password
					);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
