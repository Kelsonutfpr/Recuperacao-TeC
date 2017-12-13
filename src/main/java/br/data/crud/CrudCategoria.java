/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Categoria;
import java.text.Normalizer;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Kelson
 */
public class CrudCategoria extends AbstractCrud<br.data.entity.Categoria> {

    private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudCategoria() {
        super(Categoria.class);
    }

    public Collection<Categoria> SelectByDesc(String desc) {
        try {
            desc = Normalizer.normalize(desc, Normalizer.Form.NFD);
            desc = desc.replaceAll("[^\\p{ASCII}]", "");
            return getEntityManager().createNamedQuery("Categoria.findDesc").setParameter("descricao", "%" + desc.toUpperCase() + "%").getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(PU).createEntityManager();
        }
        return em;
    }

}
