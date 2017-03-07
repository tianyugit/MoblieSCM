
package com.sise.suppliertype;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.sise.supplier.Exception;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sise.suppliertype package. 
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

    private final static QName _GetTypeResponse_QNAME = new QName("http://supplierType.sise.com/", "getTypeResponse");
    private final static QName _GetTypeListResponse_QNAME = new QName("http://supplierType.sise.com/", "getTypeListResponse");
    private final static QName _GetTypeList_QNAME = new QName("http://supplierType.sise.com/", "getTypeList");
    private final static QName _SetSupplierTypeDaoResponse_QNAME = new QName("http://supplierType.sise.com/", "setSupplierTypeDaoResponse");
    private final static QName _Exception_QNAME = new QName("http://supplierType.sise.com/", "Exception");
    private final static QName _GetType_QNAME = new QName("http://supplierType.sise.com/", "getType");
    private final static QName _SetSupplierTypeDao_QNAME = new QName("http://supplierType.sise.com/", "setSupplierTypeDao");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sise.suppliertype
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetSupplierTypeDao }
     * 
     */
    public SetSupplierTypeDao createSetSupplierTypeDao() {
        return new SetSupplierTypeDao();
    }

    /**
     * Create an instance of {@link GetType }
     * 
     */
    public GetType createGetType() {
        return new GetType();
    }

    /**
     * Create an instance of {@link SetSupplierTypeDaoResponse }
     * 
     */
    public SetSupplierTypeDaoResponse createSetSupplierTypeDaoResponse() {
        return new SetSupplierTypeDaoResponse();
    }

    /**
     * Create an instance of {@link GetTypeResponse }
     * 
     */
    public GetTypeResponse createGetTypeResponse() {
        return new GetTypeResponse();
    }

    /**
     * Create an instance of {@link GetTypeListResponse }
     * 
     */
    public GetTypeListResponse createGetTypeListResponse() {
        return new GetTypeListResponse();
    }

    /**
     * Create an instance of {@link GetTypeList }
     * 
     */
    public GetTypeList createGetTypeList() {
        return new GetTypeList();
    }

    /**
     * Create an instance of {@link SupplierType }
     * 
     */
    public SupplierType createSupplierType() {
        return new SupplierType();
    }

    /**
     * Create an instance of {@link SupplierTypeDaoImpl }
     * 
     */
    public SupplierTypeDaoImpl createSupplierTypeDaoImpl() {
        return new SupplierTypeDaoImpl();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplierType.sise.com/", name = "getTypeResponse")
    public JAXBElement<GetTypeResponse> createGetTypeResponse(GetTypeResponse value) {
        return new JAXBElement<GetTypeResponse>(_GetTypeResponse_QNAME, GetTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTypeListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplierType.sise.com/", name = "getTypeListResponse")
    public JAXBElement<GetTypeListResponse> createGetTypeListResponse(GetTypeListResponse value) {
        return new JAXBElement<GetTypeListResponse>(_GetTypeListResponse_QNAME, GetTypeListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTypeList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplierType.sise.com/", name = "getTypeList")
    public JAXBElement<GetTypeList> createGetTypeList(GetTypeList value) {
        return new JAXBElement<GetTypeList>(_GetTypeList_QNAME, GetTypeList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetSupplierTypeDaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplierType.sise.com/", name = "setSupplierTypeDaoResponse")
    public JAXBElement<SetSupplierTypeDaoResponse> createSetSupplierTypeDaoResponse(SetSupplierTypeDaoResponse value) {
        return new JAXBElement<SetSupplierTypeDaoResponse>(_SetSupplierTypeDaoResponse_QNAME, SetSupplierTypeDaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplierType.sise.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplierType.sise.com/", name = "getType")
    public JAXBElement<GetType> createGetType(GetType value) {
        return new JAXBElement<GetType>(_GetType_QNAME, GetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetSupplierTypeDao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://supplierType.sise.com/", name = "setSupplierTypeDao")
    public JAXBElement<SetSupplierTypeDao> createSetSupplierTypeDao(SetSupplierTypeDao value) {
        return new JAXBElement<SetSupplierTypeDao>(_SetSupplierTypeDao_QNAME, SetSupplierTypeDao.class, null, value);
    }

}
