package br.com.educandoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educandoweb.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	
	

}
