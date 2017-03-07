
package com.sise.suppliertype;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SupplierTypeService", targetNamespace = "http://supplierType.sise.com/", wsdlLocation = "http://127.0.0.1:12345/supplierType?wsdl")
public class SupplierTypeService
    extends Service
{

    private final static URL SUPPLIERTYPESERVICE_WSDL_LOCATION;
    private final static WebServiceException SUPPLIERTYPESERVICE_EXCEPTION;
    private final static QName SUPPLIERTYPESERVICE_QNAME = new QName("http://supplierType.sise.com/", "SupplierTypeService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://127.0.0.1:12345/supplierType?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SUPPLIERTYPESERVICE_WSDL_LOCATION = url;
        SUPPLIERTYPESERVICE_EXCEPTION = e;
    }

    public SupplierTypeService() {
        super(__getWsdlLocation(), SUPPLIERTYPESERVICE_QNAME);
    }

    public SupplierTypeService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SUPPLIERTYPESERVICE_QNAME, features);
    }

    public SupplierTypeService(URL wsdlLocation) {
        super(wsdlLocation, SUPPLIERTYPESERVICE_QNAME);
    }

    public SupplierTypeService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SUPPLIERTYPESERVICE_QNAME, features);
    }

    public SupplierTypeService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SupplierTypeService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SupplierTypeServiceImpl
     */
    @WebEndpoint(name = "SupplierTypeServiceImplPort")
    public SupplierTypeServiceImpl getSupplierTypeServiceImplPort() {
        return super.getPort(new QName("http://supplierType.sise.com/", "SupplierTypeServiceImplPort"), SupplierTypeServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SupplierTypeServiceImpl
     */
    @WebEndpoint(name = "SupplierTypeServiceImplPort")
    public SupplierTypeServiceImpl getSupplierTypeServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://supplierType.sise.com/", "SupplierTypeServiceImplPort"), SupplierTypeServiceImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SUPPLIERTYPESERVICE_EXCEPTION!= null) {
            throw SUPPLIERTYPESERVICE_EXCEPTION;
        }
        return SUPPLIERTYPESERVICE_WSDL_LOCATION;
    }

}