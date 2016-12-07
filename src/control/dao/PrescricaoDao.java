package control.dao;

import java.util.ArrayList;

import model.Prescricao;

/**
 * A interface {@code PrescricaoDao} define uma interface padrao DAO para o objeto {@code Prescricao}
 * @author Wanderlan Carvalho
 *
 */

public interface PrescricaoDao {
	/**
	 * Persiste o objeto {@code Prescricao} 
	 * @param prescricao
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean adicionar(Prescricao prescricao);
	
	/**
	 * Deleta o objeto {@code Prescricao}
	 * @param prescricao
	 * @return true se obt0eve exito, false se ocorreu algum problema
	 */
	public boolean deletar(Prescricao prescricao);
	
	/**
	 * Altera o objeto {@code Prescricao}
	 * @param prescricao
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean alterar(Prescricao prescricao);
	
	/**
	 * Lista todos os objetos do tipo {@code Prescricao}
	 * @return um ArrayList do tipo {@code Prescricao}
	 */
	public ArrayList<Prescricao> listar();
	
	/**
	 * Busca um objeto {@code Prescricao} atraves de seu atributo id
	 * @param id
	 * @return um objeto {@code Prescricao} se encontrou, null caso contrario
	 */
	public Prescricao buscar(int id);
}
