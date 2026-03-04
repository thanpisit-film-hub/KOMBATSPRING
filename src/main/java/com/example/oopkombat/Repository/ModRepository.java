package com.example.oopkombat.Repository;

import com.example.oopkombat.GameManager.GameManager;
import com.example.oopkombat.GameState.GameState;
import com.example.oopkombat.Mode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ModRepository implements iModRepository {
    private final GameManager gameManager;

    @Override
    public UUID selectMod(Mode mode) {
        if (mode == null) return null;
        String gameId = gameManager.newGame();
        GameState gs = gameManager.getGame(gameId);
        gs.setGameMode(mode);
        return UUID.fromString(gameId);
    }
}
