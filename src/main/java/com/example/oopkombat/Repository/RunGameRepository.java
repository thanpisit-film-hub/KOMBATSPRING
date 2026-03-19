package com.example.oopkombat.Repository;


import com.example.oopkombat.DTO.CreateHexRespond;

import com.example.oopkombat.GameManager.GameManager;
import com.example.oopkombat.GameState.GameState;
import com.example.oopkombat.Hex.Hex;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class RunGameRepository {
    private final GameManager gameManager;

    // buy hex
    public List<CreateHexRespond> buyHex(UUID gameId, UUID playerId, int row, int col) {
        List<CreateHexRespond> list = new ArrayList<>();
        GameState gameState = gameManager.getGame(gameId);
        if (gameState == null) return null;

        //

        // method(Buy hex here) must update All hex before while-loop

        //

        Iterator<Hex> avh =  gameState.getAllHexInfo().iterator();
        while(avh.hasNext()){
            CreateHexRespond createHexRespond = new CreateHexRespond();
            Hex hex = avh.next();

            createHexRespond.setRow(hex.getRow());
            createHexRespond.setCol(hex.getCol());
            if (hex.getPlayer() != null) {
                createHexRespond.setPlayerId(hex.getPlayer().getPlayerId());
            }
            if (hex.getMinion() != null) {
                createHexRespond.setMinionId(hex.getMinion().getMinionId());
            }
            list.add(createHexRespond);
        }
        return list;
    }

    // buy minion
    public List<CreateHexRespond> buyMinion(UUID  gameId, UUID minionTypeId, UUID playerId, int row, int col) {
        List<CreateHexRespond> list = new ArrayList<>();
        GameState gameState = gameManager.getGame(gameId);
        if (gameState == null) return null;

        //

        // method(Buy minion here) must update All hex before while-loop

        //

        Iterator<Hex> avh = gameState.getAllHexInfo().iterator();
        while (avh.hasNext()) {
            CreateHexRespond createHexRespond = new CreateHexRespond();
            Hex hex = avh.next();

            createHexRespond.setRow(hex.getRow());
            createHexRespond.setCol(hex.getCol());
            if (hex.getPlayer() != null) {
                createHexRespond.setPlayerId(hex.getPlayer().getPlayerId());
            }
            if (hex.getMinion() != null) {
                createHexRespond.setMinionId(hex.getMinion().getMinionId());
            }
            list.add(createHexRespond);
        }
        return list;
    }

    // end turn execute
    public List<CreateHexRespond> endTurn(UUID  gameId, UUID playerId) {
        List<CreateHexRespond> list = new ArrayList<>();
        GameState gameState = gameManager.getGame(gameId);
        if (gameState == null) return null;

        //

        // method(end-turn here) must update All hex before while-loop

        //

        Iterator<Hex> avh = gameState.getAllHexInfo().iterator();
        while (avh.hasNext()) {
            CreateHexRespond createHexRespond = new CreateHexRespond();
            Hex hex = avh.next();

            createHexRespond.setRow(hex.getRow());
            createHexRespond.setCol(hex.getCol());
            if (hex.getPlayer() != null) {
                createHexRespond.setPlayerId(hex.getPlayer().getPlayerId());
            }
            if (hex.getMinion() != null) {
                createHexRespond.setMinionId(hex.getMinion().getMinionId());
            }
            list.add(createHexRespond);
        }
        return list;
    }

}
