package com.dreyke.studentclassassignments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {

    @Autowired
    private CoursesService coursesService;

    // uses findAll method to retrieve list of existing course objects from database
    // and pushes into the ModelMap
    @RequestMapping(value = "/")
    public String courseList(ModelMap model) {
        model.addAttribute("courseList", coursesService.findAll());
        return "courseList";
    }

    // populates form to create or edit a course object
    @RequestMapping(value={"/courseEdit", "/courseEdit/{id}"}, method = RequestMethod.GET)
    public String courseEditForm(ModelMap model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("courses", coursesService.findById(id));
        } else {
            model.addAttribute("courses", new Course());
        }
        return "courseEdit";
    }

    // method is invoked when form is being submitted.
    @RequestMapping(value="/courseEdit", method = RequestMethod.POST)
    public String courseEdit(ModelMap model, Course course) {
        coursesService.saveCourse(course);
        model.addAttribute("courseList", coursesService.findAll());
        return "courseList";
    }

    @RequestMapping(value="/courseDelete/{id}", method = RequestMethod.GET)
    public String courseDelete(ModelMap model, @PathVariable(required = true, name = "id") Long id) {
        coursesService.deleteCourse(id);
        model.addAttribute("notesList", coursesService.findAll());
        return "courseList";
    }

}
