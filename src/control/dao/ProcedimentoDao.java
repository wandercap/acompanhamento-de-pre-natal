package control.dao;

import java.util.ArrayList;

import model.Procedimento;

/**
 * A interface {@code ProcedimentoDao} define uma interface padrao DAO para o objeto {@code Procedimento}
 * @author Wanderlan Carvalho
 *
 */

public interface ProcedimentoDao {
	/**
	 * Persiste o objeto {@code Procedimento} 
	 * @param procedimento
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean adicionar(Procedimento procedimento);
	
	/**
	 * Deleta o objeto {@code Procedimento}
	 * @param procedimento
	 * @return true se obt0eve exito, false se ocorreu algum problema
	 */
	public boolean deletar(Procedimento procedimento);
	
	/**
	 * Altera o objeto {@code Procedimento}
	 * @param procedimento
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean alterar(Procedimento procedimento);
	
	/**
	 * Lista todos os objetos do tipo {@code Procedimento}
	 * @return um ArrayList do tipo {@code Procedimento}
	 */
	public ArrayList<Procedimento> listar();
	
	/**
	 * Busca um objeto {@code Procedimento} atraves de seu atributo id
	 * @param id
	 * @return um objeto {@code Procedimento} se encontrou, null caso contrario
	 */
	public Procedimento buscar(int id);
}
