package com.app.tutorial.springbootschoolwebexceptionhandling.controller;

import com.app.tutorial.springbootschoolwebexceptionhandling.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    @GetMapping("/holidays")
    public String displayHoliday(@RequestParam(required = false) boolean festival, @RequestParam(required = false) boolean federal, Model model) {
        model.addAttribute("festival", festival);
        model.addAttribute("federal", federal);

        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31", "Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24", "Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25", "Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17", "Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                new Holiday(" July 4", "Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5", "Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 11", "Veterans Day", Holiday.Type.FEDERAL)
        );

        Holiday.Type[] types = Holiday.Type.values();
        for(Holiday.Type type: types) {
            model.addAttribute(type.toString(), holidays.stream().filter(holiday -> holiday.getType().equals(type)).
                    collect(Collectors.toList()));
        }

        return "holidays.html";
    }

    @GetMapping("/holidays/{display}")
    public String displayHolidayByPath (@PathVariable String display, Model model) {

        if (display != null && display.equals("festival")) {
            model.addAttribute("festival", true);
            model.addAttribute("federal", false);
        } else if (display != null && display.equals("federal")) {
            model.addAttribute("festival", false);
            model.addAttribute("federal", true);
        } else if (display != null && display.equals("all")) {
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        }

        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31", "Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24", "Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25", "Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17", "Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                new Holiday(" July 4", "Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5", "Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 11", "Veterans Day", Holiday.Type.FEDERAL)
        );

        Holiday.Type[] types = Holiday.Type.values();
        for(Holiday.Type type: types) {
            model.addAttribute(type.toString(), holidays.stream().filter(holiday -> holiday.getType().equals(type)).
                    collect(Collectors.toList()));
        }

        return "holidays.html";
    }

}
