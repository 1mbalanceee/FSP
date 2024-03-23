package com.politech.fsptenders.parser.service;

import com.politech.fsptenders.parser.dto.TenderDto;
import com.politech.fsptenders.parser.dto.TenderDtoOnce;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Класс CourseClient - работа с внешним ресурсом, обработка и выдача результата
 */
@Component
public class TenderClient {
    public static final String URL = "https://cbr.ru/scripts/XML_daily.asp?date_req=23/01/2022.xml";

    final RestTemplate restTemplate = new RestTemplate();


    public List<TenderDtoOnce> getCourses() {
        TenderDto response = restTemplate.getForObject(URL, TenderDto.class);

        if (response != null) {
            response
                    .getValute()
                    .forEach(x -> {
                        x.setValue(Double.parseDouble(x.get_Value().replace(",", ".")));
                        System.out.println(x);
                    });

            return response.getValute();
        }

        return null;
    }
}
