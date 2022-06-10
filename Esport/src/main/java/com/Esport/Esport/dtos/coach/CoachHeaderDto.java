package com.Esport.Esport.dtos.coach;

import com.Esport.Esport.models.Coach;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class CoachHeaderDto implements Serializable {
    private final Integer id;
    private final Integer userId;
    private final Integer teamId;
    private final String nickname;
    private final BigDecimal value;

    public static List<CoachHeaderDto> toList(List<Coach> coaches){
        List<CoachHeaderDto> result = new ArrayList<>();

        for (Coach coach : coaches) {
            result.add(set(coach));
        }
        return result;
    }

    public static CoachHeaderDto set(Coach coach){
        return new CoachHeaderDto(
                coach.getId(),
                coach.getUser().getId(),
                coach.getTeam().getId(),
                coach.getNickname(),
                coach.getValue()
        );
    }
}
