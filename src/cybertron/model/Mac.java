package cybertron.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@View(name="Cliente", members="mac")
public class Mac {

	@Id
	@Stereotype("MAC")
	private String mac;
	
	@ManyToMany(mappedBy="macs")
	@ListAction("ManyToMany.new")
	@CollectionView("Mac")
	private Collection<Cliente> clientes;

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}
}
