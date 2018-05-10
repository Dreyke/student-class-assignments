package com.dreyke.studentclassassignments.controller;

import com.dreyke.studentclassassignments.model.Course;
import com.dreyke.studentclassassignments.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CoursesController {

    private final CoursesRepository courses;

    @Autowired
    public CoursesController(CoursesRepository courses) {
        this.courses = courses;
    }

    @RequestMapping("/")
    public ModelAndView addCourse() {
        return new ModelAndView("createCourse.html", "course", new Course());
    }

    @RequestMapping(value="/addCourse", method=RequestMethod.POST)
    public RedirectView addNewCourse(Course course) {
        courses.save(course);
        return new RedirectView("/allCourses");
    }

    @RequestMapping("/allCourses")
    public ModelAndView allCourses(ModelMap modelMap){
        modelMap.addAttribute("courses", courses.findAll());
        return new ModelAndView("courseList.html", modelMap);
    }
}
