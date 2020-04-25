package com.finalproject.finalproject.controller;
import com.finalproject.finalproject.Models.Inventory;
import com.finalproject.finalproject.Models.InventoryRepo;
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
public class InventoryController {
    @Autowired
    InventoryRepo inventoryRepo;

    @RequestMapping("/indexinv/")
    public ModelAndView inventory() {
        ModelAndView mv = new ModelAndView("indexinv");
        mv.addObject("inventoryList", inventoryRepo.findAll());
        return mv;
    }
    @RequestMapping(value = "/editinv/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView ev = new ModelAndView("editem");
        Optional<Inventory> inventory = inventoryRepo.findById(id);
        Inventory inventoryToMap = inventory.get();
        ev.addObject("selectedItem", inventoryToMap);
        return ev;
    }

    @RequestMapping(value = "/saveinv", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam("id") String id, @RequestParam("invdescription") String invDescription, @RequestParam("invprice") double invPrice){
        ModelAndView iv = new ModelAndView("redirect:/indexinv/");
        Inventory inventoryToSave ;
        if(!id.isEmpty())
        {
            Optional<Inventory> inventory = inventoryRepo.findById(id);
            inventoryToSave = inventory.get();
        }
        else
        {
            inventoryToSave = new Inventory();
            inventoryToSave.setId(UUID.randomUUID().toString());
        }
        inventoryToSave.setInvDescription(invDescription);
        inventoryToSave.setInvPrice(invPrice);
        inventoryRepo.save(inventoryToSave);
        iv.addObject("inventoryList", inventoryRepo.findAll());
        return iv;
    }

    @RequestMapping( value = "/deleteinv/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView iv = new ModelAndView("redirect:/indexinv/");
        inventoryRepo.deleteById(id);
        return iv;
    }


    }

