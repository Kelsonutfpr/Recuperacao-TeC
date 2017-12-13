/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Kelson
 */
@ManagedBean
@RequestScoped
public class JsfCategoria {

    private int idcategoria;
    private String descricao;

    public void persist() {
        br.data.entity.Categoria c = new br.data.entity.Categoria();
        c.setIdcategoria(idcategoria);
        c.setDescricao(descricao);
        new br.data.crud.CrudCategoria().persist(c);
        this.descricao = "";
        this.idcategoria = 0;
    }

    public java.util.Collection<br.data.entity.Categoria> getAll() {
        return new br.data.crud.CrudCategoria().getAll();
    }

    public void remove(br.data.entity.Categoria cat) {
        new br.data.crud.CrudCategoria().remove(cat);
    }

    public String update(br.data.entity.Categoria cat) {
        this.idcategoria = cat.getIdcategoria();
        this.descricao = cat.getDescricao();
        return "merge.xhtml";
    }

    public void merge() {
        br.data.entity.Categoria cat = new br.data.entity.Categoria();
        cat.setIdcategoria(idcategoria);
        cat.setDescricao(descricao);
        new br.data.crud.CrudCategoria().merge(cat);
        this.descricao = "";
        this.idcategoria = 0;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
