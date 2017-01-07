package com.teamtreehouse.countries.data;

import com.teamtreehouse.countries.model.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CountryRepository {

    private static final List<Country> ALL_COUNTRIES= Arrays.asList(
     new Country ("India",1252000000, "New Delhi", new String [] {"hindi", "english"}),
     new Country ("Kenya",45000000, "Nairobi", new String [] {"english", "kiswahili"}),
     new Country("Ecuador", 16144000, "Quito", new String[] {"spanish"}),
     new Country ("France",66030000, "Paris", new String [] {"french"}),
      new Country ("Italy",59300000, "Rome", new String [] {"italian"}));

   public Country findByName(String name) {
       for (Country country:ALL_COUNTRIES) {
           if (country.getName().equals(name)) {
               return country;
           }
       }
       return null;
   }

   public List <Country>  getAllCountries() {
       return ALL_COUNTRIES;
   }



}
