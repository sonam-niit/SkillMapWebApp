package com.niit.skillMap.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConfig {

	public static Connection connect()
	{
		String driver;
		String url;
		String user;
		String password;
		Properties prop = new Properties();
		InputStream input = null;
		Connection connection=null;
		try {

			//input = ClassLoader.getSystemResourceAsStream("utility.properties");
			//prop.load(input);
			/*driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			user=prop.getProperty("user");
			password=prop.getProperty("password");*/
			
			Class.forName("org.h2.Driver");
			connection=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/NIITProject","sa","password");
			
			/*if(connection!= null)
				System.out.println("Connected");*/

		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return connection;

	}
}
