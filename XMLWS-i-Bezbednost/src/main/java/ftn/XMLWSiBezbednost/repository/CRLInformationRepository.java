package ftn.XMLWSiBezbednost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.XMLWSiBezbednost.utils.data.CRLInformation;


public interface CRLInformationRepository extends JpaRepository<CRLInformation, Integer> {

}
