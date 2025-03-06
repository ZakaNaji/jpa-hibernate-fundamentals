package com.znaji;

import com.znaji.config.CustomePersistenceUnitInfo;
import com.znaji.dto.StudentEnrollment;
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

            String jpql = """
                select s.name, count(s) from Student s group by s.name
                """;
            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            query.getResultList().forEach(o -> System.out.println(o[0] + " " + o[1]));

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
