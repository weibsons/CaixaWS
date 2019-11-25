/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import mobi.audax.caixaws.enumm.TipoPagamentoEnum;

/**
 *
 * @author links
 */
@XmlType(propOrder = {"quantidade", "tipoPagamento", "valorMinimo", "valorMaximo"})
public class Pagamento {

    private int quantidade;
    private TipoPagamentoEnum tipoPagamento;
    private BigDecimal valorMinimo;
    private BigDecimal valorMaximo;

    public Pagamento() {
    }

    public Pagamento(int quantidade, TipoPagamentoEnum tipoPagamento) {
        this.quantidade = quantidade;
        this.tipoPagamento = tipoPagamento;
    }

    public Pagamento(int quantidade, TipoPagamentoEnum tipoPagamento, BigDecimal valorMinimo, BigDecimal valorMaximo) {
        this.quantidade = quantidade;
        this.tipoPagamento = tipoPagamento;
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
    }

    @XmlElement(name = "QUANTIDADE_PERMITIDA")
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @XmlElement(name = "TIPO")
    public TipoPagamentoEnum getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamentoEnum tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @XmlElement(name = "VALOR_MINIMO")
    public BigDecimal getValorMinimo() {
        if (valorMinimo == null) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
        }
        return valorMinimo.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setValorMinimo(BigDecimal valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    @XmlElement(name = "VALOR_MAXIMO")
    public BigDecimal getValorMaximo() {
        if (valorMaximo == null) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
        }
        return valorMaximo.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setValorMaximo(BigDecimal valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

}
