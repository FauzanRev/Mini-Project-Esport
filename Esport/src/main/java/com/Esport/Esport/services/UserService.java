package com.Esport.Esport.services;

import com.Esport.Esport.dtos.user.UpsertUserDto;
import com.Esport.Esport.dtos.user.UserHeaderDto;
import com.Esport.Esport.models.User;
import com.Esport.Esport.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserHeaderDto> findAllUser() {
        return userRepository.findAll().stream()
                .map(UserHeaderDto::set)
                .collect(Collectors.toList());
    }

    public UserHeaderDto findUserById(Integer id) {
        return userRepository.findById(id).map(UserHeaderDto::set).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public boolean insertUser(UpsertUserDto newUser) {
        return userRepository.save(newUser.convert()) != null;
    }

    public boolean updateUser(int id, UpsertUserDto updatedUser) {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        User user = userRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setBirthDate(LocalDate.parse(updatedUser.getBirthDate(), date));
        user.setBirthPlace(updatedUser.getBirthPlace());
        user.setCountry(updatedUser.convert().getCountry());
        userRepository.save(user);
        return true;
    }


    public boolean deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
        userRepository.delete(user);
        return true;
    }

    public List<UserHeaderDto> getUserByCountry(int countryId) {
        return userRepository.getUserByCountryId(countryId).stream()
                .map(UserHeaderDto::set)
                .collect(Collectors.toList());
    }

}
