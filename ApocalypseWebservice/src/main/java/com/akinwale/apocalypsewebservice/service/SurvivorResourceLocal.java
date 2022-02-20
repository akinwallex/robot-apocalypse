/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.akinwale.apocalypsewebservice.service;

import com.akinwale.apocalypsewebservice.entity.Location;
import com.akinwale.apocalypsewebservice.entity.Survivor;
import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author akinwale akinpelu
 */
@Local
@Path("/survivors")
public interface SurvivorResourceLocal {

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_XML)
    public Response addSurvivor(Survivor survivor);
    
    @PUT
    @Path("/{id}/location")
    @Consumes(MediaType.APPLICATION_XML)
    public Response updateSurvivorLocation(@PathParam("id") Long id,Location location);
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response flagSurvivorInfected(@PathParam("id")Long id, @QueryParam("infected")boolean infected);

    @GET
    @Path("/search/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getSurvivor(@PathParam("id")Long id);

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/search")                // pageIndex is zero based
    public Response getSurvivorList(@QueryParam("pageIndex")int pageIndex, @QueryParam("size")int size);
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/reports")
    public Response reports();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/count")
    public Response getSurvivorCount();
    
}
