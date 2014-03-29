package cybertron.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Tab(properties="usuario, activo, nombre, grupo.nombre, telefono, observaciones")
@Views({
	@View(members="usuario, activo; nombre; grupo; telefono; email; observaciones; macs; facturas"),
	@View(name="Simple", members="usuario, nombre"), 
	@View(name="Mac", members="usuario, nombre; grupo, telefono, email, macs")
})
public class Cliente {

	@Id
	@Column(length=32)
	private String usuario;
	
	@Column(length=64)
	private String nombre;
	
	@ManyToOne
	@DescriptionsList(descriptionProperties="nombre")
	private Grupo grupo;
	
	@Stereotype("TELEPHONE")
	private String telefono;
	
	@Stereotype("EMAIL")
	private String email;
	
	@Stereotype("MEMO")
	private String observaciones;

	@ManyToMany
	@JoinTable(name="cliente_macs")
	@ListAction("ManyToMany.new")
	@CollectionView("Cliente")
	private Collection<Mac> macs;
	
	@OneToMany(mappedBy="cliente")
	@ListAction("ManyToMany.new")
	@ListProperties("codigo, fecha, producto.codigo, producto.descripcion, producto.precio")
	private Collection<Factura> facturas;
	
	@ReadOnly
	private boolean activo;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Collection<Mac> getMacs() {
		return macs;
	}

	public void setMacs(Collection<Mac> macs) {
		this.macs = macs;
	}

	public Collection<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Collection<Factura> facturas) {
		this.facturas = facturas;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
