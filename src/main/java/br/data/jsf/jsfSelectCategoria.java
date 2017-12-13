package br.data.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kelson
 */
@ManagedBean
@RequestScoped
public class jsfSelectCategoria {

    private int idcategoria;
    private String descricao;

    public java.util.Collection<br.data.entity.Categoria> getSelect() {
        return new br.data.crud.CrudCategoria().SelectByDesc(this.descricao);
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
