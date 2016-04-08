package it.polito.tdp.lab3.model;
/**
 * La classe Corso rappresenta un singolo elemento del
 * Corso
 * Semplice Java BEAN (POJO)
 */
public class Corso {
	private String condIns;
	private int crediti;
	private String nome;
	private int pD;
	
	public Corso(String condIns, int crediti, String nome, int pD) {
		super();
		this.condIns = condIns;
		this.crediti = crediti;
		this.nome = nome;
		this.pD = pD;
	}
	public String getCondIns() {
		return condIns;
	}
	public void setCondIns(String condIns) {
		this.condIns = condIns;
	}
	public int getCrediti() {
		return crediti;
	}
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getpD() {
		return pD;
	}
	public void setpD(int pD) {
		this.pD = pD;
	}
	
}
