package com.politech.fsptenders.parser.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * CourseDto - модель общего списка валют
 *
 * @author max
 */
@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class TenderDto implements Serializable {

    @XmlElement(name = "Valute")
    private List<TenderDtoOnce> valute;
    @XmlElement(name = "Date")
    private LocalDate date;

    public List<TenderDtoOnce> getValute() {
        return valute;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "valute=" + valute +
                ", date=" + date +
                '}';
    }
}
