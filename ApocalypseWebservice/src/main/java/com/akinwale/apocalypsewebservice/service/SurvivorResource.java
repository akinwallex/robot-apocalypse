/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.akinwale.apocalypsewebservice.service;

import com.akinwale.apocalypsewebservice.entity.Location;
import com.akinwale.apocalypsewebservice.entity.Report;
import com.akinwale.apocalypsewebservice.entity.Survivor;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author hp 1030 g2
 */
@Stateless
public class SurvivorResource implements SurvivorResourceLocal {

    @EJB
    private RobotResourceLocal robotResource;

    @PersistenceContext(unitName = "ApocalypseWebservice_PU")
    private EntityManager em;
    

    @Override
    public Response addSurvivor(Survivor survivor) {
        em.persist(survivor);
        return Response.created(URI.create("/survivors/"+survivor.getId())).build();
    }

    @Override
    public Response updateSurvivorLocation(Long id,Location location) {
        Survivor survivor = em.find(Survivor.class, id);
        if(survivor == null)
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        survivor.setLocation(location);
        return Response.accepted().build();
    }

    @Override
    public Response flagSurvivorInfected(Long id, boolean infected) {
        Survivor survivor = em.find(Survivor.class, id);
        if(survivor == null)
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        survivor.setInfected(infected);
        return Response.accepted().build();
    }

    @Override
    public Response reports() {
        
        TypedQuery<Survivor> infectedSurvQuery = em.createQuery(
                "SELECT s FROM Survivor s WHERE s.infected==true", Survivor.class);
        TypedQuery<Survivor> nonInfectedSurvQuery = em.createQuery(
                "SELECT s FROM Survivor s WHERE s.infected==false", Survivor.class);
        TypedQuery<Survivor> allSurvQuery = em.createQuery(
                "SELECT s FROM Survivor s", Survivor.class);
        
        
        long allSurvivorCount = allSurvQuery.getMaxResults();
        long infectedSurvCount = infectedSurvQuery.getMaxResults();
        long nonInfectedSurvCount = nonInfectedSurvQuery.getMaxResults();
        
        
        
        Report report = new Report();
        report.setInfectedSurvivorPercent(
                (infectedSurvCount/allSurvivorCount)*100);
        report.setNonInfectedSurvivorPercent(
                (nonInfectedSurvCount/allSurvivorCount)*100);
        report.setInfectedSurvivors(
                infectedSurvQuery.getResultList());
        report.setNonInfectedSurvivors(
                nonInfectedSurvQuery.getResultList());
        try {
            //set robot list
            report.setRobots(robotResource.getRobotList());
        } catch (JsonProcessingException ex) {
            Logger.getLogger(SurvivorResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(report).build();
    }

    @Override
    public Response getSurvivor(Long id) {
        Survivor survivor = em.find(Survivor.class, id);
        if(survivor == null)
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        return Response.ok(survivor).build();
    }

    // pageIndex is zero based
    @Override
    public Response getSurvivorList(int pageIndex, int size) {
        TypedQuery<Survivor> pagedQuery = em.createQuery("SELECT s FROM Survivor s", Survivor.class);
        List<Survivor> survivors = new ArrayList<>();
        Survivor[] survivorArray = {};
        if(size <= 0){
            survivors = em.createQuery("SELECT s FROM Survivor s", Survivor.class).getResultList();
        }else if(size >0){
            int count = pagedQuery.getMaxResults();
            survivors = pagedQuery.setFirstResult(pageIndex * size)
                .setMaxResults(size)
                .getResultList();
        }
        return Response.ok(survivors.toArray(survivorArray)).build();
    }

    //needed for paging the survivor list
    @Override
    public Response getSurvivorCount() {
        String count = Integer.toString(em.createQuery("SELECT s FROM Survivor s", Survivor.class).getMaxResults());
        return Response.ok(count).build();
    }
    
    
    
}
