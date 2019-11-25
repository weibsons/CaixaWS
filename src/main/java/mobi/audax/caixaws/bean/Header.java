/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import mobi.audax.caixaws.enumm.OperacaoEnum;
import mobi.audax.caixaws.enumm.SistemaEnum;

/**
 *
 * @author links
 */
@XmlType(propOrder = {"versao", "autenticacao", "usuarioServico", "operacao", "sistema", "unidade", "dataHora"})
public class Header {

    private String versao;
    private String autenticacao;
    private String usuarioServico;
    private OperacaoEnum operacao;
    private SistemaEnum sistema;
    private String unidade;
    private Date dataHora;

    public Header() {
    }

    public Header(String versao, String autenticacao, String usuarioServico, OperacaoEnum operacao, SistemaEnum sistema, String unidade, Date dataHora) {
        this.versao = versao;
        this.autenticacao = autenticacao;
        this.usuarioServico = usuarioServico;
        this.operacao = operacao;
        this.sistema = sistema;
        this.unidade = unidade;
        this.dataHora = dataHora;
    }

    @XmlElement(name = "VERSAO")
    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    @XmlElement(name = "AUTENTICACAO")
    public String getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(String autenticacao) {
        this.autenticacao = autenticacao;
    }

    @XmlElement(name = "USUARIO_SERVICO")
    public String getUsuarioServico() {
        return usuarioServico;
    }

    public void setUsuarioServico(String usuarioServico) {
        this.usuarioServico = usuarioServico;
    }

    @XmlElement(name = "OPERACAO")
    public OperacaoEnum getOperacao() {
        return operacao;
    }

    public void setOperacao(OperacaoEnum operacao) {
        this.operacao = operacao;
    }

    @XmlElement(name = "SISTEMA_ORIGEM")
    public SistemaEnum getSistema() {
        return sistema;
    }

    public void setSistema(SistemaEnum sistema) {
        this.sistema = sistema;
    }

    @XmlElement(name = "UNIDADE")
    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @XmlElement(name = "DATA_HORA")
    public String getDataHora() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(dataHora);
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

}
