package control.dao;

import java.util.ArrayList;

import model.Gestante;

/**
 * A interface {@code GestanteDao} define uma interface padrao DAO para o objeto {@code Gestante}
 * @author Wanderlan Carvalho
 *
 */

public interface GestanteDao {
	/**
	 * Persiste o objeto {@code Gestante} 
	 * @param gestante
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean adicionar(Gestante gestante);
	
	/**
	 * Deleta o objeto {@code Gestante}
	 * @param gestante
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean deletar(Gestante gestante);
	
	/**
	 * Altera o objeto {@code Gestante}
	 * @param gestante
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean alterar(Gestante gestante);
	
	/**
	 * Lista todos os objetos do tipo {@code Gestante}
	 * @return um ArrayList do tipo {@code Gestante}
	 */
	public ArrayList<Gestante> listar();
	
	/**
	 * Busca um objeto {@code Gestante} atraves de seu atributo nome
	 * @param nome
	 * @return um objeto {@code Gestante} se encontrou, null caso contrario
	 */
	public Gestante buscar(String nome);
	
	/**
	 * Busca um objeto {@code Gestante} atraves de seu atributo id
	 * @param id
	 * @return um objeto {@code Gestante} se encontrou, null caso contrario
	 */
	public Gestante buscar(int id);
}
