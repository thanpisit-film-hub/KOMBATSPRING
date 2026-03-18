package com.example.oopkombat.Repository;


import com.example.oopkombat.DTO.CreateBudgetPlayer;
import com.example.oopkombat.DTO.CreateCurrentTurn;
import com.example.oopkombat.DTO.CreateHexRespond;
import com.example.oopkombat.DTO.CreateMinionRespond;
import com.example.oopkombat.GameManager.GameManager;
import com.example.oopkombat.GameState.GameState;
import com.example.oopkombat.Hex.Hex;
import com.example.oopkombat.Minion.Minion;
import com.example.oopkombat.Player.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class InfoRepository {
    private final GameManager gameManager;

    public CreateCurrentTurn getCurrentTurn(UUID gameId) {
        GameState gameState = gameManager.getGame(gameId);
        if(gameState == null) return null;

        CreateCurrentTurn createCurrentTurn = new CreateCurrentTurn();
        createCurrentTurn.setCurrentTurn(gameState.getCurrentTurn());

        return createCurrentTurn;
    }

    public List<Hex> getAllHexInfo(UUID gameId) {
        GameState gameState = gameManager.getGame(gameId);
        if(gameState == null) return List.of();
        return gameState.getAllHexInfo();
    }

    public List<CreateHexRespond> getOwnHex(UUID gameId, UUID playerId) {
        List<CreateHexRespond> list = new ArrayList<>();

        GameState gameState = gameManager.getGame(gameId);
        if (gameState == null) return List.of();

        Player player = gameState.getPlayers().get(playerId);
        if (player == null) return List.of();

        Iterator<Hex> poh = player.getOwnHex().iterator();
        while(poh.hasNext()){
            CreateHexRespond createHexRespond = new CreateHexRespond();
            Hex hex = poh.next();

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

    public CreateBudgetPlayer getBudgetPlayer(UUID gameId, UUID playerId) {
        GameState gameState = gameManager.getGame(gameId);
        if (gameState == null) return null;

        Player player = gameState.getPlayers().get(playerId);
        if (player == null) return null;

        CreateBudgetPlayer createBudgetPlayer = new CreateBudgetPlayer();
        createBudgetPlayer.setBudget(player.getBudget());

        return createBudgetPlayer;
    }

    public List<CreateMinionRespond> getOwnMinion(UUID gameId, UUID playerId) {
        List<CreateMinionRespond> list = new ArrayList<>();
        GameState gameState = gameManager.getGame(gameId);
        if (gameState == null) return null;

        Player player = gameState.getPlayers().get(playerId);
        if (player == null) return null;

        Iterator<Minion> mop = player.getMinions().iterator();
        while(mop.hasNext()){
            CreateMinionRespond createMinionRespond = new CreateMinionRespond();
            Minion minion = mop.next();
            createMinionRespond.setMinionTypeId(minion.getModel().getMinionTypeID());
            createMinionRespond.setMinionId(minion.getMinionId());
            createMinionRespond.setPlayerId(minion.getOwner().getPlayerId());
            list.add(createMinionRespond);
        }

        return list;
    }
}
