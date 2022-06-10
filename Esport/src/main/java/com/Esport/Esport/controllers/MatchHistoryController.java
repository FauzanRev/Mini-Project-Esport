package com.Esport.Esport.controllers;

import com.Esport.Esport.RestResponse;
import com.Esport.Esport.dtos.matchhistory.MatchHistoryHeaderDto;
import com.Esport.Esport.dtos.matchhistory.UpsertMatchHistoryDto;
import com.Esport.Esport.models.MatchHistory;
import com.Esport.Esport.services.MatchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("match-history")
public class MatchHistoryController {
    private MatchHistoryService service;

    @Autowired
    public MatchHistoryController(MatchHistoryService service) {
        this.service = service;
    }

    @GetMapping("get-all")
    public ResponseEntity<RestResponse<List<MatchHistoryHeaderDto>>> findAllMatchHistory() {
        return ResponseEntity.ok().body(
                new RestResponse<>(service.findAllMatchHistory(),
                        "Berhasil mendapatkan semua data match history",
                        "200"));
    }

    @GetMapping("get-by-id/{id}")
    public ResponseEntity<RestResponse<MatchHistoryHeaderDto>> findMatchHistoryById(@PathVariable int id) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.findMatchHistoryById(id),
                        "Berhasil mendapatkan data match history dengan id " + id,
                        "200"));
    }

    @PostMapping("insert")
    public ResponseEntity<RestResponse<Boolean>> insertMatchHistory(@RequestBody UpsertMatchHistoryDto newMatchHistory) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.insertMatchHistory(newMatchHistory.getTeamId(), newMatchHistory),
                        "Berhasil menambahkan data match history",
                        "200"));
    }

    @PutMapping("update/{matchHistoryId}")
    public ResponseEntity<RestResponse<Boolean>> updateMatchHistory(@PathVariable int matchHistoryId, @RequestBody UpsertMatchHistoryDto updatedMatchHistory) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.updateMatchHistory(matchHistoryId, updatedMatchHistory),
                        "Berhasil mengubah data match history dengan id " + matchHistoryId,
                        "200"));
    }

    @DeleteMapping("delete/{matchHistoryId}")
    public ResponseEntity<RestResponse<Boolean>> deleteMatchHistory(@PathVariable int matchHistoryId) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.deleteMatchHistory(matchHistoryId),
                        "Berhasil menghapus data match history dengan id " + matchHistoryId,
                        "200"));
    }

    @GetMapping("team/{teamId}")
    public ResponseEntity<RestResponse<List<MatchHistoryHeaderDto>>> findMatchHistoryByTeamId(@PathVariable int teamId) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.findMatchHistoryByTeamId(teamId),
                        "Berhasil mendapatkan data match history dengan TeamId " + teamId,
                        "200"));
    }
}
