package com.znaji;

import com.znaji.config.CustomePersistenceUnitInfo;
import com.znaji.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.math.BigDecimal;
import java.time.LocalDate;
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
        props.put("hibernate.hbm2ddl.auto", "update");

        var emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomePersistenceUnitInfo(), props);
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            var s = new Student();
            s.setId(1L);
            em.merge(s);

            var c = new Course();
            c.setTitle("Spring Boot");
            em.persist(c);

            var enr = new Enrollment();
            enr.setCourse(c);
            enr.setStudent(s);
            enr.setEnrollmentDate(LocalDate.now());
            em.persist(enr);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
