/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.akinwale.apocalypsewebservice.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp 1030 g2
 */
@Entity
@IdClass(value = ResourceId.class)
@XmlRootElement(name="resource")
@XmlAccessorType(XmlAccessType.FIELD)
public class Resource implements Serializable {
    
    @Id
    @ManyToOne
    @XmlTransient
    private Survivor survivor;
    
    @Id
    @Enumerated(EnumType.STRING)
    private ResourceType type;

    public Long getId() {
        return survivor.getId()+type.ordinal();
    }

    public Survivor getSurvivor() {
        return survivor;
    }

    public void setSurvivor(Survivor survivor) {
        this.survivor = survivor;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resource)) {
            return false;
        }
        Resource other = (Resource) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.akinwale.apocalypsewebservice.entity.Resource[ id=" + getId() + " ]";
    }
    
}
