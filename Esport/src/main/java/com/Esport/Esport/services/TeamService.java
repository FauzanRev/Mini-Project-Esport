package com.Esport.Esport.services;

import com.Esport.Esport.dtos.team.TeamHeaderDto;
import com.Esport.Esport.dtos.team.UpsertTeamDto;
import com.Esport.Esport.models.Country;
import com.Esport.Esport.models.Team;
import com.Esport.Esport.repositories.CountryRepository;
import com.Esport.Esport.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TeamService {
    TeamRepository teamRepository;
    CountryRepository countryRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, CountryRepository countryRepository) {
        this.teamRepository = teamRepository;
        this.countryRepository = countryRepository;
    }

    public List<TeamHeaderDto> findAllTeam(){
        return teamRepository.findAll().stream()
                .map(TeamHeaderDto::set)
                .collect(java.util.stream.Collectors.toList());
    }

    public TeamHeaderDto findTeamById(Integer id){
        return teamRepository.findById(id).map(TeamHeaderDto::set).orElseThrow(() ->
                new EntityNotFoundException("Team not found"));
    }

    public boolean insertTeam(UpsertTeamDto newTeam){
        Team team = new Team(
                newTeam.getName(),
                newTeam.getCountryId(),
                newTeam.getValue()
        );

        teamRepository.save(team);
        return true;
    }

    public boolean updateTeam(int id, UpsertTeamDto updatedTeam) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Team not found"));
        team.setName(updatedTeam.getName());
        team.setCountry(updatedTeam.convert().getCountry());
        team.setValue(updatedTeam.getValue());
        teamRepository.save(team);
        return true;
    }

    public boolean deleteTeam(int id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Team not found"));
        teamRepository.delete(team);
        return true;
    }

    public List<TeamHeaderDto> findTeamByCountryId(int country){
        return teamRepository.getTeamByCountryId(country).stream()
                .map(TeamHeaderDto::set)
                .collect(java.util.stream.Collectors.toList());
    }

}
