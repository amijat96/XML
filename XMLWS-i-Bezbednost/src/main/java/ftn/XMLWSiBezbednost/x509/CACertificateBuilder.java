package ftn.XMLWSiBezbednost.x509;

import java.security.PrivateKey;

import ftn.XMLWSiBezbednost.utils.data.CertificateAuthority;
import ftn.XMLWSiBezbednost.utils.data.CertificateData;



public class CACertificateBuilder extends CertificateBuilder {

    public CACertificateBuilder(CertificateData data, int durationInMonths, int serialNumber, CertificateAuthority issuer){
        super();
        this.subjectData = data;
        this.duration = durationInMonths;
        this.serialNumber = serialNumber;
        this.issuer = issuer;
    }

    public CACertificateBuilder(CertificateData data, int durationInMonths, int serialNumber, PrivateKey privateKey){
        super();
        this.subjectData = data;
        this.duration = durationInMonths;
        this.privateKey = privateKey;
        this.serialNumber = serialNumber;
    }

}