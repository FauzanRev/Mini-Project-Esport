package com.Esport.Esport.controllers;

import com.Esport.Esport.RestResponse;
import com.Esport.Esport.dtos.user.UpsertUserDto;
import com.Esport.Esport.dtos.user.UserHeaderDto;
import com.Esport.Esport.models.User;
import com.Esport.Esport.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("get-all")
    public ResponseEntity<RestResponse<List<UserHeaderDto>>> findAllUser() {
        return ResponseEntity.ok().body(
                new RestResponse<>(service.findAllUser(),
                        "Berhasil mendapatkan semua data user",
                        "200"));
    }

    @GetMapping("get-by-id/{id}")
    public ResponseEntity<RestResponse<UserHeaderDto>> findUserById(@PathVariable int id) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.findUserById(id),
                        "Berhasil mendapatkan data user dengan id " + id,
                        "200"));
    }
    @PostMapping("insert")
    public ResponseEntity<RestResponse<Boolean>> insertUser(@RequestBody UpsertUserDto newUser) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.insertUser(newUser),
                        "Berhasil menambahkan data user baru",
                        "200"));
    }

    @PutMapping("update/{userId}")
    public ResponseEntity<RestResponse<Boolean>> updateUser(@PathVariable int userId, @RequestBody UpsertUserDto updatedUser) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.updateUser(userId, updatedUser),
                        "Berhasil mengubah data user dengan id " + userId,
                        "200"));
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<RestResponse<Boolean>> deleteUser(@PathVariable int userId) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.deleteUser(userId),
                        "Berhasil menghapus data user dengan id " + userId,
                        "200"));
    }

    @GetMapping("country/{country}")
    public ResponseEntity<RestResponse<List<UserHeaderDto>>> findUserByCountry(@PathVariable int country) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.getUserByCountry(country),
                        "Berhasil mendapatkan data user dari negara " + country,
                        "200"));
    }
}
