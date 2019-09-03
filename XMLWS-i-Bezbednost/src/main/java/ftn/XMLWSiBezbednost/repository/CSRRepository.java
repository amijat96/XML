package ftn.XMLWSiBezbednost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.XMLWSiBezbednost.utils.data.CertificateSigningRequest;


public interface CSRRepository extends JpaRepository<CertificateSigningRequest, Integer>{

}
