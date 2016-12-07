package control.dao;

import java.util.ArrayList;

import model.Consulta;

/**
 * A interface {@code ConsultaDao} define uma interface padrao DAO para o objeto {@code Consulta}
 * @author Wanderlan Carvalho
 *
 */

public interface ConsultaDao {
	/**
	 * Persiste o objeto {@code Consulta} 
	 * @param consulta
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean adicionar(Consulta consulta);
	
	/**
	 * Deleta o objeto {@code Consulta}
	 * @param consulta
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean deletar(Consulta consulta);
	
	/**
	 * Altera o objeto {@code Consulta}
	 * @param consulta
	 * @return true se obteve exito, false se ocorreu algum problema
	 */
	public boolean alterar(Consulta consulta);
	
	/**
	 * Lista todos os objetos do tipo {@code Consulta}
	 * @return um ArrayList do tipo {@code Consulta}
	 */
	public ArrayList<Consulta> listar();
	
	/**
	 * Busca um objeto {@code Consulta} atraves de seu atributo id
	 * @param id
	 * @return um objeto {@code Consulta} se encontrou, null caso contrario
	 */
	public Consulta buscar(int id);
}
