package com.Esport.Esport.dtos.team;

import com.Esport.Esport.models.Team;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class TeamHeaderDto {
    private final Integer id;
    private final String name;
    private final Integer CountryId;
    private final BigDecimal value;

    public static List<TeamHeaderDto> toList(List<Team> teams){
        List<TeamHeaderDto> result = new ArrayList<>();

        for (Team team : teams) {
            result.add(set(team));
        }
        return result;
    }

    public static TeamHeaderDto set(Team team){
        return new TeamHeaderDto(
                team.getId(),
                team.getName(),
                team.getCountry().getId(),
                team.getValue()
        );
    }
}
