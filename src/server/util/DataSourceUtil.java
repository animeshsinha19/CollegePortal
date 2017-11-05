package server.util;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataSourceUtil {

    public static DataSource getDataSource() {
        Properties props = new Properties();
        FileInputStream fis = null;
        BasicDataSource ds = new BasicDataSource(); // uses apache DBCP for initializing datasource

        try {
            fis = new FileInputStream("db.properties");
            props.load(fis);
        } catch(IOException e){
            e.printStackTrace();
            return null;
        }

        ds.setDriverClassName(props.getProperty("MYSQL_DB_DRIVER_CLASS"));
        ds.setUrl(props.getProperty("MYSQL_DB_URL"));
        ds.setUsername(props.getProperty("MYSQL_DB_USERNAME"));
        ds.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));

        return ds;
    }
}
