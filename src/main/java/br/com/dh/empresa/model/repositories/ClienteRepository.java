package br.com.dh.empresa.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.dh.empresa.model.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

	Cliente findOneByNome(String nome);
	
	List<Cliente> findByNomeAndCpf(String nome, String cpf);

	List<Cliente> findByNome(String nome);
	
	Cliente findOneByCpf(String cpf);
		
	String query = "select nome, cpf FROM cliente where nome like %:nome%";
	@Query(value = query, nativeQuery = true)
	List<Object[]> encontrarNomeParecido(String nome);
	
	//List<Cliente> findByNomeContaining(String nome);
}
