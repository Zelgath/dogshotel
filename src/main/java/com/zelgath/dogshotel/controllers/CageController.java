package com.zelgath.dogshotel.controllers;

import com.zelgath.dogshotel.domain.Cage;
import com.zelgath.dogshotel.domain.Dog;
import com.zelgath.dogshotel.services.CageService;
import com.zelgath.dogshotel.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CageController {

    @Autowired
    CageService cageService;

    @Autowired
    DogService dogService;

    @RequestMapping("/cages")
    public String getCages(Model model) {
        List<Cage> allCages = cageService.getAllCages();
        model.addAttribute("cages", allCages);
        return "cages";
    }

    @RequestMapping("/assignCage")
    public String assignCage(@RequestParam("dogId") Integer id, Model model) {
        Dog dog = dogService.getDog(id);
        List<Cage> notOccupiedCages = cageService.getAllNotOccupiedCages();
        model.addAttribute("dog", dog);
        model.addAttribute("notOccupiedCages", notOccupiedCages);
        return "assignCage";
    }

    @RequestMapping(value = "/assignCage", method = RequestMethod.POST)
    public String assignCage(Dog dog, BindingResult result) {
        System.out.println(result);
        dogService.updateDog(dog);
        return "redirect:/dogs";
    }

    @RequestMapping(value = "/dog/deleteCage/{id}")
    public String removeDog(@PathVariable("id") Integer id) {
        dogService.removeCageFromDog(id);
        return "redirect:/dogs";
    }


}
