package model;

import java.io.Serializable;

/**
 * A classe {@code Consulta} define o objeto Consulta, seu comportamento e seus atributos
 * @author Wanderlan Carvalho
 *
 */

public class Consulta implements Serializable {
	private static final long serialVersionUID = -8145366721780852541L;
	private int id;
	private int idGest;
	private String data;
	private String horario;
	private String local;
	private String especialidade;
	private String medico;
	private String comentarios;
	private boolean realizada;
	
	/**
	 * Construtor padrao
	 */
	public Consulta(int idGest, String data, String horario, String local, String especialidade, String medico, String comentarios, boolean realizada) {
		this.setIdGest(idGest);
		this.setData(data);
		this.setHorario(horario);
		this.setLocal(local);
		this.setEspecialidade(especialidade);
		this.setMedico(medico);
		this.setComentarios(comentarios);
		this.setRealizada(realizada);
	}
	
	/**
	 * Construtor padrao utilizado para copiar um objeto
	 * @param c um objeto {@code Consulta}
	 */
	public Consulta(Consulta c) {
		this.setId(c.getId());
		this.setIdGest(c.getIdGest());
		this.setData(c.getData());
		this.setHorario(c.getHorario());
		this.setLocal(c.getLocal());
		this.setEspecialidade(c.getEspecialidade());
		this.setMedico(c.getMedico());
		this.setComentarios(c.getComentarios());
		this.setRealizada(c.isRealizada());
	}
	
	/**
	 * Construtor utilizado para criar um objeto vazio
	 */
	public Consulta() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdGest() {
		return idGest;
	}

	public void setIdGest(int idGest) {
		this.idGest = idGest;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return this.horario;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String getLocal() {
		return this.local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	public String getEspecialidade() {
		return this.especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public String getMedico() {
		return this.medico;
	}
	
	public void setMedico(String medico) {
		this.medico = medico;
	}
	
	public String getComentarios() {
		return this.comentarios;
	}
	
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public boolean isRealizada() {
		return realizada;
	}

	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}
}
