package com.Esport.Esport.services;

import com.Esport.Esport.dtos.coach.CoachHeaderDto;
import com.Esport.Esport.dtos.coach.UpsertCoachDto;
import com.Esport.Esport.models.Coach;
import com.Esport.Esport.models.Team;
import com.Esport.Esport.models.User;
import com.Esport.Esport.repositories.CoachRepository;
import com.Esport.Esport.repositories.TeamRepository;
import com.Esport.Esport.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoachService {
    CoachRepository coachRepository;
    TeamRepository teamRepository;
    UserRepository userRepository;

    @Autowired
    public CoachService(CoachRepository coachRepository, TeamRepository teamRepository, UserRepository userRepository) {
        this.coachRepository = coachRepository;
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
    }

    public List<CoachHeaderDto> findAllCoach(){
        return coachRepository.findAll().stream()
                .map(CoachHeaderDto::set)
                .collect(java.util.stream.Collectors.toList());
    }

    public CoachHeaderDto findCoachById(Integer id){
        return coachRepository.findById(id).map(CoachHeaderDto::set).orElseThrow(() ->
                new EntityNotFoundException("Coach not found"));
    }

    public boolean insertCoach(Integer teamId,UpsertCoachDto newCoach){
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new EntityNotFoundException("Team not found"));
        User user = userRepository.findById(newCoach.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found"));
        Coach coach = new Coach(
                team,
                user,
                newCoach.getUserId(),
                newCoach.getTeamId(),
                newCoach.getNickname(),
                newCoach.getValue());
        coachRepository.save(coach);

        BigDecimal newValue = newCoach.getValue();
        if(newCoach.getTeamId() == team.getId()){
            newValue = team.getValue().subtract(newCoach.getValue());
        }
        team.setValue(newValue);
        teamRepository.save(team);
        return true;
    }

    public boolean updateCoach(int id, UpsertCoachDto updatedCoach){
        Coach coach = coachRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Coach not found"));
        Team team = teamRepository.findById(updatedCoach.getTeamId()).orElseThrow(() -> new EntityNotFoundException("Team not found"));
        coach.setUserId(updatedCoach.getUserId());
        coach.setTeamId(updatedCoach.getTeamId());
        coach.setNickname(updatedCoach.getNickname());
        coach.setValue(updatedCoach.getValue());
        coachRepository.save(coach);

        BigDecimal newValue = updatedCoach.getValue();
        if(updatedCoach.getTeamId() == team.getId()){
            newValue = team.getValue().subtract(updatedCoach.getValue());
        }
        team.setValue(newValue);
        teamRepository.save(team);
        return true;
    }

    public boolean deleteCoach(int id){
        Coach coach = coachRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Coach not found"));
        coachRepository.delete(coach);
        return true;
    }

    public List<CoachHeaderDto> getCoachByTeamId(int teamId){
       List<CoachHeaderDto> listCoach = CoachHeaderDto.toList(coachRepository.findCoachByTeamId(teamId));
       if(listCoach.isEmpty()){
           throw new EntityNotFoundException("Coach not found");
       }
       return listCoach;
    }

    public List<CoachHeaderDto> getCoachByUserId(int userId){
        List<CoachHeaderDto> listUser = CoachHeaderDto.toList(coachRepository.findCoachByUserId(userId));
        if(listUser.isEmpty()){
            throw new EntityNotFoundException("Coach not found");
        }
        return listUser;
    }
}

