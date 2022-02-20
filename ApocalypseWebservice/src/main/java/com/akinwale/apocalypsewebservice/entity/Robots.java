/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.akinwale.apocalypsewebservice.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp 1030 g2
 */
@XmlRootElement(name="robot")
@XmlAccessorType(XmlAccessType.FIELD)
public class Robots {
    @XmlElement(name = "robot")
    private List<Robots> robots;

    public List<Robots> getRobots() {
        return robots;
    }

    public void setRobots(List<Robots> robots) {
        this.robots = robots;
    }
    
}
