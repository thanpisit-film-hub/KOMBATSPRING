package com.example.oopkombat.GameManager;

import com.example.oopkombat.GameState.GameState;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameManager {
    private final Map<String, GameState> games = new ConcurrentHashMap<>();

    public String newGame() {
        String gameId = UUID.randomUUID().toString();
        GameState gs = new GameState();
        gs.setGameId(gameId);
        games.put(gameId, gs);
        return gameId;
    }

    public GameState getGame(String gameId) {
        return games.get(gameId);
    }
}
