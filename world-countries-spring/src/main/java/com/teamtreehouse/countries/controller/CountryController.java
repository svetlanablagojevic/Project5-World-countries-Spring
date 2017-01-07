package com.teamtreehouse.countries.controller;

import com.teamtreehouse.countries.data.CountryRepository;
import com.teamtreehouse.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @RequestMapping("/")
    public String listCountries(ModelMap modelMap) {
        List<Country> countries=countryRepository.getAllCountries();
        modelMap.put("countries", countries);
        return "index";

    }

    @RequestMapping("/countries")
    public String listCountry(ModelMap modelMap) {
        List<Country> countries=countryRepository.getAllCountries();
        modelMap.put("countries", countries);
        return "index";


    }



    @RequestMapping("/countries/{name}")
    public String countryDetails(@PathVariable String name, ModelMap modelMap) {

        Country country=countryRepository.findByName(name);
        modelMap.put("country", country);
        return "country-detail";

    }


    @RequestMapping("/sort-by-country-name")
    public String getSortedbyName(ModelMap modelMap)  {
        List<Country> countries = countryRepository.getAllCountries();

        countries.sort((Country o1, Country o2) -> o1.getName().compareTo(o2.getName()));
        modelMap.put("countries", countries);
        return "index";
    }

    @RequestMapping("/sort-by-population")
    public String getSortedbyPopulation(ModelMap modelMap)  {
        List<Country> countries = countryRepository.getAllCountries();

        countries.sort((Country o1, Country o2) -> o2.getPopulation() - o1.getPopulation());
        modelMap.put("countries", countries);
        return "index";
    }



}
