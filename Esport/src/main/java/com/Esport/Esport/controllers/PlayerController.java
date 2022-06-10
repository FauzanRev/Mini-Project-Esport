package com.Esport.Esport.controllers;

import com.Esport.Esport.RestResponse;
import com.Esport.Esport.dtos.player.PlayerHeaderDto;
import com.Esport.Esport.dtos.player.UpsertPlayerDto;
import com.Esport.Esport.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("player")
public class PlayerController {
    private PlayerService service;

    @Autowired
    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping("get-all")
    public ResponseEntity<RestResponse<List<PlayerHeaderDto>>> findAllPlayer() {
        return ResponseEntity.ok().body(
                new RestResponse<>(service.findAllPlayer(),
                        "Berhasil mendapatkan semua data player",
                        "200"));
    }

    @GetMapping("get-by-id/{id}")
    public ResponseEntity<RestResponse<PlayerHeaderDto>> findPlayerById(@PathVariable int id) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.findPlayerById(id),
                        "Berhasil mendapatkan data player dengan id " + id,
                        "200"));
    }

    @PostMapping("insert")
    public ResponseEntity<RestResponse<Boolean>> insertPlayer(@RequestBody UpsertPlayerDto newPlayer) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.insertPlayer(newPlayer),
                        "Berhasil menambahkan data player",
                        "200"));
    }

    @PutMapping("update/{playerId}")
    public ResponseEntity<RestResponse<Boolean>> updatePlayer(@PathVariable int playerId, @RequestBody UpsertPlayerDto updatedPlayer) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.updatePlayer(playerId, updatedPlayer),
                        "Berhasil mengubah data player dengan id " + playerId,
                        "200"));
    }

    @DeleteMapping("delete/{playerId}")
    public ResponseEntity<RestResponse<Boolean>> deletePlayer(@PathVariable int playerId) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.deletePlayer(playerId),
                        "Berhasil menghapus data player dengan id " + playerId,
                        "200"));
    }

    @GetMapping("team/{teamId}")
    public ResponseEntity<RestResponse<List<PlayerHeaderDto>>> findPlayerByTeamId(@PathVariable int teamId) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.findPlayerByTeamId(teamId),
                        "Berhasil mendapatkan data player berdasarkan TeamId " + teamId,
                        "200"));
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<RestResponse<List<PlayerHeaderDto>>> findPlayerByUserId(@PathVariable int userId) {
        return ResponseEntity.ok().body(
                new RestResponse<>(
                        service.findPlayerByUserId(userId),
                        "Berhasil mendapatkan data player berdasarkan UserId " + userId,
                        "200"));
    }
}
