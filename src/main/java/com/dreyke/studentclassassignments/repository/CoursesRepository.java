package com.dreyke.studentclassassignments.repository;

import com.dreyke.studentclassassignments.model.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoursesRepository extends PagingAndSortingRepository<Course, Long> {

}
