/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.akinwale.apocalypsewebservice.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 *
 * @author hp 1030 g2
 */
@XmlEnum
public enum Resource {
    @XmlEnumValue(value = "water")
    WATER,
    @XmlEnumValue(value = "food")
    FOOD,
    @XmlEnumValue(value = "medication")
    MEDICATION,
    @XmlEnumValue(value = "ammunition")
    AMMUNITION;
}
