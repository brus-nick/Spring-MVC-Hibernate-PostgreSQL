package com.project.controller;

import com.project.service.api.RecordApproval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/record")
public class RecordApprovalController {

    @Autowired
    public RecordApproval recordApproval;

    @RequestMapping(value = "/submitForApproval/{recordType}/{id}", method = RequestMethod.GET)
    public ModelAndView submitForApproval(@PathVariable String recordType, @PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("home");
        recordApproval.submitForApproval(id, recordType);
        String message = "The " + recordType + "with id: " + id.toString() + " has been sent for confirmation.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/approve/{recordType}/{id}", method = RequestMethod.GET)
    public ModelAndView approve(@PathVariable String recordType, @PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("home");
        recordApproval.approve(id, recordType);
        String message = "The " + recordType + "with id: " + id.toString() + " has been approved.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/reject/{recordType}/{id}", method = RequestMethod.GET)
    public ModelAndView reject(@PathVariable String recordType, @PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("home");
        recordApproval.reject(id, recordType);
        String message = "The " + recordType + "with id: " + id.toString() + " has been rejected.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    public static class Record {
        private String id;
        private String type;

        Record(String id, String type) {
            this.id = id;
            this.type = type;
        }

        public String getId() {
            return this.id;
        }

        public String getType() {
            return this.type;
        }
    }
}
