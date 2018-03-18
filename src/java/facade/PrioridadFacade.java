/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidad.Prioridad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author samuel
 */
@Stateless
public class PrioridadFacade extends AbstractFacade<Prioridad> {

    @PersistenceContext(unitName = "qmanagementPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrioridadFacade() {
        super(Prioridad.class);
    }
    
}
