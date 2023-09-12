package com.app.tutorial.springbootschoolweblogging.controller;

import com.app.tutorial.springbootschoolweblogging.model.Person;
import com.app.tutorial.springbootschoolweblogging.repository.CoursesRepository;
import com.app.tutorial.springbootschoolweblogging.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("student")
public class StudentController {

    private final PersonRepository personRepository;
    private final CoursesRepository coursesRepository;

    @Autowired
    public StudentController(PersonRepository personRepository,  CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/displayCourses", method = {RequestMethod.GET})
    public ModelAndView displayCourses (Model model, HttpSession httpSession) {
        Person person = (Person) httpSession.getAttribute("loggedinperson");
        ModelAndView modelAndView = new ModelAndView("courses.enrolled.html");
        modelAndView.addObject("person", person);
        return modelAndView;
    }
}
