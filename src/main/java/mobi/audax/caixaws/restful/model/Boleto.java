/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.restful.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import mobi.audax.caixaws.enumm.TipoPagamentoEnum;
import mobi.audax.caixaws.util.Util;

/**
 *
 * @author links
 */
public class Boleto {

    private String agencia;
    private String codigoBeneficiario;
    private String cpfCnpjBeneficiario;
    private String nossoNumero;
    private String numeroDocumento;
    private Date vencimento;
    private BigDecimal valor;
    private boolean aceite;
    private Juros juros;
    private PosVencimento posVencimento;
    private List<Mensagem> fichaCompensacao;
    private List<Mensagem> reciboPagador;

    private String cpfPagador;
    private String nomePagador;

    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    private int quantidade;
    private TipoPagamentoEnum tipoPagamento;

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getCodigoBeneficiario() {
        return codigoBeneficiario;
    }

    public void setCodigoBeneficiario(String codigoBeneficiario) {
        this.codigoBeneficiario = codigoBeneficiario;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public BigDecimal getValor() {
        return valor.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public boolean isAceite() {
        return aceite;
    }

    public void setAceite(boolean aceite) {
        this.aceite = aceite;
    }

    public Juros getJuros() {
        return juros;
    }

    public void setJuros(Juros juros) {
        this.juros = juros;
    }

    public PosVencimento getPosVencimento() {
        return posVencimento;
    }

    public void setPosVencimento(PosVencimento posVencimento) {
        this.posVencimento = posVencimento;
    }

    public List<Mensagem> getFichaCompensacao() {
        return fichaCompensacao;
    }

    public void setFichaCompensacao(List<Mensagem> fichaCompensacao) {
        this.fichaCompensacao = fichaCompensacao;
    }

    public List<Mensagem> getReciboPagador() {
        return reciboPagador;
    }

    public void setReciboPagador(List<Mensagem> reciboPagador) {
        this.reciboPagador = reciboPagador;
    }

    public String getCpfCnpjBeneficiario() {
        return Util.onlyNumber(cpfCnpjBeneficiario);
    }

    public void setCpfCnpjBeneficiario(String cpfCnpjBeneficiario) {
        this.cpfCnpjBeneficiario = cpfCnpjBeneficiario;
    }

    public String getCpfPagador() {
        return cpfPagador;
    }

    public void setCpfPagador(String cpfPagador) {
        this.cpfPagador = cpfPagador;
    }

    public String getNomePagador() {
        return Util.unaccent(nomePagador);
    }

    public void setNomePagador(String nomePagador) {
        this.nomePagador = nomePagador;
    }

    public String getEndereco() {
        return Util.alphanumeric(Util.unaccent(endereco));
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return Util.unaccent(bairro);
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return Util.unaccent(cidade);
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return Util.unaccent(uf);
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return Util.onlyNumber(cep);
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public TipoPagamentoEnum getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamentoEnum tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

}
