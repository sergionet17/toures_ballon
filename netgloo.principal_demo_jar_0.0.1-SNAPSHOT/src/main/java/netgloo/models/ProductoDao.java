/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sergio
 */
//un mecanismo para encapsular el almacenamiento, 
//la recuperación y el comportamiento de búsqueda que emula una colección de objetos
@Repository
//@Transactinal es una anotación que le permite trabajar con transacciones de bases de datos de forma declarativa.
@Transactional
public class ProductoDao {

                // An EntityManager will be automatically injected from entityManagerFactory
                // setup on DatabaseConfig class.
                @PersistenceContext
                private EntityManager entityManager;

                /**
                 * Save the user in the database.
                 */
                public void create(Productos producto) {
                    entityManager.persist(producto);
                    return;
                }

                  /**
               * Return the user having the passed id.
               */
              public List<Productos> getByCodigoProduto(int codigo_producto) {
                   List<Productos> list = new ArrayList<>();
                  return  (list) = entityManager.createQuery(
                    "from Productos where codigo_producto = :codigo_producto")
                    .setParameter("codigo_producto", codigo_producto)
                    .getResultList();
              }

}
