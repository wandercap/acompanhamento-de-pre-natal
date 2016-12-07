package model;

import java.io.Serializable;

/**
 * A classe {@code Procedimento} define o objeto Procedimento, seu comportamento e seus atributos
 * @author Wanderlan Carvalho
 *
 */

public class Procedimento implements Serializable {
	private static final long serialVersionUID = -7676195053746687547L;
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
	public Procedimento(int idGest, String data, String horario, String local, String especialidade, String medico, String comentarios, boolean realizado) {
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
	 * @param p um objeto {@code Procedimento}
	 */
	public Procedimento(Procedimento p) {
		this.setId(p.getId());
		this.setIdGest(p.getIdGest());
		this.setData(p.getData());
		this.setHorario(p.getHorario());
		this.setLocal(p.getLocal());
		this.setEspecialidade(p.getEspecialidade());
		this.setMedico(p.getMedico());
		this.setComentarios(p.getComentarios());
		this.setRealizado(p.isRealizado());
	}
	
	/**
	 * Construtor utilizado para criar um objeto vazio
	 */
	public Procedimento() {
		
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

