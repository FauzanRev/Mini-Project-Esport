package com.Esport.Esport.dtos.player;

import com.Esport.Esport.models.Player;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class PlayerHeaderDto implements Serializable {
    private final Integer id;
    private final Integer userId;
    private final Integer teamId;
    private final String nickname;
    private final BigDecimal value;

    public static List<PlayerHeaderDto> toList(List<Player> players){
        List<PlayerHeaderDto> result = new ArrayList<>();

        for (Player player : players) {
            result.add(set(player));
        }
        return result;
    }

    public static PlayerHeaderDto set(Player player){
        return new PlayerHeaderDto(
                player.getId(),
                player.getUser().getId(),
                player.getTeam().getId(),
                player.getNickname(),
                player.getValue()
        );
    }
}
