package com.finalproject.finalproject.controller;
import com.finalproject.finalproject.Models.Customers;
import com.finalproject.finalproject.Models.CustomersRepo;
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
public class CustomerController {

    @Autowired
    CustomersRepo customersRepo;

    @RequestMapping("/indexcu/")
    public ModelAndView customer(){
        ModelAndView cv = new ModelAndView("indexcu");
        cv.addObject("customerList", customersRepo.findAll());
        return cv;
    }

    @RequestMapping(value = "/editcu/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView cv = new ModelAndView("editcu");
        Optional<Customers> customer = customersRepo.findById(id);
        Customers customerToMap = customer.get();
        cv.addObject("selectedItem", customerToMap);
        return cv;
    }

    @RequestMapping(value = "/savecu", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam("id") String id, @RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName){
        ModelAndView cv = new ModelAndView("redirect:/indexcu/");
        Customers customerToSave ;
        if(!id.isEmpty())
        {
            Optional<Customers> users = customersRepo.findById(id);
            customerToSave = users.get();
        }
        else
        {
            customerToSave = new Customers();
            customerToSave.setId(UUID.randomUUID().toString());
        }
        customerToSave.setFirstName(firstName);
        customerToSave.setLastName(lastName);
        customersRepo.save(customerToSave);
        cv.addObject("customerList", customersRepo.findAll());
        return cv;
    }

    @RequestMapping( value = "/deletecu/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView cv = new ModelAndView("redirect:/indexcu/");
        customersRepo.deleteById(id);
        return cv;
    }



}
