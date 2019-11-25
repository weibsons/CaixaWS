/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import mobi.audax.caixaws.enumm.AcaoPosVencimentoEnum;

/**
 *
 * @author links
 */
@XmlType(propOrder = {"acaoPosVencimento", "dias"})
public class PosVencimento {

    private AcaoPosVencimentoEnum acaoPosVencimento;
    private int dias;

    public PosVencimento() {
    }

    public PosVencimento(AcaoPosVencimentoEnum acaoPosVencimento, int dias) {
        this.acaoPosVencimento = acaoPosVencimento;
        this.dias = dias;
    }

    @XmlElement(name = "ACAO")
    public AcaoPosVencimentoEnum getAcaoPosVencimento() {
        return acaoPosVencimento;
    }

    public void setAcaoPosVencimento(AcaoPosVencimentoEnum acaoPosVencimento) {
        this.acaoPosVencimento = acaoPosVencimento;
    }

    @XmlElement(name = "NUMERO_DIAS")
    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

}
