package server.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import server.entity.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    private static SessionFactory getSessionFactory() {

        if(sessionFactory == null) {
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
            Map<String,Object> settings = getRegistrySettings(); // get all required settings like DataSource etc.
            registryBuilder.applySettings(settings); // apply settings to registryBuilder
            registry = registryBuilder.build(); // build registryBuilder and get registry


            MetadataSources metadataSources =
                    new MetadataSources(registry)
                            .addAnnotatedClass(Student.class) // adding entity classes here
                            .addAnnotatedClass(Instructor.class)
                            .addAnnotatedClass(Admin.class)
                            .addAnnotatedClass(Course.class)
                            .addAnnotatedClass(Section.class)
                            .addAnnotatedClass(Department.class);

            Metadata metadata = metadataSources.getMetadataBuilder().build(); // build metadataSources

            sessionFactory = metadata.getSessionFactoryBuilder().build(); // get sessionFactoryBuilder from metadata, build it and get sessionFactory

        }

        return sessionFactory;

    }

    public static void shutdown() {
        if(registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static Session getSession() {
        return getSessionFactory().openSession(); // can use getCurrentSession()
    }


    /*
     * Initialize a HashMap with essential configuration values to build ServiceRegistry
     */
    private static Map<String,Object> getRegistrySettings() {

        Properties hibernateProperties = new Properties();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("hibernate.properties");
            hibernateProperties.load(fis);
        } catch(IOException e){
            e.printStackTrace();
            return null;
        }

        Map<String,Object> settings = new HashMap<>();

        settings.put(Environment.DATASOURCE, DataSourceUtil.getDataSource());
        settings.put(Environment.DIALECT, hibernateProperties.getProperty("hibernate.dialect"));
        settings.put(Environment.SHOW_SQL, hibernateProperties.getProperty("hibernate.show_sql"));
        settings.put(Environment.HBM2DDL_AUTO, hibernateProperties.getProperty("hibernate.hbm2ddl.auto"));

        return settings;

    }
}
