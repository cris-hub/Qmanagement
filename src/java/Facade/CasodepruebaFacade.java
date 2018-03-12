/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidad.Casodeprueba;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dell
 */
@Stateless
public class CasodepruebaFacade extends AbstractFacade<Casodeprueba> {

    @PersistenceContext(unitName = "QManagementPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CasodepruebaFacade() {
        super(Casodeprueba.class);
    }
    
}
