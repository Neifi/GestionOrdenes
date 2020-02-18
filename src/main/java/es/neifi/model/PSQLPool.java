package es.neifi.model;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

@Deprecated
public class PSQLPool {

	private static BasicDataSource ds = new BasicDataSource();

	
	//TODO implementar 
	static {
		ds.setUrl("");
		ds.setUsername("postgres");
		ds.setPassword("admin");
		ds.setMinIdle(5);
		ds.setMaxIdle(10);
		ds.setMaxOpenPreparedStatements(100);
	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

}
