/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.jsf;

import br.data.entity.Pessoa;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Kelson
 */
@ManagedBean
@RequestScoped
public class JsfPessoa {

    private int idpessoa;
    private String nome;
    private char sexo;
    private Date dataNasc;
    private int fkcategoria;

    public JsfPessoa() {

    }

    public void persist() {
        Pessoa p = new Pessoa();
        p.setIdpessoa(idpessoa);
        p.setNome(nome);
        p.setSexo(sexo);
        p.setDataNasc(dataNasc);
        p.setFkcategoria(fkcategoria);
        new br.data.crud.CrudPessoa().persist(p);
        this.nome = "";
        this.idpessoa = 0;
        this.dataNasc = null;
        this.fkcategoria = 0;

    }

    public void remove(br.data.entity.Pessoa p) {
        new br.data.crud.CrudPessoa().remove(p);
    }

    public java.util.Collection<br.data.entity.Pessoa> getAll() {
        return new br.data.crud.CrudPessoa().getAll();
    }

    public String update(br.data.entity.Pessoa p) {
        this.idpessoa = p.getIdpessoa();
        this.nome = p.getNome();
        this.sexo = p.getSexo();
        this.dataNasc = p.getDataNasc();
        this.fkcategoria = p.getFkcategoria();
        return "merge.xhtml";

    }

    public void merge() {
        br.data.entity.Pessoa p = new br.data.entity.Pessoa();
        p.setIdpessoa(this.idpessoa);
        p.setNome(this.nome);
        p.setSexo(this.sexo);
        p.setDataNasc(this.dataNasc);
        p.setFkcategoria(this.fkcategoria);
        new br.data.crud.CrudPessoa().merge(p);
        this.idpessoa = 0;
        this.nome = "";
        this.sexo = 0;
        this.fkcategoria = 0;
        this.dataNasc = null;
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

}
