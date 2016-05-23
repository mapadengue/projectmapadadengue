package business;

import java.util.Locale.Category;

import model.Pessoa;
import persistense.PessoaDao;

public class PessoaController {
	
	private PessoaDao dao;
	
	public void setDao(PessoaDao dao){
		this.dao = dao;
	}
	
	public PessoaController(){
		this.dao = new PessoaDao();
	}
	
	public void savePessoa(Pessoa pessoa){
		if(dao.containsPessoa(pessoa.getNome()))
			throw new RuntimeException("Ha uma pessoa com o mesmo nome registrada!");
		else
			dao.insertPessoa(pessoa);
	}
	
	public void upDatePessoa(Pessoa pessoa){
		
	}

}
