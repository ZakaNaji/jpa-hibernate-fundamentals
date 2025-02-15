package com.znaji;

import com.znaji.config.CustomePersistenceUnitInfo;
import com.znaji.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.math.BigDecimal;
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

            String jpql = "SELECT COUNT(p) FROM Product p";
            TypedQuery<Long> numOfProducts = em.createQuery(jpql, Long.class);
            System.out.println(numOfProducts.getSingleResult());

            jpql = "SELECT AVG(p.price) FROM Product p";
            TypedQuery<Double> avgPrice = em.createQuery(jpql, Double.class);
            System.out.println(avgPrice.getSingleResult());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
