package ua.litovka.helper;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by SergLion on 21.02.2017.
 */
public class PropertyHolder {

    private static PropertyHolder propertyHolder;

    private boolean isInMemoryDB;
    private String jdbcUrl;
    private String dbUserLogin;
    private String dbUserPassword;
    private String dbDriver;

    private PropertyHolder() { loadProperties(); }

    public static synchronized PropertyHolder getInstance() {
        if (propertyHolder == null) {
            propertyHolder = new PropertyHolder();
        }
        return propertyHolder;
    }

    private void loadProperties() {
        Properties properties = new Properties();

        try {
            properties.load(PropertyHolder.class.getClassLoader().getResourceAsStream("application.properties"));

            this.isInMemoryDB = Boolean.valueOf(properties.getProperty("isInMemoryDB"));
            this.dbUserLogin = properties.getProperty("dbUserLogin");
            this.dbUserPassword = properties.getProperty("dbUserPassword");
            this.jdbcUrl = properties.getProperty("jdbcUrl");
            this.dbDriver = properties.getProperty("dbDriver");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getDbDriver() {
        return dbDriver;
    }

    public boolean isInMemoryDB() {
        return isInMemoryDB;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getDbUserLogin() {
        return dbUserLogin;
    }

    public String getDbUserPassword() {
        return dbUserPassword;
    }


}
