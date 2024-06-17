//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.6 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.10.17 a las 02:15:58 PM COT 
//


package pe.gob.pge.soap.reniec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para peticionConsulta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="peticionConsulta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nuDniConsulta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nuDniUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nuRucUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "peticionConsulta", propOrder = {
    "nuDniConsulta",
    "nuDniUsuario",
    "nuRucUsuario",
    "password"
})
public class PeticionConsulta {

    protected String nuDniConsulta;
    protected String nuDniUsuario;
    protected String nuRucUsuario;
    protected String password;

    /**
     * Obtiene el valor de la propiedad nuDniConsulta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNuDniConsulta() {
        return nuDniConsulta;
    }

    /**
     * Define el valor de la propiedad nuDniConsulta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNuDniConsulta(String value) {
        this.nuDniConsulta = value;
    }

    /**
     * Obtiene el valor de la propiedad nuDniUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNuDniUsuario() {
        return nuDniUsuario;
    }

    /**
     * Define el valor de la propiedad nuDniUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNuDniUsuario(String value) {
        this.nuDniUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad nuRucUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNuRucUsuario() {
        return nuRucUsuario;
    }

    /**
     * Define el valor de la propiedad nuRucUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNuRucUsuario(String value) {
        this.nuRucUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define el valor de la propiedad password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

}
