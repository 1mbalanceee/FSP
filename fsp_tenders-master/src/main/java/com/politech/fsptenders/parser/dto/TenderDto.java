package com.politech.fsptenders.parser.dto;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * TenderDto - модель общего списка тендеров
 *
 * @author max
 */
@XmlRootElement(name = "TenderList")
@XmlAccessorType(XmlAccessType.FIELD)
public class TenderDto implements Serializable {

    @Getter
    @XmlElement(name = "Tender")
    private List<TenderDtoOnce> tenderList;
    @XmlElement(name = "Date")
    private LocalDate date;

    @Override
    public String toString() {
        return "TenderDto{" +
                "tenderList=" + tenderList +
                ", date=" + date +
                '}';
    }
}
