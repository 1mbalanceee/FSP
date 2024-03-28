package com.politech.fsptenders.parser.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * CourseDtoOnce - модель единичного элемента списка валют
 *
 * @author max
 */
@Entity
@XmlRootElement(name = "Valute")
@XmlAccessorType(XmlAccessType.FIELD)
public class TenderDtoOnce implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @XmlElement(name = "NumCode")
    private String numCode;

    @XmlElement(name = "CharCode")
    private String charCode;

    @XmlElement(name = "Nominal")
    private int nominal;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Value")
    @JsonIgnore
    @Transient
    private String _Value;

    private double value;

    public String get_Value() {
        return _Value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "\n" + name + " (" +
                "numCode = " + numCode + ", " +
                "charCode = " + charCode + ", " +
                "nominal = " + nominal + ", " +
                "value = " + value + ")";
    }
}