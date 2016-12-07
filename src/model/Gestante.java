package model;

import java.io.Serializable;

/**
 * A classe {@code Gestante} define o objeto Gestante, seu comportamento e seus atributos
 * @author Wanderlan Carvalho
 *
 */

public class Gestante implements Serializable {
	private static final long serialVersionUID = -5629977757951507222L;
	private int id;
	private String nome;
	private String telRes;
	private String telCel;
	private String mae;
	private String pai;
	private String dataNasc;
	private String endereco;
	private String bairro;
	private String cep;

	/**
	 * Construtor padrao
	 */
	public Gestante(String nome, String telRes, String telCel, String mae, String pai, String dataNasc, String endereco, String bairro, String cep) {
		this.setNome(nome);
		this.setTelRes(telRes);
		this.setTelCel(telCel);
		this.setMae(mae);
		this.setPai(pai);
		this.setDataNasc(dataNasc);
		this.setEndereco(endereco);
		this.setBairro(bairro);
		this.setCep(cep);
	}
	
	/**
	 * Construtor utilizado para copiar um objeto
	 * @param g um objeto {@code Gestante}
	 */
	public Gestante(Gestante g) {
		this.setId(g.getId());
		this.setNome(g.getNome());
		this.setTelRes(g.getTelRes());
		this.setTelCel(g.getTelCel());
		this.setMae(g.getMae());
		this.setPai(g.getPai());
		this.setDataNasc(g.getDataNasc());
		this.setEndereco(g.getEndereco());
		this.setBairro(g.getBairro());
		this.setCep(g.getCep());
	}
	
	/**
	 * Construtor utilizado para criar um objeto vazio
	 */
	public Gestante() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelRes() {
		return telRes;
	}

	public void setTelRes(String telRes) {
		this.telRes = telRes;
	}

	public String getTelCel() {
		return telCel;
	}

	public void setTelCel(String telCel) {
		this.telCel = telCel;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
