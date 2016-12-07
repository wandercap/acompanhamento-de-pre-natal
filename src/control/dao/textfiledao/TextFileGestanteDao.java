package control.dao.textfiledao;

import java.util.ArrayList;

import control.dao.GestanteDao;
import model.Gestante;

/**
 * A classe {@code TextFileGestanteDao} implementa a interface {@code GestanteDao} utilizando {@code TextFileDao}
 * @author Wanderlan Carvalho
 *
 */

public class TextFileGestanteDao implements GestanteDao {
	private static final String nomeArq = "textfiles/gestanteArq.dat";
	private static TextFileDao<Gestante> arq = new TextFileDao<Gestante>();
	
	@Override
	public boolean adicionar(Gestante gestante) {
		ArrayList<Gestante> lista = new ArrayList<Gestante>(arq.getLista(nomeArq));
		
		gestante.setId(lista.size());
		
		lista.add(gestante);
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}

	@Override
	public boolean deletar(Gestante gestante) {
		ArrayList<Gestante> lista = new ArrayList<Gestante>(arq.getLista(nomeArq));
		Gestante g = new Gestante();
		g.setId(gestante.getId());
		
		try {
			lista.set(gestante.getId(), g);
		} catch (IndexOutOfBoundsException f) {
			return false;
		}
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;	
	}

	@Override
	public boolean alterar(Gestante gestante) {
		ArrayList<Gestante> lista = new ArrayList<Gestante>(arq.getLista(nomeArq));
		
		lista.set(gestante.getId(), gestante);
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}
	
	@Override
	public ArrayList<Gestante> listar() {
		return new ArrayList<Gestante>(arq.getLista(nomeArq));
	}

	@Override
	public Gestante buscar(String nome) {
		ArrayList<Gestante> lista = new ArrayList<Gestante>(arq.getLista(nomeArq));
		
		for(Gestante g : lista) {
			if(g.getNome().equals(nome))
				return g;
		}
		
		return null;
	}
	
	public Gestante buscar(int id) {
		ArrayList<Gestante> lista = new ArrayList<Gestante>(arq.getLista(nomeArq));
		
		if(lista.get(id) != null)
			return lista.get(id);
		else
			return null;
	}

}
