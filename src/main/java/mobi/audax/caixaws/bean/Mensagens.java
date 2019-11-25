/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import mobi.audax.caixaws.restful.model.Mensagem;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author links
 */
@XmlType(propOrder = {"mensagem1", "mensagem2", "mensagem3", "mensagem4"})
public class Mensagens {

    private String mensagem1;
    private String mensagem2;
    private String mensagem3;
    private String mensagem4;

    public Mensagens() {
    }

    public Mensagens(String mensagem1, String mensagem2) {
        this.mensagem1 = mensagem1;
        this.mensagem2 = mensagem2;
    }

    public Mensagens(String mensagem1, String mensagem2, String mensagem3, String mensagem4) {
        this.mensagem1 = mensagem1;
        this.mensagem2 = mensagem2;
        this.mensagem3 = mensagem3;
        this.mensagem4 = mensagem4;
    }
    
    public void addMensagem(String text) {
        if (StringUtils.isBlank(this.mensagem1)) {
            this.mensagem1 = text;
        } else if (StringUtils.isBlank(this.mensagem2)) {
            this.mensagem2 = text;
        } else if (StringUtils.isBlank(this.mensagem3)) {
            this.mensagem3 = text;
        } else if (StringUtils.isBlank(this.mensagem4)) {
            this.mensagem4 = text;
        } else {
            
        }
    }

    @XmlElement(name = "MENSAGEM")
    public String getMensagem1() {
        return mensagem1;
    }

    public void setMensagem1(String mensagem1) {
        this.mensagem1 = mensagem1;
    }

    @XmlElement(name = "MENSAGEM")
    public String getMensagem2() {
        return mensagem2;
    }

    public void setMensagem2(String mensagem2) {
        this.mensagem2 = mensagem2;
    }

    @XmlElement(name = "MENSAGEM")
    public String getMensagem3() {
        return mensagem3;
    }

    public void setMensagem3(String mensagem3) {
        this.mensagem3 = mensagem3;
    }

    @XmlElement(name = "MENSAGEM")
    public String getMensagem4() {
        return mensagem4;
    }

    public void setMensagem4(String mensagem4) {
        this.mensagem4 = mensagem4;
    }

}
