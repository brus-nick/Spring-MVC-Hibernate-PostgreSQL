package com.project.controller;

import com.project.model.Applicant;
import com.project.service.api.ApplicantService;
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
@RequestMapping(value = "/applicant")
public class ApplicantController {

    @Autowired
    public ApplicantService applicantService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addApplicantPage() {
        ModelAndView modelAndView = new ModelAndView("add-applicant-form");
        modelAndView.addObject("applicant", new Applicant());
        List<Applicant> applicants = applicantService.list();
        modelAndView.addObject("applicants", applicants);
        return modelAndView;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addingApplicant(@Valid @ModelAttribute Applicant applicant) {

        ModelAndView modelAndView = new ModelAndView("home");
        applicantService.add(applicant);

        String message = "Applicant was successfully added.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value = "/list")
    public ModelAndView listOfApplicants() {
        ModelAndView modelAndView = new ModelAndView("list-of-applicants");

        List<Applicant> applicants = applicantService.list();
        modelAndView.addObject("applicants", applicants);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editApplicantPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-applicant-form");
        Applicant applicant = applicantService.getById(id);
        modelAndView.addObject("applicant", applicant);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edditingApplicant(@ModelAttribute Applicant applicant, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("home");

        applicantService.update(applicant);

        String message = "Applicant was successfully edited.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteApplicant(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        applicantService.remove(id);
        String message = "Applicant was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
