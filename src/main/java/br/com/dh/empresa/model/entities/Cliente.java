package br.com.dh.empresa.model.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id_cliente;
	private String nome;
	private String cpf;
	private String rg;
	private String email;
	private LocalDate nascimento;
	private String ddi;
	private String ddd;
	private String telefone;
	private int numero;
	private String rua;
	private String bairro;
	private String complemento;
	private String cidade;
	private String estado;
	private String senha;

	@ManyToOne
	@JoinColumn(name = "fk_funcionario")
	@JsonIgnoreProperties("clientes")
	private Funcionario funcionario;	
	
	@OneToMany(mappedBy = "cliente")
	@JsonIgnoreProperties("cliente")
	private Set<Pedido> pedidos;
	
	public Cliente() {}
	
	/**
	 * @param id_cliente
	 * @param nome
	 * @param cpf
	 * @param rg
	 * @param email
	 * @param nascimento
	 * @param ddi
	 * @param ddd
	 * @param telefone
	 * @param numero
	 * @param rua
	 * @param bairro
	 * @param complemento
	 * @param cidade
	 * @param estado
	 * @param fk_funcionario
	 */
	public Cliente(int id_cliente, String nome, String cpf, String rg, String email, LocalDate nascimento, String ddi,
			String ddd, String telefone, int numero, String rua, String bairro, String complemento, String cidade,
			String estado, Funcionario funcionario, String senha) {
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.nascimento = nascimento;
		this.ddi = ddi;
		this.ddd = ddd;
		this.telefone = telefone;
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.funcionario = funcionario;
		this.senha = senha;
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
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * @param rua the rua to set
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the fk_funcionario
	 */
	public Funcionario getFk_funcionario() {
		return funcionario;
	}

	/**
	 * @param fk_funcionario the fk_funcionario to set
	 */
	public void setFk_funcionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the id_cliente
	 */
	public int getId_cliente() {
		return id_cliente;
	}
	
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}	

}
