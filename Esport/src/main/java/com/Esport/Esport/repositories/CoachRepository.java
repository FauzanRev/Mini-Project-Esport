package com.Esport.Esport.repositories;

import com.Esport.Esport.models.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach, Integer> {
    @Query(value = """
            SELECT *
            FROM Coaches
            WHERE TeamId = :TeamId
            """, nativeQuery = true)
    List<Coach> findCoachByTeamId(@Param("TeamId")int CountryId);

    @Query(value = """
            SELECT *
            FROM Coaches
            WHERE UserId= :UserId
            """, nativeQuery = true)
    List<Coach> findCoachByUserId(@Param("UserId")int UserId);
}