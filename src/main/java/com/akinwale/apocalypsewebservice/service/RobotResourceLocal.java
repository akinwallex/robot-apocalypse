/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.akinwale.apocalypsewebservice.service;

import com.akinwale.apocalypsewebservice.entity.Robot;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author hp 1030 g2
 */
@Local
@Path("/robots")
public interface RobotResourceLocal {

    @GET
    @Produces("application/xml")
    @Path("/search")
    public Response getRobotList(
            @QueryParam("startIndex")int startIndex,
            @QueryParam("size")Long size);
    public  List<Robot> getRobotList()throws JsonProcessingException;
    
}
