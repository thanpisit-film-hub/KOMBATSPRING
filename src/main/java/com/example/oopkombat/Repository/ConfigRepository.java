package com.example.oopkombat.Repository;

import com.example.oopkombat.GameConfig.GameConfigManager;
import com.example.oopkombat.GameManager.GameManager;
import com.example.oopkombat.GameState.GameState;
import com.example.oopkombat.Model.GameConfigModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@AllArgsConstructor
public class ConfigRepository {
    private final GameConfigManager gameConfigManager;
    private final GameManager gameManager;

    public UUID setUpGameConfig(UUID gameID,
                                           long startingGold,
                                           long maxGold,
                                           long goldPerRound,
                                           long interestRate,
                                           long hexCost,
                                           long turnLimit,
                                           long minionHp,
                                           long maxMinions,
                                           long minionCost){

        GameState gs = gameManager.getGame(gameID);
        if(gs==null){
            return null;
        }

        UUID gameConfigUUID = gameConfigManager.newConfig(gameID);
        GameConfigModel gameConfigModel = gameConfigManager.getGameConfig(gameConfigUUID);

        if(gameConfigModel == null){return null;}

        gameConfigModel.setStartingGold(startingGold);
        gameConfigModel.setMaxGold(maxGold);
        gameConfigModel.setGoldPerRound(goldPerRound);
        gameConfigModel.setInterestRate(interestRate);
        gameConfigModel.setHexCost(hexCost);
        gameConfigModel.setTurnLimit(turnLimit);
        gameConfigModel.setMinionHp(minionHp);
        gameConfigModel.setMaxMinions(maxMinions);
        gameConfigModel.setMinionCost(minionCost);

        return gameConfigUUID;
    }

    public GameConfigModel getGameConfig(UUID gameId, UUID gameConfigId) {
        GameState gs = gameManager.getGame(gameId);

        if(gs == null){return null;}
        if(gs.getGameConfigId() == null) return null;
        if(!gs.getGameConfigId().equals(gameConfigId)) {
            return null;
        }
        return gameConfigManager.getGameConfig(gameConfigId);
    }

}
