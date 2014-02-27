package cybertron.model;

import java.util.*;

import javax.persistence.*;

@Entity
public class Grupo {

	@Id
	@Column(length=32)
	private String nombre;
	
	@Column(length=64)
	private String descripcion;
	
	@OneToMany(mappedBy="grupo")
	private Collection<Cliente> clientes;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}
}
