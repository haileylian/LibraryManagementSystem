package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton class for managing database connections.
 * This class provides a single instance of a database connection to ensure that
 * only one connection is used throughout the application.
 */
public class DBConnection {

	private static volatile DBConnection dbConnectionSingleton;
	private Connection connection = null;
	private final String serverUrl = "jdbc:mysql://127.0.0.1:3306/bookvault";
	private final String userString = "root";
	private final String passwordString = "password";
	private final String driverString = "com.mysql.cj.jdbc.Driver";

	/**
	 * Private constructor to initialize the database connection.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private DBConnection() throws SQLException {
		try {
			Class.forName(driverString);
			this.connection = DriverManager.getConnection(serverUrl, userString, passwordString);
		} catch (ClassNotFoundException ex) {
			System.out.println("Connection was not successful: " + ex.getMessage());
		}
	}

	/**
	 * Returns the singleton instance of the DBConnection class.
	 * If the instance does not exist, it is created in a thread-safe manner.
	 *
	 * @return the singleton instance of DBConnection
	 * @throws SQLException if a database access error occurs
	 */
	public static DBConnection getInstance() throws SQLException {
		if (dbConnectionSingleton == null) {
			synchronized (DBConnection.class) {
				if (dbConnectionSingleton == null) {
					dbConnectionSingleton = new DBConnection();
				}
			}
		}
		return dbConnectionSingleton;
	}

	/**
	 * Returns the current database connection.
	 *
	 * @return the current database connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * Closes the database connection.
	 * Currently, this method is not implemented.
	 */
	public void close() {
	}
}