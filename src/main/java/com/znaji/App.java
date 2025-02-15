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

            String jpql = "SELECT p FROM Product p where p.price > :price";
            TypedQuery<Product> findAllProducts = em.createQuery(jpql, Product.class);
            findAllProducts.setParameter("price", 10000);
            findAllProducts.getResultList().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
