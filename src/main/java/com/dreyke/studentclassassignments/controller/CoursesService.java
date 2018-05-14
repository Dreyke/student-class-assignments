package com.dreyke.studentclassassignments.controller;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* interface to retrieve course objects
 * retrieve course objects by id
  * save objects based on create/edit
  * delete objects from database*/
@Service("courseRepository")
public interface CoursesService {

    List<Course> findAll();

    Optional<Course> findById(Long id);

    Course saveCourse(Course course);

    void deleteCourse(Long id);

}
