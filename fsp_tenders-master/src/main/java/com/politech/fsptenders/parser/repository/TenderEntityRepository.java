package com.politech.fsptenders.parser.repository;

import com.politech.fsptenders.parser.dto.TenderDtoOnce;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CourseEntityRepository - класс с базовыми методами
 */
public interface TenderEntityRepository extends JpaRepository<TenderDtoOnce, Long> {
}