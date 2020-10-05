package br.com.dh.empresa.model.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.empresa.model.entities.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer>{

	Pedido findOneByNfe(String nfe);

	List<Pedido> findByDataEmissao(LocalDate data_emissao);
	
	//List<Pedido> findByData_Emissao(LocalDate data_emissao);

}
