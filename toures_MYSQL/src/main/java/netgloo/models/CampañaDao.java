package netgloo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 * This class is used to access data for the User entity.
 * Repository annotation allows the component scanning support to find and 
 * configure the DAO wihtout any XML configuration and also provide the Spring 
 * exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */
//un mecanismo para encapsular el almacenamiento, 
//la recuperación y el comportamiento de búsqueda que emula una colección de objetos
@Repository
//@Transactinal es una anotación que le permite trabajar con transacciones de bases de datos de forma declarativa.
@Transactional
public class CampañaDao {
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * Save the user in the database.
   */
  public void create(Campaña campaña) {
    entityManager.persist(campaña);
    return;
  }
  
    /**
   * Save the user in the database.
   */
  public void createBilblioteca(Biblioteca bliBiblioteca) {
    entityManager.persist(bliBiblioteca);
    return;
  }
  
  /**
   * Save the user in the database.
   */
  public void createLibro(Libro libro) {
    entityManager.persist(libro);
    return;
  }
  
  
  
  /**
   * Delete the user from the database.
   */
  public void delete(Campaña campana) {

     if (entityManager.contains(campana))
      entityManager.remove(campana);
    else
      entityManager.remove(entityManager.merge(campana));
    return;      
  }
  
  /**
   * Return all the users stored in the database.
   */
  @SuppressWarnings("unchecked")
  public List<Campaña> getAll() {
    return entityManager.createQuery("from Campaña").getResultList();
  }
  
  /**
   * Return the user having the passed email.
   */
  public List<Campaña> getById(int id)  {
    List<Campaña> list = new ArrayList<Campaña>();
      return  (list) = entityManager.createQuery(
        "from Campaña where id = :id")
        .setParameter("id", id)
        .getResultList();
  }

  /**
   * Return the user having the passed id.
   */
  public List<Campaña> getByCodigoCampana(int id) {
       List<Campaña> list = new ArrayList<Campaña>();
      return  (list) = entityManager.createQuery(
        "from Campaña where id = :id")
        .setParameter("id", id)
        .getResultList();
  }

  /**
   * Update the passed user in the database.
   */
  public void update(Campaña campaña) {
    entityManager.merge(campaña);
    return;
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An EntityManager will be automatically injected from entityManagerFactory
  // setup on DatabaseConfig class.
  @PersistenceContext
  private EntityManager entityManager;
  
} // class UserDao
