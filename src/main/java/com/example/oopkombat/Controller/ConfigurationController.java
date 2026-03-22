package com.example.oopkombat.Controller;

import com.example.oopkombat.DTO.CreateConfig;
import com.example.oopkombat.Model.GameConfigModel;
import com.example.oopkombat.Repository.ConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/config")
public class ConfigurationController {
    private final ConfigRepository configRepository;

    // /config/setup-config
    @PostMapping("/setup-config")
    public UUID newConfig(@RequestBody CreateConfig createConfig){
        return configRepository.setUpGameConfig(createConfig.getGameID(),
                createConfig.getStartingGold(),
                createConfig.getMaxGold(),
                createConfig.getGoldPerRound(),
                createConfig.getInterestRate(),
                createConfig.getHexCost(),
                createConfig.getTurnLimit(),
                createConfig.getMinionHp(),
                createConfig.getMaxMinions(),
                createConfig.getMinionCost());
    }

    @GetMapping("/{gameId}/{gameConfigId}")
    public GameConfigModel getConfig(@PathVariable UUID gameId,
                                     @PathVariable UUID gameConfigId) {
        return configRepository.getGameConfig(gameId, gameConfigId);
    }
}
