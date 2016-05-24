package business;

import java.util.List;

import model.Agente;
import persistense.AgenteDao;


public class AgenteController {
	 
	private static AgenteDao dao = new AgenteDao();
	
	public AgenteController(AgenteDao dao){
		AgenteController.dao = dao;
	}
	
	public static void saveAgente(Agente agente){
		if(dao.containsAgente(agente.getNome()))
			throw new RuntimeException("Ha um agente cadastrado com o mesmo nome!");
		else
			dao.insertAgente(agente);
	}
	
	public static void upDateAgente(Agente agente){
		dao.upDateAgente(agente);
	}
	
	public static void deleteAgente(Agente agente){
		if(dao.containsAgente(agente.getNome()))
			dao.removeAgente(agente);
		else
			throw new RuntimeException("Agente não registrado!");
	}
	
	public static List<Agente> listAgente(){
		
		return dao.getAll();
		
	}
	
}
