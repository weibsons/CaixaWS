/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import mobi.audax.caixaws.util.Util;

/**
 *
 * @author links
 */
@XmlType(propOrder = {"cpf", "nome", "endereco"})
public class Pagador {

    private String cpf;
    private String nome;
    private Endereco endereco;

    public Pagador() {
    }

    public Pagador(String cpf, String nome, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    @XmlElement(name = "CPF")
    public String getCpf() {
        return Util.onlyNumber(cpf);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @XmlElement(name = "NOME")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlElement(name = "ENDERECO")
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
