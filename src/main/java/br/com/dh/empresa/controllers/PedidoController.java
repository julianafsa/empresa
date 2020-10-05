package br.com.dh.empresa.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.model.entities.Funcionario;
import br.com.dh.empresa.model.entities.Pedido;
import br.com.dh.empresa.model.repositories.PedidoRepository;

@RestController
@RequestMapping("pedido")
public class PedidoController {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping()
	public Iterable<Pedido> getPedidos() {
		return pedidoRepository.findAll();
	}
	
	@GetMapping("/{nfe}")
	public Pedido getByNfe(@PathVariable String nfe) {
		return pedidoRepository.findOneByNfe(nfe);
	}
	
	@GetMapping("/data/{data_emissao}")
	public List<Pedido> getByDataEmissao(@PathVariable String data_emissao) {
		LocalDate data = LocalDate.parse(data_emissao);
		return pedidoRepository.findByDataEmissao(data);
	}
	
	@PostMapping
	public Pedido addPedido(@RequestBody Pedido pedido) {
		pedidoRepository.save(pedido);
		return pedido; 
	}
	
	/*@DeleteMapping("/{id}")
	public void deletePedido(@PathVariable int id) {
		pedidoRepository.deleteById(id);
	}*/

}
