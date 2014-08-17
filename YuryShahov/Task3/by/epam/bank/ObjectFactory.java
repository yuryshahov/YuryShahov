//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.15 at 06:55:06 PM FET 
//


package by.epam.bank;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.epam.bank package. 
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

    private final static QName _Account_QNAME = new QName("http://www.epam.by/bank", "account");
    private final static QName _Deposite_QNAME = new QName("http://www.epam.by/bank", "deposite");
    private final static QName _Credit_QNAME = new QName("http://www.epam.by/bank", "credit");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.epam.bank
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Bank }
     * 
     */
    public Bank createBank() {
        return new Bank();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link Deposite }
     * 
     */
    public Deposite createDeposite() {
        return new Deposite();
    }

    /**
     * Create an instance of {@link Credit }
     * 
     */
    public Credit createCredit() {
        return new Credit();
    }

    /**
     * Create an instance of {@link Period }
     * 
     */
    public Period createPeriod() {
        return new Period();
    }

    /**
     * Create an instance of {@link AllPeriod }
     * 
     */
    public AllPeriod createAllPeriod() {
        return new AllPeriod();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.epam.by/bank", name = "account")
    public JAXBElement<Account> createAccount(Account value) {
        return new JAXBElement<Account>(_Account_QNAME, Account.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deposite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.epam.by/bank", name = "deposite", substitutionHeadNamespace = "http://www.epam.by/bank", substitutionHeadName = "account")
    public JAXBElement<Deposite> createDeposite(Deposite value) {
        return new JAXBElement<Deposite>(_Deposite_QNAME, Deposite.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Credit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.epam.by/bank", name = "credit", substitutionHeadNamespace = "http://www.epam.by/bank", substitutionHeadName = "account")
    public JAXBElement<Credit> createCredit(Credit value) {
        return new JAXBElement<Credit>(_Credit_QNAME, Credit.class, null, value);
    }

}