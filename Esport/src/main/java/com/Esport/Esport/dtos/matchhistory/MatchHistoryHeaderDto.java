package com.Esport.Esport.dtos.matchhistory;

import com.Esport.Esport.models.MatchHistory;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class MatchHistoryHeaderDto implements Serializable {
    private final Integer id;
    private final LocalDate date;
    private final String tournament;
    private final Integer teamId;
    private final String result;
    private final BigDecimal price;

    public static List<MatchHistoryHeaderDto> toList(List<MatchHistory> matchHistories){
        List<MatchHistoryHeaderDto> result = new ArrayList<>();

        for (MatchHistory matchHistory : matchHistories) {
            result.add(set(matchHistory));
        }
        return result;
    }

    public static MatchHistoryHeaderDto set(MatchHistory matchHistory){
        return new MatchHistoryHeaderDto(
                matchHistory.getId(),
                matchHistory.getDate(),
                matchHistory.getTournament(),
                matchHistory.getTeam().getId(),
                matchHistory.getResult(),
                matchHistory.getPrice()
        );
    }
}

