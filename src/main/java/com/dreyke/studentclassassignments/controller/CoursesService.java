package com.dreyke.studentclassassignments.controller;

import java.util.List;
import com.dreyke.studentclassassignments.controller.Course;

/* interface to retrieve course objects
 * retrieve course objects by id
  * save objects based on create/edit
  * delete objects from database*/
public interface CoursesService {

    List<Course> findAll();

    Course findOne(Long id);

    Course saveCourse(Course course);

    void deleteCourse(Long id);

}
