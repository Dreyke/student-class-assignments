package com.dreyke.studentclassassignments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {

    @Autowired
    private CoursesService coursesService;

    @RequestMapping(value = "/")
    public String courseList(Model model) {
        model.addAttribute("courseList", coursesService.findAll());
        return "courseList";
    }

    @RequestMapping(value={"/courseEdit", "/courseEdit/{id}"}, method = RequestMethod.GET)
    public String courseEditForm(Model model, @PathVariable(required = false, name="id") Long id) {
        if (null != id) {
            model.addAttribute("courses", coursesService.findById(id));
        } else {
            model.addAttribute("courses", new Course());
        }
        return "courseEdit";
    }

    @RequestMapping(value="/courseEdit", method = RequestMethod.POST)
    public String courseEdit(Model model, Course course) {
        coursesService.saveCourse(course);
        model.addAttribute("courseList", coursesService.findAll());
        return "courseList";
    }

    @RequestMapping(value="/courseDelete/{id}", method = RequestMethod.GET)
    public String courseDelete(Model model, @PathVariable(required = true, name = "id") Long id) {
        coursesService.deleteCourse(id);
        model.addAttribute("notesList", coursesService.findAll());
        return "courseList";
    }

}
