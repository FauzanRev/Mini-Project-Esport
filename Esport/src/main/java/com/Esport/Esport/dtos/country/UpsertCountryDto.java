package com.Esport.Esport.dtos.country;

import com.Esport.Esport.models.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertCountryDto implements Serializable {
    private String description;

    public Country convert() {
        return new Country(description);
    }

}
