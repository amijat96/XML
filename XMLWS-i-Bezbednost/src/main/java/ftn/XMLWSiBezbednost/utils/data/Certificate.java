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
    @JoinColumn(name = "user")
    protected User user;

    @Column(name = "validfrom", nullable = false)
    protected Date validFrom;

    @Column(name = "validto", nullable = false)
    protected Date validTo;

    @Column(name = "cerfilename")
    protected String cerFileName;


    public Certificate() { }



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


 
  
}
