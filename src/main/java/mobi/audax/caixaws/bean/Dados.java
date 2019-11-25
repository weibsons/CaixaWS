/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.bean;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author links
 */
public class Dados {

    private IncluiBoleto incluiBoleto;

    @XmlElement(name = "INCLUI_BOLETO")
    public IncluiBoleto getIncluiBoleto() {
        return incluiBoleto;
    }

    public void setIncluiBoleto(IncluiBoleto incluiBoleto) {
        this.incluiBoleto = incluiBoleto;
    }

}
