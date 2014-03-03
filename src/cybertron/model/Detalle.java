package cybertron.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@View(members="producto, cantidad")
public class Detalle extends Identificable {

	@ManyToOne
	private Factura padre;
	
	private int cantidad;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@ReferenceView("Simple")
	@NoFrame
	private Producto producto;

	public Factura getPadre() {
		return padre;
	}

	public void setPadre(Factura padre) {
		this.padre = padre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
