package TTT.config;

import TTT.models.Company;
import TTT.models.Programmer;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DataBaseConfig {


    public static EntityManagerFactory entityManagerFactory() {
        Properties prop = new Properties();
        try{
           prop.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/postgres");
           prop.put(Environment.JAKARTA_JDBC_USER, "postgres");
           prop.put(Environment.JAKARTA_JDBC_PASSWORD, "baiel123");
           prop.put(Environment.JAKARTA_JDBC_PASSWORD, "Aibek005");
           prop.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
           prop.put(Environment.HBM2DDL_AUTO,"update");
           prop.put(Environment.SHOW_SQL,"true");

           Configuration con = new Configuration().addProperties(prop);
           con.addAnnotatedClass(Programmer.class);
           con.addAnnotatedClass(Company.class);
           return con.buildSessionFactory().unwrap(EntityManagerFactory.class);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


}
