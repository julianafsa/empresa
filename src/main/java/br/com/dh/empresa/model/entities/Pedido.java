package br.com.dh.empresa.model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private String nfe;
	private LocalDate dataEmissao;
	private float valor_total;
	private String status_pedido;
	
	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	@JsonIgnoreProperties("pedidos")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "fk_funcionario")
	@JsonIgnoreProperties("pedidos")
	private Funcionario funcionario;

	public static final String PENDENTE = "PENDENTE";
	public static final String CONCLUIDO = "CONCLUIDO";
	public static final String CANCELADO = "CANCELADO";
	
	public Pedido() {
		this.valor_total = 0;
		this.status_pedido = PENDENTE;
	}
	
	/**
	 * @param nfe
	 * @param data_emissao
	 * @param valor_total
	 * @param status_pedido
	 * @param cliente
	 * @param funcionario
	 */
	public Pedido(String nfe, LocalDate data_emissao, float valor_total, 
			String status_pedido, Cliente cliente,
			Funcionario funcionario) {
		this.nfe = nfe;
		this.dataEmissao = data_emissao;
		this.valor_total = valor_total;
		this.status_pedido = status_pedido;
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	/**
	 * @return the nfe
	 */
	public String getNfe() {
		return nfe;
	}
	/**
	 * @param nfe the nfe to set
	 */
	public void setNfe(String nfe) {
		this.nfe = nfe;
	}
	/**
	 * @return the data_emissao
	 */
	public LocalDate getDataEmissao() {
		return dataEmissao;
	}
	/**
	 * @param data_emissao the data_emissao to set
	 */
	public void setDataEmissao(LocalDate data_emissao) {
		this.dataEmissao = data_emissao;
	}
	/**
	 * @return the valor_total
	 */
	public float getValorTotal() {
		return valor_total;
	}
	/**
	 * @param valor_total the valor_total to set
	 */
	public void setValorTotal(float valor_total) {
		this.valor_total = valor_total;
	}
	/**
	 * @return the status_pedido
	 */
	public String getStatusPedido() {
		return status_pedido;
	}
	/**
	 * @param status_pedido the status_pedido to set
	 */
	public void setStatusPedido(String status_pedido) {
		this.status_pedido = status_pedido;
	}
	/**
	 * @return the fk_cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param fk_cliente the fk_cliente to set
	 */
	public void setCliente(Cliente fk_cliente) {
		this.cliente = fk_cliente;
	}
	
	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}
