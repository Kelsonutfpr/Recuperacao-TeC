/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.all", query = "SELECT c FROM Categoria c")
   ,@NamedQuery(name="Categoria.findDesc", query="SELECT c FROM Categoria c WHERE UPPER(FUNCTION('TRANSLATE', c.descricao, 'ÁÀÃÂÄáàãâäÍÌÏíìïÚÙÜúùüÉÈÊËéèêëÓÒÕÔÖóòõôöÇç', 'AAAAAaaaaaIIIiiiUUUuuuEEEEeeeeOOOOOoooooCc')) LIKE :descricao")
})

public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcategoria")
    private Integer idcategoria;
    @Size(max = 20)
    @Column(name = "descricao")
    private String descricao;

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
