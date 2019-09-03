package ftn.XMLWSiBezbednost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.XMLWSiBezbednost.utils.data.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
	Client findByEmail(String email);

}
