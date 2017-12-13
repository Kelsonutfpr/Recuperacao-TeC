/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Pessoa;
import java.text.Normalizer;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Kelson
 */
public class CrudPessoa extends AbstractCrud<br.data.entity.Pessoa> {

    private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudPessoa() {
        super(Pessoa.class);
    }

    public Collection<Pessoa> SelectByNome(String desc) {
        try {
            desc = Normalizer.normalize(desc, Normalizer.Form.NFD);
            desc = desc.replaceAll("[^\\p{ASCII}]", "");
            return getEntityManager().createNamedQuery("Pessoa.findByNome").setParameter("nome", "%" + desc.toUpperCase() + "%").getResultList();
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
