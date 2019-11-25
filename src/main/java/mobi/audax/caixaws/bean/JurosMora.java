/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.bean;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import mobi.audax.caixaws.enumm.TipoJurosMoraEnum;

/**
 *
 * @author links
 */
@XmlType(propOrder = {"tipo", "data", "valor", "percentual"})
public class JurosMora {

    private TipoJurosMoraEnum tipo;
    private Date data;
    private String valor;
    private String percentual;

    public JurosMora() {
    }

    public JurosMora(TipoJurosMoraEnum tipo, Date data, String valor, String percentual) {
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.percentual = percentual;
    }

    @XmlElement(name = "TIPO")
    public TipoJurosMoraEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoJurosMoraEnum tipo) {
        this.tipo = tipo;
    }

    @XmlElement(name = "DATA")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @XmlElement(name = "VALOR")
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @XmlElement(name = "PERCENTUAL")
    public String getPercentual() {
        return percentual;
    }

    public void setPercentual(String percentual) {
        this.percentual = percentual;
    }

}
