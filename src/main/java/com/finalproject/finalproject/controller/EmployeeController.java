package com.finalproject.finalproject.controller;

import com.finalproject.finalproject.Models.Customers;
import com.finalproject.finalproject.Models.Employees;
import com.finalproject.finalproject.Models.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;

@Controller
public class EmployeeController {

    @Autowired
    EmployeesRepo employeesRepo;

    @RequestMapping("/indexem/")
    public ModelAndView employee(){
        ModelAndView mv = new ModelAndView("indexem");
        mv.addObject("employeeList", employeesRepo.findAll());
        return mv;
    }
    @RequestMapping(value = "/editem/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView ev = new ModelAndView("editem");
        Optional<Employees> employee = employeesRepo.findById(id);
        Employees employeesToMap = employee.get();
        ev.addObject("selectedItem", employeesToMap);
        return ev;
    }

    @RequestMapping(value = "/saveem", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam("id") String id, @RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam("jobposition") String jobPosition){
        ModelAndView ev = new ModelAndView("redirect:/indexem/");
        Employees employeesToSave ;
        if(!id.isEmpty())
        {
            Optional<Employees> employees = employeesRepo.findById(id);
            employeesToSave = employees.get();
        }
        else
        {
            employeesToSave = new Employees();
            employeesToSave.setId(UUID.randomUUID().toString());
        }
        employeesToSave.setFirstName(firstName);
        employeesToSave.setLastName(lastName);
        employeesToSave.setJobPosition(jobPosition);
        employeesRepo.save(employeesToSave);
        ev.addObject("employeeList", employeesRepo.findAll());
        return ev;
    }

    @RequestMapping( value = "/deleteem/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView ev = new ModelAndView("redirect:/indexem/");
        employeesRepo.deleteById(id);
        return ev;
    }

}
