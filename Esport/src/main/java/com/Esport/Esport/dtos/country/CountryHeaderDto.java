package com.Esport.Esport.dtos.country;

import com.Esport.Esport.models.Country;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class CountryHeaderDto implements Serializable {
    private final Integer id;
    private final String description;

    public static List<CountryHeaderDto> toList(List<Country>countries){
    List<CountryHeaderDto> result = new ArrayList<>();

    for(Country country : countries){
        result.add(set(country));
    }
    return result;
    }

    public static CountryHeaderDto set(Country country){
        return new CountryHeaderDto(
                country.getId(),
                country.getDescription()
        );
    }

}
