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
public class GenreFacade extends AbstractFacade<Genre> implements GenreFacadeLocal {

    @PersistenceContext(unitName = "mediatheque-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GenreFacade() {
        super(Genre.class);
    }
    
}
