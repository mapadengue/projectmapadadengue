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

import model.Pessoa;

public class PessoaDao {
	protected EntityManager em;
	
	public void insertPessoa(Pessoa pessoa){
		EntityManagerFactory factory = EntityManagerFactoryHolder.factory;
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(pessoa);
		transaction.commit();
	}
	
	public void upDatePessoa(Pessoa pessoa) {
		EntityManagerFactory factory = EntityManagerFactoryHolder.factory;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		
		manager.merge(pessoa);
		
		transaction.commit();
	}
	
	
	public void removePessoa(Pessoa pessoa) {
		EntityManagerFactory factory = EntityManagerFactoryHolder.factory;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		pessoa = manager.find(Pessoa.class, pessoa.getId());
		manager.remove(pessoa);
		transaction.commit();		
	}

	public boolean containsPessoa(String pessoaNome) {
		EntityManagerFactory factory = EntityManagerFactoryHolder.factory;
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Pessoa> query;
		List<Pessoa> result;
		
		query = manager.createNamedQuery("Selecione pessoa de Pessoa onde o nome = :prNome", Pessoa.class);
		query.setParameter("prNome", pessoaNome);
		
		result = query.getResultList();
		
		if(result.size() != 0)
			return true;
		
		return false;
	}
	
}
