/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author glorfindel
 */
@Local
public interface AdherentFacadeLocal {

    void create(Adherent adherent);

    void edit(Adherent adherent);

    void remove(Adherent adherent);

    Adherent find(Object id);

    List<Adherent> findAll();

    List<Adherent> findRange(int[] range);

    int count();
    
}
