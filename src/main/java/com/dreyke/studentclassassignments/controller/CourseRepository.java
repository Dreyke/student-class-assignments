package com.dreyke.studentclassassignments.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dreyke.studentclassassignments.controller.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Modifying
    @Query("delete from Course where id = :id")
    void delete(Long id);
}
