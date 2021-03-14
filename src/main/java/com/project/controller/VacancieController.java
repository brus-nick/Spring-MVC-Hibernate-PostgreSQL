package com.project.controller;

import com.project.model.Vacancie;
import com.project.service.api.VacancieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/vacancy")
public class VacancieController {

    @Autowired
    public VacancieService vacancieService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addVacanciePage() {
        ModelAndView modelAndView = new ModelAndView("add-vacancie-form");
        modelAndView.addObject("vacancie", new Vacancie());
        List<Vacancie> vacancies = vacancieService.list();
        modelAndView.addObject("vacancies", vacancies);
        return modelAndView;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addingVacancie(@Valid @ModelAttribute Vacancie vacancie) {

        ModelAndView modelAndView = new ModelAndView("home");
        vacancieService.add(vacancie);

        String message = "Vacancie was successfully added.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value = "/list")
    public ModelAndView listOfVacancies() {
        ModelAndView modelAndView = new ModelAndView("list-of-vacancies");

        List<Vacancie> vacancies = vacancieService.list();
        modelAndView.addObject("vacancies", vacancies);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editVacanciePage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-vacancie-form");
        Vacancie vacancie = vacancieService.getById(id);
        modelAndView.addObject("vacancie", vacancie);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editingVacancie(@ModelAttribute Vacancie vacancie, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("home");

        vacancieService.update(vacancie);

        String message = "Vacancie was successfully edited.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteVacancie(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        vacancieService.remove(id);
        String message = "Vacancie was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
