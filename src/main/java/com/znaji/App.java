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
                SELECT NEW com.znaji.dto.StudentEnrollment(s,e) from Student s inner join Enrollment e on s.id = e.student.id
                """;
            TypedQuery<StudentEnrollment> query = em.createQuery(jpql, StudentEnrollment.class);
            query.getResultList().forEach(o -> System.out.println(o.s() + " " + o.e()));

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
