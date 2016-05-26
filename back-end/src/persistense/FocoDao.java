package persistense;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Foco;

public class FocoDao {
private EntityManager manager = EntityManagerFactoryHolder.factory.createEntityManager();
	
	public void insertFoco(Foco foco){
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(foco);
		transaction.commit();
	}
	
	public void upDateFoco(Foco foco) {
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		
		manager.merge(foco);
		
		transaction.commit();
	}
	
	public List<Foco> getAll(){
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		
			@SuppressWarnings("unchecked")
			List<Foco> lista = manager
				  .createQuery("select f from FOCO")
				  .getResultList();
			return lista;
	}
	
	public void removeFoco(Foco foco) {
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		foco = manager.find(Foco.class, foco.getId());
		manager.remove(foco);
		transaction.commit();		
	}

	public boolean containsFoco(int focoID) {
		TypedQuery<Foco> query;
		List<Foco> result;
		
		query = manager.createNamedQuery("Selecione foco de Foco onde o nome = :prID", Foco.class);
		query.setParameter("prNome", focoID);
		result = query.getResultList();
		
		if(result.size() != 0)
			return true;
		
		return false;
	}

}
