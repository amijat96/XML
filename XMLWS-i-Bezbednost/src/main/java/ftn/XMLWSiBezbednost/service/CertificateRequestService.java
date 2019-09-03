package ftn.XMLWSiBezbednost.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import ftn.XMLWSiBezbednost.exception.ActionNotPossibleException;
import ftn.XMLWSiBezbednost.exception.EntityAlreadyExistsException;
import ftn.XMLWSiBezbednost.exception.EntityNotFoundException;
import ftn.XMLWSiBezbednost.utils.data.Certificate;
import ftn.XMLWSiBezbednost.utils.data.CertificateData;
import ftn.XMLWSiBezbednost.utils.data.CertificateSigningRequest;
import ftn.XMLWSiBezbednost.utils.data.User;



public interface CertificateRequestService {

	
	
	CertificateSigningRequest findByID(int id) throws EntityNotFoundException;

    List<CertificateSigningRequest> getMyRequests(User logged);

    List<CertificateSigningRequest> getSubmittedRequests();

    Certificate approveRequest(int id) throws EntityNotFoundException,
    											ActionNotPossibleException;

    CertificateSigningRequest rejectRequest(int id) throws EntityNotFoundException;

    CertificateSigningRequest create(CertificateSigningRequest request) 
    			throws EntityAlreadyExistsException;

    CertificateSigningRequest acceptCSRFile
    				(byte[] csrFile, CertificateData.
    				CertUsage usage, User user) throws EntityAlreadyExistsException,
    				NoSuchAlgorithmException, InvalidKeyException;
}
