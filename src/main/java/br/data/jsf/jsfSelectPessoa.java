/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.jsf;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Kelson
 */
@ManagedBean
@RequestScoped
public class jsfSelectPessoa {

    private int idPessoa;
    private String nome;
    private char sexo;
    private Date dataNasc;
    private int fkcategoria;

    public java.util.Collection<br.data.entity.Pessoa> getSelect() {
        return new br.data.crud.CrudPessoa().SelectByNome(this.nome);
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getFkcategoria() {
        return fkcategoria;
    }

    public void setFkcategoria(int fkcategoria) {
        this.fkcategoria = fkcategoria;
    }

}
