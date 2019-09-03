package ftn.XMLWSiBezbednost.service;

import java.io.OutputStream;
import java.security.cert.X509Certificate;
import java.util.List;

import ftn.XMLWSiBezbednost.dto.RevocationDTO;
import ftn.XMLWSiBezbednost.exception.ActionNotPossibleException;
import ftn.XMLWSiBezbednost.exception.EntityNotFoundException;
import ftn.XMLWSiBezbednost.exception.InvalidDataException;
import ftn.XMLWSiBezbednost.exception.NotPermittedException;
import ftn.XMLWSiBezbednost.utils.data.Certificate;
import ftn.XMLWSiBezbednost.utils.data.CertificateAuthority;
import ftn.XMLWSiBezbednost.utils.data.CertificateSigningRequest;
import ftn.XMLWSiBezbednost.utils.data.User;
import ftn.XMLWSiBezbednost.utils.keystore.KeyStoreCredentials;



public interface CertificateService {

    Certificate generateCertificate(CertificateAuthority cA, CertificateSigningRequest cr, KeyStoreCredentials keyStoreCredentials);

    Certificate findOne(int id) throws EntityNotFoundException;

    Certificate save(Certificate certificate);

    List<Certificate> getMyCertificates(User logged);

    String writeCerFile(X509Certificate cert, int randomNumber);

    Certificate revokeCertificate(RevocationDTO revocation, User logged) throws EntityNotFoundException, ActionNotPossibleException,
            NotPermittedException, InvalidDataException;

    Certificate restoreCertificateOnHold(int id, User logged) throws EntityNotFoundException, ActionNotPossibleException,
            NotPermittedException;

    Certificate fullyRevokeCertificateOnHold(int id, User logged, String reason) throws EntityNotFoundException, ActionNotPossibleException,
            NotPermittedException, InvalidDataException;

    int generateSerialNumber();

    boolean isValid(Certificate cert);

    void getCerFileBySerialNumber(int serialNumber, OutputStream os) throws EntityNotFoundException;

}