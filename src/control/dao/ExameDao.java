package control.dao;

import java.util.ArrayList;

import model.Exame;

/**
 * A interface {@code ExameDao} define uma interface padrao DAO para o objeto {@code Exame}
 * @author Wanderlan Carvalho
 *
 */

public interface ExameDao {
	/**
	 * Persiste o objeto {@code Exame} 
	 * @param exame
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean adicionar(Exame exame);
	
	/**
	 * Deleta o objeto {@code Exame}
	 * @param exame
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean deletar(Exame exame);
	
	/**
	 * Altera o objeto {@code Exame}
	 * @param exame
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean alterar(Exame exame);
	
	/**
	 * Lista todos os objetos do tipo {@code Exame}
	 * @return um ArrayList do tipo {@code Exame}
	 */
	public ArrayList<Exame> listar();
	
	/**
	 * Busca um objeto {@code Exame} atraves de seu atributo id
	 * @param id
	 * @return um objeto {@code Exame} se encontrou, null caso contrario
	 */
	public Exame buscar(int id);
}
