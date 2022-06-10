package com.Esport.Esport.dtos.user;

import com.Esport.Esport.models.Country;
import com.Esport.Esport.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpsertUserDto implements Serializable {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String birthPlace;
    private Integer countryId;

    public User convert() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new User(
                firstName,
                lastName,
                LocalDate.parse(birthDate, date),
                birthPlace,
                countryId
        );
    }

}
