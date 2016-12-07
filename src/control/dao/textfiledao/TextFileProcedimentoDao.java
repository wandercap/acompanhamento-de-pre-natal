package control.dao.textfiledao;

import java.util.ArrayList;

import control.dao.ProcedimentoDao;
import model.Procedimento;

/**
 * A classe {@code TextFileProcedimentoDao} implementa a interface {@code ProcedimentoDao} utilizando {@code TextFileDao}
 * @author Wanderlan Carvalho
 *
 */

public class TextFileProcedimentoDao implements ProcedimentoDao {
	private static final String nomeArq = "textfiles/procedimentoArq.dat";
	private static TextFileDao<Procedimento> arq = new TextFileDao<Procedimento>();

	@Override
	public boolean adicionar(Procedimento procedimento) {
		ArrayList<Procedimento> lista = new ArrayList<Procedimento>(arq.getLista(nomeArq));
		
		procedimento.setId(lista.size());
		
		lista.add(procedimento);
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}

	@Override
	public boolean deletar(Procedimento procedimento) {
		ArrayList<Procedimento> lista = new ArrayList<Procedimento>(arq.getLista(nomeArq));
		Procedimento p = new Procedimento();
		p.setId(procedimento.getId());
		
		try {
			lista.set(procedimento.getId(), p);
		} catch (IndexOutOfBoundsException f) {
	        return false;
		}
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}

	@Override
	public boolean alterar(Procedimento procedimento) {
		ArrayList<Procedimento> lista = new ArrayList<Procedimento>(arq.getLista(nomeArq));
		
		lista.set(procedimento.getId(), procedimento);
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}

	@Override
	public ArrayList<Procedimento> listar() {
		return new ArrayList<Procedimento>(arq.getLista(nomeArq));
	}


	@Override
	public Procedimento buscar(int id) {
		ArrayList<Procedimento>lista = new ArrayList<Procedimento>(arq.getLista(nomeArq));
		
		if(lista.get(id) != null)
			return lista.get(id);
		else
			return null;
	}
}
