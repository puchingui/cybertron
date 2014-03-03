package cybertron.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import cybertron.calculators.*;

@Entity
public class Factura {

	@Id
	@DefaultValueCalculator(value=ProximoCodigoFactura.class)
	private int codigo;
	
	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date fecha;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Cliente cliente;
	
	@OneToMany(mappedBy="padre", cascade=CascadeType.ALL)
	@ListProperties("producto.codigo, producto.descripcion, cantidad")
	private Collection<Detalle> detalle = new ArrayList<Detalle>();

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

	public Collection<Detalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(Collection<Detalle> detalle) {
		this.detalle = detalle;
	}
}
