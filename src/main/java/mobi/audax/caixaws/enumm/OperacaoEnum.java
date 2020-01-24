/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.enumm;

/**
 *
 * @author links
 */
public enum OperacaoEnum {

    INCLUI_BOLETO("IncluiBoleto"),
    BAIXA_BOLETO("AlteraBoleto");
//    ALTERA_BOLETO("BaixaBoleto");

    private final String operacao;

    private OperacaoEnum(String operacao) {
        this.operacao = operacao;
    }

    public String getOperacao() {
        return operacao;
    }

}
