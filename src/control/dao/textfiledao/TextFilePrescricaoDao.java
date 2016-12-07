package control.dao.textfiledao;

import java.util.ArrayList;

import control.dao.PrescricaoDao;
import model.Prescricao;

/**
 * A classe {@code TextFilePrescricaoDao} implementa a interface {@code PrescricaoDao} utilizando {@code TextFileDao}
 * @author Wanderlan Carvalho
 *
 */

public class TextFilePrescricaoDao implements PrescricaoDao {
	private static final String nomeArq = "textfiles/prescricaoArq.dat";
	private static TextFileDao<Prescricao> arq = new TextFileDao<Prescricao>();

	@Override
	public boolean adicionar(Prescricao prescricao) {
		ArrayList<Prescricao> lista = new ArrayList<Prescricao>(arq.getLista(nomeArq));
		
		prescricao.setId(lista.size());
		
		lista.add(prescricao);
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}

	@Override
	public boolean deletar(Prescricao prescricao) {
		ArrayList<Prescricao> lista = new ArrayList<Prescricao>(arq.getLista(nomeArq));
		Prescricao p = new Prescricao();
		p.setId(prescricao.getId());
		
		try {
			lista.set(prescricao.getId(), p);
		} catch (IndexOutOfBoundsException f) {
			return false;
		}
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;	
	}

	@Override
	public boolean alterar(Prescricao prescricao) {
		ArrayList<Prescricao> lista = new ArrayList<Prescricao>(arq.getLista(nomeArq));
		
		lista.set(prescricao.getId(), prescricao);
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}

	@Override
	public ArrayList<Prescricao> listar() {
		return new ArrayList<Prescricao>(arq.getLista(nomeArq));
	}

	@Override
	public Prescricao buscar(int id) {
		ArrayList<Prescricao> lista = new ArrayList<Prescricao>(arq.getLista(nomeArq));
		
		for(Prescricao p : lista) {
			if(p.getIdCons() == id)
				return p;
		}
		
		return new Prescricao(id, "", "", "", "");
		/*if(lista.get(id) != null)
			return lista.get(id);
		else
			return null;*/
	}

}
