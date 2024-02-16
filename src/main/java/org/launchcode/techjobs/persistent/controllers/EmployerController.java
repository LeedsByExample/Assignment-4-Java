package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepository;

    //Add an index method that responds at /employers with a list of all employers in the database. This method should use the template employers/index
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("Title", "All Employers");
        model.addAttribute("employers", employerRepository.findAll());
        return "employers/index";
    }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer, Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        }

        employerRepository.save(newEmployer);

        return "redirect:"; //unsure if this redirect correct? check
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional<Employer> optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }

    }
}

//Task 2: Add an index method that responds at /employers with a list of all employers in the database. This method should use the template employers/
//Task 2: processAddEmployerForm already takes care of sending the form back if any of the submitted employer object information is invalid. However, it doesn’t yet contain the code to save a valid object. Use employerRepository and the appropriate method to do so. (CHECK MY SOLUTION BEFORE SUBMISSION - IS REDIRECT CORRECT?)
//Task 2: displayViewEmployer will be in charge of rendering a page to view the contents of an individual employer object. It will make use of that employer object’s id field to grab the correct information from employerRepository. optEmployer is currently initialized to null. Replace this using the .findById() method with the right argument to look for the given employer object from the data layer.