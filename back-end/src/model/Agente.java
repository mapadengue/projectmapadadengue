package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AGENTE")
public class Agente {
	private int id;
	private long cnes;
	private long senha;
	private String email;
	private String nome;
	private long telefone;
	private long cpf;
	private Agente agente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "CNES")
	public long getCnes() {
		return cnes;
	}
	public void setCnes(long cnes) {
		this.cnes = cnes;
	}
	
	@Column(name = "SENHA")
	public long getSenha() {
		return senha;
	}
	public void setSenha(long senha) {
		this.senha = senha;
	}
	
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "NOME")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "TELEFONE")
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	
	@Column(name = "CPF")
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	@ManyToOne
	@JoinColumn(name = "AGUENTE_FK")
	public Agente getAgente(){
		return agente;
	}
	public void setPessoa(Agente agente){
		this.agente = agente;
	}
	
	
}
