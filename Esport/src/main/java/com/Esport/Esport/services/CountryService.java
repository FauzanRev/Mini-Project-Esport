package com.Esport.Esport.services;

import com.Esport.Esport.dtos.country.CountryHeaderDto;
import com.Esport.Esport.dtos.country.UpsertCountryDto;
import com.Esport.Esport.models.Country;
import com.Esport.Esport.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    private CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryHeaderDto> findAllCountry() {
        return countryRepository.findAll().stream()
                .map(CountryHeaderDto::set)
                .collect(Collectors.toList());
    }

    public CountryHeaderDto findCountryById(Integer id) {
        return countryRepository.findById(id).map(CountryHeaderDto::set).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found"));
    }

    public Boolean insertCountry(UpsertCountryDto newCountry) {
        Country country = new Country(
                newCountry.getDescription()
        );
        countryRepository.save(country);
        return true;
    }

    public Boolean updateCountry(int id, UpsertCountryDto updatedCountry) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Country not found"));
        country.setDescription(updatedCountry.getDescription());
        countryRepository.save(country);
        return true;
    }

    public Boolean deleteCountry(int id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Country not found"));
        countryRepository.delete(country);
        return true;
    }
}
