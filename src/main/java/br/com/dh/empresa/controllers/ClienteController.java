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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.model.entities.Cliente;
import br.com.dh.empresa.model.repositories.ClienteRepository;

@RestController
@RequestMapping("cliente") // Todos os métodos dessa classe irão responder para um endpoint só
public class ClienteController {
	@Autowired // injeta o repositório nessa variável.
	private ClienteRepository clienteRepository;
	
	@GetMapping()
	public Iterable<Cliente> getClientes() {
		return clienteRepository.findAll();
	}
	
	/*@GetMapping("/nome/{nome}")
	public Cliente getByNome(@PathVariable String nome) {
		return clienteRepository.findOneByNome(nome);
	}*/

	@GetMapping("/nome")
	public Cliente getByNome(@RequestParam String nome) {
		return clienteRepository.findOneByNome(nome);
	}
	
	@GetMapping("/search")
	public List<Cliente> getByNomeAndCpf(@RequestParam String nome, @RequestParam String cpf) {
		return clienteRepository.findByNomeAndCpf(nome, cpf);
	}

	/*@GetMapping("/nomelike")
	public List<Cliente> getByNomeLike(@RequestParam String nome) {
		return clienteRepository.findByNomeContaining(nome);
	}*/

	@GetMapping("/nomelike")
	public List<Object[]> getByNomeLike(@RequestParam String nome) {
		return clienteRepository.encontrarNomeParecido(nome);
	}
	
	/**
	 * 
	 * @param cliente Do corpo da requisição contém os campos do objeto cliente a ser adicionado.
	 */
	@PostMapping()
	public void addCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	/**
	 * Obtém um cliente dado um id.
	 * @param id Id do cliente.
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<Cliente> getById(@PathVariable int id) {
		return clienteRepository.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable int id) {
		clienteRepository.deleteById(id);
	}
	
	@PutMapping("/{idCliente}")
	public Cliente updateCliente(@PathVariable int idCliente, 
			@RequestBody Cliente dadosCliente) throws IllegalAccessException {
		Cliente clienteDB = clienteRepository.findById(idCliente).orElseThrow(() -> new IllegalAccessException());
		
		if(dadosCliente.getCpf() != null) clienteDB.setCpf(dadosCliente.getCpf());
		if(dadosCliente.getNome() != null) clienteDB.setNome(dadosCliente.getNome());
		if(dadosCliente.getEmail() != null) clienteDB.setEmail(dadosCliente.getEmail());
		if(dadosCliente.getNascimento() != null) clienteDB.setNascimento(dadosCliente.getNascimento());
		if(dadosCliente.getDdi() != null) clienteDB.setDdi(dadosCliente.getDdi());
		if(dadosCliente.getDdd() != null && !dadosCliente.getDdd().isEmpty()) clienteDB.setDdi(dadosCliente.getDdd());
		if(dadosCliente.getTelefone() != null && !dadosCliente.getTelefone().isEmpty()) clienteDB.setTelefone(dadosCliente.getTelefone());
		if(dadosCliente.getNumero() > 0) clienteDB.setNumero(dadosCliente.getNumero());
		if(dadosCliente.getRua() != null && !dadosCliente.getRua().isEmpty()) clienteDB.setRua(dadosCliente.getRua());
		if(dadosCliente.getBairro() != null && !dadosCliente.getBairro().isEmpty()) clienteDB.setBairro(dadosCliente.getBairro());
		if(dadosCliente.getComplemento() != null && !dadosCliente.getComplemento().isEmpty()) clienteDB.setComplemento(dadosCliente.getComplemento());
		if(dadosCliente.getCidade() != null && !dadosCliente.getCidade().isEmpty()) clienteDB.setCidade(dadosCliente.getCidade());
		if(dadosCliente.getEstado() != null && !dadosCliente.getEstado().isEmpty()) clienteDB.setEstado(dadosCliente.getEstado());
		if(dadosCliente.getFk_funcionario() != null) clienteDB.setFk_funcionario(dadosCliente.getFk_funcionario());

		clienteRepository.save(clienteDB);
		return dadosCliente;
	}

}
