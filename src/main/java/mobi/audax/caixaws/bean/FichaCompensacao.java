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
public class FichaCompensacao {

    private Mensagens mensagens;

    @XmlElement(name = "MENSAGENS")
    public Mensagens getMensagens() {
        return mensagens;
    }

    public void setMensagens(Mensagens mensagens) {
        this.mensagens = mensagens;
    }
}
