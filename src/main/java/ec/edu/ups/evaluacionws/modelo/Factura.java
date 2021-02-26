package ec.edu.ups.evaluacionws.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double totalCompra;
	
	@JsonIgnore
	@OneToMany(mappedBy = "factura",cascade = CascadeType.ALL)
	private List<CabeceraDetalle> listaDestalles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(double totalCompra) {
		this.totalCompra = totalCompra;
	}

	public List<CabeceraDetalle> getListaDestalles() {
		return listaDestalles;
	}

	public void setListaDestalles(List<CabeceraDetalle> listaDestalles) {
		this.listaDestalles = listaDestalles;
	}
	
	
}
