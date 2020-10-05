package br.com.dh.empresa.model.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.dh.empresa.model.entities.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>{

	/**
	 * Obtém um ou mais funcionários pelo nome.
	 * @param nome Nome do funcionário a ser buscado.
	 * @return Iterador funcionários.
	 */
	Iterable<Funcionario> findOneByNome(String nome);

	/**
	 * Obtém os funcionários ativos, ou seja, os funcionários que ainda
	 * trabalham na empresa.
	 * @return Os funcionários ativos.
	 */
	String query1 = 
		"select * from funcionario f where f.habilitado = true";
	@Query(value = query1, nativeQuery = true)
	List<Funcionario> listarFuncionariosAtivos();
	
	/**
	 * Obtém os funcionários inaativos, ou seja, os funcionários que não
	 * trabalham mais na empresa.
	 * @return Os funcionários inativos.
	 */
	String query2 = 
		"select * from funcionario f where f.habilitado = false";
	@Query(value = query2, nativeQuery = true)
	List<Funcionario> listarFuncionariosInativos();	
	
	/**
	 * Altera o valor do campo habilitado para falso quando um funcionário for demitido.
	 * O registro do funcionário não é apagado do banco de dados.
	 * A anotação @Modifying é usada para aprimorar a anotação @Query para executar 
	 * não apenas consultas SELECT, mas também consultas INSERT, UPDATE, DELETE e 
	 * até mesmo DDL.
	 * @para O id do funcionário a ser demitido.
	 */
	String query3 = 
		"UPDATE funcionario f SET habilitado = false WHERE f.id_funcionario = :id";
	@Transactional
	@Modifying
	@Query(value = query3, nativeQuery = true)
	void demitirFuncionario(int id);

	
}
