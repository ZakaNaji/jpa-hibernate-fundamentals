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

            //var product = new Product();
            //product.setId(4L);
            //product.setName("Bread And cheese");
            //em.persist(product);// add it to the context and mark it for persistence(if we try to persiste with existing id will fail

            var pr = em.find(Product.class, 5L);
            System.out.println("Found product: " + pr);

            var product = new Product();
            product.setId(5L);
            product.setName("Test");
            var managed = em.merge(product);// adds product to context

            em.refresh(managed);//refetch entity from db
            System.out.println(managed);

            //em.detach(managed); //remove if rom context

            em.remove(managed); // mark it to be deleted

            var other = em.getReference(Product.class, 1L); // return a proxy, will do DB req once the ref is used.

                    em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
