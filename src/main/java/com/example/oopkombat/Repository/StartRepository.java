package com.example.oopkombat.Repository;

import com.example.oopkombat.DTO.CreateStartResponse;
import com.example.oopkombat.GameManager.GameManager;
import com.example.oopkombat.GameState.GameState;
import com.example.oopkombat.Player.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class StartRepository {
    private final GameManager gameManager;

    //สร้าง Player ID เมื่อกดปุ่ม Start
    public CreateStartResponse newPlayers(UUID gameID){
        GameState gameState = gameManager.getGame(gameID);
        if(gameState == null) return null;

        UUID PlayerOne = UUID.randomUUID();
        UUID PlayerTwo = UUID.randomUUID();

        gameState.getPlayers().clear();

        gameState.getPlayers().put(PlayerOne, new Player());
        gameState.getPlayers().put(PlayerTwo, new Player());

        CreateStartResponse createStartResponse = new CreateStartResponse();
        createStartResponse.setPlaterOne(PlayerOne);
        createStartResponse.setPlaterTwo(PlayerTwo);

        return createStartResponse;
    }

}
