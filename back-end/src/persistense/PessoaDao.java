package persistense;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import model.Pessoa;

public class PessoaDao {
	
	private EntityManager manager = EntityManagerFactoryHolder.factory.createEntityManager();
	
	public void insertPessoa(Pessoa pessoa){
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(pessoa);
		transaction.commit();
	}
	
	public void upDatePessoa(Pessoa pessoa) {
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		
		manager.merge(pessoa);
		
		transaction.commit();
	}
	
	public List<Pessoa> getAll(){
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		
			@SuppressWarnings("unchecked")
			List<Pessoa> lista = manager
				  .createQuery("select p from PESSOA")
				  .getResultList();
			return lista;
	}
	
	public void removePessoa(Pessoa pessoa) {
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		pessoa = manager.find(Pessoa.class, pessoa.getId());
		manager.remove(pessoa);
		transaction.commit();		
	}

	public boolean containsPessoa(String pessoaNome) {
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
