package com.Esport.Esport.dtos.matchhistory;

import com.Esport.Esport.models.MatchHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpsertMatchHistoryDto {
    private String date;
    private String tournament;
    private Integer teamId;
    private String result;
    private BigDecimal price;

    public MatchHistory convert(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new MatchHistory(
                LocalDate.parse(date,dateTimeFormatter),
                tournament,
                teamId,
                result,
                price
        );
    }
}
