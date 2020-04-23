package codegym.controller;

import codegym.model.City;
import codegym.model.Country;
import codegym.service.CityService;
import codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

    @GetMapping("/countryes")
    public ModelAndView listCountrys(){
        Iterable<Country> countryes = countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/country/listCountry");
        modelAndView.addObject("countryes", countryes);
        return modelAndView;
    }


    @GetMapping("/create-country")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/country/createCountry");
        modelAndView.addObject("country", new Country());
        return modelAndView;
    }

    @PostMapping("/create-country")
    public ModelAndView saveCountry(@ModelAttribute("country") Country country){
        countryService.save(country);

        ModelAndView modelAndView = new ModelAndView("/country/createCountry");
        modelAndView.addObject("country", new Country());
        modelAndView.addObject("message", "New country created successfully");
        return modelAndView;
    }


    @GetMapping("/edit-country/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        Country country = countryService.findById(id);
        if(country != null) {
            ModelAndView modelAndView = new ModelAndView("/country/editCountry");
            modelAndView.addObject("country", country);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-country")
    public ModelAndView updateCountry(@ModelAttribute("country") Country country){
        countryService.save(country);
        ModelAndView modelAndView = new ModelAndView("/country/editCountry");
        modelAndView.addObject("country", country);
        modelAndView.addObject("message", "country updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-country/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id){
        Country country = countryService.findById(id);
        if(country != null) {
            ModelAndView modelAndView = new ModelAndView("/country/deleteCountry");
            modelAndView.addObject("country", country);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-country")
    public String deleteCountry(@ModelAttribute("country") Country country){
        countryService.remove(country.getId());
        return "redirect:countryes";
    }

    @GetMapping("/view-country/{id}")
    public ModelAndView viewCountry(@PathVariable("id") int id){
        Country country = countryService.findById(id);
        if(country == null){
            return new ModelAndView("/error.404");
        }

        Iterable<City> citys = cityService.findAllByCountry(country);

        ModelAndView modelAndView = new ModelAndView("/country/viewCountry");
        modelAndView.addObject("country", country);
        modelAndView.addObject("citys", citys);
        return modelAndView;
    }

}
