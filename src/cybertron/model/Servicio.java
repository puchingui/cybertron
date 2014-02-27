package cybertron.model;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Servicio {

	@Id
	@Column(length=4)
	private int codigo;
	
	@Column(length=50)
	@Required
	private String descripcion;
	
	@Stereotype("MONEY")
	private BigDecimal tarifa;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getTarifa() {
		return tarifa;
	}

	public void setTarifa(BigDecimal tarifa) {
		this.tarifa = tarifa;
	}
}
