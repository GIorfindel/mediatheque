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
public interface EmprunteFacadeLocal {

    void create(Emprunte emprunte);

    void edit(Emprunte emprunte);

    void remove(Emprunte emprunte);

    Emprunte find(Object id);

    List<Emprunte> findAll();

    List<Emprunte> findRange(int[] range);

    int count();
    
}
