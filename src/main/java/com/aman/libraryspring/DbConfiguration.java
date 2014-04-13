package com.aman.libraryspring;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.aman.libraryspring.dao.ConnectionUtils;

public class DbConfiguration {
    public static void populateSqls(String sqlFileName) throws SQLException {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        ClassPathResource sqlFile = new ClassPathResource(sqlFileName);
        System.out.println("Resource is:"+sqlFile);
        ClassPathResource[] scripts = new ClassPathResource[1];
        scripts[0] = sqlFile;
        databasePopulator.setScripts(scripts);
        DataSource dataSource = new ConnectionUtils().getDataSource();
        ;
        
        Connection connection = dataSource.getConnection();
        
        System.out.println("The connection is:"+connection);

        try {
            databasePopulator.populate(connection);
        } finally {
            dataSource.getConnection().close();
        }
    }
    
    public static void tearDownSchema() throws SQLException {
        Connection con = new ConnectionUtils().getDataSource().getConnection();
        try {
            java.sql.PreparedStatement prepareStatement = con
                    .prepareStatement("DROP SCHEMA PUBLIC CASCADE");
            prepareStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
