package ec.edu.ups.evaluacionws.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import ec.edu.ups.evaluacionws.modelo.CabeceraDetalle;
import ec.edu.ups.evaluacionws.modelo.Factura;
import ec.edu.ups.evaluacionws.modelo.Producto;
import ec.edu.ups.evaluacionws.negocio.GestionON;

import javax.ws.rs.Produces;
/**
 * 
 * @author xavier
 *
 */
@Path("/cliente")
public class ServicioREST {

	@Inject
	private GestionON on;

	@GET
	@Path("/productoid")
	@Produces("application/json")
	public Producto getCategoriaId(@QueryParam("id") int id) {
		Producto pro=new Producto();
		try {
			pro = on.buscarProducto(id);
			return pro;		
		//	System.out.println(cat);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No existe placa");
			//return pro;		
		}
		return pro;		
	}

	@POST
	@Path("/guardar")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta saveCategoria(Parametros parametros) {
		Respuesta resp = new Respuesta();
		CabeceraDetalle cab;
		Factura factura = new Factura();
		
		List<Detalles>lista = parametros.getListaDetalles();
		List<CabeceraDetalle>listacab=new ArrayList<CabeceraDetalle>();
		double aux=0;

		try {

			for (Detalles detalles : lista) {
				cab = new CabeceraDetalle();
				cab.setCedula(parametros.getCedula());
				cab.setNombre(parametros.getNombre());
				cab.setCorreo(parametros.getCorreo());
				cab.setCantidad(detalles.getCantidad());
				
				Producto producto= on.buscarProducto(detalles.getCodigoProducto());
				aux=aux+(detalles.getCantidad() *producto.getPrecio());
				
				//aux=total+aux
				cab.setTotal(detalles.getCantidad() *producto.getPrecio());
				cab.setFactura(factura);
				cab.setProducto(producto);
				listacab.add(cab);
			//	on.insertCabecera(cab);
			}
			factura.setTotalCompra(aux);
			factura.setListaDestalles(listacab);
			on.insertFactura(factura);
			

			resp.setCodigo(1);
			resp.setMensaje("Factura ingresada exitosa!!");
		} catch (Exception e) {
			resp.setCodigo(-1);
			resp.setMensaje("Error en cabecera ");
		}
		return resp;
	}


}
