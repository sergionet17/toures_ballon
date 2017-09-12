package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import netgloo.models.Biblioteca;
import netgloo.models.Libro;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/*
@SpringBootTest
public class DemoApplicationTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void contextLoads() {
            Libro libro = new Libro();
            libro.setId_libro(Long.MIN_VALUE);
            libro.setNombre("lo que el viento se");
            //Biblioteca biblioteca = new Biblioteca();
            //biblioteca.setLibro(libro);
            entityManager.persist(libro);
    }

}
*/