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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((condIns == null) ? 0 : condIns.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (condIns == null) {
			if (other.condIns != null)
				return false;
		} else if (!condIns.equals(other.condIns))
			return false;
		return true;
	}
	
	
	
}
