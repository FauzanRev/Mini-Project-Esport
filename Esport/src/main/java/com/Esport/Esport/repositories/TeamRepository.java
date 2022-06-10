package com.Esport.Esport.repositories;

import com.Esport.Esport.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    @Query(value = """
            SELECT *
            FROM Teams
            WHERE CountryId = :CountryId
            """, nativeQuery = true)
    List<Team> getTeamByCountryId(@Param("CountryId")int CountryId);

}