package com.app.tutorial.springbootschoolwebonetomany_manytoone.controller;

import com.app.tutorial.springbootschoolwebonetomany_manytoone.model.Person;
import com.app.tutorial.springbootschoolwebonetomany_manytoone.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class DashboardController {

    private final PersonRepository personRepository;

    @Autowired
    public DashboardController (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
    public String displayDashboard(Model model, Authentication authentication, HttpSession httpSession) {
        Person person = personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        httpSession.setAttribute("loggedinperson", person);
        return "dashboard.html";
    }

}
