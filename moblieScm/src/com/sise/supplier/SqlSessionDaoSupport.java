
package com.sise.supplier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sqlSessionDaoSupport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sqlSessionDaoSupport">
 *   &lt;complexContent>
 *     &lt;extension base="{http://supplier.sise.com/}daoSupport">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sqlSessionDaoSupport")
@XmlSeeAlso({
    SupplierDaoImpl.class
})
public abstract class SqlSessionDaoSupport
    extends DaoSupport
{


}
