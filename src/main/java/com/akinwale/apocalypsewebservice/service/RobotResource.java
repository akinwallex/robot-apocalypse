/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.akinwale.apocalypsewebservice.service;

import com.akinwale.apocalypsewebservice.entity.Robot;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.json.JsonArray;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author hp 1030 g2
 */
@Stateless
public class RobotResource implements RobotResourceLocal {
    private static final String URI_STRING = 
                "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";
    @Override
    public Response getRobotList(int startIndex, Long size) {
        List<Robot> robotList;
        Response response = null;
        try{
            robotList = getRobotList();
            if(robotList.isEmpty())
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            response = Response.ok(robotList).build();
        }catch(JsonProcessingException ex){
            Logger.getLogger(RobotResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
    
    @Override
    public  List<Robot> getRobotList()throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Robot> robots = new ArrayList<>();
        Client client = ClientBuilder.newClient()
                .property("connection.timeout", 100);
        WebTarget target = client.target(URI_STRING);
        JsonArray response = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
        for (JsonValue robot : response) {
            robots.add(objectMapper.readValue(((JsonString)robot).getString(),Robot.class));
        }
        return robots;
    }
}
