package com.znaji;

import com.znaji.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            var product = new Product();
            product.setId(1L);
            product.setName("Test");

            em.persist(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
