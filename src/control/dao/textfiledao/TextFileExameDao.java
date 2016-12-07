package control.dao.textfiledao;

import java.util.ArrayList;

import control.dao.ExameDao;
import model.Exame;

/**
 * A classe {@code TextFileExameDao} implementa a interface {@code ExameDao} utilizando {@code TextFileDao}
 * @author Wanderlan Carvalho
 *
 */

public class TextFileExameDao implements ExameDao {
	private static final String nomeArq = "textfiles/exameArq.dat";
	private static TextFileDao<Exame> arq = new TextFileDao<Exame>();
	
	@Override
	public boolean adicionar(Exame exame) {
		ArrayList<Exame> lista = new ArrayList<Exame>(arq.getLista(nomeArq));
		
		exame.setId(lista.size());
		
		lista.add(exame);
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}

	@Override
	public boolean deletar(Exame exame) {
		ArrayList<Exame> lista = new ArrayList<Exame>(arq.getLista(nomeArq));
		Exame e = new Exame();
		e.setId(exame.getId());
		
		try {
			lista.set(exame.getId(), e);
		} catch (IndexOutOfBoundsException f) {
			return false;
		}
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}

	@Override
	public boolean alterar(Exame exame) {
		ArrayList<Exame> lista = new ArrayList<Exame>(arq.getLista(nomeArq));
		
		lista.set(exame.getId(), exame);
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}
	
	@Override
	public ArrayList<Exame> listar() {
		return new ArrayList<Exame>(arq.getLista(nomeArq));
	}

	@Override
	public Exame buscar(int id) {
		ArrayList<Exame> lista = new ArrayList<Exame>(arq.getLista(nomeArq));
		
		if(lista.get(id) != null)
			return lista.get(id);
		else
			return null;
	}

}
