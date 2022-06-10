package com.Esport.Esport.repositories;

import com.Esport.Esport.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = """
            SELECT *
            FROM [User]
            WHERE CountryId = :CountryId
            """, nativeQuery = true)
    List<User> getUserByCountryId(@Param("CountryId")int CountryId);

}