package com.aman.libraryspring.dao;

import java.sql.Driver;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.aman.libraryspring.ApplicationConfiguration;
import com.aman.libraryspring.ApplicationConstants;

public class ConnectionUtils {
	public ConnectionUtils() {
	}

	public DataSource getDataSource() {
		Driver driver = null;
		try {
			String driverName = ApplicationConfiguration.INSTANCE
					.getValue(ApplicationConstants.JDBC_DRIVERNAME);
			System.out.println("The driver name is:" + driverName);
			Class<?> driverClass = Class.forName(driverName);
			driver = (Driver) driverClass.newInstance();
		} catch (InstantiationException e) {
			throw new IllegalStateException(e);
		} catch (IllegalAccessException e) {
			throw new IllegalStateException(e);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(e);
		}
		DataSource dataSource = new SimpleDriverDataSource(driver,
				ApplicationConfiguration.INSTANCE
						.getValue(ApplicationConstants.JDBC_URL) + "; user=SA");
		return dataSource;
	}
}