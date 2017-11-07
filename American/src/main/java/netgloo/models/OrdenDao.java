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
public class OrdenDao {
    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Save the user in the database.
     */
    public void create(OrdenVenta ordenVenta) {
        entityManager.persist(ordenVenta);
        return;
    }

    /**
     * Save the products
     */
    public void createProduct(ProductoOrdenes productoOrdenes) {
        entityManager.persist(productoOrdenes);
        return;
    }

    /**
     * getAllOrdenes
     */
    public List<OrdenVenta> getAllOrdenes(int cedula) {
        List<OrdenVenta> list = new ArrayList<>();
        return (list) = entityManager.createQuery(
                "from ORDENES_VENTA_TB WHERE NUMERO_DOC_CLIENTE = :cedula")
                .setParameter("cedula", cedula)
                .getResultList();
    }

    public List<ProductoOrdenes> getProductoByCodigoOrden(int codigoOrdenProd) {
        List<ProductoOrdenes> list = new ArrayList<ProductoOrdenes>();
        return (list) = entityManager.createQuery(
                "from PRODUCTO_ORDENES_TB WHERE CODIGO_ORDEN_PROD = :codigoOrdenProd")
                .setParameter("codigoOrdenProd", codigoOrdenProd)
                .getResultList();
    }

    public OrdenVenta getOdenVentaByCodigoOrden(int codigoProducto) {
        OrdenVenta ordenVenta = new OrdenVenta();
        ordenVenta = (OrdenVenta) entityManager.createQuery(
                "from ORDENES_VENTA_TB WHERE CODIGO_ORDEN = :codigoProducto")
                .setParameter("codigoProducto", codigoProducto).getSingleResult();
        return ordenVenta;
    }

    /**
     * Delete the user from the database.
     */
    public void deleteProduct(ProductoOrdenes productoOrdenes) {
        if (entityManager.contains(productoOrdenes)) {
            entityManager.remove(productoOrdenes);
        } else {
            entityManager.remove(entityManager.merge(productoOrdenes));
        }
        return;
    }

    /**
     * Delete the user from the database.
     */
    public void deleteOrder(OrdenVenta ordenVenta) {
        if (entityManager.contains(ordenVenta)) {
            entityManager.remove(ordenVenta);
        } else {
            entityManager.remove(entityManager.merge(ordenVenta));
        }
        return;
    }
    /**
     * Update the ordenVenta user in the database.
     */
    public void updateOrdenCancelar(OrdenVenta ordenVenta) {
        entityManager.merge(ordenVenta);
        return;
    }
    /**
     * Update the productoOrden user in the database.
     */
    public void updateProductoOrden(ProductoOrdenes productoOrdenes) {
        entityManager.merge(productoOrdenes);
        return;
    }

}
