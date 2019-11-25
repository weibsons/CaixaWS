/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.restful.model;

import mobi.audax.caixaws.util.Util;

/**
 *
 * @author links
 */
public class Mensagem {

    private String mensagem;

    public String getMensagem() {
        return Util.unaccent(mensagem);
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
