/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Stake;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Zana
 */
@Local
public interface StakeFacadeLocal {

    void create(Stake stake);

    void edit(Stake stake);

    void remove(Stake stake);

    Stake find(Object id);

    List<Stake> findAll();

    List<Stake> findRange(int[] range);

    int count();
    
}
