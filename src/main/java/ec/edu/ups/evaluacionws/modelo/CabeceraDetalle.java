package ec.edu.ups.evaluacionws.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CabeceraDetalle {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoCabecera;
	
	private String cedula;
	private String nombre;
	private String correo;
	private int cantidad;
	private double total;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="idProducto")	
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="id")	
	private Factura factura;
	

	public int getCodigoCabecera() {
		return codigoCabecera;
	}

	public void setCodigoCabecera(int codigoCabecera) {
		this.codigoCabecera = codigoCabecera;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
}
