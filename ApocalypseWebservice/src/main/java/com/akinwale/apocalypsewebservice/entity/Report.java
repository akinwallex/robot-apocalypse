/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.akinwale.apocalypsewebservice.entity;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp 1030 g2
 */
@XmlRootElement(name="report")
@XmlAccessorType(XmlAccessType.FIELD)
public class Report implements Serializable{
    private float infectedSurvivorPercent;
    private float nonInfectedSurvivorPercent;
    @XmlElementWrapper
    private List<Survivor> infectedSurvivors;
    @XmlElementWrapper
    private List<Survivor>  nonInfectedSurvivors;
    @XmlElementWrapper
    private List<Robot> robots;

    public float getInfectedSurvivorPercent() {
        return infectedSurvivorPercent;
    }

    public void setInfectedSurvivorPercent(float infectedSurvivorPercent) {
        this.infectedSurvivorPercent = infectedSurvivorPercent;
    }

    public float getNonInfectedSurvivorPercent() {
        return nonInfectedSurvivorPercent;
    }

    public void setNonInfectedSurvivorPercent(float nonInfectedSurvivorPercent) {
        this.nonInfectedSurvivorPercent = nonInfectedSurvivorPercent;
    }

    public List<Survivor>  getInfectedSurvivors() {
        return infectedSurvivors;
    }

    public void setInfectedSurvivors(List<Survivor>  infectedSurvivors) {
        this.infectedSurvivors = infectedSurvivors;
    }

    public List<Survivor>  getNonInfectedSurvivors() {
        return nonInfectedSurvivors;
    }

    public void setNonInfectedSurvivors(List<Survivor>  nonInfectedSurvivors) {
        this.nonInfectedSurvivors = nonInfectedSurvivors;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public void setRobots(List<Robot> robots) {
        this.robots = robots;
    }
    
    
}
