package com.Esport.Esport.dtos.team;

import com.Esport.Esport.models.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpsertTeamDto implements Serializable {
    private String name;
    private Integer countryId;
    private BigDecimal value;

    public Team convert() {
        return new Team(
                name,
                countryId,
                value
        );
    }
}
