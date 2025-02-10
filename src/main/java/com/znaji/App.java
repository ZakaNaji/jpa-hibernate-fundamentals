package com.znaji;

import com.znaji.config.CustomePersistenceUnitInfo;
import com.znaji.entity.*;
import com.znaji.keys.ProductKey;
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
        props.put("hibernate.hbm2ddl.auto", "create");

        var emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomePersistenceUnitInfo(), props);
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            var post = new Post();
            post.setTitle("Post 1");
            post.setContent("This is my 1st post, so welcome all.");

            var comment = new Comment();
            comment.setContent("Welcome aboard!");
            comment.setPost(post);

            em.persist(comment);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
