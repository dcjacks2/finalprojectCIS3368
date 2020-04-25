package com.finalproject.finalproject.controller;
import com.finalproject.finalproject.Models.CustomersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    CustomersRepo customersRepo;

    @RequestMapping("/")
    public ModelAndView home()
    {
        ModelAndView mv = new ModelAndView("homepage");
        mv.addObject("list", customersRepo.findAll());
        return mv;
    }



}
