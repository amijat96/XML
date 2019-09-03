package ftn.XMLWSiBezbednost.utils.data;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;




@Entity
public class Certificate extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "issuer", referencedColumnName = "id")
    protected CertificateAuthority issuer;

    @OneToOne
    @JoinColumn(name = "certificatedata", nullable = false)
    protected CertificateData certificateData;

    @OneToOne(mappedBy = "certificate")
    protected CertificateAuthority ca;

    @ManyToOne
    @JoinColumn(name = "user")
    protected User user;

    @Column(name = "validfrom", nullable = false)
    protected Date validFrom;

    @Column(name = "validto", nullable = false)
    protected Date validTo;

    @Column(name = "cerfilename")
    protected String cerFileName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "revocation", referencedColumnName = "id")
    protected Revocation revocation;


    public Certificate() { }

    public CertificateAuthority getIssuer() {
        return issuer;
    }

    public void setIssuer(CertificateAuthority issuer) {
        this.issuer = issuer;
    }

    public CertificateData getCertificateData() {
        return certificateData;
    }

    public void setCertificateData(CertificateData certificateData) {
        this.certificateData = certificateData;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getCerFileName() {
        return cerFileName;
    }

    public void setCerFileName(String cerFileName) {
        this.cerFileName = cerFileName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CertificateAuthority getCa() {
        return ca;
    }

    public void setCa(CertificateAuthority ca) {
        this.ca = ca;
    }

    public Revocation getRevocation() {
        return revocation;
    }

    public void setRevocation(Revocation revocation) {
        this.revocation = revocation;
    }

 
  
}
