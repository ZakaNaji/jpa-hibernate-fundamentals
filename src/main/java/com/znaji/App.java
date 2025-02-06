package com.znaji;

import com.znaji.config.CustomePersistenceUnitInfo;
import com.znaji.entity.Product;
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

        var emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomePersistenceUnitInfo(), props);
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            var product = new Product();
            product.setId(4L);
            product.setName("Bread And cheese");
            em.persist(product);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
