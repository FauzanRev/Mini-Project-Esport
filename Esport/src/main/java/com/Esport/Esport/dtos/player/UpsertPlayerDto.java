package com.Esport.Esport.dtos.player;

import com.Esport.Esport.models.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpsertPlayerDto {
    private  Integer userId;
    private  Integer teamId;
    private  String nickname;
    private  BigDecimal value;

    public Player convert(){
        return new Player(
                userId,
                teamId,
                nickname,
                value
        );
    }
}
