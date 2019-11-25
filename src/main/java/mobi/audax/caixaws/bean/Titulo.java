/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import mobi.audax.caixaws.enumm.AceiteEnum;

/**
 *
 * @author links
 */
@XmlType(propOrder = {"nossoNumero", "numeroDocumento", "dataVencimento", "valor",
    "tipoEspecie", "aceite", "dataEmissao", "jurosMora", "valorAbatimento", "posVencimento",
    "codigoMoeda", "pagador", "multa", "desconto", "fichaCompensacao", "reciboPagador", "pagamento"})
public class Titulo {

    private String nossoNumero;
    private String numeroDocumento;
    private String dataVencimento;
    private String valor;
    private String tipoEspecie;
    private AceiteEnum aceite;
    private String dataEmissao;
    private JurosMora jurosMora;
    private String valorAbatimento;
    private PosVencimento posVencimento;
    private int codigoMoeda;
    private Pagador pagador;
    private Multa multa;
    private Desconto desconto;
    private FichaCompensacao fichaCompensacao;
    private ReciboPagador reciboPagador;
    private Pagamento pagamento;

    @XmlElement(name = "NOSSO_NUMERO")
    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    @XmlElement(name = "NUMERO_DOCUMENTO")
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @XmlElement(name = "DATA_VENCIMENTO")
    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @XmlElement(name = "VALOR")
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @XmlElement(name = "TIPO_ESPECIE")
    public String getTipoEspecie() {
        return tipoEspecie;
    }

    public void setTipoEspecie(String tipoEspecie) {
        this.tipoEspecie = tipoEspecie;
    }

    @XmlElement(name = "FLAG_ACEITE")
    public AceiteEnum getAceite() {
        return aceite;
    }

    public void setAceite(AceiteEnum aceite) {
        this.aceite = aceite;
    }

    @XmlElement(name = "DATA_EMISSAO")
    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    @XmlElement(name = "JUROS_MORA")
    public JurosMora getJurosMora() {
        return jurosMora;
    }

    public void setJurosMora(JurosMora jurosMora) {
        this.jurosMora = jurosMora;
    }

    @XmlElement(name = "VALOR_ABATIMENTO")
    public String getValorAbatimento() {
        return valorAbatimento;
    }

    public void setValorAbatimento(String valorAbatimento) {
        this.valorAbatimento = valorAbatimento;
    }

    @XmlElement(name = "POS_VENCIMENTO")
    public PosVencimento getPosVencimento() {
        return posVencimento;
    }

    public void setPosVencimento(PosVencimento posVencimento) {
        this.posVencimento = posVencimento;
    }

    @XmlElement(name = "CODIGO_MOEDA")
    public int getCodigoMoeda() {
        return codigoMoeda;
    }

    public void setCodigoMoeda(int codigoMoeda) {
        this.codigoMoeda = codigoMoeda;
    }

    @XmlElement(name = "PAGADOR")
    public Pagador getPagador() {
        return pagador;
    }

    public void setPagador(Pagador pagador) {
        this.pagador = pagador;
    }

    @XmlElement(name = "MULTA")
    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    @XmlElement(name = "DESCONTOS")
    public Desconto getDesconto() {
        return desconto;
    }

    public void setDesconto(Desconto desconto) {
        this.desconto = desconto;
    }

    @XmlElement(name = "FICHA_COMPENSACAO")
    public FichaCompensacao getFichaCompensacao() {
        return fichaCompensacao;
    }

    public void setFichaCompensacao(FichaCompensacao fichaCompensacao) {
        this.fichaCompensacao = fichaCompensacao;
    }

    @XmlElement(name = "RECIBO_PAGADOR")
    public ReciboPagador getReciboPagador() {
        return reciboPagador;
    }

    public void setReciboPagador(ReciboPagador reciboPagador) {
        this.reciboPagador = reciboPagador;
    }

    @XmlElement(name = "PAGAMENTO")
    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

}
