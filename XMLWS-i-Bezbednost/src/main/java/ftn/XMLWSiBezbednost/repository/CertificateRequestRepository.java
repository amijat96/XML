package ftn.XMLWSiBezbednost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.XMLWSiBezbednost.utils.data.CertificateSigningRequest;
import ftn.XMLWSiBezbednost.utils.data.User;

public interface CertificateRequestRepository extends JpaRepository<CertificateSigningRequest, Integer>  {
	 List<CertificateSigningRequest> findByUser(User user);
}
