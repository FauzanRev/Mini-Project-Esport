package com.Esport.Esport.controllers;

import com.Esport.Esport.RestResponse;
import com.Esport.Esport.dtos.team.TeamHeaderDto;
import com.Esport.Esport.dtos.team.UpsertTeamDto;
import com.Esport.Esport.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("team")
public class TeamController {
    private TeamService service;

    @Autowired
    public TeamController(TeamService service) {
        this.service = service;
    }

    @GetMapping("get-all")
    public ResponseEntity<RestResponse<List<TeamHeaderDto>>> findAllTeam() {
        return ResponseEntity.ok().body(
                new RestResponse<>(service.findAllTeam(),
                        "Berhasil mendapatkan semua data team",
                        "200"));
    }

    @GetMapping("get-by-id/{id}")
    public ResponseEntity<RestResponse<TeamHeaderDto>> findTeamById(@PathVariable int id) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.findTeamById(id),
                        "Berhasil mendapatkan data team dengan id " + id,
                        "200"));
    }

    @PostMapping("insert")
    public ResponseEntity<RestResponse<Boolean>> insertTeam(@RequestBody UpsertTeamDto newTeam) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.insertTeam(newTeam),
                        "Berhasil menambahkan data team baru",
                        "200"));
    }

    @PutMapping("update/{teamId}")
    public ResponseEntity<RestResponse<Boolean>> updateTeam(@PathVariable int teamId, @RequestBody UpsertTeamDto updatedTeam) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.updateTeam(teamId, updatedTeam),
                        "Berhasil mengubah data team dengan id " + teamId,
                        "200"));
    }

    @DeleteMapping("delete/{teamId}")
    public ResponseEntity<RestResponse<Boolean>> deleteTeam(@PathVariable int teamId) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.deleteTeam(teamId),
                        "Berhasil menghapus data team dengan id " + teamId,
                        "200"));
    }

    @GetMapping("country/{countryId}")
    public ResponseEntity<RestResponse<List<TeamHeaderDto>>> findTeamByCountryId(@PathVariable int countryId) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.findTeamByCountryId(countryId),
                        "Berhasil mendapatkan data team dengan CountryId " + countryId,
                        "200"));
    }

}
