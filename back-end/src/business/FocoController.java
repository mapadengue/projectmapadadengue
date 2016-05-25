package business;

import java.util.List;

import model.Foco;
import persistense.FocoDao;


public class FocoController {
	
	private static FocoDao dao = new FocoDao();
	
	public static void setDao(FocoDao dao){
		FocoController.dao = dao;
	}
	
	public static void saveFoco(FocoDao foco){
		//if(dao.containsFoco(foco.getId()))
			//throw new RuntimeException("Ha uma pessoa com o mesmo nome registrada!");
		//else
			dao.insertFoco(foco);
	}
	
	public static void upDatePessoa(Foco foco){
		dao.upDateFoco(foco);
	}

	public static void deleteFoco(Foco foco){
		if(dao.containsFoco(foco.getId()))
			dao.removeFoco(foco);
		else
			throw new RuntimeException("Pessoa não registrada!"); 
	}
	
	public static List<Foco> listPessoa(){
		
		return dao.getAll();
		
	}
}
