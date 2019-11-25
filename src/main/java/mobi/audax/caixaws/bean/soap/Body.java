/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.bean.soap;

import javax.xml.bind.annotation.XmlElement;
import mobi.audax.caixaws.bean.ServicoEntrada;

/**
 *
 * @author links
 */
public class Body {

    private ServicoEntrada servicoEntrada;

    public Body() {
    }


    public Body(ServicoEntrada servicoEntrada) {
        this.servicoEntrada = servicoEntrada;
    }

    @XmlElement(name = "SERVICO_ENTRADA", namespace = "http://caixa.gov.br/sibar/manutencao_cobranca_bancaria/boleto/externo")
    public ServicoEntrada getServicoEntrada() {
        return servicoEntrada;
    }
}
