package com.Esport.Esport.dtos.user;

import com.Esport.Esport.models.Country;
import com.Esport.Esport.models.User;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data
public class UserHeaderDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String birthPlace;
    private final Integer countryId;

    public static List<UserHeaderDto> toList(List<User> users){
        List<UserHeaderDto> result = new ArrayList<>();

        for (User user : users) {
            result.add(set(user));
        }
        return result;
    }


    public static UserHeaderDto set(User user) {
        return new UserHeaderDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getBirthPlace(),
                user.getCountry().getId()
        );

    }
}
