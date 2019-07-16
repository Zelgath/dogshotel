package com.zelgath.dogshotel.controllers;

import com.zelgath.dogshotel.components.TimeComponent;
import com.zelgath.dogshotel.domain.Dog;
import com.zelgath.dogshotel.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
public class DogController {

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    DogService dogService;

    @RequestMapping("/dogs")
    public String getDogs(Model model) {
        List<Dog> allDogs = dogService.getAllDogs();
        model.addAttribute("dogs", allDogs);
        model.addAttribute("timecomponent", timeComponent);
        return "dogs";
    }

    @RequestMapping("/dog")
    public String getDog(@RequestParam("id") Integer id, Model model) {
       Dog dog = dogService.getDog(id);
       model.addAttribute("dog", dog);
        model.addAttribute("timecomponent", timeComponent);
       return "dog";
    }

    @RequestMapping("/newdog")
    public String createDog(Model model) {
        Set<String> sexTypes = dogService.getAllSexTypes();
        model.addAttribute("dog", new Dog());
        model.addAttribute("sexTypes", sexTypes);
        model.addAttribute("timecomponent", timeComponent);
        return "dogform";
    }

    @RequestMapping(value = "/dogs", method = RequestMethod.POST)
    public String saveDog(@Valid Dog dog, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> {
                System.out.println(objectError.getObjectName() + " " + objectError.getDefaultMessage());
                    }

            );
            System.out.println("there were errors");
            return "dogform";
        } else {
            dogService.saveDog(dog);
            return "redirect:/dogs";
        }
    }

    @RequestMapping(value = "/dog/delete/{id}")
    public String removeDog(@PathVariable("id") Integer id) {
        dogService.removeDog(id);
        return "redirect:/dogs";
    }

    @RequestMapping(value = "/dog/deleteCharge/{id}")
    public String removeCharge(@PathVariable("id") Integer id) {
        dogService.removeOwnerCharge(id);
        return "redirect:/dog?id={id}";
    }
}
