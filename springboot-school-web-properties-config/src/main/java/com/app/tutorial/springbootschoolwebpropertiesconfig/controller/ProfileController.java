package com.app.tutorial.springbootschoolwebpropertiesconfig.controller;

import com.app.tutorial.springbootschoolwebpropertiesconfig.model.Address;
import com.app.tutorial.springbootschoolwebpropertiesconfig.model.Person;
import com.app.tutorial.springbootschoolwebpropertiesconfig.model.Profile;
import com.app.tutorial.springbootschoolwebpropertiesconfig.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ProfileController {

    private final PersonRepository personRepository;

    @Autowired
    public ProfileController (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/displayProfile", method = {RequestMethod.GET})
    public ModelAndView displayProfile(Model model, HttpSession httpSession) {
        Person person = (Person) httpSession.getAttribute("loggedinperson");
        Profile profile = new Profile();
        profile.setName(person.getName());
        profile.setMobileNumber(person.getMobileNumber());
        profile.setEmail(person.getEmail());
        if (person.getAddress() != null && person.getAddress().getAddressId() > 0) {
            profile.setAddress1(person.getAddress().getAddress1());
            profile.setAddress2(person.getAddress().getAddress2());
            profile.setCity(person.getAddress().getCity());
            profile.setState(person.getAddress().getState());
            profile.setZipCode(person.getAddress().getZipCode());
        }
        ModelAndView modelAndView = new ModelAndView("profile.html");
        modelAndView.addObject("profile", profile);
        return modelAndView;
    }

    @RequestMapping(value = "/updateProfile", method = {RequestMethod.POST})
    public String updateProfile (@Valid @ModelAttribute("profile") Profile profile, Errors errors,
                                 HttpSession httpSession)
    {
        if(errors.hasErrors()) {
            return "profile.html";
        }

        Person person = (Person) httpSession.getAttribute("loggedinperson");
        person.setName(profile.getName());
        person.setEmail(profile.getEmail());
        person.setMobileNumber(profile.getMobileNumber());
        if (person.getAddress() == null || !(person.getAddress().getAddressId() > 0)) {
            person.setAddress(new Address());
        }
        person.getAddress().setAddress1(profile.getAddress1());
        person.getAddress().setAddress2(profile.getAddress2());
        person.getAddress().setCity(profile.getCity());
        person.getAddress().setState(profile.getState());
        person.getAddress().setZipCode(profile.getZipCode());
        Person savedPerson = personRepository.save(person);
        httpSession.setAttribute("loggedinperson", savedPerson);
        return "redirect:/displayProfile";
    }
}
