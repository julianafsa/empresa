package br.com.dh.empresa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.model.entities.Funcionario;
import br.com.dh.empresa.model.repositories.FuncionarioRepository;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	/**
	 * Obtém todos os funcionários (ativos e inativos).
	 */
	@GetMapping()
	public Iterable<Funcionario> getFuncionarios() {
		return funcionarioRepository.findAll();
	}
	
	/**
	 * Obtém um funcionario dado um id.
	 * @param id Id do cliente.
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<Funcionario> getById(@PathVariable int id) {
		return funcionarioRepository.findById(id);
	}
	
	@GetMapping("/nome/{nome}")
	public Iterable<Funcionario> getByNome(@PathVariable String nome) {
		return funcionarioRepository.findOneByNome(nome);
	}

	@GetMapping("/ativos")
	public List<Funcionario> getFuncionariosAtivos() {
		return funcionarioRepository.listarFuncionariosAtivos();
	}
	
	@GetMapping("/inativos")
	public List<Funcionario> getFuncionariosInativos() {
		return funcionarioRepository.listarFuncionariosInativos();
	}

	@PostMapping
	public Funcionario addFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		return funcionario; 
	}
	
	@DeleteMapping("/{id}")
	public void deleteFuncionario(@PathVariable int id) {
		funcionarioRepository.deleteById(id);
	}
	
	@PutMapping("/demitir/{id}")
	public void demitirFuncionario(@PathVariable int id) {
		funcionarioRepository.demitirFuncionario(id);
	}

	@PutMapping("/reajustar/{id}")
	public void reajustarSalarioFuncionario(@PathVariable int id,
			@RequestBody Funcionario dadosFuncionario) throws IllegalAccessException {
		Funcionario funcionarioDB = funcionarioRepository.findById(id).orElseThrow(() -> new IllegalAccessException());
		float novoSalario = dadosFuncionario.getSalario();
		// Se o funcionário está ativo e
		// se o novo salário é maior que zero e é diferente do salário atual, 
		// o novo salário é atualizado.
		if (funcionarioDB.isHabilitado() &&
			novoSalario > 0 && funcionarioDB.getSalario() != novoSalario) {
			funcionarioDB.setSalario(novoSalario);
			funcionarioRepository.save(funcionarioDB);
		}
	}

	@PutMapping("/{idFuncionario}")
	public Funcionario updateFuncionario(@PathVariable int idFuncionario, 
			@RequestBody Funcionario dadosFuncionario) throws IllegalAccessException {
		Funcionario funcionarioDB = funcionarioRepository.findById(idFuncionario).orElseThrow(() -> new IllegalAccessException());
		
		if(dadosFuncionario.getNome() != null) funcionarioDB.setNome(dadosFuncionario.getNome());
		if(dadosFuncionario.getCpf() != null) funcionarioDB.setCpf(dadosFuncionario.getCpf());
		if(dadosFuncionario.getRg() != null) funcionarioDB.setRg(dadosFuncionario.getRg());
		if(dadosFuncionario.getEmail() != null) funcionarioDB.setEmail(dadosFuncionario.getEmail());
		if(dadosFuncionario.getNascimento() != null) funcionarioDB.setNascimento(dadosFuncionario.getNascimento());

		if(dadosFuncionario.getDdi() != null) funcionarioDB.setDdi(dadosFuncionario.getDdi());
		if(dadosFuncionario.getDdd() != null && !dadosFuncionario.getDdd().isEmpty()) funcionarioDB.setDdi(dadosFuncionario.getDdd());
		if(dadosFuncionario.getTelefone() != null && !dadosFuncionario.getTelefone().isEmpty()) funcionarioDB.setTelefone(dadosFuncionario.getTelefone());
		
		if(dadosFuncionario.getSalario() > 0) funcionarioDB.setSalario(dadosFuncionario.getSalario());
		//if(dadosFuncionario.getId_gerente_cadastro() != null) funcionarioDB.setId_gerente_cadastro(dadosFuncionario.getId_gerente_cadastro());
		if(dadosFuncionario.isHabilitado() != null) funcionarioDB.setHabilitado(dadosFuncionario.isHabilitado());

		funcionarioRepository.save(funcionarioDB);
		return dadosFuncionario;
	}
	

}
