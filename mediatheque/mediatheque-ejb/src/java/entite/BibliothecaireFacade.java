/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    public void remove(int id) {
        /*Query query = em.createQuery("DELETE FROM Bibliothecaire b WHERE b.bibliothecaireId = :idb");
         query.setParameter("idb", id);
         query.executeUpdate();*/
        Personne p = em.getReference(Personne.class, id);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        /*em.getTransaction().begin();
        Bibliothecaire b = em.find(Bibliothecaire.class, id);
        Personne p = em.find(Personne.class, id);
        Bibliothecaire tmpb = em.merge(b);
        Personne tmpp = em.merge(p);
        em.remove(tmpb);
        em.remove(tmpp);
        em.joinTransaction();
        em.flush();
        em.getTransaction().commit();*/
        
    }

}
