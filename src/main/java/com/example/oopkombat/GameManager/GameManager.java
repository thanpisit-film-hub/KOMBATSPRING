package com.example.oopkombat.GameManager;

import com.example.oopkombat.GameState.GameState;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@NoArgsConstructor
public class GameManager {
    private final Map<UUID, GameState> games = new ConcurrentHashMap<>();

    public UUID newGame() {
        UUID gameId = UUID.randomUUID();
        GameState gs = new GameState();
        gs.setGameId(gameId);
        games.put(gameId, gs);
        return gameId;
    }

    public GameState getGame(UUID gameId) {
        return games.get(gameId);
    }
}
