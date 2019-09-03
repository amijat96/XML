package ftn.XMLWSiBezbednost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.XMLWSiBezbednost.utils.data.CertificateAuthority;


public interface CARepository extends JpaRepository<CertificateAuthority, Integer> {
    List<CertificateAuthority> findByIssuerIsNull();

    List<CertificateAuthority> findByCaRole(CertificateAuthority.CARole role);

    List<CertificateAuthority> findByCaRoleIn(List<CertificateAuthority.CARole> roles);
}