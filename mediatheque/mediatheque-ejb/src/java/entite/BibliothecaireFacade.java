/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author glorfindel
 */
@Stateless
public class BibliothecaireFacade extends AbstractFacade<Bibliothecaire> implements BibliothecaireFacadeLocal {

    @PersistenceContext(unitName = "mediatheque-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BibliothecaireFacade() {
        super(Bibliothecaire.class);
    }


}
