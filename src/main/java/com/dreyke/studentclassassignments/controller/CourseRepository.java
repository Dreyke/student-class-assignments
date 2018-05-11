package com.dreyke.studentclassassignments.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dreyke.studentclassassignments.controller.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    void delete(Long id);
}
