package com.sathya.advjavaproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnection {
	public static Connection createConnection()
	{	Connection connection = null;
		try {
			//Load the properties file
			Properties properties = new Properties();
			properties.load(new FileInputStream("C:\\Users\\SAI KIRAN\\eclipse-workspace\\advjavaproject\\connection-info.properties"));
		
			//Get the data from properties file 
			Class.forName(properties.getProperty("driver"));
			connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
		}
		catch(ClassNotFoundException | SQLException| IOException e)
		{	
			e.printStackTrace();
		}
		return connection;
	}
}
