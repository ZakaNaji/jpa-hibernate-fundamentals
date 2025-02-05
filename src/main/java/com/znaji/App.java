package com.znaji;

import com.znaji.config.JpaConfig;
import com.znaji.entity.Product;
import jakarta.persistence.EntityManager;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var jpaConfig = new JpaConfig();
        var emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(jpaConfig, new HashMap<>());
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            var product = new Product();
            product.setId(2L);
            product.setName("Xiomi 13");

            em.persist(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
