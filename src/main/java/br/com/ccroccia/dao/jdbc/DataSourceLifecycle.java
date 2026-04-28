package br.com.ccroccia.dao.jdbc;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


/* When we use connections pools, there are a lot of connections TCP opened.
 * Then we need to shutdown this connections
 * 
 * The interface ServletContextListener solved that problem, there is a method
 * called contextDestroyed() that is called when the app is turn off
 * 
 * 
 * @WebListener - register listener
 */

@WebListener
public class DataSourceLifecycle implements ServletContextListener{
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ConnectionFactory.shutdown();
	}
}
