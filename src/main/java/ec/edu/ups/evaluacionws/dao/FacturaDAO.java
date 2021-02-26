package ec.edu.ups.evaluacionws.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.evaluacionws.modelo.Factura;


@Stateless
public class FacturaDAO {

	@PersistenceContext
    private EntityManager em;
	
	public void insertFactura(Factura factura) {
		em.persist(factura);
	}
	
    public List<Factura> listaFacturaId(String id) throws Exception {
        String jpql = "SELECT p FROM Factura p WHERE id LIKE :id";

        Query q = em.createQuery(jpql, Factura.class);
        q.setParameter("id", id);
        System.out.println("ejecuto listasolicitud");
        return q.getResultList();
    }
}
