package com.example.oopkombat.Repository;

import com.example.oopkombat.GameManager.GameManager;
import com.example.oopkombat.GameState.GameState;
import com.example.oopkombat.Mode;
import com.example.oopkombat.Model.ModeModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ModRepository implements iModRepository {
    private final GameManager gameManager;

    // เลือก Mode
    @Override
    public ModeModel selectMod(Mode mode) {
        if (mode == null) return null;
        UUID gameId = gameManager.newGame();
        GameState gs = gameManager.getGame(gameId);
        gs.setGameMode(mode);
        return new ModeModel(gameId, mode);
    }
}
