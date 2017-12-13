/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")
    ,@NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE UPPER(FUNCTION('TRANSLATE', p.nome, 'ÁÀÃÂÄáàãâäÍÌÏíìïÚÙÜúùüÉÈÊËéèêëÓÒÕÔÖóòõôöÇç', 'AAAAAaaaaaIIIiiiUUUuuuEEEEeeeeOOOOOoooooCc')) LIKE :nome")})

public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpessoa")
    private Integer idpessoa;

    @Size(max = 50)
    @Column(name = "nome")
    private String nome;

    @Column(name = "sexo")
    private char sexo;

    @Column(name = "dataNasc")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNasc;

    @Column(name = "fkcategoria")
    private int fkcategoria;

    public Pessoa() {
    }

    public Integer getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Integer idpessoa) {
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
