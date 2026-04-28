package br.com.ccroccia.dao.jdbc;

import java.sql.*;

import jakarta.annotation.PreDestroy;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv; 


/*In this class the manage of pools connections with standalone.xml file
 * But I prefered to use Hiraki to know the repository */
public class ConnectionFactory {
	
	private static final HikariDataSource dataSource;
	
	private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();  
	static {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(resolve(dotenv, "DB_URL"));                                                   
	    config.setUsername(resolve(dotenv, "DB_USER"));                                                 
	    config.setPassword(resolve(dotenv, "DB_PASS"));  
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
	
		@PreDestroy
		public static void shutdown() {                                                                                    
		      if (dataSource != null && !dataSource.isClosed()) {
		          dataSource.close();                                                                                        
		      }
		  } 
	

		public static Connection getConnection() {
			try {
				return dataSource.getConnection();
			} catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		private static String resolve(Dotenv dotenv, String key) {                                        
		      String value = dotenv.get(key);  
		      
		      return value != null ? value : System.getenv(key);                                              
		    } 
}
