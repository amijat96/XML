package ftn.XMLWSiBezbednost.service;

import ftn.XMLWSiBezbednost.dto.CertificateAuthorityDTO;
import ftn.XMLWSiBezbednost.exception.EntityNotFoundException;
import ftn.XMLWSiBezbednost.utils.data.CertificateAuthority;

public interface CAService {

	 CertificateAuthority getRootCA();

	    CertificateAuthority generateCertificateAuthority(CertificateAuthority issuer, CertificateAuthorityDTO dto);

	    CertificateAuthority generateRootCA();

	    void generateHTTPSCertificate();

	    CertificateAuthority findById(int id) throws EntityNotFoundException;
}
