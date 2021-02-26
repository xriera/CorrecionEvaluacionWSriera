package ec.edu.ups.evaluacionws.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.evaluacionws.modelo.Producto;


@Stateless
public class ProductoDAO {
	
	@PersistenceContext
    private EntityManager em;
	
	public void insertProducto(Producto producto) {
		em.persist(producto);
	}
	
	public Producto buscarProducto(int codigoProducto) {
		return em.find(Producto.class, codigoProducto);
	}
	
}
