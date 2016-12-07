package model;

import java.io.Serializable;

/**
 * A classe {@code Prescricao} define o objeto Prescricao, seu comportamento e seus atributos
 * @author Wanderlan Carvalho
 *
 */

public class Prescricao implements Serializable {
	private static final long serialVersionUID = 6678163493218644433L;
	private int id;
	private int idCons;
	private String data;
	private String medico;
	private String especialidade;
	private String prescricao;
	
	/**
	 * Construtor padrao
	 */
	public Prescricao(int idCons, String data, String medico, String especialidade, String prescricao) {
		this.setIdCons(idCons);
		this.setData(data);
		this.setMedico(medico);
		this.setEspecialidade(especialidade);
		this.setPrescricao(prescricao);
	}
	
	/**
	 * Construtor padrao utilizado para copiar um objeto
	 * @param p um objeto {@code Prescricao}
	 */
	public Prescricao(Prescricao p) {
		this.setId(p.getId());
		this.setIdCons(p.getIdCons());
		this.setData(p.getData());
		this.setMedico(p.getMedico());
		this.setEspecialidade(p.getEspecialidade());
		this.setPrescricao(p.getPrescricao());
	}
	
	/**
	 * Construtor utilizado para criar um objeto vazio
	 */
	public Prescricao() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCons() {
		return idCons;
	}

	public void setIdCons(int idCons) {
		this.idCons = idCons;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMedico() {
		return this.medico;
	}
	
	public void setMedico(String medico) {
		this.medico = medico;
	}
	
	public String getEspecialidade() {
		return this.especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public String getPrescricao() {
		return this.prescricao;
	}
	
	public void setPrescricao(String prescricao) {
		this.prescricao = prescricao;
	}
}
