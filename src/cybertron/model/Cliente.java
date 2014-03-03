package cybertron.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Tab(properties="usuario, nombre, grupo.nombre")
@View(name="Simple", members="usuario, nombre")
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

	@ManyToMany
	@JoinTable(name="cliente_macs")
	@ListAction("ManyToMany.new")
	@CollectionView("NoClientes")
	private Collection<Mac> macs;
	
	@Stereotype("MEMO")
	private String observaciones;
	
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

	public Collection<Mac> getMacs() {
		return macs;
	}

	public void setMacs(Collection<Mac> macs) {
		this.macs = macs;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
