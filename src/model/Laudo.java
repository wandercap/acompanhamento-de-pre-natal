package model;

import java.io.Serializable;

/**
 * A classe {@code Laudo} define o objeto Laudo, seu comportamento e seus atributos
 * @author Wanderlan Carvalho
 *
 */

public class Laudo implements Serializable {
	private static final long serialVersionUID = 8199000701191428347L;
	private int id;
	private int idProc;
	private int idExam;
	private String data;
	private String medico;
	private String laudo;
	private String especialidade;
	
	/**
	 * Construtor padrao
	 */
	public Laudo(int idProc, int idExam, String data, String medico, String especialidade, String laudo) {
		this.setIdProc(idProc);
		this.setIdExam(idExam);
		this.setData(data);
		this.setMedico(medico);
		this.setEspecialidade(especialidade);
		this.setLaudo(laudo);
	}
	
	/**
	 * Construtor padrao utilizado para copiar um objeto
	 * @param l um objeto {@code Laudo}
	 */
	public Laudo(Laudo l) {
		this.setId(l.getId());
		this.setIdProc(l.getIdProc());
		this.setIdExam(l.getIdExam());
		this.setData(l.getData());
		this.setMedico(l.getMedico());
		this.setEspecialidade(l.getEspecialidade());
		this.setLaudo(l.getLaudo());
	}
	
	/**
	 * Construtor utilizado para criar um objeto vazio
	 */
	public Laudo() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProc() {
		return idProc;
	}

	public void setIdProc(int idProc) {
		this.idProc = idProc;
	}

	public int getIdExam() {
		return idExam;
	}

	public void setIdExam(int idExam) {
		this.idExam = idExam;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getLaudo() {
		return laudo;
	}

	public void setLaudo(String laudo) {
		this.laudo = laudo;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade= especialidade;
	}
}
	
