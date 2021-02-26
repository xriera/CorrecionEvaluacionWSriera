package ec.edu.ups.evaluacionws.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.evaluacionws.dao.CabeceraDetalleDAO;
import ec.edu.ups.evaluacionws.dao.FacturaDAO;
import ec.edu.ups.evaluacionws.dao.ProductoDAO;
import ec.edu.ups.evaluacionws.modelo.CabeceraDetalle;
import ec.edu.ups.evaluacionws.modelo.Factura;
import ec.edu.ups.evaluacionws.modelo.Producto;
/**
 * 
 * @author xavier 
 *
 */
@Stateless
public class GestionON {
	
	@Inject
	private ProductoDAO daoProducto;
	
	@Inject
	private CabeceraDetalleDAO daoCabacera;
	
	@Inject
	private FacturaDAO daoFactura;
	
	public Producto buscarProducto(int codigoProducto) throws Exception {
		try {
			return daoProducto.buscarProducto(codigoProducto);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al registrar cliente");
		}
		
	}
	public void guardarProducto( Producto producto) {
		daoProducto.insertProducto(producto);
	}
	
	public void insertCabecera(CabeceraDetalle cabeceraDeatalle) {
		daoCabacera.insertCabecera(cabeceraDeatalle);
	}
	
	public void insertFactura(Factura factura) {
		daoFactura.insertFactura(factura);
	}
	  public List<CabeceraDetalle> listaDetalles() throws Exception {
		  return daoCabacera.listaDetalles();
	  }
	  public List<Factura> listaFacturaId(String id) throws Exception {
		  return daoFactura.listaFacturaId(id);
	  }
	  
	  public List<CabeceraDetalle> listaDetalleId(String cedula) throws Exception {
		  return daoCabacera.listaDetalleId(cedula);
	  }
}
