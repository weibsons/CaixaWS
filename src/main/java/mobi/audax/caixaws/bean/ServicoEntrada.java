/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author links
 */
@XmlRootElement(name = "SERVICO_ENTRADA", namespace = "http://caixa.gov.br/sibar/manutencao_cobranca_bancaria/boleto/externo")
@XmlType(propOrder = {"header", "dados"})
public class ServicoEntrada {

    private Header header;
    private Dados dados;

//    @XmlAttribute(name = "manutencaocobrancabancaria", namespace = "http://caixa.gov.br/sibar/manutencao_cobranca_bancaria/boleto/externo")
//    public String getManutencaoCobrancaBancaria() {
//        return "http://caixa.gov.br/sibar/manutencao_cobranca_bancaria/boleto/externo";
//    }
//
//    @XmlAttribute(namespace = "http://caixa.gov.br/sibar")
//    public String getSibar() {
//        return "http://caixa.gov.br/sibar";
//    }
    @XmlElement(name = "HEADER", namespace = "http://caixa.gov.br/sibar")
    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    @XmlElement(name = "DADOS")
    public Dados getDados() {
        return dados;
    }

    public void setDados(Dados dados) {
        this.dados = dados;
    }

}
