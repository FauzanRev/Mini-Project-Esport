package com.Esport.Esport.repositories;

import com.Esport.Esport.models.MatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchHistoryRepository extends JpaRepository<MatchHistory, Integer> {
    @Query(value = """
            SELECT *
            FROM MatchHistories
            WHERE TeamId = :TeamId
            """, nativeQuery = true)
    List<MatchHistory> findMatchHistoryByTeamId(@Param("TeamId")int CountryId);
}