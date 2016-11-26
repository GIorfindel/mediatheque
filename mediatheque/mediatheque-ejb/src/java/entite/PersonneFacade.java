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

    public void create(Personne p, Bibliothecaire b) {
        //String s = "insert into Personne(nom,prenom,telephone,adresse_id) ";
        //s = s + "values ('" + p.getNom() + "'," + p.getPrenom() + ",";
        //s = s + p.getTelephone() + ",'" + p.getAdresseId() + "')";
        //em.createNativeQuery(s).executeUpdate();
        em.persist(p);
        em.flush();
        b.setBibliothecaireId(p.getPersonneId());
        em.persist(b);
        em.flush();
    }

}
