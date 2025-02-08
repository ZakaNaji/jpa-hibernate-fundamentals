package com.znaji;

import com.znaji.config.CustomePersistenceUnitInfo;
import com.znaji.entity.Employee;
import com.znaji.entity.Passport;
import com.znaji.entity.Person;
import com.znaji.entity.Product;
import com.znaji.keys.ProductKey;
import jakarta.persistence.EntityManager;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.format_sql", "true");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "update");

        var emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomePersistenceUnitInfo(), props);
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            var passport = em.find(Passport.class, 1L);

            System.out.println(passport.getPerson());

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
