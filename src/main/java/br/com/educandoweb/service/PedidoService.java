package br.com.educandoweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educandoweb.entities.Cliente;
import br.com.educandoweb.entities.Pedido;
import br.com.educandoweb.repositories.ClienteRepository;
import br.com.educandoweb.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private  PedidoRepository repository;

	public List<Pedido> findAll() {
		return repository.findAll();
	}

	public Pedido findById(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.get();
	}

}
