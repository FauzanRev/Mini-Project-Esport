package com.Esport.Esport.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MatchHistories")
public class MatchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MatchId", nullable = false)
    private Integer id;

    @Column(name = "\"Date\"", nullable = false)
    private LocalDate date;

    @Column(name = "Tournament", nullable = false, length = 100)
    private String tournament;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TeamId")
    private Team team;

    @Column(name = "Result", nullable = false, length = 10)
    private String result;

    @Column(name = "Price", nullable = false, precision = 19, scale = 4)
    private BigDecimal price;

    public MatchHistory(Integer id, LocalDate date, String tournament, Integer team, String result, BigDecimal price) {
        this.id = id;
        this.date = date;
        this.tournament = tournament;
        this.team = new Team(team);
        this.result = result;
        this.price = price;
    }

    public MatchHistory(LocalDate date, String tournament, Integer team, String result, BigDecimal price) {
        this.date = date;
        this.tournament = tournament;
        this.team = new Team(team);
        this.result = result;
        this.price = price;
    }

    public MatchHistory(Team team, LocalDate parse, String tournament, Integer teamId, String result, BigDecimal price) {
        this.team = team;
        this.date = parse;
        this.tournament = tournament;
        this.team = new Team(teamId);
        this.result = result;
        this.price = price;
    }

    public void setTeamId(Integer teamId) {
        this.team.setId(teamId);
    }
}