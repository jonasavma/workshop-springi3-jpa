package br.com.educandoweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educandoweb.entities.Cliente;
import br.com.educandoweb.repositories.ClienteRepository;
import br.com.educandoweb.service.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Cliente insert(Cliente obj) {
		return repository.save(obj);

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Cliente update(Long id, Cliente obj) {
		Cliente entity = repository.getReferenceById(id);
		updateDate(entity, obj);
		return repository.save(entity);
	}

	private void updateDate(Cliente entity, Cliente obj) {

		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
