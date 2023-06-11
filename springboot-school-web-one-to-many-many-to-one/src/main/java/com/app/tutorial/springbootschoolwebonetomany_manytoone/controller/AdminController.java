package com.app.tutorial.springbootschoolwebonetomany_manytoone.controller;

import com.app.tutorial.springbootschoolwebonetomany_manytoone.model.Courses;
import com.app.tutorial.springbootschoolwebonetomany_manytoone.model.Person;
import com.app.tutorial.springbootschoolwebonetomany_manytoone.model.SchoolClass;
import com.app.tutorial.springbootschoolwebonetomany_manytoone.repository.CoursesRepository;
import com.app.tutorial.springbootschoolwebonetomany_manytoone.repository.PersonRepository;
import com.app.tutorial.springbootschoolwebonetomany_manytoone.repository.SchoolClassRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    private final PersonRepository personRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final CoursesRepository coursesRepository;

    @Autowired
    public AdminController(PersonRepository personRepository, SchoolClassRepository schoolClassRepository,
                           CoursesRepository coursesRepository)
    {
        this.personRepository = personRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.coursesRepository = coursesRepository;
    }

    @RequestMapping("/displayClasses")
    public ModelAndView displayClasses(Model model) {
        List<SchoolClass> schoolClassList = schoolClassRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("classes.html");
        modelAndView.addObject("schoolClasses", schoolClassList);
        modelAndView.addObject("schoolClass", new SchoolClass());
        return modelAndView;
    }

    @RequestMapping(value = "/addNewClass", method = {RequestMethod.POST})
    public ModelAndView addSchoolClass (Model model, @ModelAttribute("schoolClass") SchoolClass schoolClass) {
        schoolClassRepository.save(schoolClass);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteClass", method = {RequestMethod.GET})
    public ModelAndView deleteClass(Model model, @RequestParam int id) {
        Optional<SchoolClass> schoolClass = schoolClassRepository.findById(id);
        for (Person person : schoolClass.get().getPersons()) {
            person.setSchoolClass(null);
            personRepository.save(person);
        }
        schoolClassRepository.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }

    @RequestMapping(value = "/displayStudents", method = {RequestMethod.GET})
    public ModelAndView displayStudents (Model model, @RequestParam int classId, HttpSession httpSession,
                                         @RequestParam(value = "error", required = false) String error)
    {
        String errorMessage = null;
        ModelAndView modelAndView =  new ModelAndView("students.html");
        Optional<SchoolClass> schoolClass = schoolClassRepository.findById(classId);
        modelAndView.addObject("schoolClass", schoolClass.get());
        modelAndView.addObject("person", new Person());
        httpSession.setAttribute("schoolClass", schoolClass.get());
        if (error != null) {
            errorMessage = "Invalid Email entered";
            modelAndView.addObject("errorMessage", errorMessage);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/addStudent", method = {RequestMethod.POST})
    public ModelAndView addStudent (Model model, @ModelAttribute("person") Person person, HttpSession httpSession) {

        ModelAndView modelAndView = new ModelAndView();
        SchoolClass schoolClass = (SchoolClass) httpSession.getAttribute("schoolClass");
        Person personEntity = personRepository.readByEmail(person.getEmail());
        if (personEntity == null || !(personEntity.getPersonId() > 0)) {
            modelAndView.setViewName("redirect:/admin/displayStudents?classId=" + schoolClass.getClassId() +
                    "&error=true");
            return modelAndView;
        }

        personEntity.setSchoolClass(schoolClass);
        personRepository.save(personEntity);
        schoolClass.getPersons().add(personEntity);
        schoolClassRepository.save(schoolClass);
        modelAndView.setViewName("redirect:/admin/displayStudents?classId=" + schoolClass.getClassId());

        return modelAndView;

    }

    @RequestMapping(value = "/deleteStudent", method = {RequestMethod.GET})
    public ModelAndView deleteStudent(Model model, @RequestParam int personId, HttpSession httpSession) {
        SchoolClass schoolClass = (SchoolClass) httpSession.getAttribute("schoolClass");
        Optional<Person> person = personRepository.findById(personId);
        person.get().setSchoolClass(null);
        schoolClass.getPersons().remove(person.get());
        schoolClassRepository.save(schoolClass);
        httpSession.setAttribute("schoolClass", schoolClass);
        ModelAndView modelAndView = new ModelAndView ("redirect:/admin/displayStudents?classId=" +
                schoolClass.getClassId());

        return modelAndView;
    }

    @RequestMapping(value = "/displayCourses", method = {RequestMethod.GET})
    public ModelAndView displayCourses(Model model) {
        List<Courses> courses = coursesRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("courses_secure.html");
        modelAndView.addObject("courses", courses);
        modelAndView.addObject("course", new Courses());
        return modelAndView;
    }

    @RequestMapping(value = "/addNewCourse", method = {RequestMethod.POST})
    public ModelAndView displayCourses(Model model, @ModelAttribute("course") Courses course) {
        ModelAndView modelAndView = new ModelAndView();
        coursesRepository.save(course);
        modelAndView.setViewName("redirect:/admin/displayCourses");
        return modelAndView;
    }

    @RequestMapping(value = "/viewStudents", method = {RequestMethod.GET})
    public ModelAndView displayCourses(Model model, @RequestParam int id, HttpSession httpSession,
                                       @RequestParam(required = false) String error)
    {
        String errorMessage = null;
        ModelAndView modelAndView = new ModelAndView("course_students.html");
        Optional<Courses> courses = coursesRepository.findById(id);
        modelAndView.addObject("courses", courses.get());
        modelAndView.addObject("person", new Person());
        httpSession.setAttribute("courses", courses.get());
        if(error != null) {
            errorMessage = "Invalid Email entered!!";
            modelAndView.addObject("errorMessage", errorMessage);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/addStudentToCourse", method = {RequestMethod.POST})
    public ModelAndView addStudentToCourse(Model model, @ModelAttribute("person") Person person,
                                           HttpSession httpSession)
    {
        ModelAndView modelAndView = new ModelAndView();
        Courses courses = (Courses) httpSession.getAttribute("courses");
        Person personEntity = personRepository.readByEmail(person.getEmail());
        if (personEntity == null || !(personEntity.getPersonId() > 0)) {
            modelAndView.setViewName("redirect:/admin/viewStudents?id=" + courses.getCourseId() +
                    "&error=true");
            return modelAndView;
        }
        personEntity.getCourses().add(courses);
        courses.getPersons().add(personEntity);
        personRepository.save(personEntity);
        httpSession.setAttribute("courses", courses);
        modelAndView.setViewName("redirect:/admin/viewStudents?id=" + courses.getCourseId());
        return modelAndView;
    }

    @RequestMapping(value = "deleteStudentFromCourse", method = {RequestMethod.GET})
    public ModelAndView deleteStudentFromCourse(Model model, @RequestParam int personId,
                                                HttpSession httpSession)
    {
        Courses courses = (Courses) httpSession.getAttribute("courses");
        Optional<Person> person = personRepository.findById(personId);
        person.get().getCourses().remove(courses);
        courses.getPersons().remove(person);
        personRepository.save(person.get());
        httpSession.setAttribute("courses", courses);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/viewStudents?id=" + courses.getCourseId());
        return modelAndView;
    }
}
