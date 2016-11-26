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
public interface EditionFacadeLocal {

    void create(Edition edition);

    void edit(Edition edition);

    void remove(Edition edition);

    Edition find(Object id);

    List<Edition> findAll();

    List<Edition> findRange(int[] range);

    int count();
    
}
