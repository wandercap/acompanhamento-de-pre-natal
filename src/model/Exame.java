package model;

import java.io.Serializable;

/**
 * A classe {@code Exame} define o objeto Exame, seu comportamento e seus atributos
 * @author Wanderlan Carvalho
 *
 */

public class Exame implements Serializable {
	private static final long serialVersionUID = -6660474577479326317L;
	private int id;
	private int idGest;
	private String data;
	private String horario;
	private String local;
	private String especialidade;
	private String medico;
	private String comentarios;
	private boolean realizado;
	
	/**
	 * Construtor padrao
	 */
	public Exame(int idGest, String data, String horario, String local, String especialidade, String medico, String comentarios, boolean realizado) {
		this.setIdGest(idGest);
		this.setData(data);
		this.setHorario(horario);
		this.setLocal(local);
		this.setEspecialidade(especialidade);
		this.setMedico(medico);
		this.setComentarios(comentarios);
		this.setRealizado(realizado);
	}
	
	/**
	 * Construtor padrao utilizado para copiar um objeto
	 * @param e um objeto {@code Exame}
	 */
	public Exame(Exame e) {
		this.setId(e.getId());
		this.setIdGest(e.getIdGest());
		this.setData(e.getData());
		this.setHorario(e.getHorario());
		this.setLocal(e.getLocal());
		this.setEspecialidade(e.getEspecialidade());
		this.setMedico(e.getMedico());
		this.setComentarios(e.getComentarios());
		this.setRealizado(e.isRealizado());
	}
	
	/**
	 * Construtor utilizado para criar um objeto vazio
	 */
	public Exame() {
		
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

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}
}
