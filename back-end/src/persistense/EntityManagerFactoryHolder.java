package persistense;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryHolder {
	
	public static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("DENGUE");
	
}
