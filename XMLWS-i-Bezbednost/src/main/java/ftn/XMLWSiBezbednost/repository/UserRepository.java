package ftn.XMLWSiBezbednost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.XMLWSiBezbednost.utils.data.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

}
