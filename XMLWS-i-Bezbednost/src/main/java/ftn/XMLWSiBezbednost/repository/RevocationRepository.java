package ftn.XMLWSiBezbednost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.XMLWSiBezbednost.utils.data.Revocation;


public interface RevocationRepository extends JpaRepository<Revocation, Integer>{

}
