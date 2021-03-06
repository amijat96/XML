package ftn.XMLWSiBezbednost.utils.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CRLInformation {
	  @OneToOne
	    @JoinColumn(name = "issuer", referencedColumnName = "id")
	    protected CertificateAuthority ca;

	    @Column(name = "currentissued")
	    protected Date currentIssued;

	    @Column(name = "nextissued")
	    protected Date nextIssued;

	    @Column(name = "crlfilename")
	    protected String crlFilename;

	    @Column(name = "crlnumber")
	    protected int crlNumber;

	    @Column(name = "cronexpression")
	    protected String cronExpression;

	    @Column(name = "frequencydescription")
	    protected String frequencyDescription;

	    public CRLInformation() { }


	    public int incrementAndReturnNumber(){
	        return ++this.crlNumber;
	    }


	    public CertificateAuthority getCa() {
	        return ca;
	    }

	    public void setCa(CertificateAuthority ca) {
	        this.ca = ca;
	    }

	    public Date getCurrentIssued() {
	        return currentIssued;
	    }

	    public void setCurrentIssued(Date currentIssued) {
	        this.currentIssued = currentIssued;
	    }

	    public Date getNextIssued() {
	        return nextIssued;
	    }

	    public void setNextIssued(Date nextIssued) {
	        this.nextIssued = nextIssued;
	    }

	    public String getCrlFilename() {
	        return crlFilename;
	    }

	    public void setCrlFilename(String crlFilename) {
	        this.crlFilename = crlFilename;
	    }

	    public int getCrlNumber() {
	        return crlNumber;
	    }

	    public void setCrlNumber(int crlNumber) {
	        this.crlNumber = crlNumber;
	    }

	    public String getCronExpression() {
	        return cronExpression;
	    }

	    public void setCronExpression(String cronExpression) {
	        this.cronExpression = cronExpression;
	    }

	    public String getFrequencyDescription() {
	        return frequencyDescription;
	    }

	    public void setFrequencyDescription(String frequencyDescription) {
	        this.frequencyDescription = frequencyDescription;
	    }
}
