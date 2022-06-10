package com.Esport.Esport.controllers;

import com.Esport.Esport.RestResponse;
import com.Esport.Esport.dtos.country.CountryHeaderDto;
import com.Esport.Esport.dtos.country.UpsertCountryDto;
import com.Esport.Esport.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("country")
public class CountryController {
    private CountryService service;

    @Autowired
    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("get-all")
    public ResponseEntity<RestResponse<List<CountryHeaderDto>>> findAllCountry() {
        return ResponseEntity.ok().body(
                new RestResponse<>(service.findAllCountry(),
                        "Berhasil mendapatkan semua data country",
                        "200"));
    }
    @GetMapping("get-by-id/{id}")
    public ResponseEntity<RestResponse<CountryHeaderDto>> findCountryById(@PathVariable int id) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.findCountryById(id),
                        "Berhasil mendapatkan data negara dengan id " + id,
                        "200"));
    }

    @PostMapping("insert")
    public ResponseEntity<RestResponse<Boolean>> insertCountry(@RequestBody UpsertCountryDto newCountry) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.insertCountry(newCountry),
                        "Berhasil menambahkan data negara baru",
                        "200"));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<RestResponse<Boolean>> updateCountry(@PathVariable int id, @RequestBody UpsertCountryDto updatedCountry) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.updateCountry(id, updatedCountry),
                        "Berhasil mengubah data negara dengan id " + id,
                        "200"));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<RestResponse<Boolean>> deleteCountry(@PathVariable int id) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.deleteCountry(id),
                        "Berhasil menghapus data negara dengan id " + id,
                        "200"));
    }

}
