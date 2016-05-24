package business;


import java.util.List;

import model.Pessoa;
import persistense.PessoaDao;

public class PessoaController {
	
	private static PessoaDao dao = new PessoaDao();
	
	public static void setDao(PessoaDao dao){
		PessoaController.dao = dao;
	}
	
	public static void savePessoa(Pessoa pessoa){
		if(dao.containsPessoa(pessoa.getNome()))
			throw new RuntimeException("Ha uma pessoa com o mesmo nome registrada!");
		else
			dao.insertPessoa(pessoa);
	}
	
	public static void upDatePessoa(Pessoa pessoa){
		dao.upDatePessoa(pessoa);
	}

	public static void deletePessoa(Pessoa pessoa){
		if(dao.containsPessoa(pessoa.getNome()))
			dao.removePessoa(pessoa);
		else
			throw new RuntimeException("Pessoa não registrada!"); 
	}
	
	public static List<Pessoa> listPessoa(){
		
		return dao.getAll();
		
	}
	
}
