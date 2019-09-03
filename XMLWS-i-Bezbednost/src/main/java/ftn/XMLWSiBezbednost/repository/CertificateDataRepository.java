package ftn.XMLWSiBezbednost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.XMLWSiBezbednost.utils.data.CertificateData;


public interface CertificateDataRepository extends JpaRepository<CertificateData, Integer> {
    CertificateData findBySerialNumber(int serialNumber);

}
