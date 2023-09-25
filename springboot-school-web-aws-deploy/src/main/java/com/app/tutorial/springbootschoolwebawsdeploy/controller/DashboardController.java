package com.app.tutorial.springbootschoolwebawsdeploy.controller;

import com.app.tutorial.springbootschoolwebawsdeploy.model.Person;
import com.app.tutorial.springbootschoolwebawsdeploy.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class DashboardController {

    private final PersonRepository personRepository;
    private final Environment environment;

    @Value("${successMsg}")
    private String successMsg;
    @Value("${defaultPageSize}")
    private int defaultPageSize;

    @Autowired
    public DashboardController (PersonRepository personRepository, Environment environment) {
        this.personRepository = personRepository;
        this.environment = environment;
    }

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
    public String displayDashboard(Model model, Authentication authentication, HttpSession httpSession) {
        Person person = personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        if (person.getSchoolClass() != null && person.getSchoolClass().getName() != null) {
            model.addAttribute("enrolledClass", person.getSchoolClass().getName());
        }
        httpSession.setAttribute("loggedinperson", person);
        logMessages();
        return "dashboard.html";
    }

    private void logMessages() {
        log.error("Error message from the Dashboard page");
        log.warn("Warning message from the Dashboard page");
        log.info("Info message from the Dashboard page");
        log.debug("Debug message from the Dashboard page");
        log.trace("Trace message from the Dashboard page");

        log.error("defaultPageSize: " + defaultPageSize);
        log.error("successMsg: " + successMsg);

        log.error("defaultPageSize with Environment: " + environment.getProperty("defaultPageSize"));
        log.error("successMsg with Environment: " + environment.getProperty("successMsg"));
        log.error("JAVA_HOME with Environment: " + environment.getProperty("JAVA_HOME"));

    }

}
