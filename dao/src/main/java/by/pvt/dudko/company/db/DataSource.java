package by.pvt.dudko.company.db;
import com.mchange.v2.c3p0.ComboPooledDataSource;


import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class DataSource {
    private static DataSource datasource;
    private ComboPooledDataSource cpds;
    private static final Logger log = Logger.getLogger(ConnectionUtil.class);

    private DataSource() {
        cpds = new ComboPooledDataSource();
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
            cpds.setDriverClass(resourceBundle.getString("driver"));
            cpds.setJdbcUrl(resourceBundle.getString("url"));
            cpds.setUser(resourceBundle.getString("user"));
            cpds.setPassword(resourceBundle.getString("password"));
            cpds.setMinPoolSize(5);
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(20);
            cpds.setMaxStatements(180);
        } catch (PropertyVetoException e ) {
        	log.error("Invalid setting value",e);
        }
    }

    public static  synchronized DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
        }
        return datasource;
    }

    public  Connection getConnection() throws SQLException {
    	Connection conn = cpds.getConnection();
        return conn;
    }
}