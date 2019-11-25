/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.restful.model;

import mobi.audax.caixaws.enumm.AcaoPosVencimentoEnum;

/**
 *
 * @author links
 */
public class PosVencimento {

    private AcaoPosVencimentoEnum acaoPosVencimento;
    private int dias;

    public AcaoPosVencimentoEnum getAcaoPosVencimento() {
        return acaoPosVencimento;
    }

    public void setAcaoPosVencimento(AcaoPosVencimentoEnum acaoPosVencimento) {
        this.acaoPosVencimento = acaoPosVencimento;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

}
