package com.dreyke.studentclassassignments.service;

import com.dreyke.studentclassassignments.controller.CoursesService;
import com.dreyke.studentclassassignments.controller.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dreyke.studentclassassignments.controller.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service("coursesService")
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.delete(id);
    }

}
