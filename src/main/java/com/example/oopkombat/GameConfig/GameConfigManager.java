package com.example.oopkombat.GameConfig;

import com.example.oopkombat.GameManager.GameManager;
import com.example.oopkombat.GameState.GameState;
import com.example.oopkombat.Model.GameConfigModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Service
public class GameConfigManager {
    private final GameManager gameManager;
    private final Map<UUID, GameConfigModel> gameConfigs = new ConcurrentHashMap<>();

    public UUID newConfig(UUID gameID) {
        UUID uuid = UUID.randomUUID();
        gameConfigs.put(uuid, new GameConfigModel());
        GameState gs = gameManager.getGame(gameID);
        gs.setGameConfigId(uuid);
        return uuid;
    }

    public GameConfigModel getGameConfig(UUID gameId) {
        return gameConfigs.get(gameId);
    }
}
