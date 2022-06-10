package com.Esport.Esport.services;

import com.Esport.Esport.dtos.player.PlayerHeaderDto;
import com.Esport.Esport.dtos.player.UpsertPlayerDto;
import com.Esport.Esport.models.Player;
import com.Esport.Esport.models.Team;
import com.Esport.Esport.models.User;
import com.Esport.Esport.repositories.PlayerRepository;
import com.Esport.Esport.repositories.TeamRepository;
import com.Esport.Esport.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PlayerService {
    PlayerRepository playerRepository;
    TeamRepository teamRepository;
    UserRepository userRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository, UserRepository userRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
    }

    public List<PlayerHeaderDto> findAllPlayer(){
        return playerRepository.findAll().stream()
                .map(PlayerHeaderDto::set)
                .collect(java.util.stream.Collectors.toList());
    }

    public PlayerHeaderDto findPlayerById(Integer id){
        return playerRepository.findById(id).map(PlayerHeaderDto::set).orElseThrow(() ->
                new EntityNotFoundException("Player not found"));
    }

    public boolean insertPlayer(UpsertPlayerDto newPlayer) {
        Team team = teamRepository.findById(newPlayer.getTeamId()).orElseThrow(()-> new EntityNotFoundException("Team not found"));
        User user = userRepository.findById(newPlayer.getUserId()).orElseThrow(()-> new EntityNotFoundException("User not found"));
        Player player = new Player(
                team,
                user,
                newPlayer.getUserId(),
                newPlayer.getTeamId(),
                newPlayer.getNickname(),
                newPlayer.getValue());
        playerRepository.save(player);

        BigDecimal newValue = newPlayer.getValue();
        if(newPlayer.getTeamId() == team.getId()){
            newValue = team.getValue().subtract(newPlayer.getValue());
        }
        team.setValue(newValue);
        teamRepository.save(team);
        return true;
    }

    public boolean updatePlayer(int id, UpsertPlayerDto updatedPlayer) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Player not found"));
        Team team = teamRepository.findById(updatedPlayer.getTeamId()).orElseThrow(()-> new EntityNotFoundException("Team not found"));
        User user = userRepository.findById(updatedPlayer.getUserId()).orElseThrow(()-> new EntityNotFoundException("User not found"));

        player.setUserId(updatedPlayer.getUserId());
        player.setTeamId(updatedPlayer.getTeamId());
        player.setNickname(updatedPlayer.getNickname());
        player.setValue(updatedPlayer.getValue());
        playerRepository.save(player);

        BigDecimal newValue = updatedPlayer.getValue();
        if(updatedPlayer.getTeamId() == team.getId()){
            newValue = team.getValue().subtract(updatedPlayer.getValue());
        }
        team.setValue(newValue);
        teamRepository.save(team);
        return true;
    }

    public boolean deletePlayer(int id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Player not found"));
        playerRepository.delete(player);
        return true;
    }

    public List<PlayerHeaderDto> findPlayerByTeamId(int teamId){
        return playerRepository.findPlayerByTeamId(teamId).stream()
                .map(PlayerHeaderDto::set)
                .collect(java.util.stream.Collectors.toList());
    }

    public List<PlayerHeaderDto> findPlayerByUserId(int userId){
        return playerRepository.findPlayerByUserId(userId).stream()
                .map(PlayerHeaderDto::set)
                .collect(java.util.stream.Collectors.toList());
    }

}
