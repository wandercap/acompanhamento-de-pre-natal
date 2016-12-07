package control.dao.textfiledao;

import java.util.ArrayList;

import control.dao.ConsultaDao;
import model.Consulta;

/**
 * A classe {@code TextFileConsultaDao} implementa a interface {@code ConsultaDao} utilizando {@code TextFileDao}
 * @author Wanderlan Carvalho
 *
 */

public class TextFileConsultaDao implements ConsultaDao {
	private static final String nomeArq = "textfiles/consultaArq.dat";
	private static TextFileDao<Consulta> arq = new TextFileDao<Consulta>();
	
	@Override
	public boolean adicionar(Consulta consulta) {
		ArrayList<Consulta> lista = new ArrayList<Consulta>(arq.getLista(nomeArq));
		
		consulta.setId(lista.size());
		
		lista.add(consulta);
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}

	@Override
	public boolean deletar(Consulta consulta) {
		ArrayList<Consulta> lista = new ArrayList<Consulta>(arq.getLista(nomeArq));
		Consulta c = new Consulta();
		c.setId(consulta.getId());
		
		try {
			lista.set(consulta.getId(), c);
		} catch (IndexOutOfBoundsException f) {
	        return false;
		}
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}

	@Override
	public boolean alterar(Consulta consulta) {
		ArrayList<Consulta> lista = new ArrayList<Consulta>(arq.getLista(nomeArq));
		
		lista.set(consulta.getId(), consulta);
		
		if(arq.setLista(lista, nomeArq))
			return true;
		else
			return false;
	}
	
	@Override
	public ArrayList<Consulta> listar() {
		return new ArrayList<Consulta>(arq.getLista(nomeArq));
	}

	@Override
	public Consulta buscar(int id) {
		ArrayList<Consulta> lista = new ArrayList<Consulta>(arq.getLista(nomeArq));
		
		if(lista.get(id) != null)
			return lista.get(id);
		else
			return null;
	}

}
