package br.com.ccroccia.dao.jdbc;

import java.sql.*;

import io.github.cdimascio.dotenv.Dotenv;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


/*In this class the manage of pools connections with standalone.xml file
 * But I prefered to use Hiraki to know the repository */
public class ConnectionFactory {
	
	private static final HikariDataSource dataSource;
	
	private static final Dotenv dotenv = Dotenv.load();
	static {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(dotenv.get("DB_URL"));
		config.setUsername(dotenv.get("DB_USER"));
		config.setPassword(dotenv.get("DB_PASS"));
		config.setMaximumPoolSize(10);
		
		dataSource = new HikariDataSource(config);
	}
	
	

	private ConnectionFactory() {};
	
	/*
	 * 
	 * Hiraki make this logic internally
	 * However its interisting to stay to know how it works
	 * 
	 * 
	public static Connection getConnection() throws SQLException {
		if(connection == null) {
			connection = initConnection();
		} else if(connection != null && connection.isClosed() ) {
			connection = initConnection();
		}
		return connection;
	}*/ 
	

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
