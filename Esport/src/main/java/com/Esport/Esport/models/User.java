package com.Esport.Esport.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "[User]")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId", nullable = false)
    private Integer id;

    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LastName", length = 50)
    private String lastName;

    @Column(name = "BirthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "BirthPlace", nullable = false, length = 30)
    private String birthPlace;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CountryId", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "user")
    private Set<Player> players = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Coach> coachs = new LinkedHashSet<>();

    public User(String firstName, String lastName, LocalDate birthDate, String birthPlace, Integer country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.country = new Country(country);
    }
    public User(String firstName, LocalDate birthDate, String birthPlace, Integer country) {
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.country = new Country(country);
    }
    public User(Integer id) {
        this.id = id;
    }
}