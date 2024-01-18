package com.example.testmoduel4.controller;

import com.example.testmoduel4.model.City;
import com.example.testmoduel4.model.Country;
import com.example.testmoduel4.service.ICityService;
import com.example.testmoduel4.service.ICountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/cities")
public class CityController {
    @Autowired
    private ICityService cityService;
    @Autowired
    private ICountryService countryService;
    @GetMapping()
    public String listCity(Model model) {
        model.addAttribute("list", cityService.getAllCities());
        return "list";
    }

    @GetMapping("/create")
    public String formCreateCity(Model model){
        model.addAttribute("city",new City());
        model.addAttribute("list",countryService.getCountryList());
        return "form";
    }
    @GetMapping("{id}/edit")
    public String formEditCity(Model model,@PathVariable Long id){
        model.addAttribute("city", cityService.findCityByCityId(id));
        model.addAttribute("list",countryService.getCountryList());
        return "form";
    }

    @PostMapping("/save")
    public String createCity(@Valid @ModelAttribute City city, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("message","Has Error");
            model.addAttribute("city", city);
            model.addAttribute("list",countryService.getCountryList());
            return "form";
        }
        cityService.saveCity(city);
        return "redirect:/cities";
    }
    @GetMapping("/{id}/delete")
    public String deleteCity(@PathVariable Long id){
        cityService.deleteCity(id);
        return "redirect:/cities";
    }
    @GetMapping("/{id}/details")
    public String viewCityDetails(Model model,@PathVariable Long id){
        model.addAttribute("city",cityService.findCityByCityId(id));
        return "detail";
    }
    @GetMapping("/search")
    public String search(@RequestParam String keyword,Model model){
        model.addAttribute("list",cityService.getAllCityByCityName(keyword));
        return "list";
    }
}
