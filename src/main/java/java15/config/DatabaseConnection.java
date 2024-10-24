package java15.config;

import jakarta.persistence.EntityManagerFactory;
import java15.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

//@Deprecated
public class DatabaseConnection {
    public static EntityManagerFactory getSessionFactory() {
        try {
        Properties props = new Properties();
        props.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/postgres");
        props.put(Environment.JAKARTA_JDBC_USER, "postgres");
        props.put(Environment.JAKARTA_JDBC_PASSWORD, "adilet.2005");
        props.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
//        props.put(Environment.STATEMENT_BATCH_SIZE, "100");
        props.put(Environment.HBM2DDL_AUTO, "update");
        props.put(Environment.SHOW_SQL, "true");


        Configuration configuration = new Configuration();
        configuration.setProperties(props);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Lesson.class);
        configuration.addAnnotatedClass(Mentor.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Task.class);


        System.out.println("Successfully connected!");
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
            return null;
    }
}
