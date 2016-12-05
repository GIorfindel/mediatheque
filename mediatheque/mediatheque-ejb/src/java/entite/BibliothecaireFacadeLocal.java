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
public interface BibliothecaireFacadeLocal {

    void create(Bibliothecaire bibliothecaire);

    void edit(Bibliothecaire bibliothecaire);

    void remove(Bibliothecaire bibliothecaire);
    
    void remove(int id);

    Bibliothecaire find(Object id);

    List<Bibliothecaire> findAll();

    List<Bibliothecaire> findRange(int[] range);

    int count();

}
