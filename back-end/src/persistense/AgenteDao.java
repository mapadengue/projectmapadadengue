package persistense;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;

import model.Agente;
import model.Pessoa;

public class AgenteDao {
	private EntityManager manager = EntityManagerFactoryHolder.factory.createEntityManager();
	

	public void insertAgente(Agente agente){
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(agente);
		transaction.commit();
	}
	
	public void upDateAgente(Agente agente) {
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		
		manager.merge(agente);
		
		transaction.commit();
	}
	
	public List<Agente> getAll(){
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		
			@SuppressWarnings("unchecked")
			List<Agente> lista = manager
				  .createQuery("select p from AGENTE")
				  .getResultList();
			return lista;
	}
	
	public void removeAgente(Agente agente) {
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		agente = manager.find(Agente.class, agente.getId());
		manager.remove(agente);
		transaction.commit();		
	}
	
	public boolean containsAgente(String agenteNome) {
		TypedQuery<Agente> query;
		List<Agente> result;
		
		query = manager.createNamedQuery("Selecione pessoa de Pessoa onde o nome = :prNome", Agente.class);
		query.setParameter("prNome", agenteNome);
		
		result = query.getResultList();
		
		if(result.size() != 0)
			return true;
		
		return false;
	}
	
}
