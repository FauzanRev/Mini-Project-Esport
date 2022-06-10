package com.Esport.Esport.controllers;

import com.Esport.Esport.RestResponse;
import com.Esport.Esport.dtos.coach.CoachHeaderDto;
import com.Esport.Esport.dtos.coach.UpsertCoachDto;
import com.Esport.Esport.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coach")
public class CoachController {
    private CoachService service;

    @Autowired
    public CoachController(CoachService service) {
        this.service = service;
    }

    @GetMapping("get-all")
    public ResponseEntity<RestResponse<List<CoachHeaderDto>>> findAllCoach() {
        return ResponseEntity.ok().body(
                new RestResponse<>(service.findAllCoach(),
                        "Berhasil mendapatkan semua data coach",
                        "200"));
    }

    @GetMapping("get-by-id/{id}")
    public ResponseEntity<RestResponse<CoachHeaderDto>> findCoachById(@PathVariable int id) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.findCoachById(id),
                        "Berhasil mendapatkan data coach dengan id " + id,
                        "200"));
    }

    @PostMapping("insert")
    public ResponseEntity<RestResponse<Boolean>> insertCoach(@RequestBody UpsertCoachDto newCoach) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.insertCoach(newCoach.getTeamId(), newCoach),
                        "Berhasil menambahkan data coach",
                        "200"));
    }

    @PutMapping("update/{coachId}")
    public ResponseEntity<RestResponse<Boolean>> updateCoach(@PathVariable int coachId, @RequestBody UpsertCoachDto updatedCoach) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.updateCoach(coachId, updatedCoach),
                        "Berhasil mengubah data coach dengan id " + coachId,
                        "200"));
    }

    @DeleteMapping("delete/{coachId}")
    public ResponseEntity<RestResponse<Boolean>> deleteCoach(@PathVariable int coachId) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.deleteCoach(coachId),
                        "Berhasil menghapus data coach dengan id " + coachId,
                        "200"));
    }

    @GetMapping("team/{teamId}")
    public ResponseEntity<RestResponse<List<CoachHeaderDto>>> findCoachByTeam(@PathVariable int teamId) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.getCoachByTeamId(teamId),
                        "Berhasil mendapatkan data coach dari TeamId " + teamId,
                        "200"));
    }
    @GetMapping("user/{userId}")
    public ResponseEntity<RestResponse<List<CoachHeaderDto>>> findCoachByUser(@PathVariable int userId) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.getCoachByUserId(userId),
                        "Berhasil mendapatkan data coach dari UserId " + userId,
                        "200"));
    }

}
