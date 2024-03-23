package com.politech.fsptenders.parser.controller;

import com.politech.fsptenders.parser.service.TenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CourseParsingController
 *
 */
@RestController
@RequiredArgsConstructor
public class ParsingController {

    private final TenderService tenderService;

    /**
     * Возвращает список курсов
     *
     * @return список курсов
     */
    @GetMapping(value = "/getCourse")
    public String getListInformation() {
        return tenderService.findCourseInfo().toString();
    }
}
