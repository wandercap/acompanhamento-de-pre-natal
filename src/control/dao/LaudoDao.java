package control.dao;

import java.util.ArrayList;

import model.Laudo;

/**
 * A interface {@code LaudoDao} define uma interface padrao DAO para o objeto {@code Laudo}
 * @author Wanderlan Carvalho
 *
 */

public interface LaudoDao {
	/**
	 * Persiste o objeto {@code Laudo} 
	 * @param laudo
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean adicionar(Laudo laudo);
	
	/**
	 * Deleta o objeto {@code Laudo}
	 * @param laudo
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean deletar(Laudo laudo);
	
	/**
	 * Altera o objeto {@code Laudo}
	 * @param laudo
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean alterar(Laudo laudo);
	
	/**
	 * Lista todos os objetos do tipo {@code Laudo}
	 * @return um ArrayList do tipo {@code Laudo}
	 */
	public ArrayList<Laudo> listar();
	
	/**
	 * Busca um objeto {@code Laudo} atraves de seu atributo id
	 * @param id
	 * @return um objeto {@code Laudo} se encontrou, null caso contrario
	 */
	public Laudo buscar(int id);
	
	/**
	 * Busca um objeto {@code Laudo} atraves de seu atributo idProc ou idExam
	 * @param idProc id do {@code Procedimento} asociado ao {@code Laudo}
	 * @param idExam id do {@code Exame} asociado ao {@code Laudo}
	 * @return um objeto {@code Laudo} se encontrou, null caso contrario
	 */
	public Laudo buscar(int idProc, int idExam);
}
