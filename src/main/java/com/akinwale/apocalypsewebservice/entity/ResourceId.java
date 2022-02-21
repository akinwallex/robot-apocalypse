/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.akinwale.apocalypsewebservice.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author hp 1030 g2
 */
public class ResourceId implements Serializable{
    private Long survivor;
    private ResourceType type;

    public Long getSurvivor() {
        return survivor;
    }

    public ResourceType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.survivor);
        hash = 53 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResourceId other = (ResourceId) obj;
        if (!Objects.equals(this.survivor, other.survivor)) {
            return false;
        }
        return this.type == other.type;
    }
    
}
