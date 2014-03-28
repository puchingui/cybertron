package cybertron.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import cybertron.calculators.*;

@Entity
@View(members="codigo, fecha;"
		+ "cliente;"
		+ "producto")
public class Factura {

	@Id
	@DefaultValueCalculator(value=ProximoCodigoFactura.class)
	private int codigo;
	
	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date fecha;
	
	@ManyToOne
	@ReferenceView("Simple")
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Producto producto;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
