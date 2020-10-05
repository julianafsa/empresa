package br.com.dh.empresa.model.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id_funcionario;
	private String nome;
	private String cpf;
	private String rg;
	private String email;
	LocalDate nascimento;
	private String ddi;
	private String ddd;
	private String telefone;
	private float salario;
	private Boolean habilitado;
	
	@OneToMany(mappedBy = "funcionario")
	@JsonIgnoreProperties("funcionario")
	private Set<Cliente> clientes;
	
	@OneToMany(mappedBy = "funcionario")
	@JsonIgnoreProperties("funcionario")
	private Set<Pedido> pedidos;

	public Funcionario() {}
	/**
	 * @param id_funcionario
	 * @param nome
	 * @param cpf
	 * @param rg
	 * @param email
	 * @param nascimento
	 * @param ddi
	 * @param ddd
	 * @param telefone
	 * @param salario
	 * @param id_gerente_cadastro
	 * @param habilitado
	 */
	public Funcionario(String nome, String cpf, String rg, String email, LocalDate nascimento,
			String ddi, String ddd, String telefone, float salario, boolean habilitado) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.nascimento = nascimento;
		this.ddi = ddi;
		this.ddd = ddd;
		this.telefone = telefone;
		this.salario = salario;
		this.habilitado = habilitado;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}
	/**
	 * @param rg the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the nascimento
	 */
	public LocalDate getNascimento() {
		return nascimento;
	}
	/**
	 * @param nascimento the nascimento to set
	 */
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	/**
	 * @return the ddi
	 */
	public String getDdi() {
		return ddi;
	}
	/**
	 * @param ddi the ddi to set
	 */
	public void setDdi(String ddi) {
		this.ddi = ddi;
	}
	/**
	 * @return the ddd
	 */
	public String getDdd() {
		return ddd;
	}
	/**
	 * @param ddd the ddd to set
	 */
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/**
	 * @return the salario
	 */
	public float getSalario() {
		return salario;
	}
	/**
	 * @param salario the salario to set
	 */
	public void setSalario(float salario) {
		this.salario = salario;
	}
	/**
	 * @return the habilitado
	 */
	public Boolean isHabilitado() {
		return habilitado;
	}
	/**
	 * @param habilitado the habilitado to set
	 */
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	/**
	 * @return the id_funcionario
	 */
	public int getId_funcionario() {
		return id_funcionario;
	}
	
	///**
	// * @return the clientes
	// */
	//public Set<Cliente> getClientes() {
	//	return clientes;
	//}
	
	///**
	// * @param clientes the clientes to set
	// */
	//public void setClientes(Set<Cliente> clientes) {
	//	this.clientes = clientes;
	//}
	
}
