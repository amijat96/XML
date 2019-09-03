package ftn.XMLWSiBezbednost.x509;

import ftn.XMLWSiBezbednost.utils.data.CertificateAuthority;
import ftn.XMLWSiBezbednost.utils.data.CertificateSigningRequest;

public class NonCACertificateBuilder extends CertificateBuilder {

    public NonCACertificateBuilder(CertificateSigningRequest csr, int serialNumber, CertificateAuthority issuer){
        super();
        this.subjectData = csr.getCertificateData();
        this.creator = csr.getUser();
        this.serialNumber = serialNumber;
        this.issuer = issuer;
    }

}