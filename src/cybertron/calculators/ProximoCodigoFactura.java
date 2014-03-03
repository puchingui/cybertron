package cybertron.calculators;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

public class ProximoCodigoFactura implements ICalculator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Object calculate() throws Exception {
		Query query = XPersistence.getManager()
				.createQuery("select max(codigo) from Factura");
		Integer lastNumber = (Integer) query.getSingleResult();
		return lastNumber == null ? 1 : lastNumber + 1;
	}
}
