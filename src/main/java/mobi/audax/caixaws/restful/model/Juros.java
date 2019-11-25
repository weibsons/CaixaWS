/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.restful.model;

import java.util.Date;
import mobi.audax.caixaws.enumm.TipoJurosMoraEnum;

/**
 *
 * @author links
 */
public class Juros {

    private TipoJurosMoraEnum tipo;
    private Date data;
    private String valor;
    private String percentual;

    public TipoJurosMoraEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoJurosMoraEnum tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPercentual() {
        return percentual;
    }

    public void setPercentual(String percentual) {
        this.percentual = percentual;
    }

}
