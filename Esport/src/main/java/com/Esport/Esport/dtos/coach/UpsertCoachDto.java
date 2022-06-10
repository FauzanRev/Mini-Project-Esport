package com.Esport.Esport.dtos.coach;

import com.Esport.Esport.models.Coach;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpsertCoachDto {
    private  Integer userId;
    private  Integer teamId;
    private  String nickname;
    private BigDecimal value;

    public Coach convert(){
        return new Coach(
                userId,
                teamId,
                nickname,
                value
        );
    }
}
