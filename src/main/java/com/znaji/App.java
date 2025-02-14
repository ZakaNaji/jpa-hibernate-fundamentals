package com.znaji;

import com.znaji.config.CustomePersistenceUnitInfo;
import com.znaji.entity.*;
import jakarta.persistence.EntityManager;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

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
        props.put("hibernate.hbm2ddl.auto", "create");

        var emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomePersistenceUnitInfo(), props);
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            var asoiaf = new Book();
            asoiaf.setAuthor("George R.R Marting");

            var aaaBattery = new ElectronicDevice();
            aaaBattery.setVoltage(220);

            em.persist(asoiaf);
            em.persist(aaaBattery);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
