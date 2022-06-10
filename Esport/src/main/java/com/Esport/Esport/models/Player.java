package com.Esport.Esport.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlayerId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TeamId")
    private Team team;

    @Column(name = "Nickname", nullable = false, length = 30)
    private String nickname;

    @Column(name = "\"Value\"", nullable = false, precision = 19, scale = 4)
    private BigDecimal value;

    public Player(Integer id, Integer user, Integer team, String nickname, BigDecimal value) {
        this.id = id;
        this.user = new User(user);
        this.team = new Team(team);
        this.nickname = nickname;
        this.value = value;
    }

    public Player(Integer user, Integer team, String nickname, BigDecimal value) {
        this.user = new User(user);
        this.team = new Team(team);
        this.nickname = nickname;
        this.value = value;
    }

    public Player(Team team, User user, Integer userId, Integer teamId, String nickname, BigDecimal value) {
        this.team = team;
        this.user = user;
        this.team = new Team(teamId);
        this.nickname = nickname;
        this.value = value;
    }

    public void setUserId(Integer userId) {
        this.user.setId(userId);
    }

    public void setTeamId(Integer teamId) {
        this.team.setId(teamId);
    }
}