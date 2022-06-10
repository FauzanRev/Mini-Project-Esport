package com.Esport.Esport.repositories;

import com.Esport.Esport.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query(value = """
            SELECT *
            FROM Players
            WHERE TeamId = :TeamId
            """, nativeQuery = true)
    List<Player> findPlayerByTeamId(@Param("TeamId")int CountryId);

    @Query(value = """
            SELECT *
            FROM Players
            WHERE UserId= :UserId
            """, nativeQuery = true)
    List<Player> findPlayerByUserId(@Param("UserId")int UserId);
}