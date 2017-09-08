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
@Repository
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
    return entityManager.createQuery("from User").getResultList();
  }
  
  /**
   * Return the user having the passed email.
   */
  public List<Campaña> getById(String id) {
    List<Campaña> list = new ArrayList<>();
      return  (list) = entityManager.createQuery(
        "from Campaña where id = :id")
        .setParameter("id", id)
        .getResultList();
  }

  /**
   * Return the user having the passed id.
   */
  public Campaña getById(long id) {
    return entityManager.find(Campaña.class, id);
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
