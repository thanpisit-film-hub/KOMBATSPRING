package com.example.oopkombat.Controller;

import com.example.oopkombat.DTO.CreateBudgetPlayer;
import com.example.oopkombat.DTO.CreateCurrentTurn;
import com.example.oopkombat.DTO.CreateHexRespond;
import com.example.oopkombat.DTO.CreateMinionRespond;
import com.example.oopkombat.Repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/info")
public class CoreInfoController {
    private final InfoRepository infoRepository;

    @GetMapping("/turn/{gameId}")
    public CreateCurrentTurn getCurrentTurn(@PathVariable UUID gameId) {
        return infoRepository.getCurrentTurn(gameId);
    }

    @GetMapping("/all-hex/{gameId}")
    public List<CreateHexRespond> getHexes(@PathVariable UUID gameId) {
        return infoRepository.getAllHexInfo(gameId);
    }

    @GetMapping("/own-hex/{gameId}/{playerId}")
    public List<CreateHexRespond> getOwnHexes(@PathVariable UUID gameId, @PathVariable UUID playerId) {
        return infoRepository.getOwnHex(gameId, playerId);
    }

    @GetMapping("/own-minion/{gameId}/{playerId}")
    public List<CreateMinionRespond> getOwnMinion(@PathVariable UUID gameId, @PathVariable UUID playerId) {
        return infoRepository.getOwnMinion(gameId, playerId);
    }

    @GetMapping("/budget/{gameId}/{playerId}")
    public CreateBudgetPlayer getBudgetPlayer(@PathVariable UUID gameId, @PathVariable UUID playerId) {
        return infoRepository.getBudgetPlayer(gameId, playerId);
    }

    @GetMapping("/available-hex")
    public List<CreateHexRespond> getAvailableHexes(@PathVariable UUID gameId) {
        return infoRepository.gerAvailableHex(gameId);
    }
}
