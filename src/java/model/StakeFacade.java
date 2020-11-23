/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Stake;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Zana
 */
@Stateless
public class StakeFacade extends AbstractFacade<Stake> implements StakeFacadeLocal {

    @PersistenceContext(unitName = "RecruitmentTaskPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public StakeFacade() {
        super(Stake.class);
    }
    
}
