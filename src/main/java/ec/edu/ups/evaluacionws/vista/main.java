package ec.edu.ups.evaluacionws.vista;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.evaluacionws.modelo.CabeceraDetalle;
import ec.edu.ups.evaluacionws.modelo.Producto;
import ec.edu.ups.evaluacionws.negocio.GestionON;

@WebServlet("/main")
public class main extends HttpServlet {
	
	@Inject
	private GestionON on;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.getWriter().println("<h1>Hola mundo !!!</h1>");
    try { 
		 Producto producto = new Producto();
		 producto.setNombreProducto("leche");
		 producto.setPrecio(12);
		 
		 on.guardarProducto(producto);
		 
		Producto producto2=on.buscarProducto(1);
		System.out.println("Descripcioin"+producto2.getNombreProducto());
		
		CabeceraDetalle detalle = new CabeceraDetalle();
		detalle.setCedula("0106805591");
		detalle.setNombre("xavier ");
		detalle.setCorreo("xaveir@gmail.com");
		detalle.setCantidad(2);
		detalle.setTotal(producto2.getPrecio()*detalle.getCantidad());
		
		on.insertCabecera(detalle);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
		   
}
