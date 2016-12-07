package control.dao.textfiledao;

import java.util.ArrayList;

import control.dao.LaudoDao;
import model.Laudo;

/**
 * A classe {@code TextFileLaudoDao} implementa a interface {@code LaudoDao} utilizando {@code TextFileDao}
 * @author Wanderlan Carvalho
 *
 */

public class TextFileLaudoDao implements LaudoDao {
	private static final String nomeArq = "textfiles/laudoArq.dat";
	private static TextFileDao<Laudo> arq = new TextFileDao<Laudo>();

	@Override
	public boolean adicionar(Laudo laudo) {
		ArrayList<Laudo> lista = new ArrayList<Laudo>(arq.getLista(nomeArq));
		
		laudo.setId(lista.size());
		
		lista.add(laudo);
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}

	@Override
	public boolean deletar(Laudo laudo) {
		ArrayList<Laudo> lista = new ArrayList<Laudo>(arq.getLista(nomeArq));
		Laudo l = new Laudo();
		l.setId(laudo.getId());
		
		try {
			lista.set(laudo.getId(), l);
		} catch (IndexOutOfBoundsException f) {
			return false;
		}
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;	
	}

	@Override
	public boolean alterar(Laudo laudo) {
		ArrayList<Laudo> lista = new ArrayList<Laudo>(arq.getLista(nomeArq));
		
		lista.set(laudo.getId(), laudo);
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}
	
	@Override
	public ArrayList<Laudo> listar() {
		return new ArrayList<Laudo>(arq.getLista(nomeArq));
	}

	@Override
	public Laudo buscar(int id) {
		ArrayList<Laudo> lista = new ArrayList<Laudo>(arq.getLista(nomeArq));
		
		if(lista.get(id) != null)
			return lista.get(id);
		else
			return null;
	}
	
	@Override
	public Laudo buscar(int idProc, int idExam) {
		ArrayList<Laudo> lista = new ArrayList<Laudo>(arq.getLista(nomeArq));
		
		for(Laudo l : lista) {
			if((l.getIdProc() == idProc)&&(l.getIdExam() == idExam))
				return l;
		}
		
		return new Laudo(idProc, idExam, "", "", "", "");
		
		/*if(lista.get(id) != null)
			return lista.get(id);
		else
			return null;*/
	}

}
