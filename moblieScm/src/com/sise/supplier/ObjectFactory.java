
package com.sise.supplier;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sise.supplier package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetSupplierList_QNAME = new QName("http://supplier.sise.com/", "getSupplierList");
    private final static QName _SetSupplierDao_QNAME = new QName("http://supplier.sise.com/", "setSupplierDao");
    private final static QName _GetSupplier_QNAME = new QName("http://supplier.sise.com/", "getSupplier");
    private final static QName _GetSupplierListResponse_QNAME = new QName("http://supplier.sise.com/", "getSupplierListResponse");
    private final static QName _FindSupplierResponse_QNAME = new QName("http://supplier.sise.com/", "findSupplierResponse");
    private final static QName _FindSupplierAjaxResponse_QNAME = new QName("http://supplier.sise.com/", "findSupplierAjaxResponse");
    private final static QName _FindSupplier_QNAME = new QName("http://supplier.sise.com/", "findSupplier");
    private final static QName _FindSupplierAjax_QNAME = new QName("http://supplier.sise.com/", "findSupplierAjax");
    private final static QName _SetSupplierDaoResponse_QNAME = new QName("http://supplier.sise.com/", "setSupplierDaoResponse");
    private final static QName _GetSupplierResponse_QNAME = new QName("http://supplier.sise.com/", "getSupplierResponse");
    private final static QName _Exception_QNAME = new QName("http://supplier.sise.com/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sise.supplier
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link SetSupplierDaoResponse }
     * 
     */
    public SetSupplierDaoResponse createSetSupplierDaoResponse() {
        return new SetSupplierDaoResponse();
    }

    /**
     * Create an instance of {@link GetSupplierResponse }
     * 
     */
    public GetSupplierResponse createGetSupplierResponse() {
        return new GetSupplierResponse();
    }

    /**
     * Create an instance of {@link FindSupplierResponse }
     * 
     */
    public FindSupplierResponse createFindSupplierResponse() {
        return new FindSupplierResponse();
    }

    /**
     * Create an instance of {@link SetSupplierDao }
     * 
     */
    public SetSupplierDao createSetSupplierDao() {
        return new SetSupplierDao();
    }

    /**
     * Create an instance of {@link GetSupplierList }
     * 
     */
    public GetSupplierList createGetSupplierList() {
        return new GetSupplierList();
    }

    /**
     * Create an instance of {@link GetSupplierListResponse }
     * 
     */
    public GetSupplierListResponse createGetSupplierListResponse() {
        return new GetSupplierListResponse();
    }

    /**
     * Create an instance of {@link GetSupplier }
     * 
     */
    public GetSupplier createGetSupplier() {
        return new GetSupplier();
    }

    /**
     * Create an instance of {@link FindSupplierAjax }
     * 
     */
    public FindSupplierAjax createFindSupplierAjax() {
        return new FindSupplierAjax();
    }

    /**
     * Create an instance of {@link FindSupplier }
     * 
     */
    public FindSupplier createFindSupplier() {
        return new FindSupplier();
    }

    /**
     * Create an instance of {@link FindSupplierAjaxResponse }
     * 
     */
    public FindSupplierAjaxResponse createFindSupplierAjaxResponse() {
        return new FindSupplierAjaxResponse();
    }

    /**
     * Create an instance of {@link SupplierDaoImpl }
     * 
     */
    public SupplierDaoImpl createSupplierDaoImpl() {
        return new SupplierDaoImpl();
    }

    /**
     * Create an instance of {@link SupplierType }
     * 
     */
    public SupplierType createSupplierType() {
        return new SupplierType();
    }

    /**
     * Create an instance of {@link Supplier }
     * 
     */
    public Supplier createSupplier() {
        return new Supplier();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSupplierList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplier.sise.com/", name = "getSupplierList")
    public JAXBElement<GetSupplierList> createGetSupplierList(GetSupplierList value) {
        return new JAXBElement<GetSupplierList>(_GetSupplierList_QNAME, GetSupplierList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetSupplierDao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplier.sise.com/", name = "setSupplierDao")
    public JAXBElement<SetSupplierDao> createSetSupplierDao(SetSupplierDao value) {
        return new JAXBElement<SetSupplierDao>(_SetSupplierDao_QNAME, SetSupplierDao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSupplier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplier.sise.com/", name = "getSupplier")
    public JAXBElement<GetSupplier> createGetSupplier(GetSupplier value) {
        return new JAXBElement<GetSupplier>(_GetSupplier_QNAME, GetSupplier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSupplierListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplier.sise.com/", name = "getSupplierListResponse")
    public JAXBElement<GetSupplierListResponse> createGetSupplierListResponse(GetSupplierListResponse value) {
        return new JAXBElement<GetSupplierListResponse>(_GetSupplierListResponse_QNAME, GetSupplierListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSupplierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplier.sise.com/", name = "findSupplierResponse")
    public JAXBElement<FindSupplierResponse> createFindSupplierResponse(FindSupplierResponse value) {
        return new JAXBElement<FindSupplierResponse>(_FindSupplierResponse_QNAME, FindSupplierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSupplierAjaxResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplier.sise.com/", name = "findSupplierAjaxResponse")
    public JAXBElement<FindSupplierAjaxResponse> createFindSupplierAjaxResponse(FindSupplierAjaxResponse value) {
        return new JAXBElement<FindSupplierAjaxResponse>(_FindSupplierAjaxResponse_QNAME, FindSupplierAjaxResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSupplier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplier.sise.com/", name = "findSupplier")
    public JAXBElement<FindSupplier> createFindSupplier(FindSupplier value) {
        return new JAXBElement<FindSupplier>(_FindSupplier_QNAME, FindSupplier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSupplierAjax }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplier.sise.com/", name = "findSupplierAjax")
    public JAXBElement<FindSupplierAjax> createFindSupplierAjax(FindSupplierAjax value) {
        return new JAXBElement<FindSupplierAjax>(_FindSupplierAjax_QNAME, FindSupplierAjax.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetSupplierDaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplier.sise.com/", name = "setSupplierDaoResponse")
    public JAXBElement<SetSupplierDaoResponse> createSetSupplierDaoResponse(SetSupplierDaoResponse value) {
        return new JAXBElement<SetSupplierDaoResponse>(_SetSupplierDaoResponse_QNAME, SetSupplierDaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSupplierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplier.sise.com/", name = "getSupplierResponse")
    public JAXBElement<GetSupplierResponse> createGetSupplierResponse(GetSupplierResponse value) {
        return new JAXBElement<GetSupplierResponse>(_GetSupplierResponse_QNAME, GetSupplierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplier.sise.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
