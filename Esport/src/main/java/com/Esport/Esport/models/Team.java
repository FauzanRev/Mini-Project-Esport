package com.Esport.Esport.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TeamId", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CountryId", nullable = false)
    private Country country;

    @Column(name = "\"Value\"", nullable = false, precision = 19, scale = 4)
    private BigDecimal value;

    @OneToMany(mappedBy = "team")
    private Set<Player> players = new LinkedHashSet<>();

    @OneToMany(mappedBy = "team")
    private Set<Coach> coachs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "team")
    private Set<MatchHistory> matchHistories = new LinkedHashSet<>();

    public Team(Integer id, String name, Integer country, BigDecimal value) {
        this.id = id;
        this.name = name;
        this.country = new Country(country);
        this.value = value;
    }

    public Team(String name, Integer country, BigDecimal value) {
        this.name = name;
        this.country = new Country(country);
        this.value = value;
    }

    public Team(Integer id) {
        this.id = id;
    }

    public Team(Country country, String name, Integer countryId, BigDecimal value) {
        this.country = country;
        this.name = name;
        this.country.setId(countryId);
    }
}