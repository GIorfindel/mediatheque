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
public class PersonneFacade extends AbstractFacade<Personne> implements PersonneFacadeLocal {

    @PersistenceContext(unitName = "mediatheque-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonneFacade() {
        super(Personne.class);
    }

    //On créer une fonction create avec un bibliothécaire en paramètre pour pour pouvoir le lier à la personne
    public void create(Personne p, Bibliothecaire b) {
        em.persist(p);
        em.flush();
        b.setBibliothecaireId(p.getPersonneId());
        em.persist(b);
        em.flush();
    }
    
     //On créer une fonction create avec un adhérent en paramètre pour pour pouvoir le lier à la personne
     public void create(Personne p, Adherent a) {
        em.persist(p);
        em.flush();
        a.setAdherentId(p.getPersonneId());
        em.persist(a);
        em.flush();
    }
    //On créer une fonction create avec un auteur en paramètre pour pour pouvoir le lier à la personne
    public void create(Personne p, Auteur a) {
        em.persist(p);
        em.flush();
        a.setAuteurId(p.getPersonneId());
        em.persist(a);
        em.flush();
    }

}
