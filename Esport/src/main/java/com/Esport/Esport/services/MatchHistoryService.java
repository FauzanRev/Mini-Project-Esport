package com.Esport.Esport.services;

import com.Esport.Esport.dtos.matchhistory.MatchHistoryHeaderDto;
import com.Esport.Esport.dtos.matchhistory.UpsertMatchHistoryDto;
import com.Esport.Esport.models.MatchHistory;
import com.Esport.Esport.models.Team;
import com.Esport.Esport.repositories.MatchHistoryRepository;
import com.Esport.Esport.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MatchHistoryService {
    MatchHistoryRepository matchHistoryRepository;
    TeamRepository teamRepository;

    @Autowired
    public MatchHistoryService(MatchHistoryRepository matchHistoryRepository, TeamRepository teamRepository) {
        this.matchHistoryRepository = matchHistoryRepository;
        this.teamRepository = teamRepository;
    }

    public List<MatchHistoryHeaderDto> findAllMatchHistory(){
        return matchHistoryRepository.findAll().stream()
                .map(MatchHistoryHeaderDto::set)
                .collect(java.util.stream.Collectors.toList());
    }

    public MatchHistoryHeaderDto findMatchHistoryById(Integer id){
        return matchHistoryRepository.findById(id).map(MatchHistoryHeaderDto::set).orElseThrow(() ->
                new EntityNotFoundException("MatchHistory not found"));
    }

    public boolean insertMatchHistory(Integer teamId,UpsertMatchHistoryDto newMatchHistory){
        Team team = teamRepository.findById(teamId).orElseThrow((() -> new EntityNotFoundException("Team not found")));
        MatchHistory matchHistory = new MatchHistory(
                team,
                LocalDate.parse(newMatchHistory.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                newMatchHistory.getTournament(),
                newMatchHistory.getTeamId(),
                newMatchHistory.getResult(),
                newMatchHistory.getPrice());
                matchHistoryRepository.save(matchHistory);

        BigDecimal newValue = newMatchHistory.getPrice();
        if (newMatchHistory.getTeamId() == team.getId()){
            newValue = newMatchHistory.getPrice().add(team.getValue());
        }
        team.setValue(newValue);
        teamRepository.save(team);
        return true;
    }

    public boolean updateMatchHistory(int id, UpsertMatchHistoryDto updatedMatchHistory){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        MatchHistory matchHistory = matchHistoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("MatchHistory not found"));
        Team team = teamRepository.findById(updatedMatchHistory.getTeamId()).orElseThrow((() -> new EntityNotFoundException("Team not found")));

        matchHistory.setDate(LocalDate.parse(updatedMatchHistory.getDate(), dateTimeFormatter));
        matchHistory.setTournament(updatedMatchHistory.getTournament());
        matchHistory.setTeamId(updatedMatchHistory.getTeamId());
        matchHistory.setResult(updatedMatchHistory.getResult());
        matchHistory.setPrice(updatedMatchHistory.getPrice());
        matchHistoryRepository.save(matchHistory);

        BigDecimal newValue = updatedMatchHistory.getPrice();
        if (updatedMatchHistory.getTeamId() == team.getId()){
            newValue = updatedMatchHistory.getPrice().add(team.getValue());
        }
        team.setValue(newValue);
        teamRepository.save(team);
        return true;
    }

    public boolean deleteMatchHistory(int id){
        MatchHistory matchHistory = matchHistoryRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("MatchHistory not found"));
        matchHistoryRepository.delete(matchHistory);
        return true;
    }

    public List<MatchHistoryHeaderDto> findMatchHistoryByTeamId(int teamId){
        List<MatchHistoryHeaderDto> listTeam = MatchHistoryHeaderDto.toList(
                matchHistoryRepository.findMatchHistoryByTeamId(teamId));

        if(listTeam.isEmpty()){
            throw new EntityNotFoundException("MatchHistory not found");
        }
        return listTeam;
    }
}
