package cybertron.model;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@View(name="Factura", members="codigo, descripcion, precio")
public class Producto {

	@Id
	@Column(length=4)
	private String codigo;
	
	@Column(length=50)
	@Required
	private String descripcion;
	
	@Stereotype("MONEY")
	private BigDecimal precio;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
}
