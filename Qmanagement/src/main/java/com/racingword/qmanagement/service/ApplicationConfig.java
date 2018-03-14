/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.racingword.qmanagement.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author SMEGS
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.racingword.qmanagement.service.AccesoFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.AsignacionFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.CasodepruebaFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.ControlEjecucionFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.CoreFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.EjecucionFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.EscenarioFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.EstadoFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.EstadocasoFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.IncidenteFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.MotivocasoFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.NaturalezaFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.PrioridadFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.PrivacidadFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.RolFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.SeveridadFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.TipoFacadeREST.class);
        resources.add(com.racingword.qmanagement.service.UsuarioFacadeREST.class);
        resources.add(interceptor.NewJaxRsInterceptor.class);
    }
    
}
