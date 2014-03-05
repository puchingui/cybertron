package cybertron.tests;

import org.openxava.tests.*;

public class ClienteTest extends ModuleTestBase {

	public ClienteTest(String testName) {
		super(testName, "Cybertron", "Cliente");
	}
	
	public void testCrud() throws Exception {
		//Crear
		execute("CRUD.new");
		setValue("usuario", "prueba");
		setValue("nombre","Usuario de Prueba");
		//setValue("grupo","Clientes");
		setValue("telefono","8093881234");
		setValue("email","usuario.prueba@gmail.com");
		setValue("observaciones","Probando modulo cliente");
		
		execute("CRUD.save");
		assertNoErrors();
		assertValue("usuario","");
		assertValue("nombre","");
		//assertValue("grupo","");
		assertValue("telefono","");
		assertValue("email","");
		assertValue("observaciones","");
		
	}

}
