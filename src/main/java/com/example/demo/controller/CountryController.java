package com.example.demo.controller;

import com.example.demo.dto.StoreCountryRequestBody;
import com.example.demo.dto.UpdateCountryRequestBody;
import com.example.demo.entity.Country;
import com.example.demo.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/")
    public Country addCountry(@RequestBody StoreCountryRequestBody countryRequestBody) {
        return this.countryService.addCountry(countryRequestBody);
    }

    @GetMapping("/all")
    public Page<Country> getAllCountries(@RequestParam("page") int page) {
        return this.countryService.getAllCountries(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findCountryById(@PathVariable int id) {
        return this.countryService.findCountryById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountryById(@PathVariable int id) {
        return this.countryService.deleteCountryById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable int id,
            @RequestBody UpdateCountryRequestBody countryRequestBody) {
        return this.countryService.updateCountry(id, countryRequestBody);
    }

}
