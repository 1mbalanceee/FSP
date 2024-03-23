package com.politech.fsptenders.parser.service;

import com.politech.fsptenders.parser.dto.TenderDtoOnce;
import com.politech.fsptenders.parser.service.TenderClient;
import com.politech.fsptenders.parser.repository.TenderEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс CourseService - бизнес логика проекта
 */
@Service
@RequiredArgsConstructor
public class TenderService {

    private final TenderEntityRepository courseEntityRepository;
    private final TenderClient courseClient;

    public List<TenderDtoOnce> findCourseInfo(){
        return courseEntityRepository.saveAll(courseClient.getCourses());
    }
}