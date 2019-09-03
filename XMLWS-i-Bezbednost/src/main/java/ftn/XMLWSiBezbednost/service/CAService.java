package ftn.XMLWSiBezbednost.service;

import java.util.List;

import ftn.XMLWSiBezbednost.dto.CertificateAuthorityDTO;
import ftn.XMLWSiBezbednost.exception.ActionNotPossibleException;
import ftn.XMLWSiBezbednost.exception.EntityNotFoundException;
import ftn.XMLWSiBezbednost.utils.data.CertificateAuthority;
import ftn.XMLWSiBezbednost.utils.data.CertificateData;

public interface CAService {

	 CertificateAuthority getRootCA();

	    CertificateAuthority generateCertificateAuthority(CertificateAuthority issuer, CertificateAuthorityDTO dto);

	    CertificateAuthority generateRootCA();

	    void generateHTTPSCertificate();

	    CertificateAuthority findById(int id) throws EntityNotFoundException;
	    
	    
	    List<CertificateAuthority> getByRole(CertificateAuthority.CARole role);

	    List<CertificateAuthority> getBottomCAs();

	    List<CertificateAuthority> getAllCAs();

	    CertificateAuthority getRandomCAForUsage(CertificateData.CertUsage usage) throws ActionNotPossibleException;

	    CertificateAuthority save(CertificateAuthority ca);
}

