/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.restful.model;

/**
 *
 * @author links
 */
public class BoletoResponse {

    private String linhaDigitavel;
    private String codigoBarras;
    private String url;

    public BoletoResponse() {
    }

    public BoletoResponse(String linhaDigitavel, String codigoBarras, String url) {
        this.linhaDigitavel = linhaDigitavel;
        this.codigoBarras = codigoBarras;
        this.url = url;
    }

    public String getLinhaDigitavel() {
        return linhaDigitavel;
    }

    public void setLinhaDigitavel(String linhaDigitavel) {
        this.linhaDigitavel = linhaDigitavel;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
