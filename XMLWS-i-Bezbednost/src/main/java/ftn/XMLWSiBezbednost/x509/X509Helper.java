package ftn.XMLWSiBezbednost.x509;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x500.style.IETFUtils;

import ftn.XMLWSiBezbednost.utils.data.CertificateData;



public class X509Helper {

    public static CertificateData readX500Name(X500Name x500Name){
        CertificateData data = new CertificateData();
        data.setCommonName(getRDN(x500Name, BCStyle.CN));
        data.setSurname(getRDN(x500Name, BCStyle.SURNAME));
        data.setGivenName(getRDN(x500Name, BCStyle.GIVENNAME));
        data.setOrganization(getRDN(x500Name, BCStyle.O));
        data.setOrganizationalUnit(getRDN(x500Name, BCStyle.OU));
        data.setCountryCode(getRDN(x500Name, BCStyle.C));
        data.setEmailAddress(getRDN(x500Name, BCStyle.E));

        return data;
    }

    private static String getRDN(X500Name x500Name, ASN1ObjectIdentifier id){
        RDN[] rdn = x500Name.getRDNs(id);//[0].getFirst().getValue();
        if (rdn != null && rdn.length > 0){
            ASN1Encodable asn = rdn[0].getFirst().getValue();
            String value = IETFUtils.valueToString(asn);
            if (!"".equals(value))
                return value;
        }
        return null;
    }

    public static X509Certificate readCertificateFromFile(ftn.XMLWSiBezbednost.utils.data.Certificate cert){
        try {
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            File file = new File(cert.getCerFileName());
            InputStream in = new ByteArrayInputStream(Files.readAllBytes(file.toPath()));
            X509Certificate x509 = (X509Certificate) certFactory.generateCertificate(in);
            return x509;
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
