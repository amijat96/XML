package ftn.XMLWSiBezbednost.service;

import java.util.Date;
import java.util.List;

import ftn.XMLWSiBezbednost.exception.EntityNotFoundException;
import ftn.XMLWSiBezbednost.exception.InvalidDataException;
import ftn.XMLWSiBezbednost.utils.data.CRLInformation;
import ftn.XMLWSiBezbednost.utils.data.CertificateAuthority;



public interface CRLService {

	 Date issueCRL(int id, Date nextUpdate);

	    CRLInformation saveCRLInformation(CRLInformation crlInformation);

	    void addCAToSchedule(CertificateAuthority ca);

	    void addCAListToSchedule(List<CertificateAuthority> list);

	    void rescheduleCRLExecution(int id, String cronExp, String frequencyDescription)
	            throws EntityNotFoundException, InvalidDataException;

	    void rescheduleCRLExecutionForAll(String cronExp, String frequencyDescription) throws InvalidDataException;

	    void cancelExecution(CertificateAuthority ca);
}
