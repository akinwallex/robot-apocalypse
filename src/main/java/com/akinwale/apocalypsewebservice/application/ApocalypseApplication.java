/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.akinwale.apocalypsewebservice.application;

import com.akinwale.apocalypsewebservice.service.RobotResource;
import com.akinwale.apocalypsewebservice.service.SurvivorResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author hp 1030 g2
 */
@ApplicationPath("/apocalypse")
public class ApocalypseApplication extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>();
        set.add(SurvivorResource.class);
        set.add(RobotResource.class);
        return set;
    }
}
