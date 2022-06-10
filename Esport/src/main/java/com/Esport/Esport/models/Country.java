package com.Esport.Esport.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CountryId", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 100)
    private String description;

    @OneToMany(mappedBy = "country")
    private Set<Team> teams = new LinkedHashSet<>();

    @OneToMany(mappedBy = "country")
    private Set<User> users = new LinkedHashSet<>();

    public Country(String description) {
        this.description = description;
    }

    public Country(Integer id) {
        this.id = id;
    }



}